package com.guille.cpm.logic;

public class FilterByArea implements Filter {

	@Override
	public boolean filter(Crucero o1, Object s) {
		return(o1.getArea().equals(s));
	}

}
