package com.guille.cpm.logic;

public class FilterByStartingDate implements Filter {

	@Override
	public boolean filter(Crucero b1, Object s) {
		if(b1.getSalidas().contains(s))
			return true;
		return false;
	}

}
