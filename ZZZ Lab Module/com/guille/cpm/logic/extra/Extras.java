package com.guille.cpm.logic.extra;

import java.util.ArrayList;
import java.util.List;

public class Extras {

	private static List<Extra> extras = new ArrayList<Extra>();
	public static String EXTRA_BED_ID = "E02";
	public static String JACUZZI = "E01";
	public static String SPECIAL_BRAKFAST = "E03";
	public static String EXTRA_BIG_BED_ID = "E04";
	
	/**
	 * Returns a list of all the extras available for the cabins.
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
	
	public static Extra getExtra(String ID) {
		for(Extra e : extras) {
			if(e.getExtraID().equals(ID))
				return e;
		}
		throw new IllegalArgumentException("This id does not match with any extra");
	}

}
