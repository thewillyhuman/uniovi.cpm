package com.guille.cpm.igu;

import javax.swing.table.*;

public class ModeloTablaNoEditable<T> extends DefaultTableModel {
	private static final long serialVersionUID = 1L;

	public ModeloTablaNoEditable(Object[] columnNames, int rowCount) {
		super(columnNames, rowCount);
   }
	@Override
	public boolean isCellEditable(int row, int column) {
        return false;
    }
	
	public void removeAll() {
		dataVector.removeAllElements();
	}
}

