package com.guille.cpm.igu;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.guille.cpm.logic.Crucero;

import javax.swing.JButton;

public class CruceroListPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblDenominacion;
	private JPanel panel;
	private JLabel lblDuracion;
	private JLabel lblImage;
	private JLabel lblStartingProt;
	private JLabel lblShipName;
	private JLabel lblItinerario;
	private JScrollPane scrollPane;
	private JTextArea txtrDescripcion;
	private JLabel lblFromPrice;
	private JButton btnSelect;

	/**
	 * Create the panel.
	 */
	public CruceroListPanel(Crucero crucero) {
		setLayout(new BorderLayout(0, 0));
		add(getLblDenominacion(), BorderLayout.NORTH);
		add(getPanel(), BorderLayout.CENTER);
		getLblDenominacion().setText(crucero.getDenominacion());
		getLblDuracion().setText("Duration: " + crucero.getDuracion() + " days.");
		
		ImageIcon icon = new ImageIcon(CruceroListPanel.class.getResource("/"+crucero.getPicturePath()));
		Image img = icon.getImage();
		img.getScaledInstance(getLblImage().getWidth(), getLblImage().getHeight(), Image.SCALE_FAST);
		getLblImage().setIcon(new ImageIcon(img));
		
		
		getLblStartingProt().setText("Starting Port: " + crucero.getStartPort());
		getLblShipName().setText("Ship Name: "+crucero.getBarco().getName());
		getLblItinerario().setText("Itinerario: " + crucero.getItinerario());
		getTxtrDescripcion().setText(crucero.getDescripcion());
		getLblFromPrice().setText(Double.toString(crucero.getBarco().getPrecioCamaroteDobleInterior()));

	}

	private JLabel getLblDenominacion() {
		if (lblDenominacion == null) {
			lblDenominacion = new JLabel("Denominacion");
			lblDenominacion.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		}
		return lblDenominacion;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblDuracion());
			panel.add(getLblImage());
			panel.add(getLblStartingProt());
			panel.add(getLblShipName());
			panel.add(getLblItinerario());
			panel.add(getScrollPane());
			panel.add(getLblFromPrice());
			panel.add(getBtnSelect());
		}
		return panel;
	}
	private JLabel getLblDuracion() {
		if (lblDuracion == null) {
			lblDuracion = new JLabel("Duración");
			lblDuracion.setBounds(6, 6, 85, 22);
		}
		return lblDuracion;
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("New label");
			lblImage.setBounds(6, 60, 160, 138);
			lblImage.setIcon(new ImageIcon(CruceroListPanel.class.getResource("/com/guille/cpm/img/CRU0001.jpg")));
		}
		return lblImage;
	}
	private JLabel getLblStartingProt() {
		if (lblStartingProt == null) {
			lblStartingProt = new JLabel("starting port");
			lblStartingProt.setBounds(103, 9, 174, 16);
		}
		return lblStartingProt;
	}
	private JLabel getLblShipName() {
		if (lblShipName == null) {
			lblShipName = new JLabel("ship name");
			lblShipName.setBounds(308, 9, 182, 16);
		}
		return lblShipName;
	}
	private JLabel getLblItinerario() {
		if (lblItinerario == null) {
			lblItinerario = new JLabel("Itinerario:");
			lblItinerario.setBounds(6, 32, 784, 16);
		}
		return lblItinerario;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(178, 60, 500, 115);
			scrollPane.setViewportView(getTxtrDescripcion());
		}
		return scrollPane;
	}
	private JTextArea getTxtrDescripcion() {
		if (txtrDescripcion == null) {
			txtrDescripcion = new JTextArea();
			txtrDescripcion.setAutoscrolls(false);
			txtrDescripcion.setWrapStyleWord(true);
			txtrDescripcion.setText("Descripcion");
		}
		return txtrDescripcion;
	}
	private JLabel getLblFromPrice() {
		if (lblFromPrice == null) {
			lblFromPrice = new JLabel("from price");
			lblFromPrice.setBounds(718, 60, 96, 16);
		}
		return lblFromPrice;
	}
	private JButton getBtnSelect() {
		if (btnSelect == null) {
			btnSelect = new JButton("Select");
			btnSelect.setBounds(697, 146, 117, 29);
		}
		return btnSelect;
	}
}
