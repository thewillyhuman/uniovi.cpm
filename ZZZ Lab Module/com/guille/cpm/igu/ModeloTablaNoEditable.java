package com.guille.cpm.igu;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.*;
import com.guille.cpm.logic.camarote.Camarote;
import com.guille.cpm.logic.camarote.CamaroteDobleExterior;
import com.guille.cpm.logic.camarote.CamaroteDobleInterior;
import com.guille.cpm.logic.camarote.CamaroteFamiliarExterior;
import com.guille.cpm.logic.camarote.CamaroteFamiliarInterior;
import com.guille.cpm.logic.extra.Extras;
import com.guille.cpm.logic.reserva.Reserva;

/**
 * This class extends the default model of the tables to create a totally
 * personalized which has an auxiliary list of cabins where, apart from in the
 * model, will save camarotes of which are displaying the data in the table .
 * 
 * @author Guillermo Facundo Colunga
 */
public class ModeloTablaNoEditable extends DefaultTableModel {

	private static final long serialVersionUID = 1L;
	private List<Camarote> li = new ArrayList<Camarote>();
	private Reserva reserva;

	/**
	 * Constructor intended to create a DefaultTableModel from its column names,
	 * its rowCount and a reserva object type.
	 * 
	 * @param columnNames are the names of each column.
	 * @param rowCount the number of rows the table holds.
	 * @param reserva the current reserva where the model is going to work.
	 */
	public ModeloTablaNoEditable(Object[] columnNames, int rowCount, Reserva reserva) {
		super(columnNames, rowCount);
		this.reserva = reserva;
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	/**
	 * Given a camarote as parameter this method will added to the model by its
	 * attributes while at the same time will add it to a list where it will be
	 * stored.
	 * 
	 * @param c is the camarote that will be added to the model.
	 */
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
			newRow[3] = "Yes + " + Extras.getExtra(Extras.JACUZZI).getPriceExtra() + "$";
		} else {
			newRow[3] = "No";
		}
		if (c.getExtras().contains(Extras.getExtra(Extras.EXTRA_BED_ID))) {
			newRow[4] = "Yes + " + Extras.getExtra(Extras.EXTRA_BED_ID).getPriceExtra() + "$";
		} else {
			newRow[4] = "No";
		}
		if (c.getExtras().contains(Extras.getExtra(Extras.SPECIAL_BRAKFAST))) {
			newRow[5] = "Yes + " + Extras.getExtra(Extras.SPECIAL_BRAKFAST).getPriceExtra() + "$";
		} else {
			newRow[5] = "No";
		}
		if (c.getExtras().contains(Extras.getExtra(Extras.EXTRA_BIG_BED_ID))) {
			newRow[6] = "Yes + " + Extras.getExtra(Extras.EXTRA_BIG_BED_ID).getPriceExtra() + "$";
		} else {
			newRow[6] = "No";
		}
		newRow[7] = "$ " + Double.toString(reserva.getPriceCamaroteAndExtras(c));
		super.addRow(newRow); // Adding the data to the table.
		li.add(c); // Adding the camarote to the list.
	}

	/**
	 * Given a camarote will remove it from the model and from the auxiliary
	 * list.
	 * 
	 * @param c is the camarote to remove.
	 * @throws IllegalStateException if the camarote given as a parameter is not
	 *             in the model.
	 */
	public void removeRow(Camarote c) {
		if (!li.contains(c))
			throw new IllegalStateException("This room is not in the model");
		super.removeRow(li.indexOf(c));
		li.remove(c);
	}

	/**
	 * Gets a completely different list with all the camarotes.
	 * 
	 * @return a different list with all the camarotes.
	 */
	public List<Camarote> getCamarotes() {
		List<Camarote> aux = new ArrayList<Camarote>();
		for (Camarote c : li)
			aux.add(c);
		return aux;
	}

	/**
	 * Removes all the elements in the model and in the auxiliary list.
	 */
	public void removeAll() {
		dataVector.removeAllElements();
		li.clear();
	}

	/**
	 * Given a row index will return the camarote that is being displayed at.
	 * 
	 * @param row is the index in the table.
	 * @return the camarote associated with that table row.
	 */
	public Camarote getCamaroteAtRow(int row) {
		return li.get(row);
	}

	/**
	 * Sets the current reserva.
	 * 
	 * @param reserva the be the new reserva.
	 */
	public void setCurrentReserva(Reserva reserva) {
		this.reserva = reserva;

	}

}
