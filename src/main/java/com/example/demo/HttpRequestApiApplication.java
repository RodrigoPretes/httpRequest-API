package com.example.demo;

import java.io.ByteArrayInputStream;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.ftp.FTP;
import com.example.demo.model.Transporte;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.io.ByteArrayInputStream;
import org.apache.commons.lang3.ArrayUtils;

@SpringBootApplication
public class HttpRequestApiApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(HttpRequestApiApplication.class, args);
	}

}
