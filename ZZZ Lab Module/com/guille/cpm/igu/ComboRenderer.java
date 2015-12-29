package com.guille.cpm.igu;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class ComboRenderer extends BasicComboBoxRenderer {

	private static final long serialVersionUID = 1L;

	public Component getListCellRendererComponent(@SuppressWarnings("rawtypes") JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		if(isSelected)
			setIcon(new ImageIcon("com/guille/cpm/img/check_mark.png"));
		else
			setIcon(null);

		return this;
	}
}