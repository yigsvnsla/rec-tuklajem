package com.bolivariano.microservice.tuklajem.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

	private final Double MOUNT_MIN = 20.00;
	private final Double MOUNT_MAX = 1000.00;

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

			messageOutputConsultDTO.setCodigoError("300");
			messageOutputConsultDTO.setMensajeUsuario(e.getMessage());

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

			// Mesaje Salida Consulta
			messageOutputConsultDTO.setMontoMinimo(this.MOUNT_MIN);
			messageOutputConsultDTO.setLimiteMontoMinimo(this.MOUNT_MIN);
			messageOutputConsultDTO.setLimiteMontoMaximo(this.MOUNT_MAX);
			messageOutputConsultDTO.setMensajeSistema("CONSULTA EJECUTADA");
			messageOutputConsultDTO.setCodigoError(debt.getCod_respuesta());
			messageOutputConsultDTO.setNombreCliente(debt.getNom_cliente());
			messageOutputConsultDTO.setMensajeUsuario(debt.getMsg_respuesta());
			messageOutputConsultDTO.setIdentificadorDeuda(debt.getIdentificador_deuda());
			messageOutputConsultDTO.setDatosAdicionales(aditionalsData);
			// messageOutputConsultDTO.setMontoTotal(10.00);


			// Mensaje de salida proceso;
			messageOutputProcessDTO.setEstado(MessageStatus.OK);
			messageOutputProcessDTO.setCodigo(debt.getCod_respuesta());
			messageOutputProcessDTO.setMensajeUsuario(debt.getMsg_respuesta());
			messageOutputProcessDTO.setMensajeSalidaConsultarDeuda(messageOutputConsultDTO);

			jmsService.sendResponseMessage(
					MqConfig.CHANNEL_RESPONSE,
					messageOutputProcessDTO,
					correlationId);

		} catch (Exception e) {

			log.error("❌ ERROR AL GENERAR CONSULTA: {}", e.getMessage(), e);
			MessageOutputProcessDTO messageOutputProcessDTO = new MessageOutputProcessDTO();
			MessageOutputConsultDTO messageOutputConsultDTO = new MessageOutputConsultDTO();

			messageOutputConsultDTO.setCodigoError("300");
			messageOutputConsultDTO.setMensajeUsuario(e.getMessage());

			messageOutputProcessDTO.setEstado(MessageStatus.ERROR);
			messageOutputProcessDTO.setCodigo("0");
			messageOutputProcessDTO.setMensajeUsuario("CONSULTA EJECUTADA");

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
					
			PaymentRequestDTO paymentRequest = new PaymentRequestDTO();

			paymentRequest.setCod_cliente(identifier);
			paymentRequest.setFecha(messageInputProcess.getFecha());
			paymentRequest.setHora(messageInputProcess.getFecha());
			paymentRequest.setTerminal(terminal.getValor());
			paymentRequest.setImporte(importe);

			PaymentResponseDTO payment = this.providerService.setPayment(paymentRequest);

			// Mesaje Salida Pago
			messageOutputPaymentDTO.setMensajeSistema("CONSULTA EJECUTADA");
			messageOutputPaymentDTO.setBanderaOffline(false);
			messageOutputPaymentDTO.setMensajeUsuario(payment.getMsg_respuesta());
			messageOutputPaymentDTO.setCodigoError(payment.getCod_respuesta());
			messageOutputPaymentDTO.setMontoTotal(messageInputProcess.getValorPago());
			messageOutputPaymentDTO.setFechaDebito(messageInputProcess.getFecha());
			messageOutputPaymentDTO.setFechaPago(messageInputProcess.getFecha());
			messageOutputPaymentDTO.setReferencia(identifier);
			messageOutputPaymentDTO.setDatosAdicionales(aditionalsData);

			// Mensaje de salida proceso;
			messageOutputProcessDTO.setEstado(MessageStatus.OK);
			messageOutputProcessDTO.setCodigo(payment.getCod_respuesta());
			messageOutputProcessDTO.setMensajeUsuario(payment.getMsg_respuesta());
			messageOutputProcessDTO.setMensajeSalidaEjecutarPago(messageOutputPaymentDTO);

			jmsService.sendResponseMessage(
					MqConfig.CHANNEL_RESPONSE,
					messageOutputProcessDTO,
					correlationId);

		} catch (Exception e) {
			log.error("❌ ERROR AL GENERAR CONSULTA: {}", e.getMessage(), e);
			MessageOutputProcessDTO messageOutputProcessDTO = new MessageOutputProcessDTO();
			MessageOutputPaymentDTO messageOutputConsultDTO = new MessageOutputPaymentDTO();

			messageOutputConsultDTO.setCodigoError("300");
			messageOutputConsultDTO.setMensajeUsuario(e.getMessage());

			messageOutputProcessDTO.setEstado(MessageStatus.ERROR);
			messageOutputProcessDTO.setCodigo("0");
			messageOutputProcessDTO.setMensajeUsuario("CONSULTA EJECUTADA");

			messageOutputProcessDTO.setMensajeSalidaEjecutarPago(messageOutputConsultDTO);

			jmsService.sendResponseMessage(MqConfig.CHANNEL_RESPONSE, messageOutputProcessDTO, correlationId);
		}
	}

	private void revert(MessageInputRevertPaymentDTO messageInputProcess, String correlationId) throws JsonProcessingException {
		try {
			log.info("📤 INICIANDO PROCESO DE REVERSO");

			MessageOutputProcessDTO messageOutputProcessDTO = new MessageOutputProcessDTO();
			MessageOutputRevertPaymentDTO messageOutputRevertPaymentDTO = new MessageOutputRevertPaymentDTO();

			String identifier = messageInputProcess
				.getServicio()
				.getIdentificador();

			MessageProcessAditionalDataDTO aditionalsData = messageInputProcess
					.getServicio()
					.getDatosAdicionales();

			// MessageAditionalDataDTO terminal = Arrays.stream(aditionalsData.getDatoAdicional())
			// 		.filter(item -> item.getCodigo().equals("e_term"))
			// 		.findFirst()
			// 		.orElse(null);

			// Integer importe = BigDecimal.valueOf(messageInputProcess.getValorPago())
			// 		.setScale(2, RoundingMode.HALF_UP)
			// 		.movePointRight(2)
			// 		.intValue();

			RevertRequestDTO revertRequest = new RevertRequestDTO();

			revertRequest.setImporte(3000);
			revertRequest.setCod_cliente("22004455");
			revertRequest.setTerminal("D00561");
			revertRequest.setCod_trx("36988406-DDC0-40BE-9D6F-712D975F6E8F");
			revertRequest.setHora("20190106");
			revertRequest.setFecha("101940");
		
			RevertResponseDTO revertPayment = this.providerService.setRevert(revertRequest);

			// Mesaje Salida Reversos
			messageOutputRevertPaymentDTO.setMensajeSistema("CONSULTA EJECUTADA");
			messageOutputRevertPaymentDTO.setBanderaOffline(false);
			messageOutputRevertPaymentDTO.setMensajeUsuario(revertPayment.getMsg_respuesta());
			messageOutputRevertPaymentDTO.setCodigoError("0"); //revertPayment.getCod_respuesta()
			messageOutputRevertPaymentDTO.setMontoTotal(messageInputProcess.getValorPago());
			messageOutputRevertPaymentDTO.setFechaDebito(messageInputProcess.getFechaPago());
			messageOutputRevertPaymentDTO.setFechaPago(messageInputProcess.getFechaPago());
			messageOutputRevertPaymentDTO.setReferencia(identifier);
			messageOutputRevertPaymentDTO.setDatosAdicionales(aditionalsData);

			// Mensaje de salida proceso;
			messageOutputProcessDTO.setEstado(MessageStatus.OK);
			messageOutputProcessDTO.setCodigo("0"); //revertPayment.getCod_respuesta()
			messageOutputProcessDTO.setMensajeUsuario(revertPayment.getMsg_respuesta());
			messageOutputProcessDTO.setMensajeSalidaEjecutarPago(messageOutputRevertPaymentDTO);

			jmsService.sendResponseMessage(
					MqConfig.CHANNEL_RESPONSE,
					messageOutputProcessDTO,
					correlationId);

		} catch (Exception e) {
			log.error("❌ ERROR AL GENERAR REVERSO: {}", e.getMessage(), e);
			MessageOutputProcessDTO messageOutputProcessDTO = new MessageOutputProcessDTO();
			MessageOutputPaymentDTO messageOutputConsultDTO = new MessageOutputPaymentDTO();

			messageOutputConsultDTO.setCodigoError("300");
			messageOutputConsultDTO.setMensajeUsuario(e.getMessage());

			messageOutputProcessDTO.setEstado(MessageStatus.ERROR);
			messageOutputProcessDTO.setCodigo("0");
			messageOutputProcessDTO.setMensajeUsuario("CONSULTA EJECUTADA");

			messageOutputProcessDTO.setMensajeSalidaEjecutarPago(messageOutputConsultDTO);

			jmsService.sendResponseMessage(MqConfig.CHANNEL_RESPONSE, messageOutputProcessDTO, correlationId);
		}
	}

}
