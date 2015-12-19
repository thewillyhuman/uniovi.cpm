package com.guille.cpm.logic;

public class FilterByStartingPort implements Filter {

	@Override
	public boolean filter(Crucero b1, Object s) {
		if(b1.getStartPort().equals(s))
			return true;
		return false;
	}

}
