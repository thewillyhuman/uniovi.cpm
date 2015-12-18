package logica;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Inmobiliaria {

  private List<Mansion> relacionMansiones;
	  
  public Inmobiliaria() {
	relacionMansiones = new ArrayList<Mansion>();
    leerFichero();
  }

  public void leerFichero() {
    String linea = "";
    try {
    	BufferedReader fichero = new BufferedReader(new FileReader("files/mansiones.dat"));
    	while (fichero.ready()) {
    		linea = fichero.readLine();
    		String[] trozos = linea.split("@");
    		relacionMansiones.add(new Mansion(trozos[0], trozos[1], trozos[2],trozos[3],
                                              Float.parseFloat(trozos[4])));
    	}
    	fichero.close();
    	}
    	catch (FileNotFoundException fnfe) {
    		JOptionPane.showMessageDialog(null,"El archivo no se ha encontrado");
    	}
    	catch (IOException ioe) {
    		new RuntimeException("Error de entrada/salida.");
    	}
  	}
  
  public int grabarFichero(String linea) {
	    String nombreFichero = "files/visitas.dat";
	    try {
	         BufferedWriter fichero = new BufferedWriter(new FileWriter(nombreFichero));
	         fichero.write(linea);
	         fichero.close();
	         return(0);
	     }
	    catch (FileNotFoundException fnfe) {
	    	System.out.println("El archivo no se ha podido guardar");
	    	return(-1);
	    }
	    catch (IOException ioe) {
	    	new RuntimeException("Error de entrada/salida.");
	    	return(-2);
	    }
	  }

  public List<Mansion> getRelacionMansiones() {
	  return relacionMansiones;
	}
   
  public String getDescripcionMansion(int indice) {
	  return relacionMansiones.get(indice).getDescripcion();
  }
  
  public float calcularEntrada (float porcentaje, float precio){
	  float entrada= precio*(porcentaje/100);
	  return entrada;
  }
}
