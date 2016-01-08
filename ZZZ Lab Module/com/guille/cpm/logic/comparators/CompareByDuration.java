package com.guille.cpm.logic.comparators;

import java.util.Comparator;

import com.guille.cpm.logic.crucero.Crucero;

public class CompareByDuration implements Comparator<Crucero> {

	@Override
	public int compare(Crucero o1, Crucero o2) {
		if(o1.getDuracion() < o2.getDuracion())
			return -1;
		else if(o1.getDuracion() > o2.getDuracion())
			return 1;
		else
			return 0;
	}

}
