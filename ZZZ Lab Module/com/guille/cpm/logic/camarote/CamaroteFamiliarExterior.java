package com.guille.cpm.logic.camarote;

import com.guille.cpm.logic.extra.Extra;
import com.guille.cpm.logic.pasajero.Pasajero;

public class CamaroteFamiliarExterior extends CamaroteFamiliar {

	public CamaroteFamiliarExterior() {
		super();
	}

	@Override
	public String toString() {
		return "Familiar Exterior";
	}

	@Override
	public Camarote copy() {
		Camarote c = new CamaroteFamiliarExterior();
		for(Pasajero p : this.getPasajeros())
			c.addPasajero(p);
		for(Extra e : this.getExtras())
			c.addExtra(e);
		return c;
	}

}
