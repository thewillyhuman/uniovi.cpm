package com.guille.cpm.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CargarDatos {

	public final static String PATH = "com/guille/cpm/files/in/";

	public final static String BARCOS = "barcos.dat";
	public final static String CRUCEROS = "cruceros.dat";
	public final static String EXTRAS = "extras.dat";

	public static void cargarArchivo(String filePath) throws IOException {
		String cadena;
		FileReader f = new FileReader(PATH+filePath);
		BufferedReader b = new BufferedReader(f);
		while ((cadena = b.readLine()) != null) {
			String[] parts = cadena.split(";");
			if(parts.length == 3) {
				Extras.addExtra(new Extra(parts[0], parts[1], Double.parseDouble(parts[2])));
			} else if (parts.length == 10) {
				boolean aux = false;
				if(parts[6] == "S")
					aux = true;
				List<Date> dates = new ArrayList<Date>();
				String[] datesString = parts[8].split("%");
				SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/mm/yyy");
				Date fecha = null;
				for(int i = 0; i < datesString.length; i++) {
					try {
						fecha = formatoDelTexto.parse(datesString[i]);
						dates.add(fecha);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				Cruceros.addCrucero(new Crucero(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], aux, Integer.parseInt(parts[7]), dates, Flota.getBarco(parts[9])));
			} else if (parts.length == 11) {
				Flota.addBarco(new Barco(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Double.parseDouble(parts[7]), Double.parseDouble(parts[8]), Double.parseDouble(parts[9]), Double.parseDouble(parts[10])));
			}
		}
		b.close();
	}

	public static void main(String[] args) throws IOException {
		cargarArchivo(BARCOS);
		cargarArchivo(CRUCEROS);
		cargarArchivo(EXTRAS);
	}
}
