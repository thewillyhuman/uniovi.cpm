package com.guille.cpm.logic;

public class FilterByDuration implements Filter {

	@Override
	public boolean filter(Crucero b1, Object s) {
		if( b1.getDuracion() == (int) s )
			return true;
		return false;
	}

}
