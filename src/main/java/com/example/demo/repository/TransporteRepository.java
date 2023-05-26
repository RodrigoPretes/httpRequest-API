package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Transporte;


@Repository
public interface TransporteRepository extends JpaRepository<Transporte, Long>{

	
}
