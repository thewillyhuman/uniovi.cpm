package com.guille.cpm.igu;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 * Custom TableCellRenderer.
 * 
 * @author Guillermo Facundo Colunga
 */
public class HeaderRenderer implements TableCellRenderer {

	DefaultTableCellRenderer renderer;

	/**
	 * Given a table will set the properties of the renderer in order to achieve
	 * that the labels are centered.
	 * 
	 * @param table is the JTable where we want to center the labels.
	 */
	public HeaderRenderer(JTable table) {
		renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
		return renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
	}
}