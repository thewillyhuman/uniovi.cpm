package com.guille.cpm.logic;

import java.util.ArrayList;
import java.util.List;

public class Reservas {
	
	private static List<Reserva> reservas = new ArrayList<Reserva>();
	
	public static List<Reserva> getReservas() {
		return reservas;
	}
	
	public static void addReserva(Reserva r) {
		reservas.add(r);
	}

}
