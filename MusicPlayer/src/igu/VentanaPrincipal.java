package src.igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JSlider;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import java.awt.event.KeyEvent;
import java.util.Properties;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.help.*;
import java.net.*;
import java.io.*;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtVol;

	private DefaultListModel modeloLista1 = new DefaultListModel();
	private DefaultListModel modeloLista2 = new DefaultListModel();
	private JList lista1;
	private JMenuItem mntmContents;
	private JSlider slVolumen;
	
	private JFileChooser selector = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Properties props = new Properties();
					props.put("logoString", "");
					HiFiLookAndFeel.setCurrentTheme(props);
					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");

					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JFileChooser getSelector() {
		if (selector == null) {
			selector = new JFileChooser();
			selector.setMultiSelectionEnabled(true);
		}
		return selector;
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/src/img/logoTitulo.png")));
		setTitle("EII Music Player");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 479);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('F');
		mnFile.setMnemonic(KeyEvent.VK_F);
		menuBar.add(mnFile);

		JMenuItem menItemOpen = new JMenuItem("Open");
		menItemOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int respuesta = getSelector().showOpenDialog(null);
				if (respuesta == JFileChooser.APPROVE_OPTION) {
					for (java.io.File f : selector.getSelectedFiles()) {
						modeloLista1.addElement(f);
					}
				}
			}
		});
		mnFile.add(menItemOpen);

		JMenuItem menItemExit = new JMenuItem("Exit");
		mnFile.add(menItemExit);

		JMenu mnPlay = new JMenu("Play");
		mnPlay.setMnemonic('p');
		mnPlay.setMnemonic(KeyEvent.VK_P);
		menuBar.add(mnPlay);

		JMenu mnOptions = new JMenu("Options");
		mnOptions.setMnemonic('t');
		mnOptions.setMnemonic(KeyEvent.VK_T);
		menuBar.add(mnOptions);

		JMenu mnHelp = new JMenu("Help");
		mnHelp.setMnemonic('H');
		mnHelp.setMnemonic(KeyEvent.VK_H);
		menuBar.add(mnHelp);
		
		mntmContents = new JMenuItem("Contents");
		mntmContents.setMnemonic('C');
		mnHelp.add(mntmContents);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel pnNorte = new JPanel();
		contentPane.add(pnNorte, BorderLayout.NORTH);
		pnNorte.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/src/img/logo.png")));
		pnNorte.add(lblLogo);

		slVolumen = new JSlider();
		slVolumen.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				txtVol.setText(Integer.toString(slVolumen.getValue()));
			}
		});
		slVolumen.setPaintTicks(true);
		slVolumen.setPaintLabels(true);
		slVolumen.setMinorTickSpacing(10);
		slVolumen.setMajorTickSpacing(20);
		pnNorte.add(slVolumen);

		JPanel pnVol = new JPanel();
		pnNorte.add(pnVol);
		pnVol.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblVol = new JLabel("Vol:");
		lblVol.setFont(new Font("Dialog", Font.BOLD, 26));
		pnVol.add(lblVol);

		txtVol = new JTextField();
		txtVol.setHorizontalAlignment(SwingConstants.CENTER);
		txtVol.setText("100");
		txtVol.setFont(new Font("Dialog", Font.BOLD, 40));
		txtVol.setEditable(false);
		pnVol.add(txtVol);
		txtVol.setColumns(3);

		JPanel pnCentro = new JPanel();
		contentPane.add(pnCentro, BorderLayout.CENTER);
		pnCentro.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel pnLibrary = new JPanel();
		pnCentro.add(pnLibrary);
		pnLibrary.setLayout(new BorderLayout(0, 0));

		JLabel lblLibrary = new JLabel("\u266ALibrary:");
		lblLibrary.setFont(new Font("Dialog", Font.BOLD, 24));
		pnLibrary.add(lblLibrary, BorderLayout.NORTH);

		JPanel pnBotonesLibrary = new JPanel();
		pnLibrary.add(pnBotonesLibrary, BorderLayout.SOUTH);
		pnBotonesLibrary.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnAdd = new JButton("Add to Playlist");
		pnBotonesLibrary.add(btnAdd);

		JButton btnDelete = new JButton("Delete");
		pnBotonesLibrary.add(btnDelete);

		JScrollPane scLista1 = new JScrollPane();
		pnLibrary.add(scLista1, BorderLayout.CENTER);

		
		lista1 = new JList();
		lista1.setModel(modeloLista1);
		scLista1.setViewportView(lista1);

		JPanel pnPlaylist = new JPanel();
		pnCentro.add(pnPlaylist);
		pnPlaylist.setLayout(new BorderLayout(0, 0));

		JLabel lblplaylist = new JLabel("\u266APlayList:");
		lblplaylist.setFont(new Font("Dialog", Font.BOLD, 24));
		pnPlaylist.add(lblplaylist, BorderLayout.NORTH);

		JPanel pnBotonesPlaylist = new JPanel();
		pnPlaylist.add(pnBotonesPlaylist, BorderLayout.SOUTH);
		pnBotonesPlaylist.setLayout(new GridLayout(0, 5, 0, 0));

		JButton pnRewind = new JButton("\u25C4\u25C4");
		pnBotonesPlaylist.add(pnRewind);

		JButton btnPlay = new JButton("\u25BA");
		pnBotonesPlaylist.add(btnPlay);

		JButton pnStop = new JButton("\u25A0");
		pnBotonesPlaylist.add(pnStop);

		JButton btnNext = new JButton("\u25BA\u25BA");
		pnBotonesPlaylist.add(btnNext);

		JButton btnDel = new JButton("Del.");
		pnBotonesPlaylist.add(btnDel);

		JScrollPane scLista2 = new JScrollPane();
		pnPlaylist.add(scLista2, BorderLayout.CENTER);

		JList<?> Lista2 = new JList<Object>();
		Lista2.setModel(modeloLista2);
		scLista2.setViewportView(Lista2);
		
		cargaAyuda();
	}

	//Incorporar este metodo en la Ventana principal e invocarlo desde el constructor
	private void cargaAyuda(){

	   URL hsURL;
	   HelpSet hs;

	   try {
		    File fichero = new File("help/help/Ayuda.hs");
		    hsURL = fichero.toURI().toURL();
		    hs = new HelpSet(null, hsURL);
	}

	    catch (Exception e){
	      System.out.println("Ayuda no encontrada");
	     return;
	   }

	   HelpBroker hb = hs.createHelpBroker();
	   hb.initPresentation();

	   hb.enableHelpKey(getRootPane(),"intro", hs);
	   hb.enableHelpOnButton(mntmContents, "intro", hs);
	   hb.enableHelp(lista1, "añadir", hs);
	   hb.enableHelp(slVolumen, "volumen", hs);
	   
	 }
}
