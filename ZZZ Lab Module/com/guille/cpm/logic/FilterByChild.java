package com.guille.cpm.logic;

public class FilterByChild implements Filter {

	@Override
	public boolean filter(Crucero b1, Object s) {
		if(b1.getAcceptUnder16() == (boolean) s)
			return true;
		return false;
	}

}
