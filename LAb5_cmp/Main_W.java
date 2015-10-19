package img;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.border.LineBorder;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.Toolkit;

import javax.swing.JSeparator;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logica.Calle;
import logica.Carrera;
import logica.Casilla;
import logica.Corredor;
import logica.Liebre;
import logica.Tortuga;

public class Main_W extends JFrame {  

	private JPanel contentPane;
	private JButton btDado;
	private JLabel lblScore;
	private JLabel lbCounter;
	private JLabel lbCounterLiebre;
	private JLabel lbCounterTortuga;
	private JPanel jPanel_Liebre;
	private JLabel label_1;
	private JLabel lblNewLabel_1;
	private JButton btL4;
	private JButton btL10;
	private JButton btL5;
	private JButton btL8;
	private JButton btL7;
	private JButton btL6;
	private JButton btL2;
	private JButton btL3;
	private JButton btL0;
	private JButton btL1;
	private JLabel label_2;
	private JLabel label_3;
	private JPanel jPanelTortuga;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_11;
	private JMenuBar menuBar;
	private JMenu mnJuego;
	private JMenu mnAyuda;
	private JMenuItem mntmNuevo;
	private JMenuItem mntmSalir;
	private JMenuItem mntmContenidos;
	private JMenuItem mntmAcercaDe;
	private JButton btL9;
	private JButton button_13;
	private JSeparator separator;
	private JSeparator separator_1;

	private Carrera carrera;
	private MyActionListener listener;
	
	private void pintarCalle(Corredor corredor, Component[] botones)
	{
		String imagen = "/img/"+corredor.getFoto();
		
		for ( int i = 0; i < botones.length ; i++)
		{
			JButton boton = (JButton) botones[i];
			if ( i == corredor.getPosicion() )
			{
				boton.setIcon(new ImageIcon(getClass().getResource(imagen)));
				boton.setDisabledIcon(new ImageIcon(getClass().getResource(imagen)));
			} else {
				boton.setIcon(null);
				boton.setDisabledIcon(null);
			}
			
			if ( !corredor.equals(carrera.getCorredorActivo()) )
			{
				boton.setEnabled(false);
			}
		}
	}
	
	private void pintarLiebre()
	{
		if ( !(carrera.getLiebre().getPosicion() == Corredor.POSICION_SALIDA) ){
			label_2.setIcon(null);
		} else {
			label_2.setIcon(new ImageIcon (getClass().getResource("/img/"+carrera.getLiebre().getFoto())));
		}
		
		Component[] btsLiebre = this.jPanel_Liebre.getComponents();
		this.pintarCalle(carrera.getLiebre(), btsLiebre);
	}
	
	private void pintarTortuga()
	{
		if ( !(carrera.getTortuga().getPosicion() == Corredor.POSICION_SALIDA) ){
			label_3.setIcon(null);
		} else {
			label_3.setIcon(new ImageIcon (getClass().getResource("/img/"+carrera.getTortuga().getFoto())));
		}
		
		Component[] btsTortuga = this.jPanelTortuga.getComponents();
		this.pintarCalle(carrera.getTortuga(), btsTortuga);
	}
	
	public void pintarArbol(int n)
	{
		for( int i = 0 ; i < 11 ; i++)
		{
			if(i == n)
				btL3.setIcon(new ImageIcon (getClass().getResource("/img/arbol.jpg")));
		}
	}
	
	
	private void representarEstadoJuego()
	{
		lbCounter.setText("");
		
		lbCounterLiebre.setText(String.valueOf(carrera.getLiebre().getPuntuacion()));
		lbCounterTortuga.setText(String.valueOf(carrera.getTortuga().getPuntuacion()));
		
		this.pintarLiebre();
		this.pintarTortuga();
		
		if ( carrera.isPartidaFinalizada() ){
			JOptionPane.showMessageDialog(this, "Partida Finalizada");
			modificarPanel ( jPanel_Liebre, false);
			modificarPanel ( jPanelTortuga, false);
		} else {
			btDado.setEnabled(true);
		}
	}
	
	private void habilitarDeshabilitarPaneles()
	{
		if ( carrera.getCorredorActivo() instanceof Liebre)
		{
			modificarPanel(jPanel_Liebre, true);
			modificarPanel(jPanelTortuga, false);
		} else {
			modificarPanel(jPanel_Liebre, false);
			modificarPanel(jPanelTortuga, true);
		}
		currentUser();
	}
	
