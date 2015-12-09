package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.DefaultListModel;
import javax.swing.UIManager;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.SpinnerNumberModel;

import logica.Inmobiliaria;
import logica.Mansion;

import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnAadirVisita;
	private JButton btnEliminarVisita;
	private JPanel panel_2;
	private JPanel panel_3;
	private JScrollPane scrollPane;
	private JLabel lblDescription;
	private JScrollPane scrollPane_1;
	private JList list;
	private JPanel panel_4;
	private JSpinner spinnerPercentage;
	private JButton btnClacular;
	private JLabel lblResultado;
	private JPanel panel_5;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	private Inmobiliaria inmobiliaria= new Inmobiliaria();
	private JTabbedPane tpMansiones;
	private JPanel pnVentas;
	private JPanel pnAlquileres;
	private JScrollPane scVentas;
	private JTable tVentas;

	private DefaultTableModel modeloTable;

	private DefaultListModel modeloLista; 

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/llave.JPG")));
		setTitle("Agencia Inmoviliaria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getPanel());
		contentPane.add(getPanel_3());
		contentPane.add(getPanel_4());
		contentPane.add(getPanel_5());
		contentPane.add(getTpMansiones());
		
		addRows();
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("AGENCIA INMOVILIARIA EII");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(Color.ORANGE);
			lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 30));
			lblNewLabel.setBounds(23, 11, 495, 94);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/llave.JPG")));
			lblNewLabel_1.setBounds(690, 11, 114, 94);
		}
		return lblNewLabel_1;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Mansiones a Visitar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(592, 159, 212, 262);
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getPanel_1(), BorderLayout.SOUTH);
			panel.add(getPanel_2(), BorderLayout.CENTER);
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridLayout(0, 2, 0, 0));
			panel_1.add(getBtnAadirVisita());
			panel_1.add(getBtnEliminarVisita());
		}
		return panel_1;
	}
	private JButton getBtnAadirVisita() {
		if (btnAadirVisita == null) {
			btnAadirVisita = new JButton("A\u00F1adir");
			btnAadirVisita.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int fila = tVentas.getSelectedRow();
					if(fila != -1) {
						modeloLista.addElement(tVentas.getValueAt(fila, 0));
					}
				}
			});
		}
		return btnAadirVisita;
	}
	private JButton getBtnEliminarVisita() {
		if (btnEliminarVisita == null) {
			btnEliminarVisita = new JButton("Eliminar");
		}
		return btnEliminarVisita;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new BorderLayout(0, 0));
			panel_2.add(getScrollPane_1(), BorderLayout.CENTER);
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBackground(Color.WHITE);
			panel_3.setBounds(23, 411, 559, 170);
			panel_3.setLayout(new BorderLayout(0, 0));
			panel_3.add(getScrollPane(), BorderLayout.CENTER);
		}
		return panel_3;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getLblDescription());
		}
		return scrollPane;
	}
	private JLabel getLblDescription() {
		if (lblDescription == null) {
			lblDescription = new JLabel("");
			lblDescription.setBackground(Color.WHITE);
			lblDescription.setForeground(Color.BLACK);
			lblDescription.setVerticalAlignment(SwingConstants.TOP);
		}
		return lblDescription;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getList());
		}
		return scrollPane_1;
	}
	private JList getList() {
		if (list == null) {
			modeloLista = new DefaultListModel();
			list = new JList(modeloLista);
		}
		return list;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBorder(new TitledBorder(null, "Entrada a Pagar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_4.setBounds(592, 441, 208, 94);
			panel_4.setLayout(null);
			panel_4.add(getSpinnerPercentage());
			panel_4.add(getBtnClacular());
			panel_4.add(getLblResultado());
		}
		return panel_4;
	}
	private JSpinner getSpinnerPercentage() {
		if (spinnerPercentage == null) {
			spinnerPercentage = new JSpinner();
			spinnerPercentage.setModel(new SpinnerNumberModel(15, 0, 20, 1));
			spinnerPercentage.setBounds(10, 21, 53, 30);
		}
		return spinnerPercentage;
	}
	private JButton getBtnClacular() {
		if (btnClacular == null) {
			btnClacular = new JButton("Clacular");
			btnClacular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int fila = tVentas.getSelectedRow();
					if(fila != -1) {
						float entrada = (inmobiliaria.calcularEntrada((Integer) spinnerPercentage.getValue(), (Float) tVentas.getValueAt(fila, 3)));
						lblResultado.setText(entrada +" $");
					}
				}
			});
			btnClacular.setBounds(91, 25, 89, 23);
		}
		return btnClacular;
	}
	private JLabel getLblResultado() {
		if (lblResultado == null) {
			lblResultado = new JLabel("");
			lblResultado.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblResultado.setBounds(10, 62, 188, 21);
		}
		return lblResultado;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setBounds(592, 541, 208, 40);
			panel_5.setLayout(new GridLayout(1, 0, 0, 0));
			panel_5.add(getBtnAceptar());
			panel_5.add(getBtnCancelar());
		}
		return panel_5;
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
		}
		return btnAceptar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
		}
		return btnCancelar;
	}
	private JTabbedPane getTpMansiones() {
		if (tpMansiones == null) {
			tpMansiones = new JTabbedPane(JTabbedPane.TOP);
			tpMansiones.setBounds(23, 97, 559, 303);
			tpMansiones.addTab("Mansiones en Venta", null, getPnVentas(), null);
			tpMansiones.addTab("Me cago en tu puta madre muerta", null, getPnAlquileres(), null);
		}
		return tpMansiones;
	}
	private JPanel getPnVentas() {
		if (pnVentas == null) {
			pnVentas = new JPanel();
			pnVentas.setLayout(new BorderLayout(0, 0));
			pnVentas.add(getScVentas(), BorderLayout.CENTER);
		}
		return pnVentas;
	}
	private JPanel getPnAlquileres() {
		if (pnAlquileres == null) {
			pnAlquileres = new JPanel();
		}
		return pnAlquileres;
	}
	private JScrollPane getScVentas() {
		if (scVentas == null) {
			scVentas = new JScrollPane();
			scVentas.setViewportView(getTVentas());
		}
		return scVentas;
	}
	private JTable getTVentas() {
		if (tVentas == null) {
			String[] nombreColumnas = {"Código", "Zona", "Localidad", "Precio"};
			modeloTable = new DefaultTableModel(nombreColumnas, 0);
			
			tVentas = new JTable(modeloTable);
			tVentas.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					lblDescription.setText(inmobiliaria.getDescripcionMansion(tVentas.getSelectedRow()));
				}
			});
			
			tVentas.getTableHeader().setReorderingAllowed(false);
			tVentas.getTableHeader().setResizingAllowed(false);
		}
		return tVentas;
	}
	
	private void addRows() {
		Object[] nuevaFila = new Object[4];
		
		for(Mansion m : inmobiliaria.getRelacionMansiones()) {
			nuevaFila[0] = m.getCodigo();
			nuevaFila[1] = m.getZona();
			nuevaFila[2] = m.getLocalidad();
			nuevaFila[3] = m.getPrecio();
			
			modeloTable.addRow(nuevaFila);
		}
	}
}
