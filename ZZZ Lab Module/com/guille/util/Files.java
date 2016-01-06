package com.guille.util;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Files {

	public static void writeFileFromString(String path, String fileName, String file, String extension, String encoding) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(path+fileName+"."+extension, encoding);
		writer.println(file);
		writer.close();
	}
	
	public static PrintWriter createLogger(String path, String filename) {
		PrintWriter log = null;
		try {
			log = new PrintWriter(new BufferedWriter(new FileWriter(path + filename + ".log", true)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd - MMM - YYYY 'at' HH:mm:ss");
		log.println("**** LOG CREATED "+sdf.format(Calendar.getInstance().getTime())+" ****");
		log.close();
		return log;
	}
	
	public static void writeLog(PrintWriter file, String message) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd - MMM - YYYY  HH:mm:ss");
		file.print(sdf.format(Calendar.getInstance().getTime())+" :: \t");
		file.println(message);
		file.close();
	}
}
