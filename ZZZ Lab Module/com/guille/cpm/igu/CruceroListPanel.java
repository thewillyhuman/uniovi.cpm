package com.guille.cpm.igu;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import com.guille.cpm.logic.Crucero;
import com.guille.util.Images;
import com.guille.util.Strings;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.SwingConstants;

/**
 * This class is intended to represent a row of a list of cruises. According to
 * a given parameters of a cruise.
 * 
 * @author Guillermo Facundo Colunga
 */
public class CruceroListPanel extends JPanel {
	
	
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
	 * Default constructor for the panel.
	 * 
	 * @param crucero that will be represented by the panel.
	 */
	public CruceroListPanel(Crucero crucero) {
		// Some changes in the structure.
		setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		add(getPanel_big(), BorderLayout.CENTER);

		// Writing the properties of the cruise.
		getLblDenominacion().setText(Strings.deAccent(crucero.getArea() + Messages.getString("CruceroListPanel.two-points_symbol") + crucero.getDenominacion())); //$NON-NLS-1$
		getLblDuracion().setText(Messages.getString("CruceroListPanel.duration-two-points_label") + crucero.getDuracion() + Messages.getString("CruceroListPanel.days_label")); //$NON-NLS-1$ //$NON-NLS-2$
		getLblImage().setIcon(Images.resize(getLblImage(), crucero.getPicturePath()));
		getLblImgShip().setIcon(Images.resize(getLblImgShip(), crucero.getBarco().getPicturePath()));
		getLblStartingProt().setText(Messages.getString("CruceroListPanel.satrting-port-two-points_label") + crucero.getStartPort()); //$NON-NLS-1$
		getLblShipName().setText(Messages.getString("CruceroListPanel.ship-name-two-points_label") + crucero.getBarco().getName()); //$NON-NLS-1$
		getLblItinerario().setText(Strings.deAccent(Messages.getString("CruceroListPanel.itinerario-two-points-space_label") + crucero.getItinerario())); //$NON-NLS-1$

		// Getting the price of the discounted and the non discounted cruises.
		if (crucero.isDiscounted()) {
			getLblFromPrice().setText(Messages.getString("CruceroListPanel.was-dollar_label") + Double.toString(crucero.getStartingPriceBD())); //$NON-NLS-1$
			getLblFromPrice().setForeground(Color.GRAY);
			getLblDiscountedPrice().setText(Messages.getString("CruceroListPanel.now-from-dollar_label") + Double.toString(crucero.getStartingPrice())); //$NON-NLS-1$
			getLblDiscountedPrice().setVisible(true);
		} else {
			getLblFromPrice().setVisible(false);
			getLblDiscountedPrice().setText(Messages.getString("CruceroListPanel.from-dollar_label") + Double.toString(crucero.getStartingPrice())); //$NON-NLS-1$
			getLblDiscountedPrice().setVisible(true);
		}

		// Setting properties depending on the availability of the cruise for
		// kids or not.
		if (!crucero.getAcceptUnder16()) {
			getLblForbiden().setIcon(Images.resize(getLblForbiden(), "com/guille/cpm/img/icon+16.png")); //$NON-NLS-1$
			getLblForbiden().setToolTipText(Messages.getString("CruceroListPanel.not-under16_tooltip")); //$NON-NLS-1$
			getLblForbidenDescription().setText(Messages.getString("CruceroListPanel.only-for-adults_label")); //$NON-NLS-1$
		} else {
			getLblForbiden().setIcon(Images.resize(getLblForbiden(), "com/guille/cpm/img/icon_family.png")); //$NON-NLS-1$
			getLblForbiden().setToolTipText(Messages.getString("CruceroListPanel.all-publics_tooltip")); //$NON-NLS-1$
			getLblForbidenDescription().setText(Messages.getString("CruceroListPanel.all-publics_label")); //$NON-NLS-1$
		}
	}

