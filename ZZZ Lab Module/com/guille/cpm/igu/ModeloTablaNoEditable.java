package com.guille.cpm.igu;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.*;
import com.guille.cpm.logic.*;

public class ModeloTablaNoEditable extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Camarote> li = new ArrayList<Camarote>();
	private Reserva reserva;

	
	public ModeloTablaNoEditable(Object[] columnNames, int rowCount, Reserva reserva) {
		super(columnNames, rowCount);
		this.reserva = reserva;
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	public void addRow(Camarote c) {
		Object[] newRow = new Object[getColumnCount()];
		newRow[0] = getRowCount();

		if (c instanceof CamaroteFamiliarInterior) {
			newRow[1] = "Familiar Interior";
		} else if (c instanceof CamaroteFamiliarExterior) {
			newRow[1] = "Familiar Exterior";
		} else if (c instanceof CamaroteDobleInterior) {
			newRow[1] = "Doble Interior";
		} else if (c instanceof CamaroteDobleExterior) {
			newRow[1] = "Doble Exterior";
		}

		newRow[2] = c.getNPasajeros();
		if (c.getExtras().contains(Extras.getExtra(Extras.JACUZZI))) {
			newRow[3] = "Yes + " + Extras.getExtra(Extras.JACUZZI).getPriceExtra()+"$";
		} else {
			newRow[3] = "No";
		}
		if (c.getExtras().contains(Extras.getExtra(Extras.EXTRA_BED_ID))) {
			newRow[4] = "Yes + " + Extras.getExtra(Extras.EXTRA_BED_ID).getPriceExtra()+"$";
		} else {
			newRow[4] = "No";
		}
		if (c.getExtras().contains(Extras.getExtra(Extras.SPECIAL_BRAKFAST))) {
			newRow[5] = "Yes + " + Extras.getExtra(Extras.SPECIAL_BRAKFAST).getPriceExtra()+"$";
		} else {
			newRow[5] = "No";
		}
		if (c.getExtras().contains(Extras.getExtra(Extras.EXTRA_BIG_BED_ID))) {
			newRow[6] = "Yes + " + Extras.getExtra(Extras.EXTRA_BIG_BED_ID).getPriceExtra()+"$";
		} else {
			newRow[6] = "No";
		}
		newRow[7] = "$ "+Double.toString(reserva.getPriceCamaroteAndExtras(c));
		super.addRow(newRow);
		li.add(c);
	}
	
	public void removeRow(Camarote c) {
		if(!li.contains(c))
			throw new IllegalStateException("This room is not in the model");
		super.removeRow(li.indexOf(c));
		li.remove(c);
	}
	
	public List<Camarote> getCamarotes() {
		List<Camarote> aux = new ArrayList<Camarote>();
		for(Camarote c : li)
			aux.add(c);
		return aux;
	}

	public void removeAll() {
		dataVector.removeAllElements();
		li.clear();
	}
	
	public Camarote getCamaroteAtRow(int row) {
		return li.get(row);
	}

	public void setCurrentReserva(Reserva reserva) {
		this.reserva = reserva;
		
	}

}
