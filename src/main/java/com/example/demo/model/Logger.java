package com.example.demo.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {
	
	public String name;

	public File log(String action) {
		Date date = new Date();
		long timeMillis = date.getTime();
		
		//String fileName =  timeMillis + ".txt";
		String fileName = "C:\\Users\\maria\\Downloads\\httpRequest-API2\\httpRequest-API\\src\\main\\java\\LOGS\\" + timeMillis + ".txt";
		name =  timeMillis + ".txt";
		File logFile = new File(fileName);
		try {
			if (!logFile.exists()) {
				logFile.createNewFile();
			}
			FileWriter writer = new FileWriter(logFile, true);
			writer.write("[" + date + "] " + action + "\n");
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return logFile;
	}

}
