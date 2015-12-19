package com.guille.cpm.igu;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.guille.cpm.logic.CargarDatos;
import com.guille.cpm.logic.Crucero;
import com.guille.cpm.logic.Cruceros;
import com.guille.fonts.SansSerifFont;

import java.awt.Color;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JComboBox;


public class VentanaPrincipal extends JFrame {

	
	private static final long serialVersionUID = -8029479718163458536L;
	private JPanel mainPane;
	private JPanel panel1;
	private JPanel panel;
	private JLabel lblSerach;
	private SansSerifFont sansSerif;
	private JSeparator separator;
	private JLabel lblDestino;
	private JComboBox<String> comboDestino;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public VentanaPrincipal() throws IOException {
		CargarDatos.cargarDatos();
		sansSerif = new SansSerifFont();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/com/guille/cpm/img/appIcon.png")));
		setLocationByPlatform(true);
		setTitle("EII CRUCEROS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1028, 660);
		mainPane = new JPanel();
		mainPane.setBackground(Color.WHITE);
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(new CardLayout(0, 0));
		mainPane.add(getPanel1(), "busqueda_inicio");
	}
	
	private JPanel getPanel1() {
		if (panel1 == null) {
			panel1 = new JPanel();
			panel1.setBackground(Color.WHITE);
			panel1.setLayout(null);
			panel1.add(getPanel());
		}
		return panel1;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(null);
			panel.setBackground(Color.WHITE);
			panel.setBounds(6, 6, 198, 616);
			panel.setLayout(null);
			panel.add(getLblSerach());
			panel.add(getSeparator());
			panel.add(getLblDestino());
			panel.add(getComboDestino());
		}
		return panel;
	}
	private JLabel getLblSerach() {
		if (lblSerach == null) {
			lblSerach = new JLabel("Search");
			lblSerach.setHorizontalAlignment(SwingConstants.LEFT);
			lblSerach.setFont(sansSerif.getSF_UI_Display_Heavy().deriveFont(10f));
			lblSerach.setBounds(6, 5, 131, 35);
		}
		return lblSerach;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(6, 34, 186, 6);
		}
		return separator;
	}
	private JLabel getLblDestino() {
		if (lblDestino == null) {
			lblDestino = new JLabel("Destino");
			lblDestino.setFont(sansSerif.getSF_UI_Display_Regular().deriveFont(7f));
			lblDestino.setBounds(6, 52, 61, 16);
		}
		return lblDestino;
	}
	private JComboBox<String> getComboDestino() {
		if (comboDestino == null) {
			comboDestino = new JComboBox<String>();
			comboDestino.setBounds(6, 70, 186, 27);
			comboDestino.setFont(sansSerif.getSF_UI_Display_Regular().deriveFont(7f));
			List<String> aux = new ArrayList<String>();
			comboDestino.addItem("Select a destination");;
			for(Crucero c : Cruceros.getCruceros()) {
				if(!aux.contains(c.getArea())) {
					aux.add(c.getArea());
				}
			} 
			Collections.sort(aux);
			for(String s : aux) {
				comboDestino.addItem(s);
			}
		}
		return comboDestino;
	}
}
