package com.guille.cpm.logic;

import java.util.ArrayList;
import java.util.List;

public class Camarote {
	
	private List<Extra> extras;
	private List<Pasajero> pasajeros;
	private boolean isFree = true;
	
	public Camarote() {
		extras = new ArrayList<Extra>();
		pasajeros = new ArrayList<Pasajero>();
	}
	
	public List<Extra> getExtras() {
		return this.extras;
	}
	
	public List<Pasajero> getPasajeros() {
		return this.pasajeros;
	}
	
	public void addPasajero(Pasajero p) {
		if(p == null)
			throw new IllegalArgumentException("The passanger to be added cannot be null");
		pasajeros.add(p);
	}
	
	public void removePasajero(Pasajero p) {
		if(p == null)
			throw new IllegalArgumentException("The passanger to be removed cannot be null");
		pasajeros.remove(p);
	}
	
	public void addExtra(Extra extra) {
		if(extra == null)
			throw new IllegalArgumentException("The extra to be added cannot be null");
		extras.add(extra);
	}
	
	public void removeExtra(Extra extra) {
		if(extra == null)
			throw new IllegalArgumentException("The extra to be removed cannot be null");
		extras.remove(extra);
	}
	
	public void book() {
		isFree = false;
	}
	
	public void unBook() {
		isFree = true;
	}
	
	public boolean isFree() {
		return this.isFree;
	}
	
	public boolean hasCamaSupletoria() {
		for(Extra e : this.getExtras()) {
			if(e.getExtra() == "Cama supletoria")
				return true;
		} return false;
	}
	
	public boolean hasChilds() {
		for(Pasajero p : this.getPasajeros()) {
			if(p.isChild())
				return true;
		} return false;
	}
	
	public int getNPasajeros() {
		return pasajeros.size();
	}
}
