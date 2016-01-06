package com.guille.cpm.igu;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.guille.cpm.logic.Camarote;
import com.guille.cpm.logic.CamaroteDoble;
import com.guille.cpm.logic.CamaroteDobleExterior;
import com.guille.cpm.logic.CamaroteDobleInterior;
import com.guille.cpm.logic.CamaroteFamiliar;
import com.guille.cpm.logic.CamaroteFamiliarExterior;
import com.guille.cpm.logic.CamaroteFamiliarInterior;
import com.guille.cpm.logic.CargarDatos;
import com.guille.cpm.logic.CompareByDuration;
import com.guille.cpm.logic.CompareByPrice;
import com.guille.cpm.logic.CompareByStartingdate;
import com.guille.cpm.logic.Crucero;
import com.guille.cpm.logic.Cruceros;
import com.guille.cpm.logic.Extra;
import com.guille.cpm.logic.Extras;
import com.guille.cpm.logic.FilterByArea;
import com.guille.cpm.logic.FilterByChild;
import com.guille.cpm.logic.FilterByDiscount;
import com.guille.cpm.logic.FilterByStartingDate;
import com.guille.cpm.logic.FilterByStartingPort;
import com.guille.cpm.logic.Pasajero;
import com.guille.cpm.logic.Reserva;
import com.guille.cpm.logic.Viaje;
import com.guille.fonts.myriadSetPro.MyriadSetPro;
import com.guille.util.CollectionsCPM;
import com.guille.util.Files;
import com.guille.util.Images;
import com.guille.util.Strings;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.MatteBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.border.EtchedBorder;
import java.awt.Insets;

/**
 * 
 * @author Guillermo Facundo Colunga
 */
