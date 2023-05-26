package com.example.demo.ftp;

import org.springframework.integration.ftp.session.DefaultFtpSessionFactory;
import org.springframework.integration.ftp.session.FtpSession;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;

public class FTP {

	private DefaultFtpSessionFactory getFactory() {
		DefaultFtpSessionFactory factory = new DefaultFtpSessionFactory();

		factory.setHost("127.0.0.1");
		// factory.setPort(21);
		factory.setUsername("mariana");
		factory.setPassword("1234");
		// factory.setAllowUnknownKeys(true);

		return factory;
	}

	private void upload(InputStream inputStream, String filePath, String fileName) throws IOException {

		try (FtpSession session = getFactory().getSession()) {
			session.write(inputStream, filePath + "/" + fileName);
		}
	}

	public void upload(String fileName, InputStream inputStream) throws IOException {
		upload(inputStream, "/ftp", fileName );
	}
}