	private JLabel getLblDenominacion() {
		if (lblDenominacion == null) {
			lblDenominacion = new JLabel(Messages.getString("CruceroListPanel.denominacion_label")); //$NON-NLS-1$
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
			lblDuracion = new JLabel(Messages.getString("CruceroListPanel.duracion_label")); //$NON-NLS-1$
			lblDuracion.setFont(VentanaPrincipal.textBold);
			lblDuracion.setBounds(6, 6, 135, 22);
			lblDuracion.setFont(VentanaPrincipal.text);
		}
		return lblDuracion;
	}

	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("img_cruise"); //$NON-NLS-1$
			lblImage.setBackground(Color.WHITE);
			lblImage.setBounds(6, 60, 160, 134);
			lblImage.setIcon(new ImageIcon(CruceroListPanel.class.getResource("/com/guille/cpm/img/CRU0001.jpg"))); //$NON-NLS-1$
		}
		return lblImage;
	}

	private JLabel getLblStartingProt() {
		if (lblStartingProt == null) {
			lblStartingProt = new JLabel(Messages.getString("CruceroListPanel.starting-port_label")); //$NON-NLS-1$
			lblStartingProt.setBounds(153, 9, 259, 16);
			lblStartingProt.setFont(VentanaPrincipal.text);
		}
		return lblStartingProt;
	}

	private JLabel getLblShipName() {
		if (lblShipName == null) {
			lblShipName = new JLabel(Messages.getString("CruceroListPanel.ship-name_label")); //$NON-NLS-1$
			lblShipName.setBounds(441, 9, 284, 16);
			lblShipName.setFont(VentanaPrincipal.text);
		}
		return lblShipName;
	}

	private JLabel getLblItinerario() {
		if (lblItinerario == null) {
			lblItinerario = new JLabel(Messages.getString("CruceroListPanel.itinerario-two-points_label")); //$NON-NLS-1$
			lblItinerario.setBounds(6, 32, 782, 16);
			lblItinerario.setFont(VentanaPrincipal.text);
		}
		return lblItinerario;
	}

	private JLabel getLblFromPrice() {
		if (lblFromPrice == null) {
			lblFromPrice = new JLabel(Messages.getString("CruceroListPanel.from-price-label")); //$NON-NLS-1$
			lblFromPrice.setForeground(Color.BLACK);
			lblFromPrice.setBounds(699, 135, 112, 16);
			lblFromPrice.setFont(VentanaPrincipal.text);
		}
		return lblFromPrice;
	}

	public JButton getBtnSelect() {
		if (btnSelect == null) {
			btnSelect = new JButton(Messages.getString("CruceroListPanel.boy-now_label")); //$NON-NLS-1$
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
			panel_1.setPreferredSize(new Dimension(this.getWidth(), 25));
		}
		return panel_1;
	}

	private JLabel getLblDiscountedPrice() {
		if (lblDiscountedPrice == null) {
			lblDiscountedPrice = new JLabel(Messages.getString("CruceroListPanel.from-dollar-cero_label")); //$NON-NLS-1$
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
					resizePanel();
				}
			});
		}
		return panel_big;
	}

	private JLabel getLblImgShip() {
		if (lblImgShip == null) {
			lblImgShip = new JLabel("img_cruise"); //$NON-NLS-1$
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
	
	/*
	 * BEGIN OF CORE METHODS.
	 */

	/**
	 * This method will emulate a layout manager. The decision of use it instead
	 * of the layout manager was based in the fact that was preferred to control
	 * the movements of the object rather than the automatization.
	 */
	private void resizePanel() {
		getPanel().setBounds((int) getPanel().getBounds().getMinX(), (int) getPanel().getBounds().getMinY(), (int) getPanel_big().getWidth(), (int) getPanel_big().getWidth());
		getPanel_1().setBounds((int) getPanel_1().getBounds().getMinX(), (int) getPanel_1().getBounds().getMinY(), (int) getPanel_big().getWidth(), (int) getPanel_big().getWidth());
		getLblFromPrice().setBounds(getPanel_big().getWidth() - 118, getLblFromPrice().getY(), getLblFromPrice().getWidth(), getLblFromPrice().getHeight());
		getLblDiscountedPrice().setBounds(getPanel_big().getWidth() - 118, getLblDiscountedPrice().getY(), getLblDiscountedPrice().getWidth(), getLblDiscountedPrice().getHeight());
		getBtnSelect().setBounds(getPanel_big().getWidth() - 123, getBtnSelect().getY(), getBtnSelect().getWidth(), getBtnSelect().getHeight());
	}
}
