package com.guille.cpm.logic.camarote;

import com.guille.cpm.logic.extra.Extra;
import com.guille.cpm.logic.pasajero.Pasajero;

public class CamaroteDobleExterior extends CamaroteDoble {

	public CamaroteDobleExterior() {
		super();
	}

	@Override
	public String toString() {
		return "Doble Exterior";
	}

	@Override
	public Camarote copy() {
		Camarote c = new CamaroteDobleExterior();
		for(Pasajero p : this.getPasajeros())
			c.addPasajero(p);
		for(Extra e : this.getExtras())
			c.addExtra(e);
		return c;
	}
}
