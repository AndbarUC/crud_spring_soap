package com.abarrigau.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abarrigau.demo.repository.VehiculoRepository;
import com.abarrigau.demo.DTO.Soat;
import com.abarrigau.demo.entity.VehiculoEntity;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.text.DecimalFormat;
import java.util.HashMap;


@Service
@WebService(serviceName = "vehicles")
public class VehiculoService 
{
    //private VehiculoModel vm = new VehiculoModel(); 


    private Soat soat = new Soat();

    @Autowired
    private VehiculoRepository repo ;   
    
    @WebMethod(operationName = "testResponse")
    public String getStudents() {
        
        return "Look Good.";
    }

    @WebMethod(operationName = "getAll")
    public List<VehiculoEntity> getVehicles() 
    {        
        return repo.findAll();
    }

    @WebMethod(operationName = "getAllbyPlaca")
    public VehiculoEntity getVehicleByPlaca(String plate) 
    {        
        return repo.findByPlaca(plate);
    }

    @WebMethod(operationName = "getById")
    public VehiculoEntity getVehicle(@WebParam(name = "idVehicle") Long idVehicle)
    {
        return repo.findBykey(idVehicle);
    }

    @WebMethod(operationName = "saveOrUpdate")
    public void saveVehicle(VehiculoEntity vehicle) 
    {        
        repo.save(vehicle);
    }

    @WebMethod(operationName = "deleteVehicleId")
    public VehiculoEntity delete(String placa)
    {
        VehiculoEntity dataDelete = this.getVehicleByPlaca(placa);
        repo.deleteById(dataDelete.getKey());
        return dataDelete;
    }

    @WebMethod(operationName = "getSoat")
    public Soat soat(String placa) 
    {
        VehiculoEntity vehicle = this.getVehicleByPlaca(placa);
        DecimalFormat formateador = new DecimalFormat("#,###.00");
        String numeroFormateado = formateador.format(vehicle.getValor_soat());
        soat.setValor(numeroFormateado);
        soat.setMoneda("COP");
    
        return soat;
    }
    
}
