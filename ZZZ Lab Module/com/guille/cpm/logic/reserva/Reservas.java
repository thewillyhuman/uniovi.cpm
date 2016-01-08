package com.guille.cpm.logic.reserva;

import java.util.ArrayList;
import java.util.List;

public class Reservas {
	
	private static List<Reserva> reservas = new ArrayList<Reserva>();
	
	public static List<Reserva> getReservas() {
		List<Reserva> aux = new ArrayList<Reserva>();
		for(Reserva r : reservas)
			aux.add(r);
		return aux;
	}
	
	public static void addReserva(Reserva r) {
		reservas.add(r);
	}

}
