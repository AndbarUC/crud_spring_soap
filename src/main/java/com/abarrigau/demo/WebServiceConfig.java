package com.abarrigau.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.abarrigau.demo.service.VehiculoService;

import jakarta.xml.ws.Endpoint;


@Configuration
public class WebServiceConfig {

    @Autowired
    private VehiculoService service;

    @Bean
    public Endpoint Endpoint() {
        System.out.println("Iniciando servicio SOAP");
        Endpoint endpoint = Endpoint.publish("http://0.0.0.0:9092/", service);
        return endpoint;
    }
    
}
