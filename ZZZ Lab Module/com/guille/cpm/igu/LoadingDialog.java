package com.guille.cpm.igu;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Image;

public class LoadingDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				try {
					LoadingDialog dialog = new LoadingDialog(null, "Cargando...", "Cargando...");
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		};
		new Thread(runnable).start();

	}

	/**
	 * Create the dialog.
	 */
	public LoadingDialog(JPanel parent, String display, String title) {
		Image spinner = new ImageIcon("com/guille/cpm/img/loading-spinerv2.gif").getImage();
		setBackground(Color.WHITE);
		setTitle(title);
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		if (parent != null) {
			setBounds(100, 100, 435, 268);
			setLocationRelativeTo(parent);
		} else {
			setBounds(100, 100, 435, 268);
		}
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(null);
			panel.setBackground(Color.WHITE);
			panel.setBounds(6, 66, 419, 114);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblLblicon = new JLabel(new ImageIcon(spinner));
				lblLblicon.setBounds(174, 6, 70, 70);
				panel.add(lblLblicon);
				lblLblicon.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				JLabel lblCargandoIdioma = new JLabel(display);
				lblCargandoIdioma.setHorizontalAlignment(SwingConstants.CENTER);
				lblCargandoIdioma.setBounds(6, 88, 407, 16);
				panel.add(lblCargandoIdioma);
			}
		}
	}

}
