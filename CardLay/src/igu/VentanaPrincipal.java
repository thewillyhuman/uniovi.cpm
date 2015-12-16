package igu;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnNorte;
	private JLabel lbPaso1;
	private JLabel lbPaso2;
	private JLabel lbPaso3;
	private JLabel lbPaso4;
	private JPanel pnBase;
	private JPanel pn1;
	private JButton btSiguiente1;
	private JLabel lbPanel1;
	private JPanel pn2;
	private JButton btSiguiente2;
	private JLabel lbPanel2;
	private JButton btAnterior2;
	private JLabel lbImagen;
	private JPanel pnBotones2;
	private JPanel pnBotones1;

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
		setTitle("Ejemplo CardLayout con Imagen redimensionable");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnNorte(), BorderLayout.NORTH);
		contentPane.add(getPnBase(), BorderLayout.CENTER);
	}
	
	private void adaptarImagenLabel(JLabel label, String rutaImagen){
		  Image imgOriginal = new ImageIcon(getClass().getResource(rutaImagen)).getImage();
		  Image imgEscalada = imgOriginal.getScaledInstance((int)(label.getWidth()),(int)(label.getHeight()), Image.SCALE_FAST);
		  label.setIcon(new ImageIcon(imgEscalada));
		}
	
	private JPanel getPnNorte() {
		if (pnNorte == null) {
			pnNorte = new JPanel();
			pnNorte.setBackground(new Color(102, 0, 0));
			pnNorte.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnNorte.add(getLbPaso1());
			pnNorte.add(getLbPaso2());
			pnNorte.add(getLbPaso3());
			pnNorte.add(getLbPaso4());
		}
		return pnNorte;
	}
	private JLabel getLbPaso1() {
		if (lbPaso1 == null) {
			lbPaso1 = new JLabel("");
			lbPaso1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/paso1.png")));
		}
		return lbPaso1;
	}
	private JLabel getLbPaso2() {
		if (lbPaso2 == null) {
			lbPaso2 = new JLabel("");
			lbPaso2.setEnabled(false);
			lbPaso2.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/paso2.png")));
		}
		return lbPaso2;
	}
	private JLabel getLbPaso3() {
		if (lbPaso3 == null) {
			lbPaso3 = new JLabel("");
			lbPaso3.setEnabled(false);
			lbPaso3.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/paso3.png")));
		}
		return lbPaso3;
	}
	private JLabel getLbPaso4() {
		if (lbPaso4 == null) {
			lbPaso4 = new JLabel("");
			lbPaso4.setEnabled(false);
			lbPaso4.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/paso4.png")));
		}
		return lbPaso4;
	}
	private JPanel getPnBase() {
		if (pnBase == null) {
			pnBase = new JPanel();
			pnBase.setBorder(new LineBorder(new Color(102, 0, 0), 8));
			pnBase.setLayout(new CardLayout(0, 0));
			pnBase.add(getPn1(), "panel1");
			pnBase.add(getPn2(), "panel2");
		}
		return pnBase;
	}
	private JPanel getPn1() {
		if (pn1 == null) {
			pn1 = new JPanel();
			pn1.setBackground(Color.WHITE);
			pn1.setLayout(new BorderLayout(0, 0));
			pn1.add(getLbPanel1(), BorderLayout.NORTH);
			pn1.add(getLbImagen(), BorderLayout.CENTER);
			pn1.add(getPnBotones1(), BorderLayout.SOUTH);
		}
		return pn1;
	}
	private JButton getBtSiguiente1() {
		if (btSiguiente1 == null) {
			btSiguiente1 = new JButton("Siguiente");
			btSiguiente1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarPaso(false, true, false, false);
					((CardLayout)pnBase.getLayout()).show(pnBase,"panel2");
				}
			});
			btSiguiente1.setForeground(new Color(102, 0, 0));
			btSiguiente1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return btSiguiente1;
	}
	private JLabel getLbPanel1() {
		if (lbPanel1 == null) {
			lbPanel1 = new JLabel("Primer panel");
			lbPanel1.setForeground(new Color(102, 0, 0));
			lbPanel1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		}
		return lbPanel1;
	}
	private JPanel getPn2() {
		if (pn2 == null) {
			pn2 = new JPanel();
			pn2.setBackground(Color.WHITE);
			pn2.setLayout(new BorderLayout(0, 0));
			pn2.add(getLbPanel2(), BorderLayout.NORTH);
			pn2.add(getPnBotones2(), BorderLayout.SOUTH);
		}
		return pn2;
	}
	private JButton getBtSiguiente2() {
		if (btSiguiente2 == null) {
			btSiguiente2 = new JButton("Siguiente");
			btSiguiente2.setForeground(new Color(102, 0, 0));
			btSiguiente2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return btSiguiente2;
	}
	private JLabel getLbPanel2() {
		if (lbPanel2 == null) {
			lbPanel2 = new JLabel("Segundo panel");
			lbPanel2.setForeground(new Color(102, 0, 0));
			lbPanel2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		}
		return lbPanel2;
	}
	private JButton getBtAnterior2() {
		if (btAnterior2 == null) {
			btAnterior2 = new JButton("Anterior");
			btAnterior2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPaso(true, false, false, false);
					((CardLayout)pnBase.getLayout()).show(pnBase,"panel1");
				}
			});
			btAnterior2.setForeground(new Color(102, 0, 0));
			btAnterior2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return btAnterior2;
	}
	
	private void mostrarPaso(boolean paso1, boolean paso2, boolean paso3, boolean paso4) {
		lbPaso1.setEnabled(paso1);
		lbPaso2.setEnabled(paso2);
		lbPaso3.setEnabled(paso3);
		lbPaso4.setEnabled(paso4);
	}
	private JLabel getLbImagen() {
		if (lbImagen == null) {
			lbImagen = new JLabel("");
			lbImagen.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					adaptarImagenLabel(lbImagen,"/img/caribe.jpg"); 
				}
			});
		}
		return lbImagen;
	}
	private JPanel getPnBotones2() {
		if (pnBotones2 == null) {
			pnBotones2 = new JPanel();
			FlowLayout fl_pnBotones2 = (FlowLayout) pnBotones2.getLayout();
			fl_pnBotones2.setAlignment(FlowLayout.RIGHT);
			pnBotones2.add(getBtAnterior2());
			pnBotones2.add(getBtSiguiente2());
		}
		return pnBotones2;
	}
	private JPanel getPnBotones1() {
		if (pnBotones1 == null) {
			pnBotones1 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnBotones1.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnBotones1.add(getBtSiguiente1());
		}
		return pnBotones1;
	}
}
