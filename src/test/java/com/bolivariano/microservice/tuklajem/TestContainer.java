package com.bolivariano.microservice.tuklajem;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@SpringBootTest
@EnableJms
@Testcontainers
public class TestContainer {


    @Autowired
    private JmsTemplate jmsTemplate;

    @Container
    @ServiceConnection
    @SuppressWarnings("resource")
    private static GenericContainer<?> container = new GenericContainer<>("icr.io/ibm-messaging/mq")
            .withExtraHost("localhost", "0.0.0.0")
            .withEnv("LICENSE", "accept")
            .withEnv("MQ_QMGR_NAME", "QM1")
            .withEnv("MQ_APP_PASSWORD", "passw0rd");

    @DynamicPropertySource
    private static void registerMQProperties(DynamicPropertyRegistry registry) {
        registry.add("ibm.mq.host", () -> container.getHost());
        registry.add("ibm.mq.port", () -> container.getMappedPort(1414));
        registry.add("ibm.mq.channel", () -> "DEV.ADMIN.SVRCONN");
        registry.add("ibm.mq.queue-manager", () -> "QM1");
        registry.add("ibm.mq.user", () -> "admin");
        registry.add("ibm.mq.password", () -> "passw0rd");
    }



    @Test
    public void testSendAndReceiveMessage() {

        String queueName = "DEV.QUEUE.1";
        String testMessage = "Prueba de mensaje IBM MQ";

        System.out.println("HOlA TEST");
        // Enviar mensaje
        jmsTemplate.convertAndSend(queueName, testMessage);

        // Recibir mensaje
        String receivedMessage = (String) jmsTemplate.receiveAndConvert(queueName);

        assertThat(receivedMessage).isEqualTo(testMessage);
    }
}