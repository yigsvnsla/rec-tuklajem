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
	private ObjectMapper objectMapper;

	@Autowired
	private JmsService jmsService;

	@Autowired
	private ProviderService providerService;

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

			messageOutputConsultDTO.setCodigoError("300");
			messageOutputConsultDTO.setMensajeUsuario("EMPRESA DESTINO NO DISPONIBLE");
			messageOutputProcessDTO.setEstado(MessageStatus.ERROR);
			messageOutputProcessDTO.setCodigo("0");
			messageOutputProcessDTO.setMensajeUsuario("CONSULTA EJECUTADA");

			messageOutputProcessDTO.setMensajeSalidaConsultarDeuda(messageOutputConsultDTO);

			jmsService.sendResponseMessage(MqConfig.CHANNEL_RESPONSE, messageOutputProcessDTO, correlationId);
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
					.filter(item -> item.getCodigo().equals("e_term"))
					.findFirst()
					.orElse(null);

			DebtRequestDTO debtRequest = new DebtRequestDTO();

			// Data Binding
			debtRequest.setIdentificador(identifier);
			debtRequest.setTerminal(terminal.getValor());
			debtRequest.setFecha(messageInputProcess.getFecha());
			debtRequest.setHora(messageInputProcess.getFecha());

			DebtResponseDTO debt = this.providerService.getDebt(debtRequest);

			if (debt.getCod_respuesta().equals(ProviderErrorCode.TRANSACCION_ACEPTADA.getcode())) {
				messageOutputConsultDTO.setMontoMinimo(debt.getValor_minimo().doubleValue());
				messageOutputConsultDTO.setLimiteMontoMinimo(debt.getValor_minimo().doubleValue());
				messageOutputConsultDTO.setLimiteMontoMaximo(debt.getValor_maximo().doubleValue());
				messageOutputConsultDTO.setMensajeSistema("CONSULTA EJECUTADA");
				messageOutputConsultDTO.setCodigoError(debt.getCod_respuesta().toString());
				messageOutputConsultDTO.setNombreCliente(debt.getNom_cliente());
				messageOutputConsultDTO.setMensajeUsuario(debt.getMsg_respuesta());
				messageOutputConsultDTO.setIdentificadorDeuda(debt.getIdentificador_deuda());
				messageOutputConsultDTO.setDatosAdicionales(aditionalsData);
			}

			// Mensaje de salida proceso;
			messageOutputProcessDTO.setEstado(MessageStatus.OK);
			messageOutputProcessDTO.setCodigo(debt.getCod_respuesta().toString());
			messageOutputProcessDTO.setMensajeUsuario(debt.getMsg_respuesta());
			messageOutputProcessDTO.setMensajeSalidaConsultarDeuda(messageOutputConsultDTO);

			log.info("📥 FINALIZANDO PROCESO DE CONSULTA");

			jmsService.sendResponseMessage(
					MqConfig.CHANNEL_RESPONSE,
					messageOutputProcessDTO,
					correlationId);

		} catch (Exception e) {

			log.error("❌ ERROR AL GENERAR CONSULTA: {}", e.getMessage(), e);
			MessageOutputProcessDTO messageOutputProcessDTO = new MessageOutputProcessDTO();
			MessageOutputConsultDTO messageOutputConsultDTO = new MessageOutputConsultDTO();

			log.error(e.getMessage());

			messageOutputConsultDTO.setCodigoError("300");
			messageOutputConsultDTO.setMensajeUsuario("EMPRESA DESTINO NO DISPONIBLE");
			messageOutputProcessDTO.setEstado(MessageStatus.ERROR);
			messageOutputProcessDTO.setCodigo("0");
			messageOutputProcessDTO.setMensajeUsuario("CONSULTA NO EJECUTADA");

			messageOutputProcessDTO.setMensajeSalidaConsultarDeuda(messageOutputConsultDTO);

			jmsService.sendResponseMessage(MqConfig.CHANNEL_RESPONSE, messageOutputProcessDTO, correlationId);
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
					.filter(item -> item.getCodigo().equals("e_term"))
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
			LocalDateTime TEST_HORA = LocalDateTime.now().plusMinutes(5);

			paymentRequest.setSecuencial(secuencial);
			paymentRequest.setTerminal(terminal.getValor());
			paymentRequest.setFecha(messageInputProcess.getFecha());
			paymentRequest.setHora(TEST_HORA.toString()); // ! hay que quitar esta vaina, es un parche
			paymentRequest.setCod_cliente(identifier);
			paymentRequest.setImporte(importe);

			PaymentResponseDTO payment = this.providerService.setPayment(paymentRequest);

			if (payment.getCod_respuesta().equals(ProviderErrorCode.TRANSACCION_ACEPTADA.getcode())) {
				// Buscamos y Actualizamos el e_cod_respuesta que hara referencia a el CAMP_ALT1

				MessageProcessAditionalDataDTO messageProcessAditionalDataDTO = new MessageProcessAditionalDataDTO();
				ArrayList<MessageAditionalDataDTO> listAditionalData = new ArrayList<>();

				listAditionalData.add(new MessageAditionalDataDTO() {
					{
						setCodigo("e_cod_respuesta");
						setValor(payment.getCod_trx());
					}
				});

				messageProcessAditionalDataDTO
						.setDatoAdicional(listAditionalData.toArray(new MessageAditionalDataDTO[0]));
				log.debug(messageProcessAditionalDataDTO.getDatoAdicional());

				// Mesaje Salida Pago
				messageOutputPaymentDTO.setMensajeSistema("PAGO EJECUTADA");
				messageOutputPaymentDTO.setMontoTotal(messageInputProcess.getValorPago());
				messageOutputPaymentDTO.setMensajeUsuario(payment.getMsg_respuesta());
				messageOutputPaymentDTO.setFechaDebito(messageInputProcess.getFecha());
				messageOutputPaymentDTO.setFechaPago(messageInputProcess.getFecha());
				messageOutputPaymentDTO.setCodigoError(payment.getCod_respuesta().toString());
				messageOutputPaymentDTO.setBanderaOffline(false);
				messageOutputPaymentDTO.setDatosAdicionales(messageProcessAditionalDataDTO);
				messageOutputPaymentDTO.setReferencia(identifier);
			}

			// Mensaje de salida proceso;
			messageOutputProcessDTO.setEstado(MessageStatus.OK);
			messageOutputProcessDTO.setCodigo(payment.getCod_respuesta().toString());
			messageOutputProcessDTO.setMensajeUsuario(payment.getMsg_respuesta());
			messageOutputProcessDTO.setMensajeSalidaEjecutarPago(messageOutputPaymentDTO);
			log.info("📥 FINALIZANDO PROCESO DE PAGO");

			jmsService.sendResponseMessage(
					MqConfig.CHANNEL_RESPONSE,
					messageOutputProcessDTO,
					correlationId);

		} catch (Exception e) {
			log.error("❌ ERROR AL GENERAR PAGO: {}", e.getMessage(), e);
			MessageOutputProcessDTO messageOutputProcessDTO = new MessageOutputProcessDTO();
			MessageOutputPaymentDTO messageOutputConsultDTO = new MessageOutputPaymentDTO();

			log.error(e.getMessage());

			messageOutputProcessDTO.setMensajeUsuario("PAGO NO EJECUTADA");
			messageOutputProcessDTO.setEstado(MessageStatus.ERROR);
			messageOutputConsultDTO.setMensajeUsuario("EMPRESA DESTINO NO DISPONIBLE");
			messageOutputConsultDTO.setCodigoError("300");
			messageOutputProcessDTO.setCodigo("300");

			messageOutputProcessDTO.setMensajeSalidaEjecutarPago(messageOutputConsultDTO);

			jmsService.sendResponseMessage(MqConfig.CHANNEL_RESPONSE, messageOutputProcessDTO, correlationId);
		}
	}

	private void revert(MessageInputRevertPaymentDTO messageInputProcess, String correlationId)
			throws JsonProcessingException {
		try {
			log.info("📤 INICIANDO PROCESO DE REVERSO");

			/*
			 * para la fecha de hoy 10/ene/2025 los valores dentro de la data adicional estan repetidos
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
					.filter(item -> (item.getCodigo().equals("e_term") && !item.getValor().isEmpty()))
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


			String secuencialReverso = Arrays.stream(aditionalsData.getDatoAdicional())
					.filter(item -> (item.getCodigo().equals("vp_s_ssn") && item.getValor().equals(secuencial)))
					.findFirst()
					.orElse(null)
					.getValor();

			String secuencialPago = Arrays.stream(aditionalsData.getDatoAdicional())
					.filter(item -> (item.getCodigo().equals("vp_s_ssn") && !item.getValor().equals(secuencial)))
					.findFirst()
					.orElse(null)
					.getValor();


			System.out.println(secuencialReverso);
			System.out.println(secuencialPago);
			System.out.println(secuencial);


			RevertRequestDTO revertRequest = new RevertRequestDTO();
			// tengo que parchear una fecha actual de la maquina +5m en el futuro porque no
			// puedo pagar en tiempo pasado, entenderia que pudiera pagar dentro de un rango
			// de tiempo
			LocalDateTime TEST_HORA = LocalDateTime.now().plusMinutes(5);

			revertRequest.setSecuencial(secuencialPago);
			revertRequest.setImporte(importe);
			revertRequest.setCod_cliente(identifier);
			revertRequest.setTerminal(terminal);
			revertRequest.setCod_trx(trxCode);
			revertRequest.setFecha(messageInputProcess.getFechaPago());
			revertRequest.setHora(TEST_HORA.toString());

			RevertResponseDTO revertPayment = this.providerService.setRevert(revertRequest);

			if (revertPayment.getCod_respuesta().equals(ProviderErrorCode.TRANSACCION_ACEPTADA.getcode())) {
				// Mesaje Salida Reversos
				messageOutputRevertPaymentDTO.setMensajeSistema("REVERSO EJECUTADA");
				messageOutputRevertPaymentDTO.setMensajeUsuario(revertPayment.getMsg_respuesta());
				messageOutputRevertPaymentDTO.setFechaDebito(messageInputProcess.getFechaPago());
				messageOutputRevertPaymentDTO.setMontoTotal(messageInputProcess.getValorPago());
				messageOutputRevertPaymentDTO.setFechaPago(messageInputProcess.getFechaPago());
				messageOutputRevertPaymentDTO.setBanderaOffline(false);
				messageOutputRevertPaymentDTO.setDatosAdicionales(aditionalsData);
				messageOutputRevertPaymentDTO.setCodigoError(revertPayment.getCod_respuesta().toString());
				messageOutputRevertPaymentDTO.setReferencia(identifier);
			}

			// Mensaje de salida proceso;
			messageOutputProcessDTO.setEstado(MessageStatus.OK);
			messageOutputProcessDTO.setCodigo(revertPayment.getCod_respuesta().toString());
			messageOutputProcessDTO.setMensajeUsuario(revertPayment.getMsg_respuesta());
			messageOutputProcessDTO.setMensajeSalidaEjecutarPago(messageOutputRevertPaymentDTO);

			log.info("📥 FINALIZANDO PROCESO DE REVERSO");

			jmsService.sendResponseMessage(
					MqConfig.CHANNEL_RESPONSE,
					messageOutputProcessDTO,
					correlationId);

		} catch (Exception e) {
			log.error("❌ ERROR AL GENERAR REVERSO: {}", e.getMessage(), e);
			MessageOutputProcessDTO messageOutputProcessDTO = new MessageOutputProcessDTO();
			MessageOutputPaymentDTO messageOutputConsultDTO = new MessageOutputPaymentDTO();

			log.error(e.getMessage());

			messageOutputConsultDTO.setCodigoError("300");
			messageOutputConsultDTO.setMensajeUsuario("EMPRESA DESTINO NO DISPONIBLE");
			messageOutputProcessDTO.setEstado(MessageStatus.ERROR);
			messageOutputProcessDTO.setCodigo("300");
			messageOutputProcessDTO.setMensajeUsuario("REVERSO NO EJECUTADA");

			messageOutputProcessDTO.setMensajeSalidaEjecutarPago(messageOutputConsultDTO);

			jmsService.sendResponseMessage(MqConfig.CHANNEL_RESPONSE, messageOutputProcessDTO, correlationId);
		}
	}
}
