package com.guille.cpm.logic.reserva;

import java.util.ArrayList;
import java.util.List;

public class Reservas {
	
	private static List<Reserva> reservas = new ArrayList<Reserva>();
	
	/**
	 * Gets a copy of the list of reservations.
	 * 
	 * @return a copy of the list of reservations.
	 */
	public static List<Reserva> getReservas() {
		List<Reserva> aux = new ArrayList<Reserva>();
		for(Reserva r : reservas)
			aux.add(r);
		return aux;
	}
	
	/**
	 * Adds the given reservation to the list of reservations.
	 * 
	 * @param r is the room to add.
	 */
	public static void addReserva(Reserva r) {
		reservas.add(r);
	}

}