	private void jugar(int i)
	{
		if ( carrera.isJugadaCorrecta(i))
		{
			carrera.resolverJugada();
			this.representarEstadoJuego();
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_W frame = new Main_W();
					frame.setLocationRelativeTo(null);//para ponerlo en el medio 
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
	public Main_W() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Saved Games\\Documents\\workspace\\LAb5_cmp\\src\\img\\liebre_durmiendo.JPG"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 886, 395);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtDado());
		contentPane.add(getLblScore());
		contentPane.add(getLbCounter());
		contentPane.add(getLbCounterLiebre());
		contentPane.add(getLbCounterTortuga());
		contentPane.add(getJPanel_Liebre());
		contentPane.add(getLabel_1());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLabel_2());
		contentPane.add(getLabel_3());
		contentPane.add(getJPanelTortuga());
		
		//We initialize Carrera.
		carrera = new Carrera();
		listener = new MyActionListener();
		
		this.asociarEventosBotones(jPanel_Liebre);
		this.asociarEventosBotones(jPanelTortuga);
		
		//pintarArbol();
		currentUser();
	}

	private void asociarEventosBotones( JPanel panel )
	{
		for ( int i= 0 ; i < panel.getComponents().length ; i++ )
		{
			JButton boton = (JButton) panel.getComponents()[i];
			boton.setActionCommand(String.valueOf(i));
			boton.addActionListener(listener);
		}
	}
	
