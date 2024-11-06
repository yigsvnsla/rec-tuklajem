package com.bolivariano.microservice.agrocalidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.bolivariano.microservice.agrocalidad.mq.MqConfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication()
@EnableConfigurationProperties()
public class AgrocalidadApplication implements CommandLineRunner{

    static final Logger logger = LoggerFactory.getLogger(AgrocalidadApplication.class);

   @Autowired
   private MqConfiguration mqConfiguration;
    
   public static void main(String... args) {
      SpringApplication.run(AgrocalidadApplication.class, args);
      logger.info("📦 Levantando Micro Servicio");
   }


   @Override
   public void run(String... args) throws Exception {
       System.out.println(mqConfiguration.toString());
   }
}