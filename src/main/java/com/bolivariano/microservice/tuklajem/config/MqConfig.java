package com.bolivariano.microservice.tuklajem.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ibm.mq.jakarta.jms.MQConnectionFactory;
import com.ibm.mq.jakarta.jms.MQQueueConnectionFactory;
import com.ibm.msg.client.jakarta.wmq.WMQConstants;
import com.ibm.msg.client.jakarta.wmq.common.CommonConstants;

import jakarta.annotation.PostConstruct;
import jakarta.jms.JMSException;
import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "mq.config")
public class MqConfig {

    public static String CHANNEL_REQUEST;
    public static String CHANNEL_RESPONSE;


    private String host;
    private String channel;
    private String queue_manager;
    private String request_queue ;
    private String response_queue;
    private String user;
    private String password;
    private Integer port;
    private Integer pool_jms;
    private Integer delay_reconnect;
    private Integer living_time;
    private Integer char_set;

    @Bean
    MQConnectionFactory mqConnectionFactory() throws JMSException {
        MQQueueConnectionFactory factory = new MQQueueConnectionFactory();
        factory.setChannel(this.channel);
        factory.setHostName(this.host);
        factory.setPort(this.port);
        factory.setQueueManager(this.queue_manager);
        factory.setTransportType(CommonConstants.WMQ_CM_CLIENT); // Tipo de transporte TCP/IP
        factory.setIntProperty(CommonConstants.WMQ_CLIENT_RECONNECT_OPTIONS, CommonConstants.WMQ_CLIENT_RECONNECT);
        factory.setStringProperty(WMQConstants.USERID, this.user);
        factory.setStringProperty(WMQConstants.PASSWORD, this.password);
        return factory;
    }

    @PostConstruct()
    private void run(){
        MqConfig.CHANNEL_REQUEST = this.getRequest_queue();
        MqConfig.CHANNEL_RESPONSE = this.getResponse_queue();
    }
}


