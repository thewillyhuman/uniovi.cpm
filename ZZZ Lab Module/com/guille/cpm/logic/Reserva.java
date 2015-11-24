package com.guille.cpm.logic;

public class Reserva {
	
	private Crucero crucero;
	private String name;
	private String surname;
	private String dni;
	private int telf;
	
	public Reserva(Crucero crucero, String name, String surname, String dni, int telf) {
		this.crucero = crucero;
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.telf = telf;
	}
	
	public Crucero getCrucero() {
		return this.crucero;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public String getFullName() {
		return (this.getName()+" "+this.getSurname());
	}
	
	public String getDNI() {
		return this.dni;
	}
	
	public int getTelf() {
		return this.telf;
	}

}
