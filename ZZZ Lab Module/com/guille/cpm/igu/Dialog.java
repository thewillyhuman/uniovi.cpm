package com.guille.cpm.igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSpinner;

public class Dialog extends JFrame {

	private JPanel contentPane;
	private JPanel agePanel;
	private JPanel cPanel;
	private JPanel sPanel;
	private JButton btnAccept;
	private JButton btnCancel;
	private JLabel lblAddTheAge;
	private JSpinner spinner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dialog frame = new Dialog();
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
	public Dialog() {
		setTitle("EII CRUCEROS...");
		setAlwaysOnTop(true);
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 479, 239);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getAgePanel(), "name_68735890989581");
	}

	private JPanel getAgePanel() {
		if (agePanel == null) {
			agePanel = new JPanel();
			agePanel.setBackground(Color.WHITE);
			agePanel.setLayout(new BorderLayout(0, 0));
			agePanel.add(getCPanel(), BorderLayout.CENTER);
			agePanel.add(getSPanel(), BorderLayout.SOUTH);
		}
		return agePanel;
	}
	private JPanel getCPanel() {
		if (cPanel == null) {
			cPanel = new JPanel();
			cPanel.setBackground(Color.WHITE);
			cPanel.setLayout(null);
			cPanel.add(getLblAddTheAge());
			cPanel.add(getSpinner());
		}
		return cPanel;
	}
	private JPanel getSPanel() {
		if (sPanel == null) {
			sPanel = new JPanel();
			sPanel.setBackground(Color.WHITE);
			sPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			sPanel.add(getBtnAccept());
			sPanel.add(getBtnCancel());
		}
		return sPanel;
	}
	private JButton getBtnAccept() {
		if (btnAccept == null) {
			btnAccept = new JButton("Accept");
		}
		return btnAccept;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(1);
				}
			});
		}
		return btnCancel;
	}
	private JLabel getLblAddTheAge() {
		if (lblAddTheAge == null) {
			lblAddTheAge = new JLabel("Add the age of the passenger:");
			lblAddTheAge.setBounds(84, 71, 201, 25);
		}
		return lblAddTheAge;
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setBounds(292, 70, 71, 26);
		}
		return spinner;
	}
}
