package com.guille.cpm.igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.guille.cpm.logic.CargarDatos;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.IOException;
import java.awt.CardLayout;


public class VentanaPrincipal extends JFrame {

	
	private static final long serialVersionUID = -8029479718163458536L;
	private JPanel mainPane;
	private JPanel panel1;
	private JPanel panel;

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
		CargarDatos.cargarDatos();
	}
	
	private JPanel getPanel1() {
		if (panel1 == null) {
			panel1 = new JPanel();
			panel1.setBackground(Color.WHITE);
			panel1.setLayout(new BorderLayout(0, 0));
			panel1.add(getPanel(), BorderLayout.WEST);
		}
		return panel1;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
		}
		return panel;
	}
}
