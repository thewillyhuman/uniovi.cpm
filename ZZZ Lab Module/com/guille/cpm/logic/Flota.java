package com.guille.cpm.logic;

import java.util.ArrayList;
import java.util.List;

public class Flota {
	
	private List<Barco> barcos;
	
	public Flota() {
		barcos = new ArrayList<Barco>();
	}

	public List<Barco> getBarcos() {
		return this.barcos;
	}
	
	public void addBarco(Barco barco) {
		if(barco == null)
			throw new IllegalArgumentException("You cannot add null ships.");
		barcos.add(barco);
	}
	
	public boolean contains(Barco barco) {
		return this.barcos.contains(barco);
	}
	
	public void removeBarco(Barco barco) {
		if(barco == null)
			throw new IllegalArgumentException("You cannot remove null ships.");
		barcos.remove(barco);
	} 
}
