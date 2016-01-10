package com.guille.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import com.guille.cpm.logic.crucero.Crucero;
import com.guille.cpm.logic.interfaces.Filter;

public class CollectionsCPM {

	public static List<Crucero> filter(Filter filter, List<Crucero> list, Object match) {
		List<Crucero> aux = new ArrayList<Crucero>();
		for (Crucero crucero : list) {
			if (filter.filter(crucero, match))
				aux.add(crucero);
		}
		return aux;
	}

	/**
	 * Given a list will return a complete different list sorted by means of the
	 * comparator of type cruise provided.
	 * 
	 * @param list of cruises to sort
	 * @param comparator to use.
	 * @return a complete different list sorted as the comparator says.
	 */
	public static List<Crucero> sort(List<Crucero> list, Comparator<Crucero> comparator) {
		List<Crucero> toSort = new ArrayList<Crucero>();
		for (Crucero c : list)
			toSort.add(c);
		Collections.sort(toSort, comparator);
		return toSort;
	}

	/**
	 * Return the minimum double value non equal to 0 from a given double array.
	 * 
	 * @param array to explore.
	 * @return the minimum double value non equal to 0 from a given double
	 *         array.
	 */
	public static double getMinDoubleArray(double[] array) {
		if (array.length == 0)
			throw new IllegalArgumentException("The aaray is empty.");
		double aux = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] < aux && array[i] != 0)
				aux = array[i];
		}
		return aux;
	}

	/**
	 * Returns the position of the minimum non equal 0 value of the given array.
	 * 
	 * @param array to explore
	 * @return the position of the minimum non equal 0 value of the given array.
	 */
	public static int getMinDoubleArrayPos(double[] array) {
		if (array.length == 0)
			throw new IllegalArgumentException("The aaray is empty.");
		int lowerIndex = -1;
		double last = Double.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < last && array[i] != 0)
				lowerIndex = i;
		}
		return lowerIndex;
	}

	/**
	 * Given two lists of cruises will return another list that contains those
	 * cruises that are in the first list but not in the second.
	 * firstList-secondList.
	 * 
	 * @param completeList is the bigger list.
	 * @param notComleteList is the smallest list.
	 * @return  another list that contains those cruises that are in the first list but not in the second. FirstList-secondList.
	 */
	public static List<Crucero> getDiference(List<Crucero> completeList, List<Crucero> notComleteList) {
		List<Crucero> aux = new ArrayList<Crucero>();
		for (Crucero c : completeList) {
			if (!notComleteList.contains(c))
				aux.add(c);
		}
		return aux;
	}

	/**
	 * From an array of dates will return the minimum one.
	 * 
	 * @param list to explore.
	 * @return the minimum date in the array.
	 */
	public static Date getMinDate(List<Date> list) {
		if (list.isEmpty())
			throw new IllegalArgumentException("The list cannot be empty.");

		Date aux = list.get(0);
		for (Date d : list) {
			if (d.compareTo(aux) == -1) {
				aux = d;
			}
		}
		return aux;
	}
}
