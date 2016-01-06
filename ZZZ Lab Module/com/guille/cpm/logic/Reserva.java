package com.guille.cpm.logic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.aeat.valida.Validador;

public class Reserva {
	
	private Viaje viaje;
	private String name;
	private String surname;
	private String dni;
	private int telf;
	//private Date fechaSalida;
	private List<Camarote> camarotes;
	
	public final static double DISCOUNT = 0.15;
	
	public enum TypesOfRooms { CDI, CDE, CFI, CFE }
	
	public Reserva(Viaje viaje, String name, String surname, String dni, int telf) {
		this.viaje = viaje;
		this.name = name;
		this.surname = surname;
		setNIF(dni);
		this.telf = telf;
		camarotes = new ArrayList<Camarote>();
	}
	
	public Reserva(Viaje viaje) {
		this.viaje = viaje;
		camarotes = new ArrayList<Camarote>();
	}
	
	public Viaje getViaje() {
		return this.viaje;
	}
	
	public Crucero getCrucero() {
		return this.getViaje().getCrucero();
	}
	
	public Date getFechaSalida() {
		return viaje.getDate();
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
	
	public void setDNI(String nif) {
		setNIF(nif);
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
			CamaroteDobleInterior aux = viaje.getCamaroteDobleInteriorLibre();
			addCamarote(aux);
		} else if(e == TypesOfRooms.CDE) {
			CamaroteDobleExterior aux = viaje.getCamaroteDobleExteriorLibre();
			addCamarote(aux);
		} else if(e == TypesOfRooms.CFI) {
			CamaroteFamiliarInterior aux = viaje.getCamaroteFamiliarInteriorLibre();
			addCamarote(aux);
		} else if(e == TypesOfRooms.CFE) {
			CamaroteFamiliarExterior aux = viaje.getCamaroteFamiliarExteriorLibre();
			addCamarote(aux);
		} 
	}
	
	public void reservarCamarote(TypesOfRooms e, int persons) {
		if (e == TypesOfRooms.CDI) {
			CamaroteDobleInterior aux = viaje.getCamaroteDobleInteriorLibre();
			for(int i = 0; i < persons; i++) {
				Pasajero p = new Pasajero();
				aux.addPasajero(p);
			} addCamarote(aux);
		} else if(e == TypesOfRooms.CDE) {
			CamaroteDobleExterior aux = viaje.getCamaroteDobleExteriorLibre();
			for(int i = 0; i < persons; i++) {
				Pasajero p = new Pasajero();
				aux.addPasajero(p);
			} addCamarote(aux);
		} else if(e == TypesOfRooms.CFI) {
			CamaroteFamiliarInterior aux = viaje.getCamaroteFamiliarInteriorLibre();
			for(int i = 0; i < persons; i++) {
				Pasajero p = new Pasajero();
				aux.addPasajero(p); 
			} addCamarote(aux);
		} else if(e == TypesOfRooms.CFE) {
			CamaroteFamiliarExterior aux = viaje.getCamaroteFamiliarExteriorLibre();
			for(int i = 0; i < persons; i++) {
				Pasajero p = new Pasajero();
				aux.addPasajero(p);
			} addCamarote(aux);
		} 
	}
	
