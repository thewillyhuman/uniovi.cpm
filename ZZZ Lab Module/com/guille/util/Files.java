package com.guille.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Files {

	public static void writeFileFromString(String path, String fileName, String file, String extension, String encoding) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(path+fileName+"."+extension, encoding);
		writer.println(file);
		writer.close();
	}
}
