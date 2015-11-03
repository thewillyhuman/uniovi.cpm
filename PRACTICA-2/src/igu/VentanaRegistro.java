package src.igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JPasswordField;

public class VentanaRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtSurname;
	private JButton btnCancelar;
	private JPanel panel;
	private JRadioButton rdbtnMujer = new JRadioButton("Mujer");
	private JRadioButton rdbtnHombre = new JRadioButton("Hombre");
	private JLabel lblDescription = null;
	private JLabel lblNombre = null;
	private JLabel lblApellidos = null;
	private JTextField txtEmail;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
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
	public VentanaRegistro() {
		setSize(new Dimension(600, 300));
		setTitle("Ventana de Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 25, 58, 14);
		contentPane.add(lblNombre);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(257, 25, 78, 14);
		contentPane.add(lblApellidos);
		
		txtName = new JTextField();
		txtName.setBounds(90, 22, 144, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setBounds(347, 22, 210, 20);
		contentPane.add(txtSurname);
		txtSurname.setColumns(10);
		contentPane.add(getBtnCancelar());
		contentPane.add(getPanel());
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnAceptar.setForeground(new Color(51, 153, 255));
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.setBounds(473, 218, 102, 33);
		contentPane.add(btnAceptar);
		
		lblDescription = new JLabel("");
		lblDescription.setAutoscrolls(true);
		lblDescription.setBounds(361, 157, 214, 49);
		contentPane.add(lblDescription);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Fecha de Nacimiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(257, 72, 297, 73);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox cbDay = new JComboBox();
		cbDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		cbDay.setBounds(6, 23, 63, 32);
		panel_1.add(cbDay);
		
		JComboBox cbMonth = new JComboBox();
		cbMonth.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"}));
		cbMonth.setBounds(81, 23, 103, 32);
		panel_1.add(cbMonth);
		
		JComboBox cbYear = new JComboBox();
		cbYear.setModel(new DefaultComboBoxModel(new String[] {"1995", "1996", "1997", "1998", "1999", "2000", "2001"}));
		cbYear.setBounds(196, 23, 95, 32);
		panel_1.add(cbYear);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Usuario y Contrase\u00F1a", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(20, 150, 326, 122);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(6, 26, 61, 16);
		panel_2.add(lblUsuario);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(79, 21, 222, 26);
		panel_2.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(6, 64, 85, 16);
		panel_2.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(89, 59, 209, 21);
		panel_2.add(passwordField);
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnCancelar.setForeground(new Color(51, 153, 255));
			btnCancelar.setBackground(Color.WHITE);
			btnCancelar.setBounds(359, 218, 102, 33);
		}
		return btnCancelar;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBorder(new TitledBorder(null, "G\u00E9nero", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(20, 72, 214, 73);
			panel.setLayout(null);
			
			rdbtnHombre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtnHombre.isSelected()) {
						rdbtnMujer.setSelected(false);
					}
				}
			});
			rdbtnHombre.setBounds(6, 31, 107, 23);
			rdbtnHombre.setSelected(true);
			panel.add(rdbtnHombre);
			rdbtnHombre.setAlignmentX(Component.CENTER_ALIGNMENT);
			rdbtnHombre.setBackground(Color.WHITE);
			
			rdbtnMujer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtnMujer.isSelected()) {
						rdbtnHombre.setSelected(false);
					}
				}
			});
			rdbtnMujer.setBounds(122, 31, 75, 23);
			panel.add(rdbtnMujer);
			rdbtnMujer.setAlignmentX(Component.CENTER_ALIGNMENT);
			rdbtnMujer.setBackground(Color.WHITE);
		}
		return panel;
	}
	
	private void update() {
		String message = null;
		if (rdbtnHombre.isSelected() == false && rdbtnMujer.isSelected() == false) {
			message = "Please, check your gender.";
		} else {
			message = "You're "+txtName.getText()+", "+txtSurname.getText()+".";
		}
		lblDescription.setText(message);
	}
}
