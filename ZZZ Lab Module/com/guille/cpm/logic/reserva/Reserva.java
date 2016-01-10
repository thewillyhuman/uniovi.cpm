package com.guille.cpm.logic.reserva;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.aeat.valida.Validador;
import com.guille.cpm.igu.Messages;
import com.guille.cpm.logic.camarote.Camarote;
import com.guille.cpm.logic.camarote.CamaroteDoble;
import com.guille.cpm.logic.camarote.CamaroteDobleExterior;
import com.guille.cpm.logic.camarote.CamaroteDobleInterior;
import com.guille.cpm.logic.camarote.CamaroteFamiliar;
import com.guille.cpm.logic.camarote.CamaroteFamiliarExterior;
import com.guille.cpm.logic.camarote.CamaroteFamiliarInterior;
import com.guille.cpm.logic.crucero.Crucero;
import com.guille.cpm.logic.extra.Extra;
import com.guille.cpm.logic.pasajero.Pasajero;
import com.guille.cpm.logic.viaje.Viaje;

public class Reserva {

	private Viaje viaje;
	private String name;
	private String surname;
	private String dni;
	private int telf;
	// private Date fechaSalida;
	private List<Camarote> camarotes;

	public final static double DISCOUNT = 0.15;

	public enum TypesOfRooms {
		CDI, CDE, CFI, CFE
	}

	/**
	 * Default constructor that uses a trip, a name, a surname, a dni and a tef
	 * to create the hole reservation.
	 * 
	 * @param viaje is the trip associated with the reservation.
	 * @param name is the name of the buyer.
	 * @param surname of the buyer.
	 * @param dni of the buyer.
	 * @param telf of the buyer.
	 */
	public Reserva(Viaje viaje, String name, String surname, String dni, int telf) {
		this.viaje = viaje;
		this.name = name;
		this.surname = surname;
		setNIF(dni);
		this.telf = telf;
		camarotes = new ArrayList<Camarote>();
	}

	/**
	 * Alternative constructor that only uses a trip to create the reservation.
	 * 
	 * @param viaje is the trip to perform.
	 */
	public Reserva(Viaje viaje) {
		this.viaje = viaje;
		camarotes = new ArrayList<Camarote>();
	}

	/**
	 * Return the trip associated with the current reservation.
	 * 
	 * @return the trip associated with the current reservation.
	 */
	public Viaje getViaje() {
		return this.viaje;
	}

	/**
	 * Will return the cruise associated with the current reservation.
	 * 
	 * @return the current cruise.
	 */
	public Crucero getCrucero() {
		return this.getViaje().getCrucero();
	}

	/**
	 * The starting date for this reservation.
	 * 
	 * @return the starting date for this reservation.
	 */
	public Date getFechaSalida() {
		return viaje.getDate();
	}

	/**
	 * Returns the name of the buyer.
	 * 
	 * @return the name of the buyer.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets a name for the buyer
	 * 
	 * @param name of the buyer.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the surname for the buyer
	 * 
	 * @return surname of the buyer.
	 */
	public String getSurname() {
		return this.surname;
	}

	/**
	 * Sets the surname of the buyer.
	 * 
	 * @param surname of the buyer.
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Return an string that contains the full name (name + surname).
	 * 
	 * @return the full name (name + surname).
	 */
	public String getFullName() {
		return (this.getName() + " " + this.getSurname());
	}

	/**
	 * Return the national id of the buyer.
	 * 
	 * @return the id of the buyer.
	 */
	public String getDNI() {
		return this.dni;
	}

	/**
	 * Sets the national id for the buyer.
	 * 
	 * @param nif of the buyer.
	 */
	public void setDNI(String nif) {
		setNIF(nif);
	}

	/**
	 * Checks the nif of the buyer with a .jar extracted from the
	 * "Ministerio del Interior". If it's correct will set it.
	 * 
	 * @param nif to check and/or add.
	 */
	private void setNIF(String nif) {
		if (!validaNIF(nif, Messages.localization))
			this.dni = "-1";
		this.dni = nif;
	}

