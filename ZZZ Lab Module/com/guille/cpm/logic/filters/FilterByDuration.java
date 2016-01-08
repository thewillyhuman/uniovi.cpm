package com.guille.cpm.logic.filters;

import com.guille.cpm.logic.crucero.Crucero;
import com.guille.cpm.logic.interfaces.Filter;

public class FilterByDuration implements Filter {

	@Override
	public boolean filter(Crucero b1, Object s) {
		if( b1.getDuracion() == (int) s )
			return true;
		return false;
	}

}
