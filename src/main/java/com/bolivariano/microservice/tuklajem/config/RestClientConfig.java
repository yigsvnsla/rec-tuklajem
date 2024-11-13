package com.bolivariano.microservice.tuklajem.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "rest.config")
public class RestClientConfig {
    
    private Number read_timeout;
    private Number connect_timeout;
    private String base_url;


    @Bean
    RestClient restClient(){
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();

        clientHttpRequestFactory.setConnectTimeout(this.connect_timeout.intValue());
        clientHttpRequestFactory.setReadTimeout(this.read_timeout.intValue());

        return RestClient
                .builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .requestFactory(clientHttpRequestFactory)
                .baseUrl(this.base_url)
                .build();
    }
}