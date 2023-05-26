package com.example.demo.model;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import com.example.demo.model.Veiculos;

import java.io.IOException;
import java.util.*;


@Service
public class TransporteService {
	
	Veiculos VUC; 
	Veiculos Caminhao34;
	Veiculos CaminhaoToco;
	Veiculos CarretaSimples;
	Veiculos CarretaEixoEstendido;
	public String fatores;
	public List veiculos = new ArrayList();
	
	public TransporteService(){
		
		VUC = new Veiculos("Veiculo urbano de carga VUC", 1.00);
		Caminhao34 = new Veiculos("Caminhao 3/4", 1.05);
		CaminhaoToco= new Veiculos("Caminhao toco", 1.08);
		CarretaSimples = new Veiculos("Carreta simples", 1.13);
		CarretaEixoEstendido = new Veiculos("Carreta eixo estendido", 1.19);
		
		veiculos.add(VUC);
		veiculos.add(Caminhao34);
		veiculos.add(CaminhaoToco);
		veiculos.add(CarretaSimples);
		veiculos.add(CarretaEixoEstendido);
		
		
		fatores = VUC.infos() + "\n\n"+
				Caminhao34.infos() + "\n\n"+
				CaminhaoToco.infos() + "\n\n"+
				CarretaSimples.infos() + "\n\n"+
				CarretaEixoEstendido.infos() + "\n\n";
		
	}
	
	
	
	public Veiculos atualizaFator(Veiculos veiculos) {
		if(veiculos.getNomeVeiculo().equals(Caminhao34.getNomeVeiculo())) {
			Caminhao34.setFatorVeiculo(veiculos.getFatorVeiculo());
		}
		if(veiculos.getNomeVeiculo().equals(CaminhaoToco.getNomeVeiculo())) {
			CaminhaoToco.setFatorVeiculo(veiculos.getFatorVeiculo());
		}
		if(veiculos.getNomeVeiculo().equals(CarretaSimples.getNomeVeiculo())) {
			CarretaSimples.setFatorVeiculo(veiculos.getFatorVeiculo());
		}
		if(veiculos.getNomeVeiculo().equals(CarretaEixoEstendido.getNomeVeiculo())) {
			CarretaEixoEstendido.setFatorVeiculo(veiculos.getFatorVeiculo());
		}
		if(veiculos.getNomeVeiculo().equals(VUC.getNomeVeiculo())) {
			VUC.setFatorVeiculo(veiculos.getFatorVeiculo());
		}
		
		fatores = VUC.infos() + "\n\n"+
				Caminhao34.infos() + "\n\n"+
				CaminhaoToco.infos() + "\n\n"+
				CarretaSimples.infos() + "\n\n"+
				CarretaEixoEstendido.infos() + "\n\n";
		return veiculos;
	}
	
	public double EncontraFator(Transporte transporte) {
		
		
		if (transporte.getTipoVeiculo().equals(CarretaEixoEstendido.getNomeVeiculo())) {
			return CarretaEixoEstendido.getFatorVeiculo();
		}
		if (transporte.getTipoVeiculo().equals(CarretaSimples.getNomeVeiculo())) {
			return CarretaSimples.getFatorVeiculo();
		}
		if (transporte.getTipoVeiculo().equals(CaminhaoToco.getNomeVeiculo())){
			return CaminhaoToco.getFatorVeiculo();
		}
		if (transporte.getTipoVeiculo().equals(Caminhao34.getNomeVeiculo())) {
			return Caminhao34.getFatorVeiculo();
		}
		if (transporte.getTipoVeiculo().equals(VUC.getNomeVeiculo())) {
			return VUC.getFatorVeiculo();
		}
		else {
			return (0);
		}
	}
	
	public double calcularFrete(Transporte transporte)  {
		
		double fatorMult = EncontraFator(transporte);
		 
		
		double frete = ((transporte.getDistanciaPavimentada() * 0.63) + (transporte.getDistanciaNPavimentada() * 0.72)) * (fatorMult);
		if (transporte.getPesoCarga() > 5) {
			frete += (((transporte.getPesoCarga()-5) * 0.03) *(transporte.getDistancia()));
		}
	
		
		return frete;
	}
	
	

}