	private JButton getBtDado() {
		if (btDado == null) {
			btDado = new JButton("");
			btDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					carrera.lanzarDado();
					lbCounter.setText(String.valueOf(carrera.getNumeroDado()));
					
					habilitarDeshabilitarPaneles();
					
					if (!carrera.isJugadaPosible()){
						btDado.setEnabled(true);
					} else {
						btDado.setEnabled(false);
					}
					
				}
			});
			btDado.setIcon(new ImageIcon(Main_W.class.getResource("/img/dado.JPG")));
			btDado.setBounds(48, 11, 68, 88);
		}
		return btDado;
	}
	private JLabel getLblScore() {
		if (lblScore == null) {
			lblScore = new JLabel("SCORE");
			lblScore.setForeground(Color.YELLOW);
			lblScore.setFont(new Font("Wide Latin", Font.PLAIN, 25));
			lblScore.setBounds(393, 29, 174, 49);
		}
		return lblScore;
	}
	private JLabel getLbCounter() {
		if (lbCounter == null) {
			lbCounter = new JLabel("2");
			lbCounter.setFont(new Font("Segoe Marker", Font.PLAIN, 45));
			lbCounter.setForeground(Color.GREEN);
			lbCounter.setBounds(158, 11, 60, 66);
		}
		return lbCounter;
	}
	private JLabel getLbCounterLiebre() {
		if (lbCounterLiebre == null) {
			lbCounterLiebre = new JLabel("0");
			lbCounterLiebre.setHorizontalAlignment(SwingConstants.CENTER);
			lbCounterLiebre.setForeground(Color.WHITE);
			lbCounterLiebre.setBorder(new LineBorder(Color.WHITE, 3));
			lbCounterLiebre.setBounds(734, 23, 102, 27);
		}
		return lbCounterLiebre;
	}
	private JLabel getLbCounterTortuga() {
		if (lbCounterTortuga == null) {
			lbCounterTortuga = new JLabel("0");
			lbCounterTortuga.setHorizontalAlignment(SwingConstants.CENTER);
			lbCounterTortuga.setBorder(new LineBorder(Color.WHITE, 3));
			lbCounterTortuga.setForeground(Color.WHITE);
			lbCounterTortuga.setBackground(Color.WHITE);
			lbCounterTortuga.setBounds(734, 61, 102, 27);
		}
		return lbCounterTortuga;
	}
	private JPanel getJPanel_Liebre() {
		if (jPanel_Liebre == null) {
			jPanel_Liebre = new JPanel();
			jPanel_Liebre.setBackground(Color.BLUE);
			jPanel_Liebre.setForeground(Color.WHITE);
			jPanel_Liebre.setBorder(new LineBorder(Color.BLUE, 5));
			jPanel_Liebre.setBounds(88, 137, 778, 77);
			jPanel_Liebre.setLayout(new GridLayout(1, 11, 2, 10));
			jPanel_Liebre.add(getBtL0());
			jPanel_Liebre.add(getBtL1());
			jPanel_Liebre.add(getBtL2());
			jPanel_Liebre.add(getBtL3());
			jPanel_Liebre.add(getBtL4());
			jPanel_Liebre.add(getBtL5());
			jPanel_Liebre.add(getBtL6());
			jPanel_Liebre.add(getBtL7());
			jPanel_Liebre.add(getBtL8());
			jPanel_Liebre.add(getBtL9());
			jPanel_Liebre.add(getBtL10());
			modificarPanel(getJPanel_Liebre(), false);

		}
		return jPanel_Liebre;
	}
	
	
	private void modificarPanel(JPanel panel , boolean habilitar){
		Component[] botones = panel.getComponents();
		for(int i=0;i<botones.length;i++){
			
			JButton boton = (JButton) botones[i];
			boton.setEnabled(habilitar);
			
		}
	}
	

	private void currentUser()
	{
		if(carrera.getCorredorActivo() instanceof Liebre)
		{	jPanel_Liebre.setBorder(null);
			jPanel_Liebre.setBackground(Color.BLACK);
		} else if (carrera.getCorredorActivo() instanceof Tortuga) {
			jPanel_Liebre.setBorder();
			jPanel_Liebre.setBackground(Color.BLUE);
			jPanelTortuga.setBorder(null);
			jPanel_Liebre.setBackground(Color.BLACK);
		}
	}
	
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("");
			label_1.setIcon(new ImageIcon(Main_W.class.getResource("/img/liebre_peq.JPG")));
			label_1.setBounds(674, 11, 35, 41);
		}
		return label_1;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(Main_W.class.getResource("/img/tortuga_peq.JPG")));
			lblNewLabel_1.setBounds(674, 60, 35, 39);
		}
		return lblNewLabel_1;
	}
	private JButton getBtL4() {
		if (btL4 == null) {
			btL4 = new JButton("");
	
			btL4.setBackground(Color.BLACK);
		}
		return btL4;
	}
	private JButton getBtL10() {
		if (btL10 == null) {
			btL10 = new JButton("");
			
			btL10.setBackground(Color.BLACK);
		}
		return btL10;
	}
	private JButton getBtL5() {
		if (btL5 == null) {
			btL5 = new JButton("");
			
			btL5.setBackground(Color.BLACK);
		}
		return btL5;
	}
	private JButton getBtL8() {
		if (btL8 == null) {
			btL8 = new JButton("");
			
			btL8.setBackground(Color.BLACK);
		}
		return btL8;
	}
	private JButton getBtL7() {
		if (btL7 == null) {
			btL7 = new JButton("");
			
			btL7.setBackground(Color.BLACK);
		}
		return btL7;
	}
	private JButton getBtL6() {
		if (btL6 == null) {
			btL6 = new JButton("");
			
			btL6.setBackground(Color.BLACK);
		}
		return btL6;
	}
	private JButton getBtL2() {
		if (btL2 == null) {
			btL2 = new JButton("");
			
			btL2.setBackground(Color.BLACK);
		}
		return btL2;
	}
	private JButton getBtL3() {
		if (btL3 == null) {
			btL3 = new JButton("");
			
			btL3.setBackground(Color.BLACK);
		}
		return btL3;
	}
	private JButton getBtL0() {
		if (btL0 == null) {
			btL0 = new JButton("");
			
			btL0.setBackground(Color.BLACK);
		}
		return btL0;
	}
	private JButton getBtL1() {
		if (btL1 == null) {
			btL1 = new JButton("");
			
			btL1.setBackground(Color.BLACK);
		}
		return btL1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("");
			label_2.setIcon(new ImageIcon(Main_W.class.getResource("/img/liebre.JPG")));
			label_2.setBounds(10, 137, 68, 77);
		}
		return label_2;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("");
			label_3.setIcon(new ImageIcon(Main_W.class.getResource("/img/tortuga.JPG")));
			label_3.setBounds(10, 248, 68, 66);
		}
		return label_3;
	}
	private JPanel getJPanelTortuga() {
		if (jPanelTortuga == null) {
			jPanelTortuga = new JPanel();
			jPanelTortuga.setForeground(Color.WHITE);
			jPanelTortuga.setBorder(new LineBorder(Color.BLUE, 5));
			jPanelTortuga.setBackground(Color.BLUE);
			jPanelTortuga.setBounds(88, 248, 778, 77);
			jPanelTortuga.setLayout(new GridLayout(1, 11, 2, 10));
			jPanelTortuga.add(getButton_1());
			jPanelTortuga.add(getButton_2());
			jPanelTortuga.add(getButton_3());
			jPanelTortuga.add(getButton_4());
			jPanelTortuga.add(getButton_5());
			jPanelTortuga.add(getButton_6());
			jPanelTortuga.add(getButton_7());
			jPanelTortuga.add(getButton_8());
			jPanelTortuga.add(getButton_9());
			jPanelTortuga.add(getButton_13());
			jPanelTortuga.add(getButton_11());
			modificarPanel(getJPanelTortuga(), false);
		}
		return jPanelTortuga;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("");
			
			button_1.setBackground(Color.BLACK);
		}
		return button_1;
	}
	private JButton getButton_2() {
		if (button_2 == null) {
			button_2 = new JButton("");
			
			button_2.setBackground(Color.BLACK);
		}
		return button_2;
	}
	private JButton getButton_3() {
		if (button_3 == null) {
			button_3 = new JButton("");
			
			button_3.setBackground(Color.BLACK);
		}
		return button_3;
	}
	private JButton getButton_4() {
		if (button_4 == null) {
			button_4 = new JButton("");
			
			button_4.setBackground(Color.BLACK);
		}
		return button_4;
	}
	private JButton getButton_5() {
		if (button_5 == null) {
			button_5 = new JButton("");
			
			button_5.setBackground(Color.BLACK);
		}
		return button_5;
	}
	private JButton getButton_6() {
		if (button_6 == null) {
			button_6 = new JButton("");
			
			button_6.setBackground(Color.BLACK);
		}
		return button_6;
	}
	private JButton getButton_7() {
		if (button_7 == null) {
			button_7 = new JButton("");
			
			button_7.setBackground(Color.BLACK);
		}
		return button_7;
	}
	private JButton getButton_8() {
		if (button_8 == null) {
			button_8 = new JButton("");
			
			button_8.setBackground(Color.BLACK);
		}
		return button_8;
	}
	private JButton getButton_9() {
		if (button_9 == null) {
			button_9 = new JButton("");
			
			button_9.setBackground(Color.BLACK);
		}
		return button_9;
	}
	private JButton getButton_11() {
		if (button_11 == null) {
			button_11 = new JButton("");
			
			button_11.setBackground(Color.BLACK);
		}
		return button_11;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnJuego());
			menuBar.add(getMnAyuda());
		}
		return menuBar;
	}
	private JMenu getMnJuego() {
		if (mnJuego == null) {
			mnJuego = new JMenu("Juego");
			mnJuego.setMnemonic('J');
			mnJuego.add(getMntmNuevo());
			mnJuego.add(getSeparator());
			mnJuego.add(getMntmSalir());
		}
		return mnJuego;
	}
	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Ayuda");
			mnAyuda.setMnemonic('A');
			mnAyuda.add(getMntmContenidos());
			mnAyuda.add(getSeparator_1());
			mnAyuda.add(getMntmAcercaDe());
		}
		return mnAyuda;
	}
	private JMenuItem getMntmNuevo() {
		if (mntmNuevo == null) {
			mntmNuevo = new JMenuItem("Nuevo");
			mntmNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					carrera.inicializarJuego();
					representarEstadoJuego();
					modificarPanel(jPanel_Liebre, false);
					modificarPanel(jPanelTortuga, false);
					btDado.setEnabled(true);
				}
			});
			mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
			mntmNuevo.setToolTipText("");
			mntmNuevo.setMnemonic('n');
		}
		return mntmNuevo;
	}
	private JMenuItem getMntmSalir() {
		if (mntmSalir == null) {
			mntmSalir = new JMenuItem("Salir");
			mntmSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			mntmSalir.setMnemonic('s');
		}
		return mntmSalir;
	}
	private JMenuItem getMntmContenidos() {
		if (mntmContenidos == null) {
			mntmContenidos = new JMenuItem("Contenidos");
			mntmContenidos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
			mntmContenidos.setMnemonic('c');
		}
		return mntmContenidos;
	}
	private JMenuItem getMntmAcercaDe() {
		if (mntmAcercaDe == null) {
			mntmAcercaDe = new JMenuItem("Acerca de ");
			mntmAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, "Juego de la liebre y la Tortuga  \n Comunicacion persona Maquina \n E.I.Informatica de Oviedo","acerca de Liebre y  Tortuga" , 1);
					//el uno del ultimo parametro es para mostrar el icono que queramos , en este caso el de informacion
				}
			});
			mntmAcercaDe.setMnemonic('r');
		}
		return mntmAcercaDe;
	}
	private JButton getBtL9() {
		if (btL9 == null) {
			btL9 = new JButton("");
			
			
			btL9.setBackground(Color.BLACK);
		}
		return btL9;
	}
	private JButton getButton_13() {
		if (button_13 == null) {
			button_13 = new JButton("");
			
			button_13.setBackground(Color.BLACK);
		}
		return button_13;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}
	
	class MyActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			int number = Integer.parseInt(button.getActionCommand());
			jugar(number);
		}
		
	}
}