	public void reservarCamarote(Camarote c) {
		addCamarote(c);
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
	
	public double getPriceCamarote(Camarote c) {
		double price = 0.0;
		if(c instanceof CamaroteDobleInterior) {
			price += viaje.getCrucero().getBarco().getPrecioCamaroteDobleInterior()*CamaroteDoble.N_PERSONS;
		} else if (c instanceof CamaroteDobleExterior) {
			price += viaje.getCrucero().getBarco().getPrecioCamaroteDobleExterior()*CamaroteDoble.N_PERSONS;
		} else if(c instanceof CamaroteFamiliarInterior) {
			price += viaje.getCrucero().getBarco().getPrecioCamaroteFamiliarInterior()*CamaroteFamiliar.N_PERSONS;
		} else if(c instanceof CamaroteFamiliarExterior) {
			price += viaje.getCrucero().getBarco().getPrecioCamaroteFamiliarExterior()*CamaroteFamiliar.N_PERSONS;
		}
		return price;
	}
	
	public double getPriceCamaroteAndExtras(Camarote c) {
		double price = 0.0;
		price += getPriceCamarote(c);
		for(Extra e : c.getExtras()) {
			if(e.getExtra().equals("Cama supletoria")) {
				price += e.getPriceExtra();
			} else {
				price += e.getPriceExtra()*c.getNPasajeros();
			}
		}
		return price;
	}

	public double getCamarotesPrice() {
		double price = 0.0;
		for(Camarote c : camarotes) {
			price += getPriceCamarote(c);
		} return price*viaje.getCrucero().getDuracion();
	}
	
	public double getExtrasPrice() {
		double price = 0.0;
		for(Camarote c : camarotes) {
			for(Extra e : c.getExtras()) {
				if(e.getExtra().equals("Cama supletoria")) {
					price += e.getPriceExtra()*viaje.getCrucero().getDuracion();
				} else {
					price += e.getPriceExtra()*viaje.getCrucero().getDuracion()*c.getNPasajeros();
				}
			}
		} return price;
	}
	
	public double getTotalPrice() {
		return (this.getCamarotesPrice() + this.getExtrasPrice());
	}
	
	public double getDiscount() {
		double discount = 0.0;
		if(viaje.getCrucero().isDiscounted())
			discount += this.getTotalPrice()*DISCOUNT;
		return discount;
	}

	public double getTotalMinusDiscount() {
		return (this.getTotalPrice() - this.getDiscount());
	}
	
	@Override
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
		aux.append("Fecha de salida: " + this.getFechaSalida() + "\n");
		aux.append("Días: " + this.getCrucero().getDuracion() + "\n");
		aux.append("Salida: " + this.getCrucero().getStartPort() + "\n");
		aux.append("N. Pasajeros: " + this.getTotalPasajeros() + "\n");
		aux.append("Camarotes: ");
		for(Camarote c : this.getCamarotes()) {
			if(c instanceof CamaroteDobleInterior) {
				aux.append("1 doble interior / ");
				for(Extra e : c.getExtras())
					aux.append(e.getExtra() + ",");
				aux.append(";");
			} else if (c instanceof CamaroteDobleExterior) {
				aux.append("1 doble exterior / ");
				for(Extra e : c.getExtras())
					aux.append(e.getExtra() + ",");
				aux.append(";");
			} else if(c instanceof CamaroteFamiliarInterior) {
				aux.append("1 familiar interior / ");
				for(Extra e : c.getExtras())
					aux.append(e.getExtra() + ",");
				aux.append(";");
			} else if(c instanceof CamaroteFamiliarExterior) {
				aux.append("1 familiar exterior / ");
				for(Extra e : c.getExtras())
					aux.append(e.getExtra() + ",");
				aux.append(";");
			}
		}
		aux.append("\n\n**PAGADO RESERVA**\n");
		aux.append("Camarotes:\n");
		aux.append("\t" + this.getCamarotesPrice()+"\n");
		aux.append("Extras:\n");
		aux.append("\t" + this.getExtrasPrice()+" $\n");
		if(this.getCrucero().isDiscounted()) {
			aux.append("Descuento oferta:\n");
			aux.append("\t" + this.getDiscount()+" $\n");
			aux.append("Importe Total:\t\t\t"+this.getCamarotesPrice()+"$ + "+this.getExtrasPrice()+"$ - "+this.getDiscount()+"$");
		}
		aux.append("\nTOTAL...................."+this.getTotalMinusDiscount()+"$");
		return aux.toString();
	}
	
	public void print() {
		System.out.println(this.toString());
	}

	public void setCamarotes(List<Camarote> camarotes) {
		this.camarotes.clear();
		for(Camarote c : camarotes)
			addCamarote(c);
		
	}
}
