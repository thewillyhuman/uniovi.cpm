package com.guille.cpm.logic;

import java.util.Comparator;

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
