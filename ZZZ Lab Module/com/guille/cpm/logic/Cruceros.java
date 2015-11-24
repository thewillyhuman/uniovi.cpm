package com.guille.cpm.logic;

import java.util.ArrayList;
import java.util.List;

public class Cruceros {
	
	private static List<Crucero> cruceros = new ArrayList<Crucero>();
	
	public static List<Crucero> getCruceros() {
		return cruceros;
	}
	
	public static void addCrucero(Crucero crucero) {
		cruceros.add(crucero);
	}
	
	public static void removeCrucero(Crucero crucero) {
		cruceros.remove(cruceros);
	}

}
