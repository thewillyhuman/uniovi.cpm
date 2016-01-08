package com.guille.cpm.logic.camarote;

import com.guille.cpm.logic.extra.Extra;
import com.guille.cpm.logic.pasajero.Pasajero;

public class CamaroteDobleInterior extends CamaroteDoble {

	public CamaroteDobleInterior() {
		super();
	}

	@Override
	public String toString() {
		return "Doble Interior";
	}
	
	@Override
	public Camarote copy() {
		Camarote c = new CamaroteDobleInterior();
		for(Pasajero p : this.getPasajeros())
			c.addPasajero(p);
		for(Extra e : this.getExtras())
			c.addExtra(e);
		return c;
	}
}
