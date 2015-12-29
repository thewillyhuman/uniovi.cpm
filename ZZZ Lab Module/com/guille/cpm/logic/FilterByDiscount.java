package com.guille.cpm.logic;

public class FilterByDiscount implements Filter {

	@Override
	public boolean filter(Crucero b1, Object s) {
		if(b1.isDiscounted() == (boolean) s)
			return true;
		return false;
	}

}
