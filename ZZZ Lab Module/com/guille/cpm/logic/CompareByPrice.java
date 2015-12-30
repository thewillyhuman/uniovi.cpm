package com.guille.cpm.logic;

import java.util.Comparator;

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
