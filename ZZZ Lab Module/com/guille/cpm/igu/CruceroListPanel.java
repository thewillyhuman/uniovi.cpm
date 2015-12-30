package com.guille.cpm.igu;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

import com.guille.cpm.logic.CargarDatos;
import com.guille.cpm.logic.Crucero;
import com.guille.util.CollectionsCPM;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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
	private JTextArea txtrDescripcion;
	private JLabel lblFromPrice;
	private JButton btnSelect;
	private JPanel panel_1;
	private JLabel lblDate;
	private JLabel lblDiscountedPrice;
	private JPanel panel_big;

	/**
	 * Create the panel.
	 */
	public CruceroListPanel(Crucero crucero) {
		setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		add(getPanel_big(), BorderLayout.CENTER);
		getLblDenominacion().setText(crucero.getDenominacion());
		getLblDuracion().setText("Duration: " + crucero.getDuracion() + " days.");
		
		
		ImageIcon imageIcon = new ImageIcon(crucero.getPicturePath()); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(getLblImage().getWidth(), getLblImage().getHeight(),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
		imageIcon = new ImageIcon(newimg);  // transform it back
		getLblImage().setIcon(imageIcon);
		
		
		getLblStartingProt().setText("Starting Port: " + crucero.getStartPort());
		getLblShipName().setText("Ship Name: "+crucero.getBarco().getName());
		getLblItinerario().setText("Itinerario: " + crucero.getItinerario());
		getTxtrDescripcion().setText(crucero.getDescripcion());
		getLblFromPrice().setText("From $" + Double.toString(CollectionsCPM.getMinDoubleArray(crucero.getBarco().getPrices())));
		setMinimumSize(new Dimension(820, 225));
		if(crucero.isDiscounted()) {
			getLblFromPrice().setText("Was $" + Double.toString(crucero.getStartingPriceBD()));
			getLblFromPrice().setForeground(Color.GRAY);
			getLblDiscountedPrice().setText("Now from $" + crucero.getStartingPrice());
			getLblDiscountedPrice().setVisible(true);
		}
		StringBuilder aux = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat(CargarDatos.DATE_FORMAT_LONG);
		for(Date d : crucero.getSalidas())
			aux.append(sdf.format(d)+" | ");
		getLblDate().setText(aux.toString());

	}

	private JLabel getLblDenominacion() {
		if (lblDenominacion == null) {
			lblDenominacion = new JLabel("Denominacion");
			lblDenominacion.setBounds(6, 6, 808, 20);
			lblDenominacion.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		}
		return lblDenominacion;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setLayout(null);
			panel.add(getLblDuracion());
			panel.add(getLblImage());
			panel.add(getLblStartingProt());
			panel.add(getLblShipName());
			panel.add(getLblItinerario());
			panel.add(getTxtrDescripcion());
			panel.add(getLblFromPrice());
			panel.add(getBtnSelect());
			panel.add(getLblDate());
			panel.add(getLblDiscountedPrice());
		}
		return panel;
	}
	private JLabel getLblDuracion() {
		if (lblDuracion == null) {
			lblDuracion = new JLabel("Duración");
			lblDuracion.setFont(VentanaPrincipal.textBold);
			lblDuracion.setBounds(6, 6, 135, 22);
		}
		return lblDuracion;
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("New label");
			lblImage.setBounds(6, 60, 160, 134);
			lblImage.setIcon(new ImageIcon(CruceroListPanel.class.getResource("/com/guille/cpm/img/CRU0001.jpg")));
		}
		return lblImage;
	}
	private JLabel getLblStartingProt() {
		if (lblStartingProt == null) {
			lblStartingProt = new JLabel("starting port");
			lblStartingProt.setBounds(153, 9, 259, 16);
		}
		return lblStartingProt;
	}
	private JLabel getLblShipName() {
		if (lblShipName == null) {
			lblShipName = new JLabel("ship name");
			lblShipName.setBounds(441, 9, 284, 16);
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
	private JTextArea getTxtrDescripcion() {
		if (txtrDescripcion == null) {
			txtrDescripcion = new JTextArea();
			txtrDescripcion.setBounds(178, 60, 500, 112);
			txtrDescripcion.setBorder(null);
			txtrDescripcion.setLineWrap(true);
			txtrDescripcion.setEditable(false);
			txtrDescripcion.setWrapStyleWord(true);
			txtrDescripcion.setText("Descripcion");
		}
		return txtrDescripcion;
	}
	private JLabel getLblFromPrice() {
		if (lblFromPrice == null) {
			lblFromPrice = new JLabel("from price");
			lblFromPrice.setForeground(Color.BLACK);
			lblFromPrice.setBounds(718, 60, 96, 16);
		}
		return lblFromPrice;
	}
	public JButton getBtnSelect() {
		if (btnSelect == null) {
			btnSelect = new JButton("Select");
			btnSelect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnSelect.setBounds(697, 146, 117, 29);
		}
		return btnSelect;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			panel_1.setLayout(null);
			panel_1.add(getLblDenominacion());
			panel_1.setPreferredSize(new Dimension(this.getWidth(),25));
		}
		return panel_1;
	}
	private JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("New label");
			lblDate.setBounds(178, 178, 636, 16);
		}
		return lblDate;
	}
	private JLabel getLblDiscountedPrice() {
		if (lblDiscountedPrice == null) {
			lblDiscountedPrice = new JLabel("From $0.0");
			lblDiscountedPrice.setBounds(690, 82, 124, 16);
			lblDiscountedPrice.setVisible(false);
		}
		return lblDiscountedPrice;
	}
	private JPanel getPanel_big() {
		if (panel_big == null) {
			panel_big = new JPanel();
			panel_big.setLayout(new BorderLayout(0, 0));
			panel_big.add(getPanel_1(), BorderLayout.NORTH);
			panel_big.add(getPanel(), BorderLayout.CENTER);
			panel_big.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					getPanel().setBounds((int)getPanel().getBounds().getMinX(), (int)getPanel().getBounds().getMinY(), (int)panel_big.getWidth(), (int)panel_big.getWidth());
					getPanel_1().setBounds((int)getPanel_1().getBounds().getMinX(), (int)getPanel_1().getBounds().getMinY(), (int)panel_big.getWidth(), (int)panel_big.getWidth());
				}
			});
		}
		return panel_big;
	}
}
