package com.example.demo.model;


import com.example.demo.model.TransporteService;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Transporte;
import com.example.demo.repository.*;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



public class Veiculos {
	private String nomeVeiculo;
	private double fatorVeiculo;
	
	
	public void Veiculos() {
		
	}

	
	public Veiculos(String nomeVeiculo, double fatorVeiculo) {
		this.nomeVeiculo = nomeVeiculo;
		this.fatorVeiculo = fatorVeiculo;

	}
	
	public Veiculos () {
	
	}

	public String getNomeVeiculo() {
		return nomeVeiculo;
	}

	public void setNomeVeiculo(String nomeVeiculo) {
		this.nomeVeiculo = nomeVeiculo;
	}

	public double getFatorVeiculo() {
		return fatorVeiculo;
	}

	public void setFatorVeiculo(double fatorVeiculo) {
		this.fatorVeiculo = fatorVeiculo;
	}
	
	public String infos() {
		String info = "Nome Veiculo: " + nomeVeiculo
				+ "\nFator Veiculo: " + fatorVeiculo;
		return info;
	}
		

}