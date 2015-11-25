package com.guille.cpm.logic;

import java.util.ArrayList;
import java.util.List;

import com.aeat.valida.Validador;

public class Reserva {
	
	private Crucero crucero;
	private String name;
	private String surname;
	private String dni;
	private int telf;
	private List<Camarote> camarotes;
	
	public final static double DISCOUNT = 0.15;
	
	public enum TypesOfRooms { CDI, CDE, CFI, CFE }
	
	public Reserva(Crucero crucero, String name, String surname, String dni, int telf) {
		this.crucero = crucero;
		this.name = name;
		this.surname = surname;
		setNIF(dni);
		this.telf = telf;
		camarotes = new ArrayList<Camarote>();
	}
	
	public Reserva(Crucero crucero) {
		this.crucero = crucero;
		camarotes = new ArrayList<Camarote>();
	}
	
	public Crucero getCrucero() {
		return this.crucero;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getFullName() {
		return (this.getName()+" "+this.getSurname());
	}
	
	public String getDNI() {
		return this.dni;
	}
	
	private void setNIF(String nif) {
		if(!validaNIF(nif))
			throw new IllegalArgumentException("This nif is not valid, please enter a valid one.");
		this.dni = nif;
	}
	
	public static boolean validaNIF(String nif) {
		Validador val = new Validador();
		boolean aux = false;
		if(val.checkNif(nif) == 1) 
			aux = true;
		return aux;
	}
	
	public int getTelf() {
		return this.telf;
	}
	
	public void setTelf(int telf) {
		this.telf = telf;
	}
	
	public void reservarCamarote(TypesOfRooms e) {
		if (e == TypesOfRooms.CDI) {
			CamaroteDobleInterior aux = crucero.getBarco().getCamaroteDobleInteriorLibre();
			addCamarote(aux);
		} else if(e == TypesOfRooms.CDE) {
			CamaroteDobleExterior aux = crucero.getBarco().getCamaroteDobleExteriorLibre();
			addCamarote(aux);
		} else if(e == TypesOfRooms.CFI) {
			CamaroteFamiliarInterior aux = crucero.getBarco().getCamaroteFamiliarInteriorLibre();
			addCamarote(aux);
		} else if(e == TypesOfRooms.CFE) {
			CamaroteFamiliarExterior aux = crucero.getBarco().getCamaroteFamiliarExteriorLibre();
			addCamarote(aux);
		} 
	}
	
	public void reservarCamarote(TypesOfRooms e, int persons) {
		if (e == TypesOfRooms.CDI) {
			CamaroteDobleInterior aux = crucero.getBarco().getCamaroteDobleInteriorLibre();
			for(int i = 0; i < persons; i++) {
				Pasajero p = new Pasajero();
				aux.addPasajero(p);
			} addCamarote(aux);
		} else if(e == TypesOfRooms.CDE) {
			CamaroteDobleExterior aux = crucero.getBarco().getCamaroteDobleExteriorLibre();
			for(int i = 0; i < persons; i++) {
				Pasajero p = new Pasajero();
				aux.addPasajero(p);
			} addCamarote(aux);
		} else if(e == TypesOfRooms.CFI) {
			CamaroteFamiliarInterior aux = crucero.getBarco().getCamaroteFamiliarInteriorLibre();
			for(int i = 0; i < persons; i++) {
				Pasajero p = new Pasajero();
				aux.addPasajero(p); 
			} addCamarote(aux);
		} else if(e == TypesOfRooms.CFE) {
			CamaroteFamiliarExterior aux = crucero.getBarco().getCamaroteFamiliarExteriorLibre();
			for(int i = 0; i < persons; i++) {
				Pasajero p = new Pasajero();
				aux.addPasajero(p);
			} addCamarote(aux);
		} 
	}
	
	public void removeReserva(Camarote c) {
		if(!camarotes.contains(c))
			throw new IllegalArgumentException("This room is not booked.");
		for(Pasajero p : c.getPasajeros())
			c.removePasajero(p);
		removeCamarote(c);
	}
	
	public void addCamarote(Camarote c) {
		c.book();
		camarotes.add(c);
	}
	
	public void removeCamarote(Camarote c) {
		c.unBook();
		camarotes.remove(c);
	}
	
	public void addPasajeroToCamarote(Pasajero p, Camarote c) {
		c.addPasajero(p);
	}
	
	public void removePasajeroFromCamarote(Pasajero p, Camarote c) {
		c.removePasajero(p);
	}
	
	public void addExtraToCamarote(Extra e, Camarote c) {
		if(e.getExtra() == "Cama supletoria" && !c.hasChilds())
			throw new IllegalStateException("You cannot add an extra bed if there are no childs in the room.");
		else if(e.getExtra() == "Cama supletoria" && c.hasCamaSupletoria())
			throw new IllegalStateException("You already have one extra bed for this room.");
		
		c.addExtra(e);
	}
	
	public void removeExtraFromCamarote(Extra e, Camarote c) {
		c.removeExtra(e);
	}
	
	public int getTotalPasajeros() {
		int pasajeros = 0;
		for(Camarote c : camarotes) {
			pasajeros += c.getNPasajeros();
		} return pasajeros;
	}

	public double getCamarotesPrice() {
		double price = 0.0;
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteDobleInterior) {
				price += crucero.getBarco().getPrecioCamaroteDobleInterior();
			} else if (c instanceof CamaroteDobleExterior) {
				price += crucero.getBarco().getPrecioCamaroteDobleExterior();
			} else if(c instanceof CamaroteFamiliarInterior) {
				price += crucero.getBarco().getPrecioCamaroteFamiliarInterior();
			} else if(c instanceof CamaroteFamiliarExterior) {
				price += crucero.getBarco().getPrecioCamaroteFamiliarExterior();
			}
		} return price;
	}
	
	public double getExtrasPrice() {
		double price = 0.0;
		for(Camarote c : camarotes) {
			for(Extra e : c.getExtras()) {
				if(e.getExtra() == "Cama supletoria") {
					price += e.getPriceExtra()*crucero.getDuracion();
				} else {
					price += e.getPriceExtra()*crucero.getDuracion()*c.getNPasajeros();
				}
			}
		} return price;
	}
	
	public double getTotalPrice() {
		return (this.getCamarotesPrice() + this.getExtrasPrice());
	}
	
	public double getDiscount() {
		double discount = 0.0;
		if(crucero.isDiscounted())
			discount += this.getTotalPrice()*DISCOUNT;
		return discount;
	}

	public double getTotalMinusDiscount() {
		return (this.getTotalPrice() - this.getDiscount());
	}
}
