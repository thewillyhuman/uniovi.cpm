package com.guille.cpm.logic;

import java.util.ArrayList;
import java.util.List;

public class Cruceros {

	private static List<Crucero> cruceros = new ArrayList<Crucero>();

	/**
	 * Returns a list containing all the trips of this agency.
	 * 
	 * @return a list containing all the trips.
	 */
	public static List<Crucero> getCruceros() {
		List<Crucero> aux = new ArrayList<Crucero>();
		for(Crucero c : cruceros)
			aux.add(c);
		return aux;
	}

	/**
	 * Returns the trip associated with the id provided if it's contained in
	 * the list of trips, otherwise will return null.
	 * 
	 * @param crCode is the code of the trip.
	 * @return the trip associated with or null if its not contained by the list.
	 */
	public static Crucero getCrucero(String crCode) {
		for (Crucero c : cruceros) {
			if (c.getCodigoCrucero().equals(crCode))
				return c;
		}
		return null;
	}

	/**
	 * Adds a trip to the trips list.
	 * 
	 * @param crucero to be added to the trip.
	 */
	public static void addCrucero(Crucero crucero) {
		cruceros.add(crucero);
	}

	/**
	 * Removes a trip from the trips list.
	 * 
	 * @param crucero to be removed from the list of trips.
	 */
	public static void removeCrucero(Crucero crucero) {
		cruceros.remove(cruceros);
	}

	/**
	 * Returns a list with the trips after applying the filter.
	 * 
	 * @param f, the filter.
	 * @param s, string to match.
	 * @return a list with the trips after applying the filter.
	 */
	public static List<Crucero> filterCrucero(Filter f, Object s) {
		List<Crucero> aux = new ArrayList<Crucero>();
		for (Crucero c : cruceros) {
			if (f.filter(c, s))
				aux.add(c);
		}
		return aux;
	}
	
	/**
	 * Returns a list with the trips after applying the filter.
	 * 
	 * @param f, the filter.
	 * @param s, string to match.
	 * @return a list with the trips after applying the filter.
	 */
	public static List<Crucero> inverseFilterCrucero(Filter f, Object s) {
		List<Crucero> aux = new ArrayList<Crucero>();
		for (Crucero c : cruceros) {
			if (!f.filter(c, s))
				aux.add(c);
		}
		return aux;
	}

}
