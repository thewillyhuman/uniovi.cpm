package com.guille.cpm.logic;

public class Pasajero {
	
	private int age;
	
	public Pasajero(int age) {
		this.age = age;
	}
	
	public Pasajero(){};
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public boolean isChild() {
		return (age < 16);
	}
}
