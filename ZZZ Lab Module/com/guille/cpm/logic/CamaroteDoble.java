package com.guille.cpm.logic;

public class CamaroteDoble extends Camarote {
	
	/**
	 * The maximum number of persons that this kind of cabin can be stored.
	 */
	public final static int N_PERSONS = 2;

	
	public CamaroteDoble() {
		super();
	}

	@Override
	public boolean isFull() {
		int aux = 0;
		if(this.hasCamaSupletoria()) aux = 1;
		return ((this.getPasajeros().size() <= N_PERSONS+aux));
	}

}
