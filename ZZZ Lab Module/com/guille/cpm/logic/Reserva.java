package com.guille.cpm.logic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.aeat.valida.Validador;

public class Reserva {
	
	private Crucero crucero;
	private String name;
	private String surname;
	private String dni;
	private int telf;
	private Date fechaSalida;
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
	
	public Date getFechaSalida() {
		return this.fechaSalida;
	}
	
	/**
	 * format dd/mm/yyyy.
	 * @param str
	 * @throws ParseException
	 */
	public void setFechaSalida(String str) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		this.fechaSalida = dateFormat.parse(str);
	}
	
	public void setFechaSalida(Date date) {
		this.fechaSalida = date;
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
	
	public List<Camarote> getCamarotes() {
		return this.camarotes;
	}
	
	public void reservarCamarote(TypesOfRooms e) {
		if (e == TypesOfRooms.CDI) {
			CamaroteDobleInterior aux = crucero.getCamaroteDobleInteriorLibre();
			addCamarote(aux);
		} else if(e == TypesOfRooms.CDE) {
			CamaroteDobleExterior aux = crucero.getCamaroteDobleExteriorLibre();
			addCamarote(aux);
		} else if(e == TypesOfRooms.CFI) {
			CamaroteFamiliarInterior aux = crucero.getCamaroteFamiliarInteriorLibre();
			addCamarote(aux);
		} else if(e == TypesOfRooms.CFE) {
			CamaroteFamiliarExterior aux = crucero.getCamaroteFamiliarExteriorLibre();
			addCamarote(aux);
		} 
	}
	
	public void reservarCamarote(TypesOfRooms e, int persons) {
		if (e == TypesOfRooms.CDI) {
			CamaroteDobleInterior aux = crucero.getCamaroteDobleInteriorLibre();
			for(int i = 0; i < persons; i++) {
				Pasajero p = new Pasajero();
				aux.addPasajero(p);
			} addCamarote(aux);
		} else if(e == TypesOfRooms.CDE) {
			CamaroteDobleExterior aux = crucero.getCamaroteDobleExteriorLibre();
			for(int i = 0; i < persons; i++) {
				Pasajero p = new Pasajero();
				aux.addPasajero(p);
			} addCamarote(aux);
		} else if(e == TypesOfRooms.CFI) {
			CamaroteFamiliarInterior aux = crucero.getCamaroteFamiliarInteriorLibre();
			for(int i = 0; i < persons; i++) {
				Pasajero p = new Pasajero();
				aux.addPasajero(p); 
			} addCamarote(aux);
		} else if(e == TypesOfRooms.CFE) {
			CamaroteFamiliarExterior aux = crucero.getCamaroteFamiliarExteriorLibre();
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
		if(!c.isFree())
			camarotes.add(c);
	}
	
	public void removeCamarote(Camarote c) {
		if(c.isFree())
			camarotes.remove(c);
	}
	
	public void addPasajeroToCamarote(Pasajero p, Camarote c) {
		if(c.isFull())
			throw new IllegalStateException("The cabin is already full. You cannot add more passangers.");
		c.addPasajero(p);
	}
	
	public void removePasajeroFromCamarote(Pasajero p, Camarote c) {
		c.removePasajero(p);
	}
	
	public void addExtraToCamarote(Extra e, Camarote c) {
		if(e.getExtra().equals("Cama supletoria") && !c.hasChilds())
			throw new IllegalStateException("You cannot add an extra bed if there are no childs in the room.");
		else if(e.getExtra().equals("Cama supletoria") && c.hasCamaSupletoria())
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
				if(e.getExtra().equals("Cama supletoria")) {
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
	
	public String toString() {
		StringBuilder aux = new StringBuilder();
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		Date date = new Date();
		aux.append("JUSTIFICANTE DE RESERVA - NOMBRE EMPRESA - " + dateFormat.format(date) + "\n");
		aux.append("---------------------------------------------------------------------\n");
		aux.append("NOMBRE: " + this.getName() + "  NIF: " + this.getDNI() + "  TEL: " + this.getTelf() + "\n");
		aux.append("\n");
		aux.append("\n");
		aux.append("**DATOS DEL CRUCERO**\n");
		aux.append("Crucero: " + this.getCrucero().getArea() + " / "+this.getCrucero().getCodigoCrucero() + "\n");
		aux.append("Barco: " + this.getCrucero().getBarco().getName() + "\n");
		aux.append("Fecha de salida: " + this.fechaSalida + "\n");
		aux.append("Días: " + this.getCrucero().getDuracion() + "\n");
		aux.append("Salida: " + this.getCrucero().getStartPort() + "\n");
		aux.append("N. Pasajeros: " + this.getTotalPasajeros() + "\n");
		aux.append("Camarotes: ");
		for(Camarote c : this.getCamarotes()) {
			if(c instanceof CamaroteDobleInterior) {
				aux.append("1 doble interior / ");
				for(Extra e : c.getExtras())
					aux.append(e.getExtra() + ",");
				aux.append(";\n");
			} else if (c instanceof CamaroteDobleExterior) {
				aux.append("1 doble exterior / ");
				for(Extra e : c.getExtras())
					aux.append(e.getExtra() + ",");
				aux.append(";\n");
			} else if(c instanceof CamaroteFamiliarInterior) {
				aux.append("1 familiar interior / ");
				for(Extra e : c.getExtras())
					aux.append(e.getExtra() + ",");
				aux.append(";\n");
			} else if(c instanceof CamaroteFamiliarExterior) {
				aux.append("1 familiar exterior / ");
				for(Extra e : c.getExtras())
					aux.append(e.getExtra() + ",");
				aux.append(";\n");
			}
		}
		aux.append("**PAGADO RESERVA**\n");
		aux.append("Camarotes:\n");
		aux.append("\t\t" + this.getCamarotesPrice()+"\n");
		aux.append("Extras:\n");
		aux.append("\t\t" + this.getExtrasPrice()+"\n");
		if(this.getCrucero().isDiscounted()) {
			aux.append("Descuento oferta:\n");
			aux.append("\t\t" + this.getDiscount()+"\n");
			aux.append("Importe Total:\t\t\t"+this.getCamarotesPrice()+"+"+this.getExtrasPrice()+"-"+this.getDiscount()+"Euros.");
		}
		aux.append("TOTAL...................."+this.getTotalPrice()+"Euros.");
		return aux.toString();
	}
	
	public void print() {
		System.out.println(this.toString());
	}
}
