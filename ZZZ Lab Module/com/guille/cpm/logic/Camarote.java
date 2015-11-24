package com.guille.cpm.logic;

import java.util.ArrayList;
import java.util.List;

public class Camarote {
	
	private List<Extra> extras;
	private boolean isFree = true;
	
	public Camarote() {
		extras = new ArrayList<Extra>();
	}
	
	public List<Extra> getExtras() {
		return this.extras;
	}
	
	public void addExtra(Extra extra) {
		if(extra == null)
			throw new IllegalArgumentException("The extra to be added cannot be null");
		extras.add(extra);
	}
	
	public void removeExtra(Extra extra) {
		if(extra == null)
			throw new IllegalArgumentException("The extra to be added cannot be null");
		extras.remove(extra);
	}
	
	public void book() {
		isFree = false;
	}
	
	public boolean isFree() {
		return this.isFree;
	}
	

}
