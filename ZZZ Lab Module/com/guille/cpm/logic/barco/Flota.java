package com.guille.cpm.logic.barco;

import java.util.ArrayList;
import java.util.List;

public class Flota {
	
	private static List<Barco> barcos = new ArrayList<Barco>();

	/**
	 * Returns a list containing all the ships available in the float.
	 * 
	 * @return a list containing all the ships available in the float.
	 */
	public static  List<Barco> getBarcos() {
		return barcos;
	}
	
	/**
	 * Adds a ship to the float.
	 * 
	 * @param barco ship to be added to the float.
	 */
	public static void addBarco(Barco barco) {
		if(barco == null)
			throw new IllegalArgumentException("You cannot add null ships.");
		barcos.add(barco);
	}
	
	/**
	 * Returns true if the collection of ships contains a given ship.
	 * 
	 * @param barco to be checked if is in.
	 * @return true if it is contained, false otherwise.
	 */
	public static boolean contains(Barco barco) {
		return barcos.contains(barco);
	}
	
	/**
	 * Given a ship id will return the ship object if it exists.
	 * 
	 * @param shipID the id of the ship.
	 * @return the pointer to the ship in the collection.
	 */
	public static Barco getBarco(String shipID) {
		for(Barco b : barcos) {
			if(b.getShipID().equals(shipID))
				return b;
		} return null;
	}
	
	/**
	 * Removes a ship from the collection.
	 *
	 * @param barco ship to be removed from the collection.
	 */
	public static void removeBarco(Barco barco) {
		if(barco == null)
			throw new IllegalArgumentException("You cannot remove null ships.");
		barcos.remove(barco);
	} 
}