	/**
	 * Checks the nif of the buyer with a .jar extracted from the
	 * "Ministerio del Interior". Also for foreigners will override the
	 * validation.
	 * 
	 * @param nif to check.
	 * @param local current application localization.
	 * @return true if the nif is valid, false otherwise.
	 */
	public static boolean validaNIF(String nif, Locale local) {
		Validador val = new Validador();
		boolean aux = false;
		if (val.checkNif(nif) == 1 || local.equals(new Locale("en_US")))
			aux = true;
		return aux;
	}

	/**
	 * Gets the telephone of the buyer.
	 * 
	 * @return the telephone of the buyer.
	 */
	public int getTelf() {
		return this.telf;
	}

	/**
	 * Sets the phone of the buyer.
	 * 
	 * @param telf of the buyer.
	 */
	public void setTelf(int telf) {
		this.telf = telf;
	}

	/**
	 * Return the rooms contained if the list of rooms.
	 * 
	 * @return the rooms contained if the list of rooms.
	 */
	public List<Camarote> getCamarotes() {
		return this.camarotes;
	}

	/**
	 * Books a room depending on a given type of room parameter.
	 * 
	 * @param e is the room type enum.
	 */
	public void reservarCamarote(TypesOfRooms e) {
		if (e == TypesOfRooms.CDI) {
			CamaroteDobleInterior aux = viaje.getCamaroteDobleInteriorLibre();
			addCamarote(aux);
		} else if (e == TypesOfRooms.CDE) {
			CamaroteDobleExterior aux = viaje.getCamaroteDobleExteriorLibre();
			addCamarote(aux);
		} else if (e == TypesOfRooms.CFI) {
			CamaroteFamiliarInterior aux = viaje.getCamaroteFamiliarInteriorLibre();
			addCamarote(aux);
		} else if (e == TypesOfRooms.CFE) {
			CamaroteFamiliarExterior aux = viaje.getCamaroteFamiliarExteriorLibre();
			addCamarote(aux);
		}
	}

	/**
	 * Books a room from a given type of room and fills it with passengers.
	 * 
	 * @param e is the room type enum.
	 * @param persons to be added to the room.
	 */
	public void reservarCamarote(TypesOfRooms e, int persons) {
		if (e == TypesOfRooms.CDI) {
			CamaroteDobleInterior aux = viaje.getCamaroteDobleInteriorLibre();
			for (int i = 0; i < persons; i++) {
				Pasajero p = new Pasajero();
				aux.addPasajero(p);
			}
			addCamarote(aux);
		} else if (e == TypesOfRooms.CDE) {
			CamaroteDobleExterior aux = viaje.getCamaroteDobleExteriorLibre();
			for (int i = 0; i < persons; i++) {
				Pasajero p = new Pasajero();
				aux.addPasajero(p);
			}
			addCamarote(aux);
		} else if (e == TypesOfRooms.CFI) {
			CamaroteFamiliarInterior aux = viaje.getCamaroteFamiliarInteriorLibre();
			for (int i = 0; i < persons; i++) {
				Pasajero p = new Pasajero();
				aux.addPasajero(p);
			}
			addCamarote(aux);
		} else if (e == TypesOfRooms.CFE) {
			CamaroteFamiliarExterior aux = viaje.getCamaroteFamiliarExteriorLibre();
			for (int i = 0; i < persons; i++) {
				Pasajero p = new Pasajero();
				aux.addPasajero(p);
			}
			addCamarote(aux);
		}
	}

	/**
	 * Given a room this method will add it to the list of rooms.
	 * 
	 * @param c id the room to add.
	 */
	public void reservarCamarote(Camarote c) {
		addCamarote(c);
	}

	/**
	 * Removes a given room from the list of rooms.
	 * 
	 * @param c is the room.
	 */
	public void removeReserva(Camarote c) {
		if (!camarotes.contains(c))
			throw new IllegalArgumentException("This room is not booked.");
		for (Pasajero p : c.getPasajeros())
			c.removePasajero(p);
		removeCamarote(c);
	}

	/**
	 * From a given room, if it's not free (has someone on it) will add it to
	 * the list of rooms.
	 * 
	 * @param c is the room to add.
	 */
	public void addCamarote(Camarote c) {
		if (!c.isFree())
			camarotes.add(c);
	}

