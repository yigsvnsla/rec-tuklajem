package com.bolivariano.microservice.agrocalidad.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jms.JmsException;
import org.springframework.stereotype.Service;

import com.bolivariano.microservice.agrocalidad.config.MqConfig;
import com.bolivariano.microservice.agrocalidad.dtos.DebtRequestDTO;
import com.bolivariano.microservice.agrocalidad.dtos.DebtResponseDTO;
import com.bolivariano.microservice.agrocalidad.dtos.MessageAditionalDataDTO;
import com.bolivariano.microservice.agrocalidad.dtos.MessageInputConsultDTO;
import com.bolivariano.microservice.agrocalidad.dtos.MessageInputProcessDTO;
import com.bolivariano.microservice.agrocalidad.dtos.MessageOutputConsultDTO;
import com.bolivariano.microservice.agrocalidad.dtos.MessageOutputProcessDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j2;

import com.bolivariano.microservice.agrocalidad.exception.ResponseExecption;

@Log4j2
@Service
public class ConsumerService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JmsService jmsService;

    @Autowired
    private ProviderService providerService;

    public void payment() {
        throw new UnsupportedOperationException("Unimplemented method 'payment'");
    }

    public void revertPayment() {
        throw new UnsupportedOperationException("Unimplemented method 'revertPayment'");
    }

    public void consulting(MessageInputConsultDTO messageInputProcess, String correlationId)
            throws JsonProcessingException {

        MessageOutputProcessDTO messageOutputProcessDTO = new MessageOutputProcessDTO();
        MessageOutputConsultDTO messageOutputConsultDTO = new MessageOutputConsultDTO();

        DebtRequestDTO debtRequest = new DebtRequestDTO();

        String identifier = messageInputProcess
                .getServicio()
                .getIdentificador();

        MessageAditionalDataDTO[] aditionalData = messageInputProcess
                .getServicio()
                .getDatosAdicionales()
                .getDatoAdicional();

        MessageAditionalDataDTO terminal = Arrays.stream(aditionalData)
                .filter(item -> item.getCodigo().equals("e_term"))
                .findFirst()
                .orElse(null);

        // Data Binding
        debtRequest.setIdentificador(identifier);
        debtRequest.setTerminal(terminal.getValor());
        debtRequest.setFecha(messageInputProcess.getFecha());
        debtRequest.setHora(messageInputProcess.getFecha());

        // log.info(debtRequest);

        DebtResponseDTO debt = this.providerService.getDebt(debtRequest);

        // Mesaje Salida Consulta
        messageOutputConsultDTO.setMontoMinimo(0.0);
        messageOutputConsultDTO.setLimiteMontoMinimo(0.0);
        messageOutputConsultDTO.setMensajeSistema("CONSULTA EJECUTADA");
        messageOutputConsultDTO.setCodigoError(debt.getCod_respuesta());
        messageOutputConsultDTO.setNombreCliente(debt.getNom_cliente());
        messageOutputConsultDTO.setMensajeUsuario(debt.getMsg_respuesta());
        messageOutputConsultDTO.setIdentificadorDeuda(debt.getIdentificador_deuda());

        // Mensaje de salida proceso;
        messageOutputProcessDTO.setEstado("OK");
        messageOutputProcessDTO.setCodigo("0");
        messageOutputProcessDTO.setMensajeUsuario("CONSULTA EJECUTADA");
        messageOutputProcessDTO.setMensajeSalidaConsultarDeuda(messageOutputConsultDTO);

        jmsService.sendMessage(MqConfig.response, messageOutputProcessDTO, correlationId);

    }

    public void stage(String message)
            throws JmsException, ResponseExecption, JsonMappingException, JsonProcessingException {

        MessageInputProcessDTO messageInputProcessDTO = objectMapper.readValue(message, MessageInputProcessDTO.class); // Deserialización

        // System.out.println(message);

        switch (messageInputProcessDTO.getTipoFlujo()) {
            case CONSULTA:
                this.consulting(messageInputProcessDTO.getMensajeEntradaConsultarDeuda(), "0000000");
                break;
            case PAGO:
                this.payment();
                break;
            case REVERSO:
                this.revertPayment();
                break;
            default:
                throw new ResponseExecption(HttpStatus.NOT_ACCEPTABLE, "type operation null");
        }
    }
}
