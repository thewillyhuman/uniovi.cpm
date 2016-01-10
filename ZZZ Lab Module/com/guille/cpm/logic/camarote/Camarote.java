package com.guille.cpm.logic.camarote;

import java.util.ArrayList;
import java.util.List;

import com.guille.cpm.logic.extra.Extra;
import com.guille.cpm.logic.interfaces.CanBeFull;
import com.guille.cpm.logic.pasajero.Pasajero;

public abstract class Camarote implements CanBeFull{
	
	private List<Extra> extras;
	private List<Pasajero> pasajeros;
	
	/**
	 * Main constructor.
	 */
	public Camarote() {
		extras = new ArrayList<Extra>();
		pasajeros = new ArrayList<Pasajero>();
	}
	
	/**
	 * Return a list containing all the extras selected for this cabin.
	 * 
	 * @return a list containing all the extras selected for this cabin.
	 */
	public List<Extra> getExtras() {
		return this.extras;
	}
	
	/**
	 * Return a list containing all the passengers on this cabin.
	 * 
	 * @return a list of passengers on this cabin.
	 */
	public List<Pasajero> getPasajeros() {
		return this.pasajeros;
	}
	
	/**
	 * Adds a passenger to the cabin.
	 * 
	 * @param p passenger to be added.
	 */
	public void addPasajero(Pasajero p) {
		if(p == null)
			throw new IllegalArgumentException("The passanger to be added cannot be null");
		pasajeros.add(p);
	}
	
	/**
	 * Removes a given passenger from the cabin.
	 * 
	 * @param p passenger to be removed from the cabin.
	 */
	public void removePasajero(Pasajero p) {
		if(p == null)
			throw new IllegalArgumentException("The passanger to be removed cannot be null");
		pasajeros.remove(p);
	}
	
	/**
	 * Adds an extra to the cabin.
	 * 
	 * @param extra to be added.
	 */
	public void addExtra(Extra extra) {
		if(extra == null)
			throw new IllegalArgumentException("The extra to be added cannot be null");
		extras.add(extra);
	}
	
	/**
	 * Removes an extra from the extras in the cabin.
	 * 
	 * @param extra to be removed from the cabin extras.
	 */
	public void removeExtra(Extra extra) {
		if(extra == null)
			throw new IllegalArgumentException("The extra to be removed cannot be null");
		extras.remove(extra);
	}
	
	/**
	 * Return whether the cabin is empty or not.
	 * A cabin will be empty whenever does not contain any passenger.
	 * 
	 * @return true if the cabin does not contain any passenger. False otherwise.
	 */
	public boolean isFree() {
		return this.pasajeros.isEmpty();
	}
	
	/**
	 * Return true whether the cabin contains an extra bed on its extras or not.
	 * 
	 * @return true if the cabin has an extra bed. False otherwise.
	 */
	public boolean hasCamaSupletoria() {
		for(Extra e : this.getExtras()) {
			if(e.getExtra().equals("Cama supletoria"))
				return true;
		} return false;
	}
	
	/**
	 * Return true when the cabin contains a child (passenger under 16).
	 * 
	 * @return true if the cabin contains a child (passenger under 16), false otherwise.
	 */
	public boolean hasChilds() {
		for(Pasajero p : this.getPasajeros()) {
			if(p.isChild())
				return true;
		} return false;
	}
	
	/**
	 * Return the number of passengers in the cabin.
	 * 
	 * @return the number of passengers in the cabin.
	 */
	public int getNPasajeros() {
		return pasajeros.size();
	}
	
	/**
	 * Validates a cabin. A cabin is not valid when:
	 * 	1. Has an extra bed but no child.
	 * 	2. The number of passengers is 0.
	 * 	3. Contains more than one extra bed.
	 * 
	 * @return true if the cabin is validated, false otherwise.
	 */
	public boolean validate() {
		int nExtraBeds = 0;
		for(Extra e : extras) {
			if(e.getExtra().equals("Cama supletoria"))
				nExtraBeds++;
		}
		if(this.hasCamaSupletoria() && !this.hasChilds()) {
			return false;
		} else if(this.getNPasajeros() == 0) {
			return false;
		} else if(nExtraBeds > 1) {
			return false;
		} else { return true; }
	}
	
	/**
	 * Creates a copy of the current room.
	 * 
	 * @return a copy of the current room.
	 */
	public abstract Camarote copy();
	
	@Override
	public abstract String toString();
}
