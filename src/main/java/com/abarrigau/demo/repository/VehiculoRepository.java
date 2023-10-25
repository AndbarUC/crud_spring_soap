package com.abarrigau.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abarrigau.demo.entity.VehiculoEntity;

@Repository
public interface VehiculoRepository extends JpaRepository<VehiculoEntity , Long>
{
    VehiculoEntity findByPlaca(String placa);
    VehiculoEntity findBykey(Long id) ;
}
