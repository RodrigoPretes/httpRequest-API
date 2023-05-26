package com.example.demo.controller;

import java.util.List;
import java.util.function.Supplier;
import java.io.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TransporteService;
import com.example.demo.model.Veiculos;
import com.example.demo.model.Transporte;
import com.example.demo.repository.*;
import com.example.demo.ftp.FTP;
import com.example.demo.model.Logger;

@RestController
@RequestMapping("/transporte")
public class TransporteController {

	@Autowired(required = false)
	private TransporteService transporteService;

	@Autowired(required = false)
	private TransporteRepository transporteRepository;

	
	//@Autowired(required = false)
	//private FTP ftp;
	
	//@Autowired(required = false)
	//private Logger log;
	
	
	@GetMapping
	public List<Transporte> Listar() {
		return transporteRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Transporte adicionar(@RequestBody Transporte transporte) throws IOException {

		long id = transporte.getId();
		Logger log = new Logger();
		
		if (!transporteRepository.existsById(id)) {
			transporte.definirFrete(transporteService.calcularFrete(transporte));
			
			//Fazer Upload do Arquivo
			InputStream inputStream = new FileInputStream(log.log("Registro Adicionado: \n" + transporte.infos()));
			FTP ftp = new FTP();
			ftp.upload(log.name, inputStream);
			
			//Salvar Registro
			return transporteRepository.save(transporte);
		} else {
			//Fazer Upload do Arquivo
			InputStream inputStream = new FileInputStream(log.log("Tentativa de Adicionar - Registro Já Existente:\n" + transporte.infos()));
			FTP ftp = new FTP();
			ftp.upload(log.name, inputStream);
			//Não salva Registro
			return transporte;

		}

	}

	@GetMapping("/listarFatores")
	public List<Veiculos> listarFator() throws IOException {
		Logger log = new Logger();
		
		InputStream inputStream = new FileInputStream(log.log("Listar Fatores: \n" + transporteService.fatores));
		FTP ftp = new FTP();
		ftp.upload(log.name, inputStream);
		return transporteService.veiculos;
	}

	@PostMapping("/atualizarFator")
	public Veiculos postAtualizaFator(@RequestBody Veiculos veiculos) throws IOException {
		Logger log = new Logger();
		InputStream inputStream = new FileInputStream(log.log("Fatores Atualizados: \n" + transporteService.fatores));
		FTP ftp = new FTP();
		ftp.upload(log.name, inputStream);
		return transporteService.atualizaFator(veiculos);
	}

	@PostMapping("/deletarRegistro")
	public void deletarRegistro(@RequestBody Transporte transporte) throws IOException {
		Logger log = new Logger();
		InputStream inputStream = new FileInputStream(log.log("Registro Deletado: \n" + transporte.infos()));
		FTP ftp = new FTP();
		ftp.upload(log.name, inputStream);
		transporteRepository.delete(transporte);
	}

	@PostMapping("/atualizarRegistro")
	public Transporte atualizarRegistro(@RequestBody Transporte transporte) throws IOException {
		Logger log = new Logger();

		long id = transporte.getId();

		if (transporteRepository.existsById(id)) {
			transporte.definirFrete(transporteService.calcularFrete(transporte));
			InputStream inputStream = new FileInputStream(log.log("Registro Atualizado: \n" + transporte.infos()));
			FTP ftp = new FTP();
			ftp.upload(log.name, inputStream);
			return transporteRepository.save(transporte);

		} else {
			InputStream inputStream = new FileInputStream(log.log("Tentativa de Atualizar - Registro Não Existente:\n" + transporte.infos()));
			FTP ftp = new FTP();
			ftp.upload(log.name, inputStream);
			
			return transporte;

		}
	}

}
