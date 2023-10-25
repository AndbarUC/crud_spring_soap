package com.abarrigau.demo.DTO;

import org.springframework.stereotype.Service;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Service
public class Soat {
    
    private String valor;
    private String moneda;
    
}
