package com.guille.cpm.igu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

public class CustomComboBoxModel<E extends Comparable<E>> extends DefaultComboBoxModel<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void sortFrom(int index) {
		if(index < 0)
			throw new NullPointerException(index + "<" + 0);
		else if(index > this.getSize())
			throw new IndexOutOfBoundsException(index + ">" + this.getSize());
		
		List<E> aux = new ArrayList<>();
		List<E> notSort = new ArrayList<>();
		
		for(int i = 0; i < index; i++) {
			notSort.add(this.getElementAt(i));
		}
		
		for(int i = index; i < this.getSize(); i++) {
			aux.add(this.getElementAt(i));
		}
		
		this.removeAllElements();
		
		Collections.sort(aux);
		
		for(E element :  notSort) {
			this.addElement(element);
		}
		
		for(E element : aux) {
			this.addElement(element);
		}
		
	}

}
