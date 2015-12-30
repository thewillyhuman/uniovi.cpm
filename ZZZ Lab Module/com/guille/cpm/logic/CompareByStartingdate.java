package com.guille.cpm.logic;

import java.util.Comparator;

import com.guille.util.CollectionsCPM;

public class CompareByStartingdate implements Comparator<Crucero> {

	@Override
	public int compare(Crucero o1, Crucero o2) {
		return CollectionsCPM.getMinDate(o1.getSalidas()).compareTo(CollectionsCPM.getMinDate(o1.getSalidas()));
	}

}
