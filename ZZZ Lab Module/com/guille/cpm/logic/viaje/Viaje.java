package com.guille.cpm.logic.viaje;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.guille.cpm.logic.camarote.Camarote;
import com.guille.cpm.logic.camarote.CamaroteDobleExterior;
import com.guille.cpm.logic.camarote.CamaroteDobleInterior;
import com.guille.cpm.logic.camarote.CamaroteFamiliarExterior;
import com.guille.cpm.logic.camarote.CamaroteFamiliarInterior;
import com.guille.cpm.logic.crucero.Crucero;
import com.guille.cpm.logic.interfaces.CanBeFull;

public class Viaje implements CanBeFull {

	private Crucero crucero;
	private Date fecha;
	private List<Camarote> camarotes;
	
	/**
	 * Default constructor for a trip from a cruise and a date.
	 * 
	 * @param crucero  
	 * @param fecha
	 */
	public Viaje(Crucero crucero, Date fecha) {
		setCrucero(crucero);
		setDate(fecha);
		camarotes = new ArrayList<Camarote>();
		createRooms(getCrucero().getBarco().getNCamarotesDoblesInteriores(), getCrucero().getBarco().getNCamarotesDoblesExteriores(), getCrucero().getBarco().getNCamarotesFamiliaresInteriores(), getCrucero().getBarco().getNCamarotesFamiliaresExteriores());
	}
	
	/**
	 * Gives the cruise associated with the current trip.
	 * 
	 * @return the cruise associated with the current trip.
	 */
	public Crucero getCrucero() {
		return this.crucero;
	}
	
	/**
	 * Sets the current cruise.
	 * 
	 * @param crucero the be set as current.
	 */
	public void setCrucero(Crucero crucero) {
		if(crucero == null)
			throw new IllegalArgumentException("The curcero cannot be null");
		this.crucero = crucero;
	}
	
	/**
	 * Gets the current date for the trip.
	 * 
	 * @return the current date for the trip.
	 */
	public Date getDate() {
		return this.fecha;
	}
	
	/**
	 * Sets the date for the current trip.
	 * 
	 * @param fecha is the date for the current trip.
	 */
	public void setDate(Date fecha) {
		if(fecha == null)
			throw new IllegalArgumentException("The fecha cannot be null");
		this.fecha = fecha;
	}
	
	/**
	 * Returns a list of rooms with the rooms for this trip.
	 * 
	 * @return a list of rooms with the rooms for this trip.
	 */
	public List<Camarote> getCamarotes() {
		return this.camarotes;
	}
	
	/**
	 * Given some ship properties will fill the ship with the necessary rooms.
	 * 
	 * @param NCamDI Number of double interior cabins.
	 * @param NCamDE Number of double exterior cabins.
	 * @param NCamFI Number of familiar interior cabins.
	 * @param NCamFE Number of familiar exterior cabins.
	 */
	private void createRooms(int NCamDI, int NCamDE, int NCamFI, int NCamFE) {
		// Creating the double interior rooms.
		for(int i = 0; i < NCamDI; i++) {
			CamaroteDobleInterior aux = new CamaroteDobleInterior();
			camarotes.add(aux);
		}
		
		// Creating the double exterior rooms
		for(int i = 0; i < NCamDE; i++) {
			CamaroteDobleExterior aux = new CamaroteDobleExterior();
			camarotes.add(aux);
		}
		
		// Creating the family interior rooms.
		for(int i = 0; i < NCamFI; i++) {
			CamaroteFamiliarInterior aux = new CamaroteFamiliarInterior();
			camarotes.add(aux);
		}
		
		// Creating the family exterior rooms.
		for(int i = 0; i < NCamFE; i++) {
			CamaroteFamiliarExterior aux = new CamaroteFamiliarExterior();
			camarotes.add(aux);
		}
	}
	
	public void setCamaroteAsFree(Camarote c) {
		if(!camarotes.contains(c))
			throw new IllegalArgumentException("This camarote is not in the collection");
		c.getPasajeros().clear();
	}
	
	/**
	 * Returns the number of free cabins in the trip.
	 * 
	 * @return the number of free cabins in the trip.
	 */
	public int getCamarotesLibres() {
		int i = 0;
		for(Camarote c : camarotes) {
			if(c.isFree()) {
				i++;
			}
		} return i;
	}
	
	/**
	 * Returns the number of free double interior cabins.
	 * 
	 * @return the number of free double interior cabins.
	 */
	public int getCamarotesDoblesInterioresLibres() {
		int i = 0;
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteDobleInterior && c.isFree()) {
				i++;
			}
		} return i;
	}
	
	/**
	 * Returns the number of free double exterior cabins.
	 * 
	 * @return the number of free double exterior cabins.
	 */
	public int getCamarotesDoblesExterioresLibres() {
		int i = 0;
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteDobleExterior && c.isFree()) {
				i++;
			}
		} return i;
	}
	
	/**
	 * Returns the number of free familiar interior cabins.
	 * 
	 * @return the number of free familiar interior cabins.
	 */
	public int getCamarotesFamiliaresInterioresLibres() {
		int i = 0;
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteFamiliarInterior && c.isFree()) {
				i++;
			}
		} return i;
	}
	
	/**
	 * Returns the number of free familiar exterior cabins.
	 * 
	 * @return the number of free familiar exterior cabins.
	 */
	public int getCamarotesFamiliaresEterioresLibres() {
		int i = 0;
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteFamiliarExterior && c.isFree()) {
				i++;
			}
		} return i;
	}
	
	//---
	
	/**
	 * Returns the first free double interior cabin.
	 * 
	 * @return the first free double interior cabin.
	 */
	public CamaroteDobleInterior getCamaroteDobleInteriorLibre() {
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteDobleInterior && c.isFree())
				return (CamaroteDobleInterior) c;
		} return null;
	}
	
	/**
	 * Returns the first free double exterior cabin.
	 * 
	 * @return the first free double exterior cabin.
	 */
	public CamaroteDobleExterior getCamaroteDobleExteriorLibre() {
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteDobleExterior && c.isFree()) 
				return (CamaroteDobleExterior) c;
		} return null;
	}
	
	/**
	 * Returns the first free familiar interior cabin.
	 * 
	 * @return the first free familiar interior cabin.
	 */
	public CamaroteFamiliarInterior getCamaroteFamiliarInteriorLibre() {
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteFamiliarInterior && c.isFree()) 
				return (CamaroteFamiliarInterior) c;
		} return null;
	}
	
	/**
	 * Returns the first free familiar exterior cabin.
	 * 
	 * @return the first free familiar exterior cabin.
	 */
	public CamaroteFamiliarExterior getCamaroteFamiliarExteriorLibre() {
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteFamiliarExterior && c.isFree())
				return (CamaroteFamiliarExterior) c;
		} return null;
	}

	@Override
	public boolean isFull() {
		if(getCamarotesLibres() == 0)
			return true;
		return false;
	}
}
