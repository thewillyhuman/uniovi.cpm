package com.guille.cpm.logic.extra;

public class Extra {

	private String extraID;
	private String extra;
	private double price;
	
	/**
	 * Main constructor.
	 * 
	 * @param extraID the unique identifier of the extra.
	 * @param extra the name of the extra.
	 * @param price the price of the extra.
	 */
	public Extra(String extraID, String extra, double price) {
		this.extraID = extraID;
		this.extra = extra;
		this.price = price;
	}
	
	/**
	 * Returns the id of the extra.
	 * 
	 * @return the id of the extra.
	 */
	public String getExtraID() {
		return this.extraID;
	}
	
	/**
	 * Returns the name of the extra.
	 * 
	 * @return the name of the extra.
	 */
	public String getExtra() {
		return this.extra;
	}
	
	/**
	 * Returns the price of the extra.
	 * 
	 * @return the price of the extra.
	 */
	public double getPriceExtra() {
		return this.price;
	}
	
	@Override
	public String toString() {
		return this.extra;
	}
}
