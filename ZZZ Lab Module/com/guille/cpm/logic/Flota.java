package com.guille.cpm.logic;

import java.util.ArrayList;
import java.util.List;

public class Flota {
	
	private static List<Barco> barcos = new ArrayList<Barco>();

	public static  List<Barco> getBarcos() {
		return barcos;
	}
	
	public static void addBarco(Barco barco) {
		if(barco == null)
			throw new IllegalArgumentException("You cannot add null ships.");
		barcos.add(barco);
	}
	
	public static boolean contains(Barco barco) {
		return barcos.contains(barco);
	}
	
	public static Barco getBarco(String shipID) {
		for(Barco b : barcos) {
			if(b.getShipID() == shipID)
				return b;
		} return null;
	}
	
	public static void removeBarco(Barco barco) {
		if(barco == null)
			throw new IllegalArgumentException("You cannot remove null ships.");
		barcos.remove(barco);
	} 
}
