package com.guille.cpm.igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Point;
import java.awt.Frame;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTable;

public class VentanaPrincipal extends JFrame {

	private JPanel mainPane;

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
	 */
	public VentanaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/com/guille/cpm/img/appIcon.png")));
		setLocationByPlatform(true);
		setTitle("EII CRUCEROS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1028, 660);
		mainPane = new JPanel();
		mainPane.setBackground(Color.WHITE);
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(new BorderLayout(0, 0));
	}
}
