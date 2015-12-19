package com.guille.cpm.logic;

import java.util.ArrayList;
import java.util.List;

public class Extras {

	private static List<Extra> extras = new ArrayList<Extra>();
	
	/**
	 * Returns a list of all the extras avaliable for the cabins.
	 * 
	 * @return
	 */
	public static List<Extra> getExtras() {
		return extras;
	}
	
	/**
	 * Adds an extra to the collection of extras.
	 * 
	 * @param extra to be added to the collection.
	 */
	public static void addExtra(Extra extra) {
		if(extra == null)
			throw new IllegalArgumentException("The extra to be added cannot be null");
		extras.add(extra);
	}

}
