package igu;

import java.awt.*;
import javax.swing.JTable;

import org.jvnet.substance.api.renderers.SubstanceDefaultTableCellRenderer;

public class RendererSubstance extends SubstanceDefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		this.setFont(new Font("Dialog", Font.PLAIN, 14));
		if (table.getSelectedRow() == row) {
			this.setForeground(Color.red);
			this.setFont(new java.awt.Font("Dialog", Font.BOLD, 14));
		}
		return this;
	}
}
