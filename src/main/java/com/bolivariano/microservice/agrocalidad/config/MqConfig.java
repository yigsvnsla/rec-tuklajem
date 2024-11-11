package com.bolivariano.microservice.agrocalidad.config;

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

    public static String request;
    public static String response;


    private String host;
    private String channel;
    private String queue_manager;
    private String request_queue ;
    private String response_queue;
    private String user;
    private String password;
    private Number port;
    private Number pool_jms;
    private Number delay_reconnect;
    private Number living_time;
    private Number char_set;

    @Bean
    MQConnectionFactory mqConnectionFactory() throws JMSException {
        MQQueueConnectionFactory factory = new MQQueueConnectionFactory();
        factory.setChannel(this.channel);
        factory.setHostName(this.host);
        factory.setPort(this.port.intValue());
        factory.setQueueManager(this.queue_manager);
        factory.setTransportType(CommonConstants.WMQ_CM_CLIENT); // Tipo de transporte TCP/IP
        factory.setIntProperty(CommonConstants.WMQ_CLIENT_RECONNECT_OPTIONS, CommonConstants.WMQ_CLIENT_RECONNECT);
        factory.setStringProperty(WMQConstants.USERID, this.user);
        factory.setStringProperty(WMQConstants.PASSWORD, this.password);
        // factory.setConnectionNameList(connectionName);
        return factory;
    }

    @PostConstruct()
    private void run(){
        MqConfig.request = this.getRequest_queue();
        MqConfig.response = this.getResponse_queue();
    }


    
}


