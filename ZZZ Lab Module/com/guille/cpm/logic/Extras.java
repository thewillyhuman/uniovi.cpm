package com.guille.cpm.logic;

import java.util.ArrayList;
import java.util.List;

public class Extras {

	private static List<Extra> extras = new ArrayList<Extra>();
	
	public static List<Extra> getExtras() {
		return extras;
	}
	
	public static void addExtra(Extra extra) {
		if(extra == null)
			throw new IllegalArgumentException("The extra to be added cannot be null");
		extras.add(extra);
	}

}
