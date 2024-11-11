package com.bolivariano.microservice.agrocalidad.config;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class RestClientTokenInterceptor implements ClientHttpRequestInterceptor {

    @Override
    @SuppressWarnings("null")
    public ClientHttpResponse intercept(HttpRequest request,  byte[] body, ClientHttpRequestExecution execution) throws IOException {
        
      
        HttpHeaders headers = request.getHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + "");
        return execution.execute(request, body);
        
        
        
    }
    
}