	/**
	 * Removes a given room from the list of rooms. ONLY IF THE ROOM IF FREE.
	 * 
	 * @param c is the room to delete.
	 */
	public void removeCamarote(Camarote c) {
		if (c.isFree())
			camarotes.remove(c);
	}

	/**
	 * Adds a given passenger to a given room.
	 * 
	 * @param p is the passenger to add.
	 * @param c the room were it will be added.
	 */
	public void addPasajeroToCamarote(Pasajero p, Camarote c) {
		if (c.isFull())
			throw new IllegalStateException("The cabin is already full. You cannot add more passangers.");
		c.addPasajero(p);
	}

	/**
	 * Remove a given passenger from a given room.
	 * 
	 * @param p is the passenger to remove.
	 * @param c is the room were the passenger will be removed.
	 */
	public void removePasajeroFromCamarote(Pasajero p, Camarote c) {
		c.removePasajero(p);
	}

	/**
	 * Adds an extra to a given room.
	 * 
	 * @param e is the extra.
	 * @param c is the room.
	 */
	public void addExtraToCamarote(Extra e, Camarote c) {
		if (e.getExtra().equals("Cama supletoria") && !c.hasChilds())
			throw new IllegalStateException("You cannot add an extra bed if there are no childs in the room.");
		else if (e.getExtra().equals("Cama supletoria") && c.hasCamaSupletoria())
			throw new IllegalStateException("You already have one extra bed for this room.");

		c.addExtra(e);
	}

	/**
	 * removes a given extra from the given room.
	 * 
	 * @param e is the extra.
	 * @param c is the room.
	 */
	public void removeExtraFromCamarote(Extra e, Camarote c) {
		c.removeExtra(e);
	}

	/**
	 * Return the total number of passengers for this current reservation.
	 * 
	 * @return the total number of passengers for this current reservation.
	 */
	public int getTotalPasajeros() {
		int pasajeros = 0;
		for (Camarote c : camarotes) {
			pasajeros += c.getNPasajeros();
		}
		return pasajeros;
	}

	/**
	 * Return the price of a given room.
	 * 
	 * @param c is the room.
	 * @return the price of a given room.
	 */
	public double getPriceCamarote(Camarote c) {
		double price = 0.0;
		if (c instanceof CamaroteDobleInterior) {
			price += viaje.getCrucero().getBarco().getPrecioCamaroteDobleInterior() * CamaroteDoble.N_PERSONS;
		} else if (c instanceof CamaroteDobleExterior) {
			price += viaje.getCrucero().getBarco().getPrecioCamaroteDobleExterior() * CamaroteDoble.N_PERSONS;
		} else if (c instanceof CamaroteFamiliarInterior) {
			price += viaje.getCrucero().getBarco().getPrecioCamaroteFamiliarInterior() * CamaroteFamiliar.N_PERSONS;
		} else if (c instanceof CamaroteFamiliarExterior) {
			price += viaje.getCrucero().getBarco().getPrecioCamaroteFamiliarExterior() * CamaroteFamiliar.N_PERSONS;
		}
		return price;
	}

	/**
	 * Return the price of a given room and its extras.
	 * 
	 * @param c is the room
	 * @return the price of a given room and its extras.
	 */
	public double getPriceCamaroteAndExtras(Camarote c) {
		double price = 0.0;
		price += getPriceCamarote(c);
		for (Extra e : c.getExtras()) {
			if (e.getExtra().equals("Cama supletoria")) {
				price += e.getPriceExtra();
			} else {
				price += e.getPriceExtra() * c.getNPasajeros();
			}
		}
		return price;
	}

	/**
	 * Gets the price of all the rooms together.
	 * 
	 * @return the price of all the rooms together.
	 */
	public double getCamarotesPrice() {
		double price = 0.0;
		for (Camarote c : camarotes) {
			price += getPriceCamarote(c);
		}
		return price * viaje.getCrucero().getDuracion();
	}

	/**
	 * gets the price of all the extras together.
	 * 
	 * @return the price of all the extras together.
	 */
	public double getExtrasPrice() {
		double price = 0.0;
		for (Camarote c : camarotes) {
			for (Extra e : c.getExtras()) {
				if (e.getExtra().equals("Cama supletoria")) {
					price += e.getPriceExtra() * viaje.getCrucero().getDuracion();
				} else {
					price += e.getPriceExtra() * viaje.getCrucero().getDuracion() * c.getNPasajeros();
				}
			}
		}
		return price;
	}

