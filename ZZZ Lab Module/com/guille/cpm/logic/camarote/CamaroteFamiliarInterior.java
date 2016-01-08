package com.guille.cpm.logic.camarote;

import com.guille.cpm.logic.extra.Extra;
import com.guille.cpm.logic.pasajero.Pasajero;

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
