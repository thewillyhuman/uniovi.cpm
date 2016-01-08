package com.guille.cpm.logic.filters;

import com.guille.cpm.logic.crucero.Crucero;
import com.guille.cpm.logic.interfaces.Filter;

public class FilterByArea implements Filter {

	@Override
	public boolean filter(Crucero o1, Object s) {
		return(o1.getArea().equals(s));
	}

}
