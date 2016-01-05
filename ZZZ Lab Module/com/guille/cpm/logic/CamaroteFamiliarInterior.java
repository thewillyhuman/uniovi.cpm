package com.guille.cpm.logic;

public class CamaroteFamiliarInterior extends CamaroteFamiliar {

	public CamaroteFamiliarInterior() {
		super();
	}

	@Override
	public String toString() {
		return "Familiar Interior";
	}
	
	@Override
	public Camarote copy() {
		Camarote c = new CamaroteFamiliarInterior();
		for(Pasajero p : this.getPasajeros())
			c.addPasajero(p);
		for(Extra e : this.getExtras())
			c.addExtra(e);
		return c;
	}

}
