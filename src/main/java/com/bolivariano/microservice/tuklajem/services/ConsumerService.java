package com.bolivariano.microservice.tuklajem.services;

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
import com.bolivariano.microservice.tuklajem.dtos.MessageOutputConsultDTO;
import com.bolivariano.microservice.tuklajem.dtos.MessageOutputPaymentDTO;
import com.bolivariano.microservice.tuklajem.dtos.MessageOutputProcessDTO;
import com.bolivariano.microservice.tuklajem.dtos.MessageProcessAditionalDataDTO;
import com.bolivariano.microservice.tuklajem.dtos.PaymentRequestDTO;
import com.bolivariano.microservice.tuklajem.dtos.PaymentResponseDTO;
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
					// this.revertPayment();
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

			DebtRequestDTO debtRequest = new DebtRequestDTO();

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

	private void payment(MessageInputPaymentDTO messageInputProcess, String correlationId) {
		log.info("📤 INICIANDO PROCESO DE PAGO");

		MessageOutputProcessDTO messageOutputProcessDTO = new MessageOutputProcessDTO();
		MessageOutputPaymentDTO messageOutputConsultDTO = new MessageOutputPaymentDTO();

		PaymentRequestDTO paymentRequest = new PaymentRequestDTO();

		paymentRequest.setCod_cliente(correlationId);

		PaymentResponseDTO payment = this.providerService.payment(paymentRequest);
	}

}
