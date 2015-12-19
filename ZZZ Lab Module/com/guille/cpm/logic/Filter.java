package com.guille.cpm.logic;

public interface Filter {
	
	/**
	 * The basic filter.
	 * 
	 * @param b1, ship to be compared to.
	 * @param s object to create the condition.
	 * @return true if the condition is satisfied. False otherwise.
	 */
	public boolean filter(Crucero b1, Object s);

}
