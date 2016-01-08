package com.guille.cpm.logic.comparators;

import java.util.Comparator;

import com.guille.cpm.logic.crucero.Crucero;

public class CompareByPrice implements Comparator<Crucero> {

	@Override
	public int compare(Crucero c1, Crucero c2) {
		if(c1.getStartingPrice() < c2.getStartingPrice())
			return -1;
		else if(c1.getStartingPrice() > c2.getStartingPrice())
			return 1;
		return 0;
	}

}
