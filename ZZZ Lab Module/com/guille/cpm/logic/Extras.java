package com.guille.cpm.logic;

import java.util.ArrayList;
import java.util.List;

public class Extras {

	private List<Extra> extras;
	
	public Extras() {
		extras = new ArrayList<Extra>();
	}
	
	public List<Extra> getExtras() {
		return this.extras;
	}
	
	public void addExtra(Extra extra) {
		if(extra == null)
			throw new IllegalArgumentException("The extra to be added cannot be null");
		extras.add(extra);
	}

}
