package com.bolivariano.microservice.tuklajem.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bolivariano.microservice.tuklajem.config.MqConfig;
import com.bolivariano.microservice.tuklajem.dtos.DebtRequestDTO;
import com.bolivariano.microservice.tuklajem.dtos.DebtResponseDTO;
import com.bolivariano.microservice.tuklajem.dtos.MessageAditionalDataDTO;
import com.bolivariano.microservice.tuklajem.dtos.MessageInputConsultDTO;
import com.bolivariano.microservice.tuklajem.dtos.MessageInputPaymentDTO;
import com.bolivariano.microservice.tuklajem.dtos.MessageInputProcessDTO;
import com.bolivariano.microservice.tuklajem.dtos.MessageInputRevertPaymentDTO;
import com.bolivariano.microservice.tuklajem.dtos.MessageOutputConsultDTO;
import com.bolivariano.microservice.tuklajem.dtos.MessageOutputPaymentDTO;
import com.bolivariano.microservice.tuklajem.dtos.MessageOutputProcessDTO;
import com.bolivariano.microservice.tuklajem.dtos.MessageOutputRevertPaymentDTO;
import com.bolivariano.microservice.tuklajem.dtos.MessageProcessAditionalDataDTO;
import com.bolivariano.microservice.tuklajem.dtos.PaymentRequestDTO;
import com.bolivariano.microservice.tuklajem.dtos.PaymentResponseDTO;
import com.bolivariano.microservice.tuklajem.dtos.RevertResponseDTO;
import com.bolivariano.microservice.tuklajem.dtos.RevertRequestDTO;
import com.bolivariano.microservice.tuklajem.enums.MessageStatus;
import com.bolivariano.microservice.tuklajem.enums.ProviderErrorCode;
import com.bolivariano.microservice.tuklajem.exception.ResponseExecption;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ConsumerService {

	@Autowired
    private MqConfig mqConfig;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private JmsService jmsService;

	@Autowired
	private ProviderService providerService;

	private String proceesTerminal = "e_term";
	private String errorMessage = "EMPRESA DESTINO NO DISPONIBLE";
	private String errorCode =  "300";
	private String errorStatus = "0";






 	public void stage(String message, String correlationId) throws JsonProcessingException {
		try {

			MessageInputProcessDTO messageInputProcessDTO = objectMapper
					.readValue(message, MessageInputProcessDTO.class); // Deserialización

			switch (messageInputProcessDTO.getTipoFlujo()) {
				case CONSULTA:
					this.consulting(messageInputProcessDTO.getMensajeEntradaConsultarDeuda(), correlationId);
					break;
				case PAGO:
					this.payment(messageInputProcessDTO.getMensajeEntradaEjecutarPago(), correlationId);
					break;
				case REVERSO:
					this.revert(messageInputProcessDTO.getMensajeEntradaEjecutarReverso(), correlationId);
					break;
				default:
					throw new ResponseExecption(HttpStatus.NOT_ACCEPTABLE, "type operation null");
			}
		} catch (JsonProcessingException e) {
			log.error("❌ ERROR DE STAGE: {}", e.getMessage(), e);
			MessageOutputProcessDTO messageOutputProcessDTO = new MessageOutputProcessDTO();
			MessageOutputConsultDTO messageOutputConsultDTO = new MessageOutputConsultDTO();

			log.error(e.getMessage());

			String revertMessageError = "REVERSO NO EJECUTADA";

			messageOutputProcessDTO.setEstado(MessageStatus.ERROR);
			messageOutputProcessDTO.setCodigo(this.errorStatus);
			messageOutputConsultDTO.setCodigoError(this.errorCode);
			messageOutputConsultDTO.setMensajeSistema(revertMessageError);
			messageOutputConsultDTO.setMensajeUsuario(this.errorMessage);
			messageOutputProcessDTO.setMensajeUsuario(revertMessageError);

			messageOutputProcessDTO.setMensajeSalidaConsultarDeuda(messageOutputConsultDTO);

			jmsService.sendResponseMessage(mqConfig.getResponse_queue(), messageOutputProcessDTO, correlationId);
		}

	}

	public void consulting(MessageInputConsultDTO messageInputProcess, String correlationId)
			throws JsonProcessingException {
		try {

			log.info("📤 INICIANDO PROCESO DE CONSULTA");

			MessageOutputProcessDTO messageOutputProcessDTO = new MessageOutputProcessDTO();
			MessageOutputConsultDTO messageOutputConsultDTO = new MessageOutputConsultDTO();

			String identifier = messageInputProcess
					.getServicio()
					.getIdentificador();

			MessageProcessAditionalDataDTO aditionalsData = messageInputProcess
					.getServicio()
					.getDatosAdicionales();

			MessageAditionalDataDTO terminal = Arrays.stream(aditionalsData.getDatoAdicional())
					.filter(item -> item.getCodigo().equals(this.proceesTerminal))
					.findFirst()
					.orElse(null);

			DebtRequestDTO debtRequest = new DebtRequestDTO();
	
			debtRequest.setIdentificador(identifier);
			debtRequest.setTerminal(terminal.getValor());
			debtRequest.setFecha(messageInputProcess.getFecha());
			debtRequest.setHora(messageInputProcess.getFecha());
			log.info("🟦 REQUEST CONSULTA PROVEEDOR ", debtRequest);
			DebtResponseDTO debt = this.providerService.getDebt(debtRequest);
			log.info("🟦 RESPONSE CONSULTA PROVEEDOR ", debt);

			if (debt.getCodRespuesta().equals(ProviderErrorCode.TRANSACCION_ACEPTADA.getcode())) {
				messageOutputConsultDTO.setMontoMinimo(debt.getValorMinimo().doubleValue());
				messageOutputConsultDTO.setLimiteMontoMinimo(debt.getValorMinimo().doubleValue());
				messageOutputConsultDTO.setLimiteMontoMaximo(debt.getValorMaximo().doubleValue());
				messageOutputConsultDTO.setMensajeSistema("CONSULTA EJECUTADA");
				messageOutputConsultDTO.setNombreCliente(debt.getNombreCliente());
				messageOutputConsultDTO.setIdentificadorDeuda(debt.getIdentificadorDeuda());
				messageOutputConsultDTO.setDatosAdicionales(aditionalsData);
			}
			
			
			messageOutputConsultDTO.setCodigoError(debt.getCodRespuesta().toString());
			messageOutputProcessDTO.setMensajeUsuario(debt.getMsgRespuesta());
			messageOutputConsultDTO.setMensajeUsuario(debt.getMsgRespuesta());
			messageOutputProcessDTO.setEstado(MessageStatus.OK);
			messageOutputProcessDTO.setCodigo(debt.getCodRespuesta().toString());
			messageOutputProcessDTO.setMensajeSalidaConsultarDeuda(messageOutputConsultDTO);

			log.info("📥 FINALIZANDO PROCESO DE CONSULTA");

			jmsService.sendResponseMessage(
				mqConfig.getResponse_queue(),
					messageOutputProcessDTO,
					correlationId);

		} catch (Exception e) {

			log.error("❌ ERROR AL GENERAR CONSULTA: {}", e.getMessage(), e);
			MessageOutputProcessDTO messageOutputProcessDTO = new MessageOutputProcessDTO();
			MessageOutputConsultDTO messageOutputConsultDTO = new MessageOutputConsultDTO();

			String revertMessageError = "REVERSO NO EJECUTADA";

			messageOutputProcessDTO.setEstado(MessageStatus.ERROR);
			messageOutputProcessDTO.setCodigo(this.errorStatus);
			messageOutputConsultDTO.setCodigoError(this.errorCode);
			messageOutputConsultDTO.setMensajeSistema(revertMessageError);
			messageOutputConsultDTO.setMensajeUsuario(this.errorMessage);
			messageOutputProcessDTO.setMensajeUsuario(revertMessageError);

			messageOutputProcessDTO.setMensajeSalidaConsultarDeuda(messageOutputConsultDTO);

			jmsService.sendResponseMessage(mqConfig.getResponse_queue(), messageOutputProcessDTO, correlationId);
		}

	}

	private void payment(MessageInputPaymentDTO messageInputProcess, String correlationId)
			throws JsonProcessingException {
		try {

			log.info("📤 INICIANDO PROCESO DE PAGO");

			MessageOutputProcessDTO messageOutputProcessDTO = new MessageOutputProcessDTO();
			MessageOutputPaymentDTO messageOutputPaymentDTO = new MessageOutputPaymentDTO();

			String identifier = messageInputProcess
					.getServicio()
					.getIdentificador();

			MessageProcessAditionalDataDTO aditionalsData = messageInputProcess
					.getServicio()
					.getDatosAdicionales();

			MessageAditionalDataDTO terminal = Arrays.stream(aditionalsData.getDatoAdicional())
					.filter(item -> item.getCodigo().equals(this.proceesTerminal))
					.findFirst()
					.orElse(null);

			Integer importe = BigDecimal.valueOf(messageInputProcess.getValorPago())
					.setScale(2, RoundingMode.HALF_UP)
					.movePointRight(2)
					.intValue();

			String secuencial = messageInputProcess.getSecuencial();

			PaymentRequestDTO paymentRequest = new PaymentRequestDTO();

			// tengo que parchear una fecha actual de la maquina +5m en el futuro porque no
			// puedo pagar en tiempo pasado, entenderia que pudiera pagar dentro de un rango
			// de tiempo
			LocalDateTime testHora = LocalDateTime.now().plusMinutes(5);

			paymentRequest.setSecuencial(secuencial);
			paymentRequest.setTerminal(terminal.getValor());
			paymentRequest.setFecha(messageInputProcess.getFecha());
			paymentRequest.setHora(testHora.toString()); // ! hay que quitar esta vaina, es un parche
			paymentRequest.setCodCliente(identifier);
			paymentRequest.setImporte(importe);

			log.info("🟦 REQUEST PAGO PROVEEDOR ", paymentRequest);
			PaymentResponseDTO payment = this.providerService.setPayment(paymentRequest);
			log.info("🟦 RESPONSE PAGO PROVEEDOR ", payment);

			if (payment.getCodRespuesta().equals(ProviderErrorCode.TRANSACCION_ACEPTADA.getcode())) {
				
				/*
				* Buscamos y Actualizamos el e_cod_respuesta que hara referencia a el CAMP_ALT1
				*/ 
				MessageProcessAditionalDataDTO messageProcessAditionalDataDTO = new MessageProcessAditionalDataDTO();
				ArrayList<MessageAditionalDataDTO> listAditionalData = new ArrayList<>();


				MessageAditionalDataDTO codTrx = new MessageAditionalDataDTO();

				codTrx.setCodigo("e_cod_respuesta");
				codTrx.setValor(payment.getCodTrx());

				listAditionalData.add(codTrx);

				messageProcessAditionalDataDTO
						.setDatoAdicional(listAditionalData.toArray(new MessageAditionalDataDTO[0]));
				log.info(messageProcessAditionalDataDTO.getDatoAdicional());

				
				messageOutputPaymentDTO.setMensajeSistema("PAGO EJECUTADA");
				messageOutputPaymentDTO.setMontoTotal(messageInputProcess.getValorPago());
				messageOutputPaymentDTO.setFechaDebito(messageInputProcess.getFecha());
				messageOutputPaymentDTO.setFechaPago(messageInputProcess.getFecha());
				messageOutputPaymentDTO.setBanderaOffline(false);
				messageOutputPaymentDTO.setDatosAdicionales(messageProcessAditionalDataDTO);
				messageOutputPaymentDTO.setReferencia(identifier);
			}
			
			
			messageOutputProcessDTO.setEstado(MessageStatus.OK);
			messageOutputPaymentDTO.setCodigoError(payment.getCodRespuesta().toString());
			messageOutputProcessDTO.setCodigo(payment.getCodRespuesta().toString());
			messageOutputPaymentDTO.setMensajeUsuario(payment.getMsgRespuesta());
			messageOutputProcessDTO.setMensajeUsuario(payment.getMsgRespuesta());
			messageOutputProcessDTO.setMensajeSalidaEjecutarPago(messageOutputPaymentDTO);
			log.info("📥 FINALIZANDO PROCESO DE PAGO");

			jmsService.sendResponseMessage(
				mqConfig.getResponse_queue(),
					messageOutputProcessDTO,
					correlationId);

		} catch (Exception e) {
			log.error("❌ ERROR AL GENERAR PAGO: {}", e.getMessage(), e);
			MessageOutputProcessDTO messageOutputProcessDTO = new MessageOutputProcessDTO();
			MessageOutputPaymentDTO messageOutputConsultDTO = new MessageOutputPaymentDTO();

			String revertMessageError = "PAGO NO EJECUTADA";
			
			messageOutputProcessDTO.setEstado(MessageStatus.ERROR);
			messageOutputProcessDTO.setCodigo(this.errorStatus);
			messageOutputConsultDTO.setCodigoError(this.errorCode);
			messageOutputConsultDTO.setMensajeSistema(revertMessageError);
			messageOutputConsultDTO.setMensajeUsuario(this.errorMessage);
			messageOutputProcessDTO.setMensajeUsuario(revertMessageError);

			messageOutputProcessDTO.setMensajeSalidaEjecutarPago(messageOutputConsultDTO);

			jmsService.sendResponseMessage(mqConfig.getResponse_queue(), messageOutputProcessDTO, correlationId);
		}
	}

	private void revert(MessageInputRevertPaymentDTO messageInputProcess, String correlationId)
			throws JsonProcessingException {
		try {
			log.info("📤 INICIANDO PROCESO DE REVERSO");

			/*
			 * para la fecha de hoy 10/ene/2025 los valores dentro de la data adicional
			 * estan repetidos
			 * por ende hay que filtrar los datos que se desean rescatar
			 * por su nombre y si su valor no esta vacio o null
			 */

			MessageOutputProcessDTO messageOutputProcessDTO = new MessageOutputProcessDTO();
			MessageOutputRevertPaymentDTO messageOutputRevertPaymentDTO = new MessageOutputRevertPaymentDTO();

			String identifier = messageInputProcess
					.getServicio()
					.getIdentificador();

			MessageProcessAditionalDataDTO aditionalsData = messageInputProcess
					.getServicio()
					.getDatosAdicionales();

			String terminal = Arrays.stream(aditionalsData.getDatoAdicional())
					.filter(item -> (item.getCodigo().equals(this.proceesTerminal) && !item.getValor().isEmpty()))
					.findFirst()
					.orElse(null)
					.getValor();

			Integer importe = BigDecimal.valueOf(messageInputProcess.getValorPago())
					.setScale(2, RoundingMode.HALF_UP)
					.movePointRight(2)
					.intValue();

			String trxCode = Arrays.stream(aditionalsData.getDatoAdicional())
					.filter(item -> (item.getCodigo().equals("e_cod_respuesta") && !item.getValor().isEmpty()))
					.findFirst()
					.orElse(null)
					.getValor();

			String secuencial = messageInputProcess.getSecuencial();

			// String secuencialReverso = Arrays.stream(aditionalsData.getDatoAdicional())
			// 		.filter(item -> (item.getCodigo().equals("vp_s_ssn") && item.getValor().equals(secuencial)))
			// 		.findFirst()
			// 		.orElse(null)
			// 		.getValor();

			String secuencialPago = Arrays.stream(aditionalsData.getDatoAdicional())
					.filter(item -> (item.getCodigo().equals("vp_s_ssn") && !item.getValor().equals(secuencial)))
					.findFirst()
					.orElse(null)
					.getValor();

			RevertRequestDTO revertRequest = new RevertRequestDTO();

			// tengo que parchear una fecha actual de la maquina +5m en el futuro porque no
			// puedo pagar en tiempo pasado, entenderia que pudiera pagar dentro de un rango
			// de tiempo
			LocalDateTime fakeHora = LocalDateTime.now().plusMinutes(5);

			revertRequest.setSecuencial(secuencialPago);
			revertRequest.setImporte(importe);
			revertRequest.setCodCliente(identifier);
			revertRequest.setTerminal(terminal);
			revertRequest.setCodTrx(trxCode);
			revertRequest.setFecha(messageInputProcess.getFechaPago());
			revertRequest.setHora(fakeHora.toString());

			log.info("🟦 REQUEST REVERSO PROVEEDOR ", revertRequest);

			RevertResponseDTO revertPayment = this.providerService.setRevert(revertRequest);

			log.info("🟦 RESPONSE REVERSO PROVEEDOR ", revertPayment);

			if (revertPayment.getCodRespuesta().equals(ProviderErrorCode.TRANSACCION_ACEPTADA.getcode())) {
				messageOutputRevertPaymentDTO.setMensajeSistema("REVERSO EJECUTADA");
				messageOutputRevertPaymentDTO.setFechaDebito(messageInputProcess.getFechaPago());
				messageOutputRevertPaymentDTO.setMontoTotal(messageInputProcess.getValorPago());
				messageOutputRevertPaymentDTO.setFechaPago(messageInputProcess.getFechaPago());
				messageOutputRevertPaymentDTO.setBanderaOffline(false);
				messageOutputRevertPaymentDTO.setDatosAdicionales(aditionalsData);
				messageOutputRevertPaymentDTO.setReferencia(identifier);
			}

			// Mensaje de salida proceso;
			messageOutputProcessDTO.setEstado(MessageStatus.OK);
			messageOutputProcessDTO.setMensajeUsuario(revertPayment.getMsgRespuesta());
			messageOutputRevertPaymentDTO.setMensajeUsuario(revertPayment.getMsgRespuesta());
			messageOutputProcessDTO.setCodigo(revertPayment.getCodRespuesta().toString());
			messageOutputProcessDTO.setMensajeSalidaEjecutarPago(messageOutputRevertPaymentDTO);
			messageOutputRevertPaymentDTO.setCodigoError(revertPayment.getCodRespuesta().toString());

			log.info("📥 FINALIZANDO PROCESO DE REVERSO");

			jmsService.sendResponseMessage(
				mqConfig.getResponse_queue(),
					messageOutputProcessDTO,
					correlationId);

		} catch (Exception e) {
			log.error("❌ ERROR AL GENERAR REVERSO: {}", e.getMessage(), e);
			MessageOutputProcessDTO messageOutputProcessDTO = new MessageOutputProcessDTO();
			MessageOutputPaymentDTO messageOutputConsultDTO = new MessageOutputPaymentDTO();

			String revertMessageError = "REVERSO NO EJECUTADA";

			
			messageOutputProcessDTO.setEstado(MessageStatus.ERROR);
			messageOutputProcessDTO.setCodigo(this.errorStatus);
			messageOutputConsultDTO.setCodigoError(this.errorCode);
			messageOutputConsultDTO.setMensajeSistema(revertMessageError);
			messageOutputConsultDTO.setMensajeUsuario(this.errorMessage);
			messageOutputProcessDTO.setMensajeUsuario(revertMessageError);

			messageOutputProcessDTO.setMensajeSalidaEjecutarPago(messageOutputConsultDTO);

			jmsService.sendResponseMessage(mqConfig.getResponse_queue(), messageOutputProcessDTO, correlationId);
		}
	}
}
