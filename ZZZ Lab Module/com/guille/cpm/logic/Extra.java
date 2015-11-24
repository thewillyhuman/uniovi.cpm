package com.guille.cpm.logic;

public class Extra {

	private String extraID;
	private String extra;
	private double price;
	
	public Extra(String extraID, String extra, double price) {
		this.extraID = extraID;
		this.extra = extra;
		this.price = price;
	}
	
	public String getExtraID() {
		return this.extraID;
	}
	
	public String getExtra() {
		return this.extra;
	}
	
	public double getPriceExtra() {
		return this.price;
	}
}
