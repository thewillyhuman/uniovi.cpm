package com.guille.cpm.logic;

public class Pasajero {
	
	private int age;
	
	/**
	 * Main constructor.
	 * 
	 * @param age of the passenger.
	 */
	public Pasajero(int age) {
		this.age = age;
	}
	
	/**
	 * Main auxiliary constructor no age needed.
	 */
	public Pasajero(){};
	
	/**
	 * Returns the age of the passenger.
	 * 
	 * @return the age of the passenger.
	 */
	public int getAge() {
		return this.age;
	}
	
	/**
	 * Sets the age of a passenger.
	 * 
	 * @param age to be set as the new age of the passenger.
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Returns whether a passenger is a child or not. (Under 16)
	 * 
	 * @return true if the age is less than 16, false otherwise.
	 */
	public boolean isChild() {
		return (age < 16);
	}
}