	/**
	 * Gets the total price of the reservation.
	 * 
	 * @return the total price of the reservation.
	 */
	public double getTotalPrice() {
		return (this.getCamarotesPrice() + this.getExtrasPrice());
	}

	/**
	 * Gets the total discount applied over the reservation total price.
	 * 
	 * @return the total discount applied over the reservation total price.
	 */
	public double getDiscount() {
		double discount = 0.0;
		if (viaje.getCrucero().isDiscounted())
			discount += this.getTotalPrice() * DISCOUNT;
		return discount;
	}

	/**
	 * Gets the total price before applying the discount.
	 * 
	 * @return total price before applying the discount.
	 */
	public double getTotalMinusDiscount() {
		return (this.getTotalPrice() - this.getDiscount());
	}

	/**
	 * Will return the string formatted as contract with teachers of the
	 * subject.
	 */
	@Override // max 50 lines!!!
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
		aux.append("Crucero: " + this.getCrucero().getArea() + " / " + this.getCrucero().getCodigoCrucero() + "\n");
		aux.append("Barco: " + this.getCrucero().getBarco().getName() + "\n");
		aux.append("Fecha de salida: " + this.getFechaSalida() + "\n");
		aux.append("Días: " + this.getCrucero().getDuracion() + "\n");
		aux.append("Salida: " + this.getCrucero().getStartPort() + "\n");
		aux.append("N. Pasajeros: " + this.getTotalPasajeros() + "\n");
		aux.append("Camarotes: ");
		for (Camarote c : this.getCamarotes()) {
			if (c instanceof CamaroteDobleInterior) {
				aux.append("1 doble interior / ");
				for (Extra e : c.getExtras())
					aux.append(e.getExtra() + ",");
				aux.append(";");
			} else if (c instanceof CamaroteDobleExterior) {
				aux.append("1 doble exterior / ");
				for (Extra e : c.getExtras())
					aux.append(e.getExtra() + ",");
				aux.append(";");
			} else if (c instanceof CamaroteFamiliarInterior) {
				aux.append("1 familiar interior / ");
				for (Extra e : c.getExtras())
					aux.append(e.getExtra() + ",");
				aux.append(";");
			} else if (c instanceof CamaroteFamiliarExterior) {
				aux.append("1 familiar exterior / ");
				for (Extra e : c.getExtras())
					aux.append(e.getExtra() + ",");
				aux.append(";");
			}
		}
		aux.append("\n\n**PAGADO RESERVA**\n");
		aux.append("Camarotes:\n");
		aux.append("\t" + this.getCamarotesPrice() + "\n");
		aux.append("Extras:\n");
		aux.append("\t" + this.getExtrasPrice() + " $\n");
		if (this.getCrucero().isDiscounted()) {
			aux.append("Descuento oferta:\n");
			aux.append("\t" + this.getDiscount() + " $\n");
			aux.append("Importe Total:\t\t\t" + this.getCamarotesPrice() + "$ + " + this.getExtrasPrice() + "$ - " + this.getDiscount() + "$");
		}
		aux.append("\nTOTAL...................." + this.getTotalMinusDiscount() + "$");
		return aux.toString();
	}

	/**
	 * Prints by console the toString method.
	 */
	public void print() {
		System.out.println(this.toString());
	}

	/**
	 * Given a lists of rooms will add every element on it to the current list
	 * of rooms.
	 * 
	 * @param camarotes is the lists of rooms to add.
	 */
	public void setCamarotes(List<Camarote> camarotes) {
		this.camarotes.clear();
		for (Camarote c : camarotes)
			addCamarote(c);

	}

	/**
	 * Given a list of rooms will remove every single room on it from the
	 * current list of rooms.
	 * 
	 * @param camarotes are the rooms to delete.
	 */
	public void removeCamarotes(List<Camarote> camarotes) {
		for (Camarote c : camarotes) {
			if (this.camarotes.contains(c)) {
				this.camarotes.remove(c);
			}
		}
	}
}
