package com.guille.cpm.igu;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Image;
import javax.swing.ImageIcon;

import com.guille.cpm.logic.CargarDatos;
import com.guille.cpm.logic.Crucero;
import com.guille.util.Images;
import com.guille.util.Strings;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.text.SimpleDateFormat;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.SwingConstants;

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
	private JLabel lblFromPrice;
	private JButton btnSelect;
	private JPanel panel_1;
	private JLabel lblDiscountedPrice;
	private JPanel panel_big;
	private JLabel lblImgShip;
	private JLabel lblForbiden;
	private JLabel lblForbidenDescription;

	/**
	 * Create the panel.
	 */
	public CruceroListPanel(Crucero crucero) {
		setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		add(getPanel_big(), BorderLayout.CENTER);
		getLblDenominacion().setText(Strings.deAccent(crucero.getArea() + ": " + crucero.getDenominacion()));
		getLblDuracion().setText("Duration: " + crucero.getDuracion() + " days.");
		
		getLblImage().setIcon(Images.resize(getLblImage(), crucero.getPicturePath()));
		
		getLblImgShip().setIcon(Images.resize(getLblImgShip(), crucero.getBarco().getPicturePath()));
	
		getLblStartingProt().setText("Starting Port: " + crucero.getStartPort());
		getLblShipName().setText("Ship Name: "+crucero.getBarco().getName());
		getLblItinerario().setText(Strings.deAccent("Itinerario: " + crucero.getItinerario()));
		//getLblFromPrice().setText("From $" + Double.toString(crucero.getStartingPrice()));
		setMinimumSize(new Dimension(820, 225));
		if(crucero.isDiscounted()) {
			getLblFromPrice().setText("Was $" + Double.toString(crucero.getStartingPriceBD()));
			getLblFromPrice().setForeground(Color.GRAY);
			getLblDiscountedPrice().setText("Now from $" + Double.toString(crucero.getStartingPrice()));
			getLblDiscountedPrice().setVisible(true);
		} else {
			getLblFromPrice().setVisible(false);
			getLblDiscountedPrice().setText("From $" + Double.toString(crucero.getStartingPrice()));
			getLblDiscountedPrice().setVisible(true);
		}
		
		if(!crucero.getAcceptUnder16()) {
			getLblForbiden().setIcon(Images.resize(getLblForbiden(), "com/guille/cpm/img/icon+16.png"));
			getLblForbiden().setToolTipText("This ship does not accept anyone under 16 years.");
			getLblForbidenDescription().setText("Only for adults.");
		} else {
			getLblForbiden().setIcon(Images.resize(getLblForbiden(), "com/guille/cpm/img/icon_family.png"));
			getLblForbiden().setToolTipText("This ship accepts all publics.");
			getLblForbidenDescription().setText("Avaliable for all publics.");
		}
	}

	private JLabel getLblDenominacion() {
		if (lblDenominacion == null) {
			lblDenominacion = new JLabel("Denominacion");
			lblDenominacion.setBounds(6, 6, 808, 20);
			lblDenominacion.setFont(VentanaPrincipal.textMedium);
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
			panel.add(getLblFromPrice());
			panel.add(getBtnSelect());
			panel.add(getLblDiscountedPrice());
			panel.add(getLblImgShip());
			panel.add(getLblForbiden());
			panel.add(getLblForbidenDescription());
		}
		return panel;
	}
	private JLabel getLblDuracion() {
		if (lblDuracion == null) {
			lblDuracion = new JLabel("Duración");
			lblDuracion.setFont(VentanaPrincipal.textBold);
			lblDuracion.setBounds(6, 6, 135, 22);
			lblDuracion.setFont(VentanaPrincipal.text);
		}
		return lblDuracion;
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("img_cruise");
			lblImage.setBackground(Color.WHITE);
			lblImage.setBounds(6, 60, 160, 134);
			lblImage.setIcon(new ImageIcon(CruceroListPanel.class.getResource("/com/guille/cpm/img/CRU0001.jpg")));
		}
		return lblImage;
	}
	private JLabel getLblStartingProt() {
		if (lblStartingProt == null) {
			lblStartingProt = new JLabel("starting port");
			lblStartingProt.setBounds(153, 9, 259, 16);
			lblStartingProt.setFont(VentanaPrincipal.text);
		}
		return lblStartingProt;
	}
	private JLabel getLblShipName() {
		if (lblShipName == null) {
			lblShipName = new JLabel("ship name");
			lblShipName.setBounds(441, 9, 284, 16);
			lblShipName.setFont(VentanaPrincipal.text);
		}
		return lblShipName;
	}
	private JLabel getLblItinerario() {
		if (lblItinerario == null) {
			lblItinerario = new JLabel("Itinerario:");
			lblItinerario.setBounds(6, 32, 782, 16);
			lblItinerario.setFont(VentanaPrincipal.text);
		}
		return lblItinerario;
	}
	private JLabel getLblFromPrice() {
		if (lblFromPrice == null) {
			lblFromPrice = new JLabel("from price");
			lblFromPrice.setForeground(Color.BLACK);
			lblFromPrice.setBounds(699, 135, 112, 16);
			lblFromPrice.setFont(VentanaPrincipal.text);
		}
		return lblFromPrice;
	}
	public JButton getBtnSelect() {
		if (btnSelect == null) {
			btnSelect = new JButton("Buy Now");
			btnSelect.setBounds(697, 172, 117, 29);
			btnSelect.setFont(VentanaPrincipal.text);
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
	private JLabel getLblDiscountedPrice() {
		if (lblDiscountedPrice == null) {
			lblDiscountedPrice = new JLabel("From $0.0");
			lblDiscountedPrice.setBounds(699, 154, 112, 16);
			lblDiscountedPrice.setVisible(false);
			lblDiscountedPrice.setFont(VentanaPrincipal.text);
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
					getLblFromPrice().setBounds(panel_big.getWidth()-118, getLblFromPrice().getY(), getLblFromPrice().getWidth(), getLblFromPrice().getHeight());
					getLblDiscountedPrice().setBounds(panel_big.getWidth()-118, getLblDiscountedPrice().getY(), getLblDiscountedPrice().getWidth(), getLblDiscountedPrice().getHeight());
					getBtnSelect().setBounds(panel_big.getWidth()-123, getBtnSelect().getY(), getBtnSelect().getWidth(), getBtnSelect().getHeight());
				}
			});
		}
		return panel_big;
	}
	private JLabel getLblImgShip() {
		if (lblImgShip == null) {
			lblImgShip = new JLabel("img_cruise");
			lblImgShip.setBackground(Color.WHITE);
			lblImgShip.setBounds(176, 60, 160, 134);
		}
		return lblImgShip;
	}
	private JLabel getLblForbiden() {
		if (lblForbiden == null) {
			lblForbiden = new JLabel();
			lblForbiden.setHorizontalAlignment(SwingConstants.CENTER);
			lblForbiden.setBounds(351, 60, 30, 30);
		}
		return lblForbiden;
	}
	private JLabel getLblForbidenDescription() {
		if (lblForbidenDescription == null) {
			lblForbidenDescription = new JLabel();
			lblForbidenDescription.setHorizontalAlignment(SwingConstants.LEFT);
			lblForbidenDescription.setBounds(393, 60, 160, 30);
			lblForbidenDescription.setFont(VentanaPrincipal.text);
		}
		return lblForbidenDescription;
	}
}
