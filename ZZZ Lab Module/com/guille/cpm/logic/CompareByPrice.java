package com.guille.cpm.logic;

import java.util.Comparator;

import com.guille.util.CollectionsCPM;

public class CompareByPrice implements Comparator<Crucero> {

	@Override
	public int compare(Crucero c1, Crucero c2) {
		if(CollectionsCPM.getMinDoubleArray(c1.getBarco().getPrices()) < CollectionsCPM.getMinDoubleArray(c2.getBarco().getPrices()))
			return 1;
		else if(CollectionsCPM.getMinDoubleArray(c1.getBarco().getPrices()) == CollectionsCPM.getMinDoubleArray(c2.getBarco().getPrices()))
			return 0;
		else
			return -1;
	}

}
