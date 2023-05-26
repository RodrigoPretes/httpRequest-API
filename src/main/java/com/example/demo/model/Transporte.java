package com.example.demo.model;


import java.io.IOException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


import com.example.demo.model.TransporteService;
import com.example.demo.model.Veiculos;
import com.example.demo.repository.*;


@Entity
@Data
public class Transporte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transporte other = (Transporte) obj;
		return id == other.id;
	}
	
	public Transporte() {
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getFrete() {
		return frete;
	}

	public void setFrete(double frete) {
		this.frete = frete;
	}

	@Column(nullable = false)
	private double distanciaPavimentada;
	private double distanciaNPavimentada;
	private String tipoVeiculo;
	private double pesoCarga;
	private double distancia;
	private double frete;
	
	
	public Transporte (double distanciaPavimentada, double distanciaNPavimentada, String tipoVeiculo, double pesoCarga, double distancia) throws IOException {
		this.distanciaPavimentada = distanciaPavimentada;
		this.distanciaNPavimentada = distanciaNPavimentada;
		this.tipoVeiculo = tipoVeiculo;
		this.pesoCarga = pesoCarga;
		this.distancia = distancia;
		
	}
	
	public void definirFrete(double frete) {
		this.frete = frete;
	}
	
	public double getDistanciaPavimentada() {
		return distanciaPavimentada;
	}
	public void setDistanciaPavimentada(double distanciaPavimentada) {
		this.distanciaPavimentada = distanciaPavimentada;
	}
	public double getDistanciaNPavimentada() {
		return distanciaNPavimentada;
	}
	public void setDistanciaNPavimentada(double distanciaNPavimentada) {
		this.distanciaNPavimentada = distanciaNPavimentada;
	}
	public String getTipoVeiculo() {
		return tipoVeiculo;
	}
	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	public double getPesoCarga() {
		return pesoCarga;
	}
	public void setPesoCarga(double pesoCarga) {
		this.pesoCarga = pesoCarga;
	}
	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	
	public String infos() {
		String info = "Distancia Pavimentada: " + distanciaPavimentada
				+ "\nDistancia não pavimentada: " + distanciaNPavimentada
				+ "\nDistância Total: " + distancia
				+ "\nTipo de Veículo: " + tipoVeiculo
				+ "\nPeso da Carga: " + pesoCarga
				+ "\nFrete: " + frete;
		return info;
		
	}

	
}
