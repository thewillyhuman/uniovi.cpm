package com.guille.cpm.logic;

public class FilterByArea implements Filter {

	@Override
	public boolean filter(Crucero o1, String s) {
		return(o1.getArea().equals(s));
	}

}
