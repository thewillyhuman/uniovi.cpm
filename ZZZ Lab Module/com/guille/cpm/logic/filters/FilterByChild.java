package com.guille.cpm.logic.filters;

import com.guille.cpm.logic.crucero.Crucero;
import com.guille.cpm.logic.interfaces.Filter;

public class FilterByChild implements Filter {

	@Override
	public boolean filter(Crucero b1, Object s) {
		if(b1.getAcceptUnder16() == (boolean) s)
			return true;
		return false;
	}

}