public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = -8029479718163458536L;
	
	// Error log.
	private static final PrintWriter log = Files.createLogger("com/guille/cpm/files/out/", "ErrorLog"); //$NON-NLS-1$ //$NON-NLS-2$
	
	// Custom Fonts.
	protected static final Font text = new MyriadSetPro().getMyriad_Set_Pro_Text().deriveFont(14f);
	protected static final Font textBold = new MyriadSetPro().getMyriad_Set_Pro_Semibold().deriveFont(14f);
	protected static final Font subtitleBold = new MyriadSetPro().getMyriad_Set_Pro_Semibold().deriveFont(20f);
	protected static final Font textMedium = new MyriadSetPro().getMyriad_Set_Pro_Medium().deriveFont(17f);
	
	// Properties.
	public static final String DEFAULT_COMBO_TEXT = Messages.getString("VentanaPrincipal.default_combo"); //$NON-NLS-1$
	
	// Variables.
	// JPanels.
	private JPanel mainPane, panel1, wPanel, cPanel, cPanelNPanel, panel2, panel2NPanel;
	private JPanel panel2SPanel;
	private JPanel panel2CPanel;
	private JPanel panel2NPanelEPanel;
	private JPanel panel2NPanelWPanel;
	private JPanel panel2NPanelNpanel;
	private JPanel pnRoom2Panel;
	private JPanel pnRooms2Panel;
	private JPanel pnPassengers2Panel;
	private JPanel pnSouthPassengers2Panel;
	private JPanel pnExtras2Panel;
	private JPanel pnButtonsRooms;
	private JPanel panel3;
	private JPanel pnNpn3;
	private JPanel pnSpn3;
	private JPanel pnCpn3;
	private JPanel pnTableSummary;
	private JPanel panel;
	private JPanel panel4;
	private JPanel pnCpn4;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel pnTripStatus;
	private JPanel pnCapacities;
	private JPanel panel_1;
	
	// JLabels.
	private JLabel lblSerach;
	private JLabel lblDestino;
	private JLabel lblStartingDate;
	private JLabel lblStartingPort;
	private JLabel lblListOfAvaliable;
	private JLabel lblMoreCriteria;
	private JLabel lblSortBy;
	private JLabel lblDuration;
	private JLabel lblImgShipPanel2;
	private JLabel lblDescripcion2Panel;
	private JLabel lblDuration2Panel;
	private JLabel lblShipName2Panel;
	private JLabel lblTypeOfRoom2Panel;
	private JLabel lblCapacity2Panel;
	private JLabel lblPartialPrice;
	private JLabel lblSummary;
	private JLabel lblName;
	private JLabel lblSurname;
	private JLabel lblFreeDoubleInterior;
	private JLabel lblFreeDoubleExterior;
	private JLabel lblFreeFamiliarInterior;
	private JLabel lblFreeFamiliarExterior;
	private JLabel lblTotalRooms;
	private JLabel lblTotalExtras;
	private JLabel lblTotalPrice;
	private JLabel lblDescriptionAndDate;
	private JLabel lblDni;
	private JLabel lblPhone;
	private JLabel lblReceiptTitle;
	
	// JTextArea
	private JTextArea txtReceipt;
	private JTextArea txtrTxtdescriptionlong;
	
	// JTextField
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtPhone;
	private JTextField txtDNI;
	
	// JComboBoxes
	private JComboBox<String> comboDestino;
	private JComboBox<String> comboStartingDate;
	private JComboBox<String> comboStartingPort;
	private JComboBox<String> comboSort;
	private JComboBox<String> comboDuration;
	private JComboBox<String> cmbDate2Panel;
	private JComboBox<String> cmbTypeOfRoom2Panl;
	
	// JCheckBoxes
	private JCheckBox ckbxAcceptsKids;
	private JCheckBox ckbxDiscount;
	private JCheckBox chckbxAddExtraBed;
	private JCheckBox chckbxJacuzzi;
	private JCheckBox chckbxSpecialBreakfast;
	private JCheckBox chckbxExtrabigBed;
	
	// JButtons
	private JButton btnNewButton;
	private JButton btnConfirm;
	private JButton btnAddPassanger;
	private JButton btnDeletePassanger;
	private JButton btnModifyPassenger;
	private JButton btnAddRoob;
	private JButton btnDeleteRoom;
	private JButton btnNewButton_1;
	private JButton btnConfirmAndPay;
	private JButton btnGoToInicio;
	private JButton btnCheckDate;
	private JButton btnModifyRoom;
	
	// JScrollPanes
	private JScrollPane scSearch;
	private JScrollPane scrollPane;
	private JScrollPane scPassengers2Panel;
	private JScrollPane scPaneTableSummary;
	private JScrollPane scrollPane_1;
	
	// JSeparators
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	
	// JTables
	private JTable tbRooms;
	private JTable tbSummary;
	
	// Models
	private DefaultComboBoxModel<String> modelDestination;
	private DefaultComboBoxModel<String> modelDate;
	private DefaultComboBoxModel<String> modelStartingPort;
	private DefaultListModel<Pasajero> modelPasajeros;
	private ModeloTablaNoEditable modeloTable;
	
	// Lists
	private List<Crucero> listaDeCruceros = new ArrayList<Crucero>();
	private JList<Pasajero> lstPassengers2Panel;
	
	// Objects to work with.
	private Viaje currentViaje;
	private Reserva currentReserva;
	private Crucero currentShip;
		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// Setting the antialiasing on. Just to make fonts look gorgeous.
		try {
			System.setProperty("awt.useSystemAAFontSettings", "lcd"); //$NON-NLS-1$ //$NON-NLS-2$
			System.setProperty("swing.aatext", "true"); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (Exception e) {
			Files.writeLog(log, e.getMessage());
		}
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					Files.writeLog(log, e.getMessage());
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public VentanaPrincipal() throws IOException {
		setMinimumSize(new Dimension(1046, 661));
		CargarDatos.cargarDatos();
		modelDestination = new DefaultComboBoxModel<String>();
		modelDate = new DefaultComboBoxModel<String>();
		modelStartingPort = new DefaultComboBoxModel<String>();

		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/com/guille/cpm/img/appIcon.png"))); //$NON-NLS-1$
		setLocationByPlatform(true);
		setTitle(Messages.getString("VentanaPrincipal.title_window")); //$NON-NLS-1$
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1046, 702);
		mainPane = new JPanel();
		mainPane.setBackground(Color.WHITE);
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(new CardLayout(0, 0));
		mainPane.add(getPanel1(), "busqueda_inicio"); //$NON-NLS-1$
		mainPane.add(getPanel2(), "info_crucero"); //$NON-NLS-1$
		mainPane.add(getPanel3(), "resumen_de_compra"); //$NON-NLS-1$
		mainPane.add(getPanel4(), "receipt"); //$NON-NLS-1$
		initializeModels();
		loadCruisesInList();
	}

	

	private JPanel getPanel1() {
		if (panel1 == null) {
			panel1 = new JPanel();
			panel1.setBackground(Color.WHITE);
			panel1.setLayout(new BorderLayout(0, 0));
			panel1.add(getWPanel(), BorderLayout.WEST);
			panel1.add(getCPanel(), BorderLayout.CENTER);
		}
		return panel1;
	}

	private JPanel getWPanel() {
		if (wPanel == null) {
			wPanel = new JPanel();
			wPanel.setBorder(new MatteBorder(0, 0, 0, 1, Color.LIGHT_GRAY));
			wPanel.setBackground(Color.WHITE);
			wPanel.setLayout(null);
			wPanel.add(getLblSerach());
			wPanel.add(getSeparator());
			wPanel.add(getLblDestino());
			wPanel.add(getComboDestino());
			wPanel.add(getLblStartingDate());
			wPanel.add(getComboStartingDate());
			wPanel.add(getLblStartingPort());
			wPanel.add(getComboStartingPort());
			wPanel.setPreferredSize(new Dimension(200, this.getContentPane().getHeight()));
			wPanel.add(getCkbxAcceptsKids());
			wPanel.add(getCkbxDiscount());
			wPanel.add(getLblMoreCriteria());
			wPanel.add(getSeparator_1());
			wPanel.add(getLblSortBy());
			wPanel.add(getSeparator_2());
			wPanel.add(getComboSort());
			wPanel.add(getComboDuration());
			wPanel.add(getLblDuration());
		}
		return wPanel;
	}

	private JLabel getLblSerach() {
		if (lblSerach == null) {
			lblSerach = new JLabel(Messages.getString("VentanaPrincipal.search_label")); //$NON-NLS-1$
			lblSerach.setHorizontalAlignment(SwingConstants.LEFT);
			lblSerach.setFont(subtitleBold);
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
			lblDestino = new JLabel(Messages.getString("VentanaPrincipal.destination_label")); //$NON-NLS-1$
			lblDestino.setFont(text);
			lblDestino.setBounds(6, 52, 186, 16);
		}
		return lblDestino;
	}

	private JComboBox<String> getComboDestino() {
		if (comboDestino == null) {
			comboDestino = new JComboBox<String>();
			comboDestino.setModel(modelDestination);
			comboDestino.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						updateListaCruceros();
						updateDateModel();
						updateStartingPortModel();
						getComboStartingDate().setEnabled(true);
						loadCruisesInList();
					}
				}
			});
			comboDestino.setBounds(6, 70, 186, 27);
			comboDestino.setFont(text);
		}
		return comboDestino;
	}

	private JLabel getLblStartingDate() {
		if (lblStartingDate == null) {
			lblStartingDate = new JLabel(Messages.getString("VentanaPrincipal.starting-date_label")); //$NON-NLS-1$
			lblStartingDate.setFont(text);
			lblStartingDate.setBounds(6, 109, 175, 16);
		}
		return lblStartingDate;
	}

	private JComboBox<String> getComboStartingDate() {
		if (comboStartingDate == null) {
			comboStartingDate = new JComboBox<String>();
			comboStartingDate.setEnabled(false);
			comboStartingDate.setFont(text);
			comboStartingDate.setBounds(6, 127, 186, 27);
			comboStartingDate.setModel(modelDate);
			comboStartingDate.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						updateListaCruceros();
						updateStartingPortModel();
						getComboStartingPort().setEnabled(true);
						loadCruisesInList();
					}
				}
			});
		}
		return comboStartingDate;
	}

	private JLabel getLblStartingPort() {
		if (lblStartingPort == null) {
			lblStartingPort = new JLabel(Messages.getString("VentanaPrincipal.starting-port_label")); //$NON-NLS-1$
			lblStartingPort.setFont(text);
			lblStartingPort.setBounds(6, 164, 175, 16);
		}
		return lblStartingPort;
	}

	private JComboBox<String> getComboStartingPort() {
		if (comboStartingPort == null) {
			comboStartingPort = new JComboBox<String>();
			comboStartingPort.setEnabled(false);
			comboStartingPort.setBounds(6, 185, 186, 27);
			comboStartingPort.setModel(modelStartingPort);
			comboStartingPort.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						updateListaCruceros();
						loadCruisesInList();
					}
				}
			});
			comboStartingPort.setFont(text);
		}
		return comboStartingPort;
	}

	private JPanel getCPanel() {
		if (cPanel == null) {
			cPanel = new JPanel();
			cPanel.setBorder(null);
			cPanel.setBackground(Color.WHITE);
			cPanel.setLayout(new BorderLayout(0, 0));
			cPanel.add(getScSearch(), BorderLayout.CENTER);
			cPanel.add(getCPanelNPanel(), BorderLayout.NORTH);
		}
		return cPanel;
	}

	private JScrollPane getScSearch() {
		if (scSearch == null) {
			scSearch = new JScrollPane();
			scSearch.setEnabled(false);
			scSearch.setVerifyInputWhenFocusTarget(false);
			scSearch.setFocusable(false);
			scSearch.setFocusTraversalKeysEnabled(false);
			scSearch.setDoubleBuffered(true);
			scSearch.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			scSearch.setBorder(null);
			scSearch.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scSearch.getVerticalScrollBar().setUnitIncrement(5);
		}
		return scSearch;
	}

	private JPanel getCPanelNPanel() {
		if (cPanelNPanel == null) {
			cPanelNPanel = new JPanel();
			cPanelNPanel.setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
			cPanelNPanel.setBackground(Color.WHITE);
			cPanelNPanel.setPreferredSize(new Dimension(0, 30));
			cPanelNPanel.setLayout(new BorderLayout(0, 0));
			cPanelNPanel.add(getLblListOfAvaliable(), BorderLayout.CENTER);
		}
		return cPanelNPanel;
	}

	private JLabel getLblListOfAvaliable() {
		if (lblListOfAvaliable == null) {
			lblListOfAvaliable = new JLabel(Messages.getString("VentanaPrincipal.title-search_label")); //$NON-NLS-1$
			lblListOfAvaliable.setHorizontalAlignment(SwingConstants.CENTER);
			lblListOfAvaliable.setFont(subtitleBold);
		}
		return lblListOfAvaliable;
	}

	private JCheckBox getCkbxAcceptsKids() {
		if (ckbxAcceptsKids == null) {
			ckbxAcceptsKids = new JCheckBox(Messages.getString("VentanaPrincipal.accepts-kids_label")); //$NON-NLS-1$
			ckbxAcceptsKids.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					updateListaCruceros();
					loadCruisesInList();
				}
			});
			ckbxAcceptsKids.setBounds(6, 261, 128, 23);
			ckbxAcceptsKids.setFont(text);
		}
		return ckbxAcceptsKids;
	}

	private JCheckBox getCkbxDiscount() {
		if (ckbxDiscount == null) {
			ckbxDiscount = new JCheckBox(Messages.getString("VentanaPrincipal.discount_label")); //$NON-NLS-1$
			ckbxDiscount.setBounds(6, 296, 128, 23);
			ckbxDiscount.setFont(text);
			ckbxDiscount.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					updateListaCruceros();
					loadCruisesInList();
				}
			});
		}
		return ckbxDiscount;
	}

	private JLabel getLblMoreCriteria() {
		if (lblMoreCriteria == null) {
			lblMoreCriteria = new JLabel(Messages.getString("VentanaPrincipal.more-criteria_label")); //$NON-NLS-1$
			lblMoreCriteria.setBounds(6, 224, 186, 16);
			lblMoreCriteria.setFont(textBold);
		}
		return lblMoreCriteria;
	}

	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBounds(6, 240, 186, 6);
		}
		return separator_1;
	}

	private JPanel getPanel2() {
		if (panel2 == null) {
			panel2 = new JPanel();
			panel2.setBackground(Color.WHITE);
			panel2.setLayout(new BorderLayout(0, 0));
			panel2.add(getPanel2NPanel(), BorderLayout.NORTH);
			panel2.add(getPanel2SPanel(), BorderLayout.SOUTH);
			panel2.add(getPanel2CPanel(), BorderLayout.CENTER);
		}
		return panel2;
	}

	private JLabel getLblSortBy() {
		if (lblSortBy == null) {
			lblSortBy = new JLabel(Messages.getString("VentanaPrincipal.sort-by_label")); //$NON-NLS-1$
			lblSortBy.setFont(textBold);
			lblSortBy.setBounds(6, 384, 186, 16);
		}
		return lblSortBy;
	}

	private JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
			separator_2.setBounds(6, 400, 186, 6);
		}
		return separator_2;
	}

	private JComboBox<String> getComboSort() {
		if (comboSort == null) {
			comboSort = new JComboBox<String>();
			comboSort.setEnabled(true);
			comboSort.setFont(text);
			comboSort.setBounds(6, 412, 186, 27);
			comboSort.addItem(DEFAULT_COMBO_TEXT);
			comboSort.addItem(Messages.getString("VentanaPrincipal.ascending-price_label")); //$NON-NLS-1$
			comboSort.addItem(Messages.getString("VentanaPrincipal.duration_label")); //$NON-NLS-1$
			comboSort.addItem(Messages.getString("VentanaPrincipal.starting-date_label")); //$NON-NLS-1$
			comboSort.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					updateListaCruceros();
					loadCruisesInList();
				}
			});
		}
		return comboSort;
	}

	private JComboBox<String> getComboDuration() {
		if (comboDuration == null) {
			comboDuration = new JComboBox<String>();
			comboDuration.setFont(text);
			comboDuration.setBounds(6, 346, 186, 27);
		}
		return comboDuration;
	}

	private JLabel getLblDuration() {
		if (lblDuration == null) {
			lblDuration = new JLabel(Messages.getString("VentanaPrincipal.duration_label")); //$NON-NLS-1$
			lblDuration.setFont(text);
			lblDuration.setBounds(6, 329, 175, 16);
		}
		return lblDuration;
	}

	private JPanel getPanel2NPanel() {
		if (panel2NPanel == null) {
			panel2NPanel = new JPanel();
			panel2NPanel.setBackground(Color.WHITE);
			panel2NPanel.setLayout(new BorderLayout(0, 0));
			panel2NPanel.add(getPanel2NPanelEPanel(), BorderLayout.EAST);
			panel2NPanel.add(getPanel2NPanelWPanel(), BorderLayout.WEST);
			panel2NPanel.add(getPanel2NPanelNpanel(), BorderLayout.CENTER);
		}
		return panel2NPanel;
	}

	private JPanel getPanel2SPanel() {
		if (panel2SPanel == null) {
			panel2SPanel = new JPanel();
			panel2SPanel.setBackground(Color.WHITE);
			panel2SPanel.setLayout(new BorderLayout(0, 0));
			panel2SPanel.add(getBtnConfirm(), BorderLayout.EAST);
		}
		return panel2SPanel;
	}

	private JPanel getPanel2CPanel() {
		if (panel2CPanel == null) {
			panel2CPanel = new JPanel();
			panel2CPanel.setBackground(Color.WHITE);
			panel2CPanel.setLayout(null);
			panel2CPanel.add(getLblImgShipPanel2());
			panel2CPanel.add(getPnRoom2Panel());
			panel2CPanel.add(getPnRooms2Panel());
			panel2CPanel.add(getLblDescripcion2Panel());
			panel2CPanel.add(getLblDuration2Panel());
			panel2CPanel.add(getLblShipName2Panel());
			panel2CPanel.add(getCmbDate2Panel());
			panel2CPanel.add(getPanel_3());
			panel2CPanel.add(getPnTripStatus());
			panel2CPanel.add(getBtnCheckDate());
		}
		return panel2CPanel;
	}

	private JPanel getPanel2NPanelEPanel() {
		if (panel2NPanelEPanel == null) {
			panel2NPanelEPanel = new JPanel();
			panel2NPanelEPanel.setBackground(Color.WHITE);
			panel2NPanelEPanel.setLayout(new BorderLayout(0, 0));
		}
		return panel2NPanelEPanel;
	}

	private JPanel getPanel2NPanelWPanel() {
		if (panel2NPanelWPanel == null) {
			panel2NPanelWPanel = new JPanel();
			panel2NPanelWPanel.setBackground(Color.WHITE);
			panel2NPanelWPanel.setLayout(new BorderLayout(0, 0));
			panel2NPanelWPanel.add(getBtnNewButton());
		}
		return panel2NPanelWPanel;
	}

	private JPanel getPanel2NPanelNpanel() {
		if (panel2NPanelNpanel == null) {
			panel2NPanelNpanel = new JPanel();
			panel2NPanelNpanel.setBackground(Color.WHITE);
			panel2NPanelNpanel.setLayout(new BorderLayout(0, 0));
		}
		return panel2NPanelNpanel;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton(Messages.getString("VentanaPrincipal.back-to-search_label")); //$NON-NLS-1$
			btnNewButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int opt = JOptionPane.showConfirmDialog(mainPane, Messages.getString("VentanaPrincipal.go-back-search_message"), Messages.getString("VentanaPrincipal.go-back-search_message_title"), JOptionPane.YES_NO_OPTION); //$NON-NLS-1$ //$NON-NLS-2$
					if (opt == 0) {
						deleteCurrentCamarotesFromViaje();
						((CardLayout) getContentPane().getLayout()).show(mainPane, "busqueda_inicio"); //$NON-NLS-1$
					}
				}
			});
		}
		return btnNewButton;
	}
	
	private JLabel getLblImgShipPanel2() {
		if (lblImgShipPanel2 == null) {
			lblImgShipPanel2 = new JLabel("New label"); //$NON-NLS-1$
			lblImgShipPanel2.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblImgShipPanel2.setBounds(6, 6, 170, 179);
		}
		return lblImgShipPanel2;
	}

	private JPanel getPnRoom2Panel() {
		if (pnRoom2Panel == null) {
			pnRoom2Panel = new JPanel();
			pnRoom2Panel.setEnabled(false);
			pnRoom2Panel.setBackground(Color.WHITE);
			pnRoom2Panel.setBorder(new TitledBorder(null, Messages.getString("VentanaPrincipal.configure-the-room_label"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
			pnRoom2Panel.setBounds(6, 197, 1024, 221);
			pnRoom2Panel.setLayout(null);
			pnRoom2Panel.add(getLblTypeOfRoom2Panel());
			pnRoom2Panel.add(getCmbTypeOfRoom2Panl());
			pnRoom2Panel.add(getLblCapacity2Panel());
			pnRoom2Panel.add(getPnPassengers2Panel());
			pnRoom2Panel.add(getPnExtras2Panel());
			pnRoom2Panel.add(getBtnAddRoom());
			pnRoom2Panel.add(getLblPartialPrice());
		}
		return pnRoom2Panel;
	}

	private JPanel getPnRooms2Panel() {
		if (pnRooms2Panel == null) {
			pnRooms2Panel = new JPanel();
			pnRooms2Panel.setEnabled(false);
			pnRooms2Panel.setBorder(new TitledBorder(null, Messages.getString("VentanaPrincipal.your-rooms_label"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
			pnRooms2Panel.setBackground(Color.WHITE);
			pnRooms2Panel.setBounds(6, 430, 1024, 167);
			pnRooms2Panel.setLayout(new BorderLayout(0, 0));
			pnRooms2Panel.add(getScrollPane(), BorderLayout.CENTER);
			pnRooms2Panel.add(getPnButtonsRooms(), BorderLayout.EAST);
		}
		return pnRooms2Panel;
	}

	private JButton getBtnConfirm() {
		if (btnConfirm == null) {
			btnConfirm = new JButton(Messages.getString("VentanaPrincipal.continue-to-summary_label")); //$NON-NLS-1$
			btnConfirm.setHorizontalAlignment(SwingConstants.TRAILING);
			btnConfirm.setEnabled(false);
			btnConfirm.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					load3Panel();
				}
			});
		}
		return btnConfirm;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setEnabled(false);
			scrollPane.setViewportView(getTbRooms());
		}
		return scrollPane;
	}

	private JTable getTbRooms() {
		if (tbRooms == null) {
			initializeModeloTable();
			tbRooms = new JTable(modeloTable);
			tbRooms.setEnabled(false);
			tbRooms.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			tbRooms.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent event) {
					if (tbRooms.getSelectedRow() > -1) {
						getBtnDeleteRoom().setEnabled(true);
						getBtnModifyRoom().setEnabled(true);
					} else {
						getBtnDeleteRoom().setEnabled(false);
						getBtnModifyRoom().setEnabled(false);
					}
				}
			});

			// Header Font & Color
			tbRooms.getTableHeader().setFont(text);
			tbRooms.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbRooms));

			tbRooms.setShowVerticalLines(false);
			tbRooms.getTableHeader().setReorderingAllowed(false);
			tbRooms.getTableHeader().setResizingAllowed(false);
		}
		return tbRooms;
	}

	private JLabel getLblDescripcion2Panel() {
		if (lblDescripcion2Panel == null) {
			lblDescripcion2Panel = new JLabel("New label"); //$NON-NLS-1$
			lblDescripcion2Panel.setBounds(188, 6, 245, 19);
			lblDescripcion2Panel.setFont(textMedium);
		}
		return lblDescripcion2Panel;
	}

	private JLabel getLblDuration2Panel() {
		if (lblDuration2Panel == null) {
			lblDuration2Panel = new JLabel("New label"); //$NON-NLS-1$
			lblDuration2Panel.setBounds(188, 26, 310, 19);
			lblDuration2Panel.setFont(text);
		}
		return lblDuration2Panel;
	}

	private JLabel getLblShipName2Panel() {
		if (lblShipName2Panel == null) {
			lblShipName2Panel = new JLabel("New label"); //$NON-NLS-1$
			lblShipName2Panel.setBounds(188, 47, 310, 19);
			lblShipName2Panel.setFont(text);
		}
		return lblShipName2Panel;
	}

	private JComboBox<String> getCmbDate2Panel() {
		if (cmbDate2Panel == null) {
			cmbDate2Panel = new JComboBox<String>();
			cmbDate2Panel.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(cmbDate2Panel.getSelectedIndex()!=0) {
						cmbDate2Panel.setEnabled(false);
						try {
							checkDate2Panel();
						} catch (ParseException e1) {
							Files.writeLog(log, e1.getMessage());
						}
					}
				}
			});
			cmbDate2Panel.setBounds(188, 82, 154, 28);
			cmbDate2Panel.setFont(text);
		}
		return cmbDate2Panel;
	}

	private JLabel getLblTypeOfRoom2Panel() {
		if (lblTypeOfRoom2Panel == null) {
			lblTypeOfRoom2Panel = new JLabel(Messages.getString("VentanaPrincipal.type-of-room-two-points_label")); //$NON-NLS-1$
			lblTypeOfRoom2Panel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTypeOfRoom2Panel.setBounds(6, 23, 99, 23);
			lblTypeOfRoom2Panel.setFont(text);
		}
		return lblTypeOfRoom2Panel;
	}

	private JComboBox<String> getCmbTypeOfRoom2Panl() {
		if (cmbTypeOfRoom2Panl == null) {
			cmbTypeOfRoom2Panl = new JComboBox<String>();
			cmbTypeOfRoom2Panl.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					updateRoomCapacityLabel();
				}
			});
			cmbTypeOfRoom2Panl.setEnabled(false);
			cmbTypeOfRoom2Panl.setBounds(106, 22, 222, 27);
			cmbTypeOfRoom2Panl.setFont(text);
		}
		return cmbTypeOfRoom2Panl;
	}

	private JLabel getLblCapacity2Panel() {
		if (lblCapacity2Panel == null) {
			lblCapacity2Panel = new JLabel(Messages.getString("VentanaPrincipal.capacity-for_label")); //$NON-NLS-1$
			lblCapacity2Panel.setBounds(340, 23, 652, 23);
			lblCapacity2Panel.setFont(text);
		}
		return lblCapacity2Panel;
	}

	private JPanel getPnPassengers2Panel() {
		if (pnPassengers2Panel == null) {
			pnPassengers2Panel = new JPanel();
			pnPassengers2Panel.setBorder(new TitledBorder(null, Messages.getString("VentanaPrincipal.passengers_label"), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))); //$NON-NLS-1$
			pnPassengers2Panel.setBackground(Color.WHITE);
			pnPassengers2Panel.setBounds(6, 53, 656, 120);
			pnPassengers2Panel.setLayout(new BorderLayout(0, 0));
			pnPassengers2Panel.add(getScPassengers2Panel(), BorderLayout.CENTER);
			pnPassengers2Panel.add(getPnSouthPassengers2Panel(), BorderLayout.EAST);
		}
		return pnPassengers2Panel;
	}

	private JScrollPane getScPassengers2Panel() {
		if (scPassengers2Panel == null) {
			scPassengers2Panel = new JScrollPane();
			scPassengers2Panel.setViewportView(getLstPassengers2Panel());
		}
		return scPassengers2Panel;
	}

	private JList<Pasajero> getLstPassengers2Panel() {
		if (lstPassengers2Panel == null) {
			lstPassengers2Panel = new JList<Pasajero>(getModelPasajeros());
			lstPassengers2Panel.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (lstPassengers2Panel.getSelectedIndex() > -1) {
						getBtnDeletePassanger().setEnabled(true);
						getBtnModifyPassenger().setEnabled(true);
					} else {
						getBtnDeletePassanger().setEnabled(false);
						getBtnModifyPassenger().setEnabled(false);
					}
				}
			});
			lstPassengers2Panel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			lstPassengers2Panel.setFont(text);
		}
		return lstPassengers2Panel;
	}

	private JPanel getPnSouthPassengers2Panel() {
		if (pnSouthPassengers2Panel == null) {
			pnSouthPassengers2Panel = new JPanel();
			pnSouthPassengers2Panel.setBackground(Color.WHITE);
			pnSouthPassengers2Panel.setLayout(new GridLayout(4, 1, 0, 0));
			pnSouthPassengers2Panel.add(getBtnAddPassanger());
			pnSouthPassengers2Panel.add(getBtnDeletePassanger());
			pnSouthPassengers2Panel.add(getBtnModifyPassenger());
		}
		return pnSouthPassengers2Panel;
	}

	private JButton getBtnAddPassanger() {
		if (btnAddPassanger == null) {
			btnAddPassanger = new JButton(Messages.getString("VentanaPrincipal.add-passenger_label")); //$NON-NLS-1$
			btnAddPassanger.setEnabled(false);
			btnAddPassanger.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Pasajero pasajero = null;
					int size = 0;
					size = getPeopleInCabin();
					int people = getLstPassengers2Panel().getModel().getSize();
					if (people < size) {
						pasajero = addPasajero();
					} else if (people == size && hasKids()) {
						int opt = JOptionPane.showConfirmDialog(mainPane, Messages.getString("VentanaPrincipal.extra-bed-kid_message"), Messages.getString("VentanaPrincipal.extra-bed-kid_message_title"), JOptionPane.YES_NO_OPTION); //$NON-NLS-1$ //$NON-NLS-2$
						if (opt == 0) {
							pasajero = addPasajero();
							if (pasajero != null)
								getChckbxAddExtraBed().setSelected(true);
						}
					} else if (people == size && !hasKids()) {
						int opt = JOptionPane.showConfirmDialog(mainPane, Messages.getString("VentanaPrincipal.extra-bed_message"), Messages.getString("VentanaPrincipal.extra-bed_message_title"), JOptionPane.YES_NO_OPTION); //$NON-NLS-1$ //$NON-NLS-2$
						if (opt == 0) {
							pasajero = addKid();
							if (pasajero != null)
								getChckbxAddExtraBed().setSelected(true);
						}
					}
					if (pasajero != null) {
						if(pasajero.isChild() && !currentReserva.getCrucero().getAcceptUnder16())
							JOptionPane.showMessageDialog(mainPane, Messages.getString("VentanaPrincipal.cruise-not-under16_message"), Messages.getString("VentanaPrincipal.cruise-not-under16_message_title"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
						else
							getModelPasajeros().addElement(pasajero);
					}
					
					// Checking the AddRoom button.
					if (getLstPassengers2Panel().getModel().getSize() > 0) {
						getBtnAddRoom().setEnabled(true);
					} else {
						getBtnAddRoom().setEnabled(false);
					}
					checkAddPasajero();
					checkExtraBed(size);
					extrasCheck();
					checkAddRoomBtn();
				}
			});
			btnAddPassanger.setFont(text);
		}
		return btnAddPassanger;
	}

	private JButton getBtnDeletePassanger() {
		if (btnDeletePassanger == null) {
			btnDeletePassanger = new JButton(Messages.getString("VentanaPrincipal.delete-passenger_label")); //$NON-NLS-1$
			btnDeletePassanger.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// Yes = 0; No = 1
					int opt = JOptionPane.showConfirmDialog(mainPane, Messages.getString("VentanaPrincipal.delete-passenger_message"), Messages.getString("VentanaPrincipal.delete-passenger_message_title"), JOptionPane.YES_NO_OPTION); //$NON-NLS-1$ //$NON-NLS-2$
					if (opt == 0) {
						getModelPasajeros().remove(getLstPassengers2Panel().getSelectedIndex());
					}
					checkExtraBed(getPeopleInCabin());
					checkAddRoomBtn();
					checkAddPasajero();
					extrasCheck();
				}
			});
			btnDeletePassanger.setEnabled(false);
			btnDeletePassanger.setFont(text);
		}
		return btnDeletePassanger;
	}

	private JButton getBtnModifyPassenger() {
		if (btnModifyPassenger == null) {
			btnModifyPassenger = new JButton(Messages.getString("VentanaPrincipal.modify_label")); //$NON-NLS-1$
			btnModifyPassenger.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int oldAge = getLstPassengers2Panel().getSelectedValue().getAge();
					if (getLstPassengers2Panel().getSelectedIndex() > -1) {
						String input = JOptionPane.showInputDialog(mainPane, Messages.getString("VentanaPrincipal.change-age_message"), getLstPassengers2Panel().getSelectedValue().getAge()); //$NON-NLS-1$
						int age = -1;
						if (input != null)
							try {
								age = Integer.parseInt(input);
							} catch (NumberFormatException e1) {
								Files.writeLog(log, e1.getMessage());
							}
						while ((age < 0 || age > 150) && input != null) {
							input = JOptionPane.showInputDialog(mainPane, Messages.getString("VentanaPrincipal.change-age_message"), getLstPassengers2Panel().getSelectedValue().getAge()); //$NON-NLS-1$
							if (input != null) {
								try {
									age = Integer.parseInt(input);
								} catch (NumberFormatException e1) {
									Files.writeLog(log, e1.getMessage());
								}
							}
						}
						if (age > 0) {
							getLstPassengers2Panel().getSelectedValue().setAge(age);
							if (getChckbxAddExtraBed().isSelected() && !hasKids()) {
								JOptionPane.showMessageDialog(mainPane, Messages.getString("VentanaPrincipal.change-not-possible_message")); //$NON-NLS-1$
								getLstPassengers2Panel().getSelectedValue().setAge(oldAge);
							} else if(age<16 && !currentReserva.getCrucero().getAcceptUnder16()) {
								JOptionPane.showMessageDialog(mainPane, Messages.getString("VentanaPrincipal.cruise-not-under16_message"), Messages.getString("VentanaPrincipal.cruise-not-under16_message_title"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
								getLstPassengers2Panel().getSelectedValue().setAge(oldAge);
							}
						}
					}
					checkAddRoomBtn();
					extrasCheck();
					checkExtraBed(getPeopleInCabin());
					checkAddPasajero();
				}
			});
			btnModifyPassenger.setEnabled(false);
			btnModifyPassenger.setFont(text);
		}
		return btnModifyPassenger;
	}

	private JCheckBox getChckbxAddExtraBed() {
		if (chckbxAddExtraBed == null) {
			chckbxAddExtraBed = new JCheckBox(Messages.getString("VentanaPrincipal.add-extra-bed_label")); //$NON-NLS-1$
			chckbxAddExtraBed.setEnabled(false);
			chckbxAddExtraBed.setFont(text);
		}
		return chckbxAddExtraBed;
	}

	private JCheckBox getChckbxJacuzzi() {
		if (chckbxJacuzzi == null) {
			chckbxJacuzzi = new JCheckBox(Messages.getString("VentanaPrincipal.jacuzzy_label")); //$NON-NLS-1$
			chckbxJacuzzi.setEnabled(false);
			chckbxJacuzzi.setFont(text);
		}
		return chckbxJacuzzi;
	}

	private JCheckBox getChckbxSpecialBreakfast() {
		if (chckbxSpecialBreakfast == null) {
			chckbxSpecialBreakfast = new JCheckBox(Messages.getString("VentanaPrincipal.special-breakfast_label")); //$NON-NLS-1$
			chckbxSpecialBreakfast.setEnabled(false);
			chckbxSpecialBreakfast.setFont(text);
		}
		return chckbxSpecialBreakfast;
	}

	private JCheckBox getChckbxExtrabigBed() {
		if (chckbxExtrabigBed == null) {
			chckbxExtrabigBed = new JCheckBox(Messages.getString("VentanaPrincipal.extra-big-bed_label")); //$NON-NLS-1$
			chckbxExtrabigBed.setEnabled(false);
			chckbxExtrabigBed.setFont(text);
		}
		return chckbxExtrabigBed;
	}

	private JPanel getPnExtras2Panel() {
		if (pnExtras2Panel == null) {
			pnExtras2Panel = new JPanel();
			pnExtras2Panel.setBorder(new TitledBorder(null, Messages.getString("VentanaPrincipal.extras_label"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
			pnExtras2Panel.setBackground(Color.WHITE);
			pnExtras2Panel.setBounds(674, 53, 318, 120);
			pnExtras2Panel.setLayout(new GridLayout(2, 2, 0, 0));
			pnExtras2Panel.add(getChckbxAddExtraBed());
			pnExtras2Panel.add(getChckbxJacuzzi());
			pnExtras2Panel.add(getChckbxSpecialBreakfast());
			pnExtras2Panel.add(getChckbxExtrabigBed());
		}
		return pnExtras2Panel;
	}

	private JButton getBtnAddRoom() {
		if (btnAddRoob == null) {
			btnAddRoob = new JButton(Messages.getString("VentanaPrincipal.add-room_label")); //$NON-NLS-1$
			btnAddRoob.setEnabled(false);
			btnAddRoob.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					loadRoomOnToTable();
					updateCapacityLabels();
					resetConfigureRoomPanel();
					getCmbDate2Panel().setEnabled(false);
					checkIfIsThereRooms();
					checkYourRoomsPane();
					if (tbRooms.getRowCount() > 0) {
						getBtnConfirm().setEnabled(true);
					}
					checkAddRoomBtn();
					getPnRoom2Panel().setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY), Messages.getString("VentanaPrincipal.configure-your-room_label"))); //$NON-NLS-1$
					btnAddRoob.setText(Messages.getString("VentanaPrincipal.add-room_label")); //$NON-NLS-1$
				}
			});
			btnAddRoob.setBounds(871, 186, 117, 29);
			btnAddRoob.setFont(text);
		}
		return btnAddRoob;
	}
	
	private DefaultListModel<Pasajero> getModelPasajeros() {
		if (modelPasajeros == null)
			modelPasajeros = new DefaultListModel<Pasajero>();
		return modelPasajeros;
	}

	private JPanel getPnButtonsRooms() {
		if (pnButtonsRooms == null) {
			pnButtonsRooms = new JPanel();
			pnButtonsRooms.setBackground(Color.WHITE);
			pnButtonsRooms.setLayout(new GridLayout(6, 0, 0, 0));
			pnButtonsRooms.add(getBtnDeleteRoom());
			pnButtonsRooms.add(getBtnModifyRoom());
		}
		return pnButtonsRooms;
	}

	private JButton getBtnDeleteRoom() {
		if (btnDeleteRoom == null) {
			btnDeleteRoom = new JButton(Messages.getString("VentanaPrincipal.delete-room_label")); //$NON-NLS-1$
			btnDeleteRoom.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int opt = JOptionPane.showConfirmDialog(mainPane, Messages.getString("VentanaPrincipal.delete-room_message"), Messages.getString("VentanaPrincipal.delete-room_message_title"), JOptionPane.YES_NO_OPTION); //$NON-NLS-1$ //$NON-NLS-2$
					if (opt == 0 && getTbRooms().getSelectedRow() > -1) {
						Camarote toDetele = getModeloNoEditable().getCamaroteAtRow(getTbRooms().getSelectedRow());
						getModeloNoEditable().removeRow(toDetele);
						currentViaje.setCamaroteAsFree(toDetele);
						if (getTbRooms().getModel().getRowCount() < 1)
							getBtnConfirm().setEnabled(false);
					}
					updateCapacityLabels();
					checkYourRoomsPane();
				}
			});
			btnDeleteRoom.setEnabled(false);
		}
		return btnDeleteRoom;
	}

	private JLabel getLblPartialPrice() {
		if (lblPartialPrice == null) {
			lblPartialPrice = new JLabel("New label"); //$NON-NLS-1$
			lblPartialPrice.setBounds(642, 185, 217, 24);
		}
		return lblPartialPrice;
	}

	private JPanel getPanel3() {
		if (panel3 == null) {
			panel3 = new JPanel();
			panel3.setBackground(Color.WHITE);
			panel3.setLayout(new BorderLayout(0, 0));
			panel3.add(getPnNpn3(), BorderLayout.NORTH);
			panel3.add(getPnSpn3(), BorderLayout.SOUTH);
			panel3.add(getPnCpn3(), BorderLayout.CENTER);
		}
		return panel3;
	}

	private JPanel getPnNpn3() {
		if (pnNpn3 == null) {
			pnNpn3 = new JPanel();
			pnNpn3.setBackground(Color.WHITE);
			pnNpn3.setLayout(new BorderLayout(0, 0));
			pnNpn3.add(getBtnNewButton_1(), BorderLayout.WEST);
		}
		return pnNpn3;
	}

	private JPanel getPnSpn3() {
		if (pnSpn3 == null) {
			pnSpn3 = new JPanel();
			pnSpn3.setBackground(Color.WHITE);
			pnSpn3.setLayout(new BorderLayout(0, 0));
			pnSpn3.add(getBtnConfirmAndPay(), BorderLayout.EAST);
		}
		return pnSpn3;
	}

	private JPanel getPnCpn3() {
		if (pnCpn3 == null) {
			pnCpn3 = new JPanel();
			pnCpn3.setBackground(Color.WHITE);
			pnCpn3.setLayout(null);
			pnCpn3.add(getLblSummary());
			pnCpn3.add(getPnTableSummary());
			pnCpn3.add(getPanel());
			pnCpn3.add(getLblDescriptionAndDate());
			pnCpn3.add(getLblTotalRooms());
			pnCpn3.add(getLblTotalExtras());
			pnCpn3.add(getLblTotalPrice());
		}
		return pnCpn3;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton(Messages.getString("VentanaPrincipal.go-back_label")); //$NON-NLS-1$
			btnNewButton_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					((CardLayout) getContentPane().getLayout()).show(mainPane, "info_crucero"); //$NON-NLS-1$
				}
			});
		}
		return btnNewButton_1;
	}

	private JButton getBtnConfirmAndPay() {
		if (btnConfirmAndPay == null) {
			btnConfirmAndPay = new JButton(Messages.getString("VentanaPrincipal.confirm-and-pay_label")); //$NON-NLS-1$
			btnConfirmAndPay.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					currentReserva.setCamarotes(getModeloNoEditable().getCamarotes());
					currentReserva.setName(getTxtName().getText());
					currentReserva.setSurname(getTxtSurname().getText());
					try {
						currentReserva.setTelf(Integer.parseInt(getTxtPhone().getText()));
					} catch (Exception e2) {
						getTxtPhone().setBorder(new LineBorder(Color.RED));
					}
					try {
						currentReserva.setDNI(getTxtDNI().getText());
						Files.writeFileFromString(CargarDatos.PATH_OUT, currentReserva.getDNI(), currentReserva.toString(), ".txt", "UTF-8"); //$NON-NLS-1$ //$NON-NLS-2$
						loadFourthPanel();
						((CardLayout) getContentPane().getLayout()).show(mainPane, "receipt"); //$NON-NLS-1$
					} catch (IllegalArgumentException | FileNotFoundException | UnsupportedEncodingException e1) {
						JOptionPane.showMessageDialog(mainPane, Messages.getString("VentanaPrincipal.valid-nif_message")); //$NON-NLS-1$
					}
				}
			});
		}
		return btnConfirmAndPay;
	}

	private JLabel getLblSummary() {
		if (lblSummary == null) {
			lblSummary = new JLabel(Messages.getString("VentanaPrincipal.summary_label")); //$NON-NLS-1$
			lblSummary.setBounds(6, 6, 158, 34);
			lblSummary.setFont(subtitleBold);
		}
		return lblSummary;
	}

	private JPanel getPnTableSummary() {
		if (pnTableSummary == null) {
			pnTableSummary = new JPanel();
			pnTableSummary.setBackground(Color.WHITE);
			pnTableSummary.setBounds(6, 44, 1024, 260);
			pnTableSummary.setLayout(new BorderLayout(0, 0));
			pnTableSummary.add(getScPaneTableSummary(), BorderLayout.CENTER);
		}
		return pnTableSummary;
	}

	private JScrollPane getScPaneTableSummary() {
		if (scPaneTableSummary == null) {
			scPaneTableSummary = new JScrollPane();
			scPaneTableSummary.setViewportView(getTbSummary());
		}
		return scPaneTableSummary;
	}

	private JTable getTbSummary() {
		if (tbSummary == null) {
			tbSummary = new JTable(modeloTable);
			tbSummary.setFocusable(false);
			tbSummary.setShowVerticalLines(false);
			tbSummary.setShowGrid(false);
			tbSummary.setRowSelectionAllowed(false);
			tbSummary.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return tbSummary;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), Messages.getString("VentanaPrincipal.personal-payment-info_label"), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))); //$NON-NLS-1$
			panel.setBackground(Color.WHITE);
			panel.setBounds(6, 408, 1024, 198);
			panel.setLayout(null);
			panel.add(getLblName());
			panel.add(getTxtName());
			panel.add(getLblSurname());
			panel.add(getTxtSurname());
			panel.add(getLblDni());
			panel.add(getTxtDNI());
			panel.add(getLblPhone());
			panel.add(getTxtPhone());
		}
		return panel;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel(Messages.getString("VentanaPrincipal.name_label")); //$NON-NLS-1$
			lblName.setHorizontalAlignment(SwingConstants.RIGHT);
			lblName.setBounds(6, 25, 67, 22);
		}
		return lblName;
	}

	private JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setBounds(85, 23, 130, 26);
			txtName.setColumns(10);
		}
		return txtName;
	}

	private JLabel getLblSurname() {
		if (lblSurname == null) {
			lblSurname = new JLabel(Messages.getString("VentanaPrincipal.surname_label")); //$NON-NLS-1$
			lblSurname.setHorizontalAlignment(SwingConstants.RIGHT);
			lblSurname.setBounds(248, 25, 86, 22);
		}
		return lblSurname;
	}

	private JTextField getTxtSurname() {
		if (txtSurname == null) {
			txtSurname = new JTextField();
			txtSurname.setColumns(10);
			txtSurname.setBounds(346, 23, 203, 26);
		}
		return txtSurname;
	}

	private JLabel getLblDescriptionAndDate() {
		if (lblDescriptionAndDate == null) {
			lblDescriptionAndDate = new JLabel(Messages.getString("VentanaPrincipal.summary_label")); //$NON-NLS-1$
			lblDescriptionAndDate.setFont(textMedium);
			lblDescriptionAndDate.setBounds(176, 6, 854, 34);
		}
		return lblDescriptionAndDate;
	}

	private JLabel getLblDni() {
		if (lblDni == null) {
			lblDni = new JLabel(Messages.getString("VentanaPrincipal.dni_label")); //$NON-NLS-1$
			lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDni.setBounds(6, 59, 67, 22);
		}
		return lblDni;
	}

	private JTextField getTxtDNI() {
		if (txtDNI == null) {
			txtDNI = new JTextField();
			txtDNI.setColumns(10);
			txtDNI.setBounds(85, 57, 130, 26);
		}
		return txtDNI;
	}

	private JLabel getLblPhone() {
		if (lblPhone == null) {
			lblPhone = new JLabel(Messages.getString("VentanaPrincipal.phone_label")); //$NON-NLS-1$
			lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPhone.setBounds(248, 62, 86, 22);
		}
		return lblPhone;
	}

	private JTextField getTxtPhone() {
		if (txtPhone == null) {
			txtPhone = new JTextField();
			txtPhone.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (c < '0' || c > '9')
						e.consume();
				}
			});
			txtPhone.setColumns(10);
			txtPhone.setBounds(346, 57, 203, 26);
		}
		return txtPhone;
	}
	private JPanel getPanel4() {
		if (panel4 == null) {
			panel4 = new JPanel();
			panel4.setBackground(Color.WHITE);
			panel4.setLayout(new BorderLayout(0, 0));
			panel4.add(getPnCpn4(), BorderLayout.CENTER);
		}
		return panel4;
	}

	private JPanel getPnCpn4() {
		if (pnCpn4 == null) {
			pnCpn4 = new JPanel();
			pnCpn4.setBackground(Color.WHITE);
			pnCpn4.setLayout(new BorderLayout(0, 0));
			pnCpn4.add(getPanel_1(), BorderLayout.NORTH);
			pnCpn4.add(getPanel_2(), BorderLayout.CENTER);
		}
		return pnCpn4;
	}

	private JTextArea getTxtReceipt() {
		if (txtReceipt == null) {
			txtReceipt = new JTextArea();
			txtReceipt.setMargin(new Insets(0, 15, 0, 0));
			txtReceipt.setBorder(new TitledBorder(null, Messages.getString("VentanaPrincipal.purchase-receipt_label"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
			txtReceipt.setBounds(107, 59, 715, 449);
			txtReceipt.setLineWrap(true);
			txtReceipt.setEditable(false);
			txtReceipt.setFont(textMedium);
		}
		return txtReceipt;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			panel_1.setLayout(new BorderLayout(0, 0));
			panel_1.add(getLblReceiptTitle(), BorderLayout.CENTER);
		}
		return panel_1;
	}

	private JLabel getLblReceiptTitle() {
		if (lblReceiptTitle == null) {
			lblReceiptTitle = new JLabel(Messages.getString("VentanaPrincipal.purchase-receipt_label")); //$NON-NLS-1$
			lblReceiptTitle.setFont(subtitleBold);
		}
		return lblReceiptTitle;
	}

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(Color.WHITE);
			panel_2.setLayout(null);
			panel_2.add(getTxtReceipt());
			panel_2.add(getBtnGoToInicio());
		}
		return panel_2;
	}

	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(null, Messages.getString("VentanaPrincipal.description-cruise_label"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
			panel_3.setBackground(Color.WHITE);
			panel_3.setBounds(432, 6, 354, 179);
			panel_3.setLayout(new BorderLayout(0, 0));
			panel_3.add(getScrollPane_1(), BorderLayout.CENTER);
		}
		return panel_3;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBorder(null);
			scrollPane_1.setViewportView(getTxtrTxtdescriptionlong());
		}
		return scrollPane_1;
	}

	private JTextArea getTxtrTxtdescriptionlong() {
		if (txtrTxtdescriptionlong == null) {
			txtrTxtdescriptionlong = new JTextArea();
			txtrTxtdescriptionlong.setBorder(null);
			txtrTxtdescriptionlong.setLineWrap(true);
			txtrTxtdescriptionlong.setEditable(false);
			txtrTxtdescriptionlong.setText("txtDescriptionLong"); //$NON-NLS-1$
			txtrTxtdescriptionlong.setFont(text);
		}
		return txtrTxtdescriptionlong;
	}

	private JPanel getPnTripStatus() {
		if (pnTripStatus == null) {
			pnTripStatus = new JPanel();
			pnTripStatus.setBorder(new TitledBorder(null, Messages.getString("VentanaPrincipal.cruise-status_label"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
			pnTripStatus.setBackground(Color.WHITE);
			pnTripStatus.setEnabled(false);
			pnTripStatus.setBounds(797, 6, 233, 179);
			pnTripStatus.setLayout(new BorderLayout(0, 0));
			pnTripStatus.add(getPnCapacities(), BorderLayout.CENTER);
		}
		return pnTripStatus;
	}

	private JPanel getPnCapacities() {
		if (pnCapacities == null) {
			pnCapacities = new JPanel();
			pnCapacities.setBorder(null);
			pnCapacities.setBackground(Color.WHITE);
			pnCapacities.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnCapacities.add(getLblFreeDoubleInterior());
			pnCapacities.add(getLblFreeDoubleExterior());
			pnCapacities.add(getLblFreeFamiliarInterior());
			pnCapacities.add(getLblFreeFamiliarExterior());
			pnCapacities.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { getLblFreeDoubleExterior(), getLblFreeDoubleInterior(), getLblFreeFamiliarExterior(), getLblFreeFamiliarInterior() }));
		}
		return pnCapacities;
	}

	private JLabel getLblFreeDoubleInterior() {
		if (lblFreeDoubleInterior == null) {
			lblFreeDoubleInterior = new JLabel(Messages.getString("VentanaPrincipal.free-double-interior_label")); //$NON-NLS-1$
			lblFreeDoubleInterior.setFont(text);
		}
		return lblFreeDoubleInterior;
	}

	private JLabel getLblFreeDoubleExterior() {
		if (lblFreeDoubleExterior == null) {
			lblFreeDoubleExterior = new JLabel(Messages.getString("VentanaPrincipal.free-double-exterior_label")); //$NON-NLS-1$
			lblFreeDoubleExterior.setFont(text);
		}
		return lblFreeDoubleExterior;
	}

	private JLabel getLblFreeFamiliarInterior() {
		if (lblFreeFamiliarInterior == null) {
			lblFreeFamiliarInterior = new JLabel(Messages.getString("VentanaPrincipal.free-familiar-interior_label")); //$NON-NLS-1$
			lblFreeFamiliarInterior.setFont(text);
		}
		return lblFreeFamiliarInterior;
	}

	private JLabel getLblFreeFamiliarExterior() {
		if (lblFreeFamiliarExterior == null) {
			lblFreeFamiliarExterior = new JLabel(Messages.getString("VentanaPrincipal.free-familiar-exterior_label")); //$NON-NLS-1$
			lblFreeFamiliarExterior.setFont(text);
		}
		return lblFreeFamiliarExterior;
	}

	private JButton getBtnGoToInicio() {
		if (btnGoToInicio == null) {
			btnGoToInicio = new JButton(Messages.getString("VentanaPrincipal.start-app_label")); //$NON-NLS-1$
			btnGoToInicio.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					resetMainWindow();
					((CardLayout) getContentPane().getLayout()).show(mainPane, "busqueda_inicio"); //$NON-NLS-1$
				}
			});
			btnGoToInicio.setBounds(465, 551, 117, 29);
		}
		return btnGoToInicio;
	}
	private JButton getBtnCheckDate() {
		if (btnCheckDate == null) {
			btnCheckDate = new JButton(Messages.getString("VentanaPrincipal.change-date_label")); //$NON-NLS-1$
			btnCheckDate.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					boolean aux = getModeloNoEditable().getRowCount() == 0;
					try {
						int opt = -1;
						if (!aux) {
							opt = JOptionPane.showConfirmDialog(mainPane, Messages.getString("VentanaPrincipal.change-date_message"), Messages.getString("VentanaPrincipal.change-dage_message_title"), JOptionPane.CANCEL_OPTION); //$NON-NLS-1$ //$NON-NLS-2$
							if (opt == 0) {
								getCmbDate2Panel().setEnabled(true);
								deleteCurrentCamarotesFromViaje();
								resetListaPasajeros();
								checkDate2Panel();
							} else {
							}
						} else {
							getCmbDate2Panel().setEnabled(true);
							checkDate2Panel();
						}
					} catch (ParseException e1) {
						Files.writeLog(log, e1.getMessage());
					}
				}
			});
			btnCheckDate.setBounds(188, 111, 154, 29);
		}
		return btnCheckDate;
	}

	private JLabel getLblTotalRooms() {
		if (lblTotalRooms == null) {
			lblTotalRooms = new JLabel("New label"); //$NON-NLS-1$
			lblTotalRooms.setHorizontalAlignment(SwingConstants.TRAILING);
			lblTotalRooms.setBounds(761, 316, 269, 23);
		}
		return lblTotalRooms;
	}
	private JLabel getLblTotalExtras() {
		if (lblTotalExtras == null) {
			lblTotalExtras = new JLabel("New label"); //$NON-NLS-1$
			lblTotalExtras.setHorizontalAlignment(SwingConstants.TRAILING);
			lblTotalExtras.setBounds(761, 345, 269, 23);
		}
		return lblTotalExtras;
	}
	private JLabel getLblTotalPrice() {
		if (lblTotalPrice == null) {
			lblTotalPrice = new JLabel("New label"); //$NON-NLS-1$
			lblTotalPrice.setHorizontalAlignment(SwingConstants.TRAILING);
			lblTotalPrice.setBounds(761, 380, 269, 23);
		}
		return lblTotalPrice;
	}
	private JButton getBtnModifyRoom() {
		if (btnModifyRoom == null) {
			btnModifyRoom = new JButton(Messages.getString("VentanaPrincipal.modify-room_label")); //$NON-NLS-1$
			btnModifyRoom.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					getPnRoom2Panel().setBorder(new TitledBorder(new LineBorder(Color.RED), Messages.getString("VentanaPrincipal.modify-your-room_label"))); //$NON-NLS-1$
					getBtnAddRoom().setText(Messages.getString("VentanaPrincipal.modify-the-room_label")); //$NON-NLS-1$
					Camarote c;
					int row = getTbRooms().getSelectedRow();
					if(row!=-1) {
						c = getModeloNoEditable().getCamaroteAtRow(getTbRooms().getSelectedRow()).copy();
						currentViaje.setCamaroteAsFree(getModeloNoEditable().getCamaroteAtRow(getTbRooms().getSelectedRow()));
						checkIfIsThereRooms();
						updateCapacityLabels();
						getModeloNoEditable().removeRow(getModeloNoEditable().getCamaroteAtRow(getTbRooms().getSelectedRow()));
						
						if (c instanceof CamaroteFamiliarInterior) {
							getCmbTypeOfRoom2Panl().setSelectedItem(Messages.getString("VentanaPrincipal.familiar-interior_label")); //$NON-NLS-1$
						} else if (c instanceof CamaroteFamiliarExterior) {
							getCmbTypeOfRoom2Panl().setSelectedItem(Messages.getString("VentanaPrincipal.familiar-exterior_label")); //$NON-NLS-1$
						} else if (c instanceof CamaroteDobleInterior) {
							getCmbTypeOfRoom2Panl().setSelectedItem(Messages.getString("VentanaPrincipal.double-interior_label")); //$NON-NLS-1$
						} else if (c instanceof CamaroteDobleExterior) {
							getCmbTypeOfRoom2Panl().setSelectedItem(Messages.getString("VentanaPrincipal.double-exterior_label")); //$NON-NLS-1$
						}
						modelPasajeros.removeAllElements();
						for(Pasajero p : c.getPasajeros()) {
							modelPasajeros.addElement(p);
						}
						for(Extra ext : c.getExtras()) {
							if(ext.getExtra().equals("Cama supletoria")) //$NON-NLS-1$
								getChckbxAddExtraBed().setSelected(true);
							if(ext.getExtra().equals("Desayuno especial")) //$NON-NLS-1$
								getChckbxSpecialBreakfast().setSelected(true);
							if(ext.getExtra().equals("Cama extragrande")) //$NON-NLS-1$
								getChckbxExtrabigBed().setSelected(true);
							if(ext.getExtra().equals("Jacuzzi")) //$NON-NLS-1$
								getChckbxJacuzzi().setSelected(true);
						}
						checkExtraBed(getPeopleInCabin());
						extrasCheck();
					}
				}
			});
			btnModifyRoom.setEnabled(false);
		}
		return btnModifyRoom;
	}
	
	// BEGIN CORE METHODS
	
	private void updateListaCruceros() {
		listaDeCruceros = new ArrayList<Crucero>();
		listaDeCruceros = Cruceros.getCruceros();
		if (getComboDestino().getSelectedItem() != DEFAULT_COMBO_TEXT && getComboDestino().getSelectedItem() != null) {
			listaDeCruceros = CollectionsCPM.filter(new FilterByArea(), listaDeCruceros, getComboDestino().getSelectedItem().toString());
		}
		if (getComboStartingDate().getSelectedItem() != DEFAULT_COMBO_TEXT && getComboStartingDate().getSelectedItem() != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(CargarDatos.DATE_FORMAT_LONG);
			try {
				listaDeCruceros = CollectionsCPM.filter(new FilterByStartingDate(), listaDeCruceros, sdf.parse(getComboStartingDate().getSelectedItem().toString()));
			} catch (ParseException e) {
				Files.writeLog(log, e.getMessage());
			}
		}
		if (getComboStartingPort().getSelectedItem() != DEFAULT_COMBO_TEXT && getComboStartingPort().getSelectedItem() != null) {
			listaDeCruceros = CollectionsCPM.filter(new FilterByStartingPort(), listaDeCruceros, getComboStartingPort().getSelectedItem().toString());
		}
		if (getCkbxAcceptsKids().isSelected()) {
			listaDeCruceros = CollectionsCPM.filter(new FilterByChild(), listaDeCruceros, getCkbxAcceptsKids().isSelected());
		}
		if (getCkbxDiscount().isSelected()) {
			listaDeCruceros = CollectionsCPM.filter(new FilterByDiscount(), listaDeCruceros, getCkbxDiscount().isSelected());
		}
		if (getComboSort().getSelectedItem() != DEFAULT_COMBO_TEXT && getComboSort().getSelectedItem() != null) {
			if (getComboSort().getSelectedItem().toString().equals(Messages.getString("VentanaPrincipal.ascending-price_label"))) //$NON-NLS-1$
				listaDeCruceros = CollectionsCPM.sort(listaDeCruceros, new CompareByPrice());
			else if (getComboSort().getSelectedItem().toString().equals(Messages.getString("VentanaPrincipal.duration_label"))) //$NON-NLS-1$
				listaDeCruceros = CollectionsCPM.sort(listaDeCruceros, new CompareByDuration());
			else if (getComboSort().getSelectedItem().toString().equals(Messages.getString("VentanaPrincipal.starting-date-comparator_label"))) //$NON-NLS-1$
				listaDeCruceros = CollectionsCPM.sort(listaDeCruceros, new CompareByStartingdate());
		}
		if (listaDeCruceros.isEmpty()) {
			JOptionPane.showMessageDialog(this, Messages.getString("VentanaPrincipal.no-creuises-avaliable_message")); //$NON-NLS-1$
			getComboDestino().setSelectedItem(DEFAULT_COMBO_TEXT);
		}
	}
	
	private void initializeModels() {
		SimpleDateFormat sdf = new SimpleDateFormat(CargarDatos.DATE_FORMAT_LONG);
		listaDeCruceros = Cruceros.getCruceros();

		modelDestination.removeAllElements();
		modelDate.removeAllElements();
		modelStartingPort.removeAllElements();
		modelDestination.insertElementAt(VentanaPrincipal.DEFAULT_COMBO_TEXT, 0);
		modelDate.insertElementAt(VentanaPrincipal.DEFAULT_COMBO_TEXT, 0);
		modelStartingPort.insertElementAt(VentanaPrincipal.DEFAULT_COMBO_TEXT, 0);

		for (Crucero c : listaDeCruceros) {
			if (modelDestination.getIndexOf(c.getArea()) == -1)
				modelDestination.addElement(c.getArea());
			for (Date d : c.getSalidas()) {
				if (modelDate.getIndexOf(sdf.format(d)) == -1)
					modelDate.addElement(sdf.format(d));
			}
			if (modelStartingPort.getIndexOf(c.getStartPort()) == -1)
				modelStartingPort.addElement(c.getStartPort());
		}
	}

	private void updateDateModel() {
		List<Crucero> toRemove = CollectionsCPM.getDiference(Cruceros.getCruceros(), listaDeCruceros);
		Object oldDate = getComboStartingDate().getSelectedItem();
		SimpleDateFormat sdf = new SimpleDateFormat(CargarDatos.DATE_FORMAT_LONG);
		for (Crucero c : toRemove)
			for (Date d : c.getSalidas())
				modelDate.removeElement(sdf.format(d));

		for (Crucero c : listaDeCruceros)
			for (Date d : c.getSalidas())
				if (modelDate.getIndexOf(sdf.format(d)) == -1)
					modelDate.addElement(sdf.format(d));
		if (modelDate.getIndexOf(oldDate) != -1)
			getComboStartingDate().setSelectedItem(oldDate);
	}

	private void updateStartingPortModel() {
		List<Crucero> toRemove = CollectionsCPM.getDiference(Cruceros.getCruceros(), listaDeCruceros);
		Object oldPort = getComboStartingPort().getSelectedItem();
		for (Crucero c : toRemove)
			modelStartingPort.removeElement(c.getStartPort());
		for (Crucero c : listaDeCruceros)
			if (modelStartingPort.getIndexOf(c.getStartPort()) == -1)
				modelStartingPort.addElement(c.getStartPort());
		if (modelStartingPort.getIndexOf(oldPort) != -1)
			getComboStartingPort().setSelectedItem(oldPort);
	}

	private void loadCruisesInList() {
		Container cont = new Container();
		for (Crucero c : listaDeCruceros) {
			CruceroListPanel aux = new CruceroListPanel(c);
			aux.getBtnSelect().setActionCommand(c.getCodigoCrucero());
			aux.getBtnSelect().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					loadSecondPane(c);
					setCurrentShip(c);
				}
			});
			aux.setPreferredSize(new Dimension(getScSearch().getWidth(), 233));
			cont.add(aux);
		}
		cont.setLayout(new GridLayout(listaDeCruceros.size(), 1));
		revalidate();
		repaint();
		getScSearch().getViewport().setView(cont);
		revalidate();
		repaint();
	}

	private void setCurrentShip(Crucero c) {
		this.currentShip = c;
	}

	private void resetExtras() {
		for (Component c : getPnExtras2Panel().getComponents())
			((JCheckBox) c).setSelected(false);
	}

	private void resetListaPasajeros() {
		getModelPasajeros().removeAllElements();
	}

	private void resetConfigureRoomPanel() {
		resetListaPasajeros();
		resetExtras();
		getCmbDate2Panel().setEnabled(true);
		getBtnCheckDate().setEnabled(false);
		getBtnConfirm().setEnabled(false);
		try {
			resetSecondWindow();
		} catch (ParseException e) {
			Files.writeLog(log, e.getMessage());
		}
	}

	private void loadSecondPane(Crucero c) {
		getLblImgShipPanel2().setIcon(Images.resize(getLblImgShipPanel2(), c.getPicturePath()));
		getLblDescripcion2Panel().setText(Strings.deAccent(c.getDenominacion()));
		((CardLayout) mainPane.getLayout()).show(mainPane, "info_crucero"); //$NON-NLS-1$
		getLblDuration2Panel().setText(Messages.getString("VentanaPrincipal.Duration-two-points_label") + Integer.toString(c.getDuracion()) + Messages.getString("VentanaPrincipal.days.-from_label") + Strings.deAccent(c.getStartPort())); //$NON-NLS-1$ //$NON-NLS-2$
		getLblShipName2Panel().setText(Messages.getString("VentanaPrincipal.onboard-the_label") + c.getBarco().getName()); //$NON-NLS-1$
		getTxtrTxtdescriptionlong().setText(Strings.deAccent(c.getDescripcion()));
		getPnRoom2Panel().setBorder(new TitledBorder(new LineBorder(Color.lightGray), Messages.getString("VentanaPrincipal.configure-your-room_label"))); //$NON-NLS-1$
		getBtnAddRoom().setText(Messages.getString("VentanaPrincipal.add-room_label")); //$NON-NLS-1$

		DefaultComboBoxModel<String> dates = new DefaultComboBoxModel<String>();
		dates.addElement(Messages.getString("VentanaPrincipal.select-date_label")); //$NON-NLS-1$
		for (Date d : c.getSalidas()) {
			SimpleDateFormat sdf = new SimpleDateFormat(CargarDatos.DATE_FORMAT_LONG);
			dates.addElement(sdf.format(d));
		}
		getCmbDate2Panel().setModel(dates);
		getCmbDate2Panel().setSelectedIndex(0);

		getCmbTypeOfRoom2Panl().removeAllItems();
		getCmbTypeOfRoom2Panl().addItem(Messages.getString("VentanaPrincipal.double-exterior_label")); //$NON-NLS-1$
		getCmbTypeOfRoom2Panl().addItem(Messages.getString("VentanaPrincipal.double-interior_label")); //$NON-NLS-1$
		getCmbTypeOfRoom2Panl().addItem(Messages.getString("VentanaPrincipal.familiar-exterior_label")); //$NON-NLS-1$
		getCmbTypeOfRoom2Panl().addItem(Messages.getString("VentanaPrincipal.familiar-interior_label")); //$NON-NLS-1$
		getCmbTypeOfRoom2Panl().setSelectedIndex(0);

		resetConfigureRoomPanel();
		updateRoomCapacityLabel();
		getModeloNoEditable().removeAll();

	}

	private void updateRoomCapacityLabel() {
		if (getCmbTypeOfRoom2Panl().getSelectedItem() != null) {
			if (getCmbTypeOfRoom2Panl().getSelectedItem().toString().equals(Messages.getString("VentanaPrincipal.double-exterior_label"))) { //$NON-NLS-1$
				getLblCapacity2Panel().setText(Messages.getString("VentanaPrincipal.this-room-has-capacity-for_label") + Integer.toString(CamaroteDoble.N_PERSONS) + Messages.getString("VentanaPrincipal.this-room-has-capacity-for_tail_label")); //$NON-NLS-1$ //$NON-NLS-2$
			} else if (getCmbTypeOfRoom2Panl().getSelectedItem().toString().equals(Messages.getString("VentanaPrincipal.double-interior_label"))) { //$NON-NLS-1$
				getLblCapacity2Panel().setText(Messages.getString("VentanaPrincipal.this-room-has-capacity-for_label") + Integer.toString(CamaroteDoble.N_PERSONS) + Messages.getString("VentanaPrincipal.this-room-has-capacity-for_tail_label")); //$NON-NLS-1$ //$NON-NLS-2$
			} else if (getCmbTypeOfRoom2Panl().getSelectedItem().toString().equals(Messages.getString("VentanaPrincipal.familiar-exterior_label"))) { //$NON-NLS-1$
				getLblCapacity2Panel().setText(Messages.getString("VentanaPrincipal.this-room-has-capacity-for_label") + Integer.toString(CamaroteFamiliar.N_PERSONS) + Messages.getString("VentanaPrincipal.this-room-has-capacity-for_tail_label")); //$NON-NLS-1$ //$NON-NLS-2$
			} else if (getCmbTypeOfRoom2Panl().getSelectedItem().toString().equals(Messages.getString("VentanaPrincipal.familiar-interior_label"))) { //$NON-NLS-1$
				getLblCapacity2Panel().setText(Messages.getString("VentanaPrincipal.this-room-has-capacity-for_label") + Integer.toString(CamaroteFamiliar.N_PERSONS) + Messages.getString("VentanaPrincipal.this-room-has-capacity-for_tail_label")); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	}

	protected ModeloTablaNoEditable getModeloNoEditable() {
		return this.modeloTable;
	}
	
	private void deleteCurrentCamarotesFromViaje() {
		for (Camarote c : getModeloNoEditable().getCamarotes()) {
			currentViaje.setCamaroteAsFree(c);
		}
		getModeloNoEditable().removeAll();
	}
	
	private void load3Panel() {
		SimpleDateFormat sdf = new SimpleDateFormat(CargarDatos.DATE_FORMAT_LONG);
		getLblDescriptionAndDate().setText(Strings.deAccent(currentReserva.getCrucero().getDenominacion()+Messages.getString("VentanaPrincipal.separator-from_label") + currentReserva.getCrucero().getStartPort()+Messages.getString("VentanaPrincipal.point-starting-price_label")+sdf.format(currentReserva.getFechaSalida()))); //$NON-NLS-1$ //$NON-NLS-2$
		resetPersonalInfo();
		double priceC = 0.0;
		double priceE = 0.0;
		for(Camarote c : getModeloNoEditable().getCamarotes()) {
			priceC+=currentReserva.getPriceCamarote(c);
		}
		for(Camarote c : getModeloNoEditable().getCamarotes()) {
			priceE+= currentReserva.getPriceCamaroteAndExtras(c);
		}
		
		getLblTotalRooms().setText(Messages.getString("VentanaPrincipal.total-rooms_lable")+ priceC + Messages.getString("VentanaPrincipal.dollar-per-day_label")); //$NON-NLS-1$ //$NON-NLS-2$
		getLblTotalExtras().setText(Messages.getString("VentanaPrincipal.total-extras_label")+(priceE-priceC) + Messages.getString("VentanaPrincipal.dollar-per-day_label")); //$NON-NLS-1$ //$NON-NLS-2$
		getLblTotalPrice().setText(Messages.getString("VentanaPrincipal.total-price_label")+priceE + Messages.getString("VentanaPrincipal.dollar-per-day_label")); //$NON-NLS-1$ //$NON-NLS-2$
		((CardLayout) getContentPane().getLayout()).show(mainPane, "resumen_de_compra"); //$NON-NLS-1$
	}
	
	private void initializeModeloTable() {
		List<String> nombreColumnas = new ArrayList<String>();
		nombreColumnas.add(Messages.getString("VentanaPrincipal.number_symbol")); //$NON-NLS-1$
		nombreColumnas.add(Messages.getString("VentanaPrincipal.type-of-room_label")); //$NON-NLS-1$
		nombreColumnas.add(Messages.getString("VentanaPrincipal.passengers_label")); //$NON-NLS-1$
		for (Extra e : Extras.getExtras()) {
			nombreColumnas.add(e.getExtra());
		}
		nombreColumnas.add(Messages.getString("VentanaPrincipal.room-price-per-nigth_label")); //$NON-NLS-1$
		String[] stringArray = nombreColumnas.toArray(new String[nombreColumnas.size()]);
		modeloTable = new ModeloTablaNoEditable(stringArray, 0, currentReserva);
	}
	
	private void checkDate2Panel() throws ParseException {
		if (cmbDate2Panel.getSelectedItem() != null && cmbDate2Panel.getSelectedIndex() != 0) {

			enablePnRoomsAll();

			SimpleDateFormat sdf = new SimpleDateFormat(CargarDatos.DATE_FORMAT_LONG);
			locateViaje(currentShip, sdf.parse(getCmbDate2Panel().getSelectedItem().toString()));

			currentReserva = new Reserva(currentViaje);

			getModeloNoEditable().setCurrentReserva(currentReserva);

			getBtnAddRoom().setEnabled(false);
			getBtnDeletePassanger().setEnabled(false);
			getBtnModifyPassenger().setEnabled(false);
			getBtnConfirm().setEnabled(false);
			getChckbxAddExtraBed().setEnabled(false);

			for (Component c : getPnCapacities().getComponents()) {
				c.setEnabled(true);
			}
			getPnCapacities().setEnabled(true);
			updateCapacityLabels();
			updateComboTypeOfRooms();
			getBtnCheckDate().setEnabled(true);
		} else {
			getPnRoom2Panel().setEnabled(false);
			for (Component c : getPnRoom2Panel().getComponents()) {
				c.setEnabled(false);
			}
			for (Component c : getPnPassengers2Panel().getComponents()) {
				c.setEnabled(false);
			}
			for (Component c : getPnExtras2Panel().getComponents()) {
				c.setEnabled(false);
			}
			for (Component c : getPnSouthPassengers2Panel().getComponents()) {
				c.setEnabled(false);
			}
			for (Component c : getPnCapacities().getComponents()) {
				c.setEnabled(false);
			}
			getPnCapacities().setEnabled(false);
			getBtnCheckDate().setEnabled(false);

		}
	}

	private void updateComboTypeOfRooms() {
		getCmbTypeOfRoom2Panl().removeAllItems();
		if (currentViaje.getCamarotesDoblesExterioresLibres() > 0)
			getCmbTypeOfRoom2Panl().addItem(Messages.getString("VentanaPrincipal.double-exterior_label")); //$NON-NLS-1$
		if (currentViaje.getCamarotesDoblesInterioresLibres() > 0)
			getCmbTypeOfRoom2Panl().addItem(Messages.getString("VentanaPrincipal.double-interior_label")); //$NON-NLS-1$
		if (currentViaje.getCamarotesFamiliaresEterioresLibres() > 0)
			getCmbTypeOfRoom2Panl().addItem(Messages.getString("VentanaPrincipal.familiar-exterior_label")); //$NON-NLS-1$
		if (currentViaje.getCamarotesFamiliaresInterioresLibres() > 0)
			getCmbTypeOfRoom2Panl().addItem(Messages.getString("VentanaPrincipal.familiar-interior_label")); //$NON-NLS-1$

	}

	private void enablePnRoomsAll() {
		getPnRoom2Panel().setEnabled(true);
		for (Component c : getPnRoom2Panel().getComponents()) {
			c.setEnabled(true);
		}
		for (Component c : getPnPassengers2Panel().getComponents()) {
			c.setEnabled(true);
		}
		extrasCheck();
		for (Component c : getPnSouthPassengers2Panel().getComponents()) {
			c.setEnabled(true);
		}
	}

	private void updateCapacityLabels() {
		getLblFreeDoubleExterior().setText(Messages.getString("VentanaPrincipal.free-double-exterior-two-points_label") + Integer.toString(currentViaje.getCamarotesDoblesExterioresLibres())); //$NON-NLS-1$
		getLblFreeDoubleInterior().setText(Messages.getString("VentanaPrincipal.free-double-interior-two-points_label") + Integer.toString(currentViaje.getCamarotesDoblesInterioresLibres())); //$NON-NLS-1$
		getLblFreeFamiliarExterior().setText(Messages.getString("VentanaPrincipal.free-familiar-exterior-two-points_label") + Integer.toString(currentViaje.getCamarotesFamiliaresEterioresLibres())); //$NON-NLS-1$
		getLblFreeFamiliarInterior().setText(Messages.getString("VentanaPrincipal.free-familiar-interior-two-points_label") + Integer.toString(currentViaje.getCamarotesFamiliaresInterioresLibres())); //$NON-NLS-1$
	}

	private void locateViaje(Crucero c, Date d) {
		this.currentViaje = c.getViaje(d);
	}
	
	private void checkAddPasajero() {
		int people = getLstPassengers2Panel().getModel().getSize();
		int size = getPeopleInCabin();
		if(people > size) {
			btnAddPassanger.setEnabled(false);
		} else {
			btnAddPassanger.setEnabled(true);
		}
	}

	private void extrasCheck() {
		if (getModelPasajeros().getSize() > 0) {
			getChckbxExtrabigBed().setEnabled(true);
			getChckbxJacuzzi().setEnabled(true);
			getChckbxSpecialBreakfast().setEnabled(true);
		} else {
			getChckbxExtrabigBed().setEnabled(false);
			getChckbxJacuzzi().setEnabled(false);
			getChckbxSpecialBreakfast().setEnabled(false);
		}
	}

	private int getPeopleInCabin() {
		int size = 0;
		if (getCmbTypeOfRoom2Panl().getSelectedItem() != null) {
			if (getCmbTypeOfRoom2Panl().getSelectedItem().toString().equals(Messages.getString("VentanaPrincipal.double-exterior_label"))) { //$NON-NLS-1$
				size = CamaroteDoble.N_PERSONS;
			} else if (getCmbTypeOfRoom2Panl().getSelectedItem().toString().equals(Messages.getString("VentanaPrincipal.double-interior_label"))) { //$NON-NLS-1$
				size = CamaroteDoble.N_PERSONS;
			} else if (getCmbTypeOfRoom2Panl().getSelectedItem().toString().equals(Messages.getString("VentanaPrincipal.familiar-exterior_label"))) { //$NON-NLS-1$
				size = CamaroteFamiliar.N_PERSONS;
			} else if (getCmbTypeOfRoom2Panl().getSelectedItem().toString().equals(Messages.getString("VentanaPrincipal.familiar-interior_label"))) { //$NON-NLS-1$
				size = CamaroteFamiliar.N_PERSONS;
			}
		}
		return size;
	}

	private Pasajero addPasajero() {
		String input = JOptionPane.showInputDialog(mainPane, Messages.getString("VentanaPrincipal.insert-age_message")); //$NON-NLS-1$
		int age = -1;
		if (input != null)
			try {
				age = Integer.parseInt(input);
			} catch (NumberFormatException e1) {
				Files.writeLog(log, e1.getMessage());
			}
		while ((age < 0 || age > 150) && input != null) {
			input = JOptionPane.showInputDialog(mainPane, Messages.getString("VentanaPrincipal.insert-age_message_warning")); //$NON-NLS-1$
			if (input != null) {
				try {
					age = Integer.parseInt(input);
				} catch (NumberFormatException e1) {
					Files.writeLog(log, e1.getMessage());
				}
			}
		}
		Pasajero aux = null;
		if (age > 0 && age < 150) {
			aux = new Pasajero(age);
		}
		return aux;
	}

	private Pasajero addKid() {
		String input = JOptionPane.showInputDialog(mainPane, Messages.getString("VentanaPrincipal.insert-age-kid_message")); //$NON-NLS-1$
		int age = -1;
		if (input != null)
			try {
				age = Integer.parseInt(input);
			} catch (NumberFormatException e1) {
				Files.writeLog(log, e1.getMessage());
			}
		while ((age < 0 || age > 16) && input != null) {
			input = JOptionPane.showInputDialog(mainPane, Messages.getString("VentanaPrincipal.insert-age-kid_message_warning")); //$NON-NLS-1$
			if (input != null) {
				try {
					age = Integer.parseInt(input);
				} catch (NumberFormatException e1) {
					Files.writeLog(log, e1.getMessage());
				}
			}
		}
		Pasajero aux = new Pasajero(age);
		if (aux.isChild() && age > 0) {
			return aux;
		}
		return null;
	}
	
	private void checkAddRoomBtn() {
		if (hasParents() && getModelPasajeros().size() > 0)
			getBtnAddRoom().setEnabled(true);
		else
			getBtnAddRoom().setEnabled(false);
	}

	private boolean hasParents() {
		for (int i = 0; i < getModelPasajeros().size(); i++) {
			if (!getModelPasajeros().getElementAt(i).isChild())
				return true;
		}
		return false;
	}

	private void checkExtraBed(int size) {
		if (hasKids() && getModelPasajeros().getSize() <= size) {
			getChckbxAddExtraBed().setEnabled(true);
		} else {
			getChckbxAddExtraBed().setEnabled(false);
		}
		if (!hasKids()) {
			getChckbxAddExtraBed().setSelected(false);
		}
	}

	private boolean hasKids() {
		for (int i = 0; i < getModelPasajeros().getSize(); i++) {
			if (getModelPasajeros().getElementAt(i).isChild())
				return true;
		}
		return false;
	}
	

	private void checkYourRoomsPane() {
		if(getModeloNoEditable().getRowCount()>0) {
			getPnRooms2Panel().setEnabled(true);
			getTbRooms().setEnabled(true);
		} else {
			getPnRooms2Panel().setEnabled(false);
			getTbRooms().setEnabled(false);
		}
	}

	private void checkIfIsThereRooms() {
		if (getCmbTypeOfRoom2Panl().getSelectedItem() != null) {
			if (getCmbTypeOfRoom2Panl().getSelectedItem().toString().equals(Messages.getString("VentanaPrincipal.double-exterior_label")) && currentViaje.getCamarotesDoblesExterioresLibres() == 0) { //$NON-NLS-1$
				getBtnAddRoom().setEnabled(false);
			} else if (getCmbTypeOfRoom2Panl().getSelectedItem().toString().equals(Messages.getString("VentanaPrincipal.double-interior_label")) && currentViaje.getCamarotesDoblesInterioresLibres() == 0) { //$NON-NLS-1$
				getBtnAddRoom().setEnabled(false);
			} else if (getCmbTypeOfRoom2Panl().getSelectedItem().toString().equals(Messages.getString("VentanaPrincipal.familiar-exterior_label")) && currentViaje.getCamarotesFamiliaresEterioresLibres() == 0) { //$NON-NLS-1$
				getBtnAddRoom().setEnabled(false);
			} else if (getCmbTypeOfRoom2Panl().getSelectedItem().toString().equals(Messages.getString("VentanaPrincipal.familiar-interior_label")) && currentViaje.getCamarotesDoblesInterioresLibres() == 0) { //$NON-NLS-1$
				getBtnAddRoom().setEnabled(false);
			} else {
				getBtnAddRoom().setEnabled(true);
			}
		}
	}

	private void loadRoomOnToTable() {
		Camarote c = null;
		if (getCmbTypeOfRoom2Panl().getSelectedItem() != null) {
			if (getCmbTypeOfRoom2Panl().getSelectedItem().toString().equals(Messages.getString("VentanaPrincipal.double-exterior_label"))) { //$NON-NLS-1$
				c = currentViaje.getCamaroteDobleExteriorLibre();
			} else if (getCmbTypeOfRoom2Panl().getSelectedItem().toString().equals(Messages.getString("VentanaPrincipal.double-interior_label"))) { //$NON-NLS-1$
				c = currentViaje.getCamaroteDobleInteriorLibre();
			} else if (getCmbTypeOfRoom2Panl().getSelectedItem().toString().equals(Messages.getString("VentanaPrincipal.familiar-exterior_label"))) { //$NON-NLS-1$
				c = currentViaje.getCamaroteFamiliarExteriorLibre();
			} else if (getCmbTypeOfRoom2Panl().getSelectedItem().toString().equals(Messages.getString("VentanaPrincipal.familiar-interior_label"))) { //$NON-NLS-1$
				c = currentViaje.getCamaroteFamiliarInteriorLibre();
			}

			for (int i = 0; i < getLstPassengers2Panel().getModel().getSize(); i++) {
				c.addPasajero(getLstPassengers2Panel().getModel().getElementAt(i));
			}

			if (getChckbxAddExtraBed().isSelected()) {
				c.addExtra(Extras.getExtra(Extras.EXTRA_BED_ID));
			}
			if (getChckbxExtrabigBed().isSelected()) {
				c.addExtra(Extras.getExtra(Extras.EXTRA_BIG_BED_ID));
			}
			if (getChckbxJacuzzi().isSelected()) {
				c.addExtra(Extras.getExtra(Extras.JACUZZI));
			}
			if (getChckbxSpecialBreakfast().isSelected()) {
				c.addExtra(Extras.getExtra(Extras.SPECIAL_BRAKFAST));
			}
			addRoom(c);
		}
	}

	private void addRoom(Camarote c) {

		modeloTable.addRow(c);
	}
	
	private void loadFourthPanel() {
		getTxtReceipt().setText(Strings.deAccent(currentReserva.toString()));
	}
	
	private void resetMainWindow() {
		initializeModels();
		resetMainCheckBoxes();
		loadCruisesInList();
	}
	
	private void resetMainCheckBoxes() {
		getCkbxDiscount().setSelected(false);
		getCkbxAcceptsKids().setSelected(false);
	}
	
	private void resetSecondWindow() throws ParseException {
		resetCruiseStatus();
		checkDate2Panel();
	}
	
	private void resetCruiseStatus() {
		getLblFreeDoubleExterior().setText(Messages.getString("VentanaPrincipal.free-double-exterior_label")); //$NON-NLS-1$
		getLblFreeDoubleInterior().setText(Messages.getString("VentanaPrincipal.free-double-interior_label")); //$NON-NLS-1$
		getLblFreeFamiliarExterior().setText(Messages.getString("VentanaPrincipal.free-familiar-exterior_label")); //$NON-NLS-1$
		getLblFreeFamiliarInterior().setText(Messages.getString("VentanaPrincipal.free-familiar-interior_label")); //$NON-NLS-1$
	}
	
	private void resetPersonalInfo() {
		getTxtName().setText(""); //$NON-NLS-1$
		getTxtSurname().setText(""); //$NON-NLS-1$
		getTxtDNI().setText(""); //$NON-NLS-1$
		getTxtPhone().setText(""); //$NON-NLS-1$
	}

}
