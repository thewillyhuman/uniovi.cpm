package com.guille.cpm.igu;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.guille.cpm.logic.CargarDatos;
import com.guille.cpm.logic.camarote.Camarote;
import com.guille.cpm.logic.camarote.CamaroteDoble;
import com.guille.cpm.logic.camarote.CamaroteDobleExterior;
import com.guille.cpm.logic.camarote.CamaroteDobleInterior;
import com.guille.cpm.logic.camarote.CamaroteFamiliar;
import com.guille.cpm.logic.camarote.CamaroteFamiliarExterior;
import com.guille.cpm.logic.camarote.CamaroteFamiliarInterior;
import com.guille.cpm.logic.comparators.CompareByDuration;
import com.guille.cpm.logic.comparators.CompareByPrice;
import com.guille.cpm.logic.comparators.CompareByStartingdate;
import com.guille.cpm.logic.crucero.Crucero;
import com.guille.cpm.logic.crucero.Cruceros;
import com.guille.cpm.logic.extra.Extra;
import com.guille.cpm.logic.extra.Extras;
import com.guille.cpm.logic.filters.FilterByArea;
import com.guille.cpm.logic.filters.FilterByChild;
import com.guille.cpm.logic.filters.FilterByDiscount;
import com.guille.cpm.logic.filters.FilterByStartingDate;
import com.guille.cpm.logic.filters.FilterByStartingPort;
import com.guille.cpm.logic.pasajero.Pasajero;
import com.guille.cpm.logic.reserva.Reserva;
import com.guille.cpm.logic.viaje.Viaje;
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.MatteBorder;
import javax.help.HelpBroker;
import javax.help.HelpSet;
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
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * 
 * @author Guillermo Facundo Colunga
 */
public class VentanaPrincipal extends JFrame {

    private static final long serialVersionUID = -8029479718163458536L;

    // Error log.
    private static final PrintWriter log = Files.createLogger("com/guille/cpm/files/out/", "ErrorLog"); //$NON-NLS-2$

    // Custom Fonts.
    protected static final Font text = new MyriadSetPro().getMyriad_Set_Pro_Text().deriveFont(14f);
    protected static final Font textBold = new MyriadSetPro().getMyriad_Set_Pro_Semibold().deriveFont(14f);
    protected static final Font subtitleBold = new MyriadSetPro().getMyriad_Set_Pro_Semibold().deriveFont(20f);
    protected static final Font textMedium = new MyriadSetPro().getMyriad_Set_Pro_Medium().deriveFont(17f);

    // Variables.
    // JPanels.
    private JPanel mainPane, panel1, wPanel, cPanel, cPanelNPanel, panel2, panel2NPanel, panel2SPanel, panel2CPanel,
	    panel2NPanelEPanel, panel2NPanelWPanel, panel2NPanelNpanel, pnRoom2Panel, pnRooms2Panel, pnPassengers2Panel,
	    pnSouthPassengers2Panel, pnExtras2Panel, pnButtonsRooms, panel3, pnNpn3, pnSpn3, pnCpn3, pnTableSummary,
	    panel, panel4, pnCpn4, panel_2, panel_3, pnTripStatus, pnCapacities, panel_1;

    // JLabels.
    private JLabel lblSerach;
    private JLabel lblDestino;
    private JLabel lblStartingDate;
    private JLabel lblStartingPort;
    private JLabel lblListOfAvaliable;
    private JLabel lblMoreCriteria;
    private JLabel lblSortBy;
    private JLabel lblImgShipPanel2;
    private JLabel lblDescripcion2Panel;
    private JLabel lblDuration2Panel;
    private JLabel lblShipName2Panel;
    private JLabel lblTypeOfRoom2Panel;
    private JLabel lblCapacity2Panel;
    private JLabel lblSummary;
    private JLabel lblName;
    private JLabel lblSurname;
    private JLabel lblFreeDoubleInterior;
    private JLabel lblFreeDoubleExterior;
    private JLabel lblFreeFamiliarInterior;
    private JLabel lblFreeFamiliarExterior;
    private JLabel lblTotalRooms;
    private JLabel lblTotalExtras;
    private JLabel lblTotalDiscount;
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
    private CustomComboBoxModel<String> modelDestination;
    private CustomComboBoxModel<String> modelDate;
    private CustomComboBoxModel<String> modelStartingPort;
    private CustomComboBoxModel<String> modeloSortBy;
    private DefaultListModel<Pasajero> modelPasajeros;
    private ModeloTablaNoEditable modeloTable;

    // Lists
    private List<Crucero> listaDeCruceros = new ArrayList<Crucero>();
    private JList<Pasajero> lstPassengers2Panel;

    // Objects to work with.
    private Viaje currentViaje;
    private Reserva currentReserva;
    private Crucero currentShip;
    private JButton btnEn;
    private JButton btnEs;
    private JPanel panel_4;
    private JButton btnEn2;
    private JButton btnES2;

    // Help objects
    private URL hsURL;
    private HelpSet hs;
    private HelpBroker hb;
    private JPanel panel_5;
    private JScrollPane scrollPane_2;
    private JPanel panel_6;
    private JButton btnEn3;
    private JButton btnEs3;
    private JPanel panel_7;
    private JPanel panel_8;
    private JButton bntEn4;
    private JButton btnEs4;
    private JPanel panel_9;
    private JLabel lblCruceroname;
    private JLabel lblBarconombre;
    private JLabel lblFechasalida;
    private JLabel lblDiascrucero;
    private JLabel lblSalidapuerto;
    private JLabel lblNpasajeros;
    private JLabel lblLblpicture;
    private JLabel lblTotalrooms;
    private JLabel lblTotalextras;
    private JLabel lblTotaldiscount;
    private JLabel lblTotalPriceTotal;
    private JLabel lblTotalTotal;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	// Setting the antialiasing on. Just to make fonts look gorgeous.
	try {
	    System.setProperty("awt.useSystemAAFontSettings", "lcd"); //$NON-NLS-2$
	    System.setProperty("swing.aatext", "true"); //$NON-NLS-2$
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
	setMinimumSize(new Dimension(1046, 703));
	CargarDatos.cargarDatos();
	modelDestination = new CustomComboBoxModel<>();
	modelDate = new CustomComboBoxModel<>();
	modelStartingPort = new CustomComboBoxModel<>();
	modeloSortBy = new CustomComboBoxModel<>();

	setIconImage(Toolkit.getDefaultToolkit()
		.getImage(VentanaPrincipal.class.getResource("/com/guille/cpm/img/appIcon.png")));
	setLocationByPlatform(true);
	setTitle(Messages.getString("VentanaPrincipal.title_window"));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1046, 703);
	mainPane = new JPanel();
	mainPane.setBackground(Color.WHITE);
	mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(mainPane);
	mainPane.setLayout(new CardLayout(0, 0));
	mainPane.add(getPanel1(), "busqueda_inicio");
	mainPane.add(getPanel2(), "info_crucero");
	mainPane.add(getPanel3(), "resumen_de_compra");
	mainPane.add(getPanel4(), "receipt");
	initializeModels();
	loadCruisesInList();
	setUpHelp();
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
	    wPanel.addComponentListener(new ComponentAdapter() {
		@Override
		public void componentResized(ComponentEvent e) {
		    getBtnEn().setBounds(getBtnEn().getX(), getWPanel().getHeight() - 42, getBtnEn().getWidth(),
			    getBtnEn().getHeight());
		    getBtnEs().setBounds(getBtnEs().getX(), getWPanel().getHeight() - 42, getBtnEs().getWidth(),
			    getBtnEs().getHeight());
		}
	    });
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
	    wPanel.add(getBtnEn());
	    wPanel.add(getBtnEs());
	}
	return wPanel;
    }

    private JLabel getLblSerach() {
	if (lblSerach == null) {
	    lblSerach = new JLabel(Messages.getString("VentanaPrincipal.search_label"));
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
	    lblDestino = new JLabel(Messages.getString("VentanaPrincipal.destination_label"));
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
	    lblStartingDate = new JLabel(Messages.getString("VentanaPrincipal.starting-date_label"));
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
	    lblStartingPort = new JLabel(Messages.getString("VentanaPrincipal.starting-port_label"));
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
	    lblListOfAvaliable = new JLabel(Messages.getString("VentanaPrincipal.title-search_label"));
	    lblListOfAvaliable.setHorizontalAlignment(SwingConstants.CENTER);
	    lblListOfAvaliable.setFont(subtitleBold);
	}
	return lblListOfAvaliable;
    }

    private JCheckBox getCkbxAcceptsKids() {
	if (ckbxAcceptsKids == null) {
	    ckbxAcceptsKids = new JCheckBox(Messages.getString("VentanaPrincipal.accepts-kids_label"));
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
	    ckbxDiscount = new JCheckBox(Messages.getString("VentanaPrincipal.discount_label"));
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
	    lblMoreCriteria = new JLabel(Messages.getString("VentanaPrincipal.more-criteria_label"));
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
	    lblSortBy = new JLabel(Messages.getString("VentanaPrincipal.sort-by_label"));
	    lblSortBy.setFont(textBold);
	    lblSortBy.setBounds(6, 331, 186, 16);
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
	    comboSort.setBounds(6, 359, 186, 27);
	    updateModelSortBy();
	    comboSort.setModel(modeloSortBy);
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
	    panel2SPanel.add(getPanel_4(), BorderLayout.WEST);
	}
	return panel2SPanel;
    }

    private JPanel getPanel2CPanel() {
	if (panel2CPanel == null) {
	    panel2CPanel = new JPanel();
	    panel2CPanel.addComponentListener(new ComponentAdapter() {
		@Override
		public void componentResized(ComponentEvent e) {
		    resize2Pane();
		}
	    });
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
	    btnNewButton = new JButton(Messages.getString("VentanaPrincipal.back-to-search_label"));
	    btnNewButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    int opt = JOptionPane.showConfirmDialog(mainPane,
			    Messages.getString("VentanaPrincipal.go-back-search_message"),
			    Messages.getString("VentanaPrincipal.go-back-search_message_title"),
			    JOptionPane.YES_NO_OPTION);
		    if (opt == 0) {
			deleteCurrentCamarotesFromViaje();
			((CardLayout) getContentPane().getLayout()).show(mainPane, "busqueda_inicio");
		    }
		}
	    });
	}
	return btnNewButton;
    }

    private JLabel getLblImgShipPanel2() {
	if (lblImgShipPanel2 == null) {
	    lblImgShipPanel2 = new JLabel("New label");
	    lblImgShipPanel2.setBorder(new LineBorder(new Color(0, 0, 0)));
	    lblImgShipPanel2.setBounds(6, 6, 170, 179);
	}
	return lblImgShipPanel2;
    }

    private JPanel getPnRoom2Panel() {
	if (pnRoom2Panel == null) {
	    pnRoom2Panel = new JPanel();
	    pnRoom2Panel.addComponentListener(new ComponentAdapter() {
		@Override
		public void componentResized(ComponentEvent e) {
		    resizePnRoom2Panel();
		}
	    });
	    pnRoom2Panel.setEnabled(false);
	    pnRoom2Panel.setBackground(Color.WHITE);
	    pnRoom2Panel
		    .setBorder(new TitledBorder(null, Messages.getString("VentanaPrincipal.configure-the-room_label"),
			    TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    pnRoom2Panel.setBounds(6, 197, 1024, 221);
	    pnRoom2Panel.setLayout(null);
	    pnRoom2Panel.add(getLblTypeOfRoom2Panel());
	    pnRoom2Panel.add(getCmbTypeOfRoom2Panl());
	    pnRoom2Panel.add(getLblCapacity2Panel());
	    pnRoom2Panel.add(getPnPassengers2Panel());
	    pnRoom2Panel.add(getPnExtras2Panel());
	    pnRoom2Panel.add(getBtnAddRoom());
	}
	return pnRoom2Panel;
    }

    private JPanel getPnRooms2Panel() {
	if (pnRooms2Panel == null) {
	    pnRooms2Panel = new JPanel();
	    pnRooms2Panel.setEnabled(false);
	    pnRooms2Panel.setBorder(new TitledBorder(null, Messages.getString("VentanaPrincipal.your-rooms_label"),
		    TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
	    btnConfirm = new JButton(Messages.getString("VentanaPrincipal.continue-to-summary_label"));
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
	    lblDescripcion2Panel = new JLabel("New label");
	    lblDescripcion2Panel.setBounds(188, 6, 245, 19);
	    lblDescripcion2Panel.setFont(textMedium);
	}
	return lblDescripcion2Panel;
    }

    private JLabel getLblDuration2Panel() {
	if (lblDuration2Panel == null) {
	    lblDuration2Panel = new JLabel("New label");
	    lblDuration2Panel.setBounds(188, 26, 310, 19);
	    lblDuration2Panel.setFont(text);
	}
	return lblDuration2Panel;
    }

    private JLabel getLblShipName2Panel() {
	if (lblShipName2Panel == null) {
	    lblShipName2Panel = new JLabel("New label");
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
		    if (cmbDate2Panel.getSelectedIndex() != 0) {
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
	    lblTypeOfRoom2Panel = new JLabel(Messages.getString("VentanaPrincipal.type-of-room-two-points_label"));
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
	    lblCapacity2Panel = new JLabel(Messages.getString("VentanaPrincipal.capacity-for_label"));
	    lblCapacity2Panel.setBounds(340, 23, 652, 23);
	    lblCapacity2Panel.setFont(text);
	}
	return lblCapacity2Panel;
    }

    private JPanel getPnPassengers2Panel() {
	if (pnPassengers2Panel == null) {
	    pnPassengers2Panel = new JPanel();
	    pnPassengers2Panel.setBorder(new TitledBorder(null, Messages.getString("VentanaPrincipal.passengers_label"),
		    TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
	    btnAddPassanger = new JButton(Messages.getString("VentanaPrincipal.add-passenger_label"));
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
			int opt = JOptionPane.showConfirmDialog(mainPane,
				Messages.getString("VentanaPrincipal.extra-bed-kid_message"),
				Messages.getString("VentanaPrincipal.extra-bed-kid_message_title"),
				JOptionPane.YES_NO_OPTION);
			if (opt == 0) {
			    pasajero = addPasajero();
			    if (pasajero != null)
				getChckbxAddExtraBed().setSelected(true);
			}
		    } else if (people == size && !hasKids()) {
			int opt = JOptionPane.showConfirmDialog(mainPane,
				Messages.getString("VentanaPrincipal.extra-bed_message"),
				Messages.getString("VentanaPrincipal.extra-bed_message_title"),
				JOptionPane.YES_NO_OPTION);
			if (opt == 0) {
			    pasajero = addKid();
			    if (pasajero != null)
				getChckbxAddExtraBed().setSelected(true);
			}
		    }
		    if (pasajero != null) {
			if (pasajero.isChild() && !currentReserva.getCrucero().getAcceptUnder16())
			    JOptionPane.showMessageDialog(mainPane,
				    Messages.getString("VentanaPrincipal.cruise-not-under16_message"),
				    Messages.getString("VentanaPrincipal.cruise-not-under16_message_title"),
				    JOptionPane.ERROR_MESSAGE);
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
	    btnDeletePassanger = new JButton(Messages.getString("VentanaPrincipal.delete-passenger_label"));
	    btnDeletePassanger.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    // Yes = 0; No = 1
		    int opt = JOptionPane.showConfirmDialog(mainPane,
			    Messages.getString("VentanaPrincipal.delete-passenger_message"),
			    Messages.getString("VentanaPrincipal.delete-passenger_message_title"),
			    JOptionPane.YES_NO_OPTION);
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
	    btnModifyPassenger = new JButton(Messages.getString("VentanaPrincipal.modify_label"));
	    btnModifyPassenger.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    int oldAge = getLstPassengers2Panel().getSelectedValue().getAge();
		    if (getLstPassengers2Panel().getSelectedIndex() > -1) {
			String input = JOptionPane.showInputDialog(mainPane,
				Messages.getString("VentanaPrincipal.change-age_message"),
				getLstPassengers2Panel().getSelectedValue().getAge());
			int age = -1;
			if (input != null)
			    try {
				age = Integer.parseInt(input);
			    } catch (NumberFormatException e1) {
				Files.writeLog(log, e1.getMessage());
			    }
			while ((age < 0 || age > 150) && input != null) {
			    input = JOptionPane.showInputDialog(mainPane,
				    Messages.getString("VentanaPrincipal.change-age_message"),
				    getLstPassengers2Panel().getSelectedValue().getAge());
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
				JOptionPane.showMessageDialog(mainPane,
					Messages.getString("VentanaPrincipal.change-not-possible_message"));
				getLstPassengers2Panel().getSelectedValue().setAge(oldAge);
			    } else if (age < 16 && !currentReserva.getCrucero().getAcceptUnder16()) {
				JOptionPane.showMessageDialog(mainPane,
					Messages.getString("VentanaPrincipal.cruise-not-under16_message"),
					Messages.getString("VentanaPrincipal.cruise-not-under16_message_title"),
					JOptionPane.ERROR_MESSAGE);
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
	    chckbxAddExtraBed = new JCheckBox(Messages.getString("VentanaPrincipal.add-extra-bed_label"));
	    chckbxAddExtraBed.setEnabled(false);
	    chckbxAddExtraBed.setFont(text);
	}
	return chckbxAddExtraBed;
    }

    private JCheckBox getChckbxJacuzzi() {
	if (chckbxJacuzzi == null) {
	    chckbxJacuzzi = new JCheckBox(Messages.getString("VentanaPrincipal.jacuzzy_label"));
	    chckbxJacuzzi.setEnabled(false);
	    chckbxJacuzzi.setFont(text);
	}
	return chckbxJacuzzi;
    }

    private JCheckBox getChckbxSpecialBreakfast() {
	if (chckbxSpecialBreakfast == null) {
	    chckbxSpecialBreakfast = new JCheckBox(Messages.getString("VentanaPrincipal.special-breakfast_label"));
	    chckbxSpecialBreakfast.setEnabled(false);
	    chckbxSpecialBreakfast.setFont(text);
	}
	return chckbxSpecialBreakfast;
    }

    private JCheckBox getChckbxExtrabigBed() {
	if (chckbxExtrabigBed == null) {
	    chckbxExtrabigBed = new JCheckBox(Messages.getString("VentanaPrincipal.extra-big-bed_label"));
	    chckbxExtrabigBed.setEnabled(false);
	    chckbxExtrabigBed.setFont(text);
	}
	return chckbxExtrabigBed;
    }

    private JPanel getPnExtras2Panel() {
	if (pnExtras2Panel == null) {
	    pnExtras2Panel = new JPanel();
	    pnExtras2Panel.setBorder(new TitledBorder(null, Messages.getString("VentanaPrincipal.extras_label"),
		    TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
	    btnAddRoob = new JButton(Messages.getString("VentanaPrincipal.add-room_label"));
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
		    getPnRoom2Panel().setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY),
			    Messages.getString("VentanaPrincipal.configure-your-room_label")));
		    btnAddRoob.setText(Messages.getString("VentanaPrincipal.add-room_label"));
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
	    btnDeleteRoom = new JButton(Messages.getString("VentanaPrincipal.delete-room_label"));
	    btnDeleteRoom.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    int opt = JOptionPane.showConfirmDialog(mainPane,
			    Messages.getString("VentanaPrincipal.delete-room_message"),
			    Messages.getString("VentanaPrincipal.delete-room_message_title"),
			    JOptionPane.YES_NO_OPTION);
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
	    pnSpn3.setPreferredSize(new Dimension(10, 30));
	    pnSpn3.setBackground(Color.WHITE);
	    pnSpn3.setLayout(new BorderLayout(0, 0));
	    pnSpn3.add(getBtnConfirmAndPay(), BorderLayout.EAST);
	    pnSpn3.add(getPanel_6(), BorderLayout.WEST);
	}
	return pnSpn3;
    }

    private JPanel getPnCpn3() {
	if (pnCpn3 == null) {
	    pnCpn3 = new JPanel();
	    pnCpn3.addComponentListener(new ComponentAdapter() {
		@Override
		public void componentResized(ComponentEvent e) {
		    resize3Panel();
		}
	    });
	    pnCpn3.setBackground(Color.WHITE);
	    pnCpn3.setLayout(null);
	    pnCpn3.add(getLblSummary());
	    pnCpn3.add(getPnTableSummary());
	    pnCpn3.add(getPanel());
	    pnCpn3.add(getLblTotalRooms());
	    pnCpn3.add(getLblTotalExtras());
	    pnCpn3.add(getLblTotalDiscount());
	    pnCpn3.add(getPanel_9());
	    pnCpn3.add(getLblTotalrooms());
	    pnCpn3.add(getLblTotalextras());
	    pnCpn3.add(getLblTotaldiscount());
	    pnCpn3.add(getLblTotalPriceTotal());
	    pnCpn3.add(getLblTotalTotal());
	}
	return pnCpn3;
    }

    private void resize3Panel() {
	getPanel_9().setBounds(getPanel_9().getX(), getPanel_9().getY(), getPnCpn3().getWidth() - 12,
		getPanel_9().getHeight());

	getPnTableSummary().setBounds(getPnTableSummary().getX(), getPnTableSummary().getY(),
		getPnCpn3().getWidth() - 12, getPnCpn3().getHeight() - 480);

	getLblTotalRooms().setBounds(getPnCpn3().getWidth() - 265, getPnCpn3().getHeight() - 296,
		getLblTotalRooms().getWidth(), getLblTotalRooms().getHeight());
	getLblTotalExtras().setBounds(getPnCpn3().getWidth() - 265, getPnCpn3().getHeight() - 268,
		getLblTotalExtras().getWidth(), getLblTotalExtras().getHeight());
	getLblTotalDiscount().setBounds(getPnCpn3().getWidth() - 265, getPnCpn3().getHeight() - 241,
		getLblTotalDiscount().getWidth(), getLblTotalDiscount().getHeight());
	getLblTotalPriceTotal().setBounds(getPnCpn3().getWidth() - 265, getPnCpn3().getHeight() - 214,
		getLblTotalPriceTotal().getWidth(), getLblTotalPriceTotal().getHeight());
	getLblTotalrooms().setBounds(getPnCpn3().getWidth() - 116, getPnCpn3().getHeight() - 296,
		getLblTotalrooms().getWidth(), getLblTotalrooms().getHeight());
	getLblTotalextras().setBounds(getPnCpn3().getWidth() - 116, getPnCpn3().getHeight() - 268,
		getLblTotalextras().getWidth(), getLblTotalextras().getHeight());
	getLblTotaldiscount().setBounds(getPnCpn3().getWidth() - 116, getPnCpn3().getHeight() - 241,
		getLblTotaldiscount().getWidth(), getLblTotaldiscount().getHeight());
	getLblTotalTotal().setBounds(getPnCpn3().getWidth() - 116, getPnCpn3().getHeight() - 214,
		getLblTotalTotal().getWidth(), getLblTotalTotal().getHeight());

	getPanel().setBounds(getPanel().getX(), getPnCpn3().getHeight() - 179, getPnCpn3().getWidth() - 12,
		getPanel().getHeight());
	repaint();
	revalidate();
    }

    private JButton getBtnNewButton_1() {
	if (btnNewButton_1 == null) {
	    btnNewButton_1 = new JButton(Messages.getString("VentanaPrincipal.go-back_label"));
	    btnNewButton_1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    currentReserva.removeCamarotes(getModeloNoEditable().getCamarotes());
		    ((CardLayout) getContentPane().getLayout()).show(mainPane, "info_crucero");
		}
	    });
	}
	return btnNewButton_1;
    }

    private JButton getBtnConfirmAndPay() {
	LineBorder red = new LineBorder(Color.RED);
	LineBorder gray = new LineBorder(Color.LIGHT_GRAY);
	if (btnConfirmAndPay == null) {
	    btnConfirmAndPay = new JButton(Messages.getString("VentanaPrincipal.confirm-and-pay_label"));
	    btnConfirmAndPay.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    boolean correct = true;

		    if (getTxtName().getText().isEmpty()) {
			getTxtName().setBorder(red);
			correct = false;
		    } else {
			getTxtName().setBorder(gray);
			currentReserva.setName(getTxtName().getText());
		    }

		    if (getTxtSurname().getText().isEmpty()) {
			getTxtSurname().setBorder(red);
			correct = false;
		    } else {
			getTxtSurname().setBorder(gray);
			currentReserva.setSurname(getTxtSurname().getText());
		    }

		    if (!Reserva.validaNIF(getTxtDNI().getText(), Messages.localization)
			    || getTxtDNI().getText().isEmpty()) {
			getTxtDNI().setBorder(red);
			correct = false;
		    } else {
			currentReserva.setDNI(getTxtDNI().getText());
			getTxtDNI().setBorder(gray);
		    }

		    if (getTxtPhone().getText().isEmpty()) {
			getTxtPhone().setBorder(red);
			correct = false;
		    } else {
			currentReserva.setTelf(Integer.parseInt(getTxtPhone().getText()));
			getTxtPhone().setBorder(gray);
		    }

		    if (correct) {
			try {
			    Files.writeFileFromString(CargarDatos.PATH_OUT, currentReserva.getDNI(),
				    currentReserva.toString(), ".txt", "UTF-8");
			} catch (FileNotFoundException | UnsupportedEncodingException e1) {
			    Files.writeLog(log, e1.getMessage());
			}
			loadFourthPanel();
			((CardLayout) getContentPane().getLayout()).show(mainPane, "receipt");
		    } else {
			JOptionPane.showMessageDialog(mainPane,
				Messages.getString("VentanaPrincipal.correct-red-fields_message"));
		    }
		}
	    });
	}
	return btnConfirmAndPay;
    }

    private JLabel getLblSummary() {
	if (lblSummary == null) {
	    lblSummary = new JLabel(Messages.getString("VentanaPrincipal.summary_label"));
	    lblSummary.setBounds(6, 6, 158, 34);
	    lblSummary.setFont(subtitleBold);
	}
	return lblSummary;
    }

    private JPanel getPnTableSummary() {
	if (pnTableSummary == null) {
	    pnTableSummary = new JPanel();
	    pnTableSummary.setBackground(Color.WHITE);
	    pnTableSummary.setBounds(6, 172, 1024, 132);
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
	    panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
		    Messages.getString("VentanaPrincipal.personal-payment-info_label"), TitledBorder.LEADING,
		    TitledBorder.TOP, null, new Color(0, 0, 0)));
	    panel.setBackground(Color.WHITE);
	    panel.setBounds(6, 433, 1024, 173);
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
	    lblName = new JLabel(Messages.getString("VentanaPrincipal.name_label"));
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
	    lblSurname = new JLabel(Messages.getString("VentanaPrincipal.surname_label"));
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

    private JLabel getLblDni() {
	if (lblDni == null) {
	    lblDni = new JLabel(Messages.getString("VentanaPrincipal.dni_label"));
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
	    lblPhone = new JLabel(Messages.getString("VentanaPrincipal.phone_label"));
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
	    pnCpn4.add(getPanel_7(), BorderLayout.SOUTH);
	}
	return pnCpn4;
    }

    private JTextArea getTxtReceipt() {
	if (txtReceipt == null) {
	    txtReceipt = new JTextArea();
	    txtReceipt.setAutoscrolls(false);
	    txtReceipt.setMargin(new Insets(0, 15, 0, 0));
	    txtReceipt.setBorder(null);
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
	    lblReceiptTitle = new JLabel(Messages.getString("VentanaPrincipal.purchase-receipt_label"));
	    lblReceiptTitle.setPreferredSize(new Dimension(106, 20));
	    lblReceiptTitle.setFont(subtitleBold);
	}
	return lblReceiptTitle;
    }

    private JPanel getPanel_2() {
	if (panel_2 == null) {
	    panel_2 = new JPanel();
	    panel_2.addComponentListener(new ComponentAdapter() {
		@Override
		public void componentResized(ComponentEvent e) {
		    getPanel_5().setBounds(getPanel_5().getX(), getPanel_5().getY(), panel_2.getWidth() - 395,
			    panel_2.getHeight() - 315);
		    int x = (getPanel_5().getX() + (getPanel_5().getWidth() / 2) - (getBtnGoToInicio().getWidth() / 2));
		    getBtnGoToInicio().setBounds(x, getPanel4().getHeight() - 150, getBtnGoToInicio().getWidth(),
			    getBtnGoToInicio().getHeight());
		    revalidate();
		    repaint();
		}
	    });
	    panel_2.setBackground(Color.WHITE);
	    panel_2.setLayout(null);
	    panel_2.add(getBtnGoToInicio());
	    panel_2.add(getPanel_5());
	}
	return panel_2;
    }

    private JPanel getPanel_3() {
	if (panel_3 == null) {
	    panel_3 = new JPanel();
	    panel_3.setBorder(new TitledBorder(null, Messages.getString("VentanaPrincipal.description-cruise_label"),
		    TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
	    txtrTxtdescriptionlong.setText("txtDescriptionLong");
	    txtrTxtdescriptionlong.setFont(text);
	}
	return txtrTxtdescriptionlong;
    }

    private JPanel getPnTripStatus() {
	if (pnTripStatus == null) {
	    pnTripStatus = new JPanel();
	    pnTripStatus.setBorder(new TitledBorder(null, Messages.getString("VentanaPrincipal.cruise-status_label"),
		    TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
	    pnCapacities.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { getLblFreeDoubleExterior(),
		    getLblFreeDoubleInterior(), getLblFreeFamiliarExterior(), getLblFreeFamiliarInterior() }));
	}
	return pnCapacities;
    }

    private JLabel getLblFreeDoubleInterior() {
	if (lblFreeDoubleInterior == null) {
	    lblFreeDoubleInterior = new JLabel(Messages.getString("VentanaPrincipal.free-double-interior_label"));
	    lblFreeDoubleInterior.setFont(text);
	}
	return lblFreeDoubleInterior;
    }

    private JLabel getLblFreeDoubleExterior() {
	if (lblFreeDoubleExterior == null) {
	    lblFreeDoubleExterior = new JLabel(Messages.getString("VentanaPrincipal.free-double-exterior_label"));
	    lblFreeDoubleExterior.setFont(text);
	}
	return lblFreeDoubleExterior;
    }

    private JLabel getLblFreeFamiliarInterior() {
	if (lblFreeFamiliarInterior == null) {
	    lblFreeFamiliarInterior = new JLabel(Messages.getString("VentanaPrincipal.free-familiar-interior_label"));
	    lblFreeFamiliarInterior.setFont(text);
	}
	return lblFreeFamiliarInterior;
    }

    private JLabel getLblFreeFamiliarExterior() {
	if (lblFreeFamiliarExterior == null) {
	    lblFreeFamiliarExterior = new JLabel(Messages.getString("VentanaPrincipal.free-familiar-exterior_label"));
	    lblFreeFamiliarExterior.setFont(text);
	}
	return lblFreeFamiliarExterior;
    }

    private JButton getBtnGoToInicio() {
	if (btnGoToInicio == null) {
	    btnGoToInicio = new JButton(Messages.getString("VentanaPrincipal.start-app_label"));
	    btnGoToInicio.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    LoadingDialog loading = new LoadingDialog(mainPane,
			    Messages.getString("LoadingDialog.inicializating-application_label"),
			    Messages.getString("LoadingDialog.inicializating-application_title"));

		    SwingWorker<Void, Void> sw = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
			    resetMainWindow();
			    return null;
			}

			@Override
			protected void done() {
			    loading.dispose();// close the modal dialog
			    
			    // go to beginning
			    ((CardLayout) getContentPane().getLayout()).show(mainPane, "busqueda_inicio");
			}
		    };
		    sw.execute(); // this will start the processing on a separate thread
		    loading.setVisible(true);
		}
	    });
	    btnGoToInicio.setBounds(409, 551, 217, 54);
	}
	return btnGoToInicio;
    }

    private JButton getBtnCheckDate() {
	if (btnCheckDate == null) {
	    btnCheckDate = new JButton(Messages.getString("VentanaPrincipal.change-date_label"));
	    btnCheckDate.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    boolean aux = getModeloNoEditable().getRowCount() == 0;
		    try {
			int opt = -1;
			if (!aux) {
			    opt = JOptionPane.showConfirmDialog(mainPane,
				    Messages.getString("VentanaPrincipal.change-date_message"),
				    Messages.getString("VentanaPrincipal.change-dage_message_title"),
				    JOptionPane.CANCEL_OPTION);
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
	    lblTotalRooms = new JLabel("New label");
	    lblTotalRooms.setHorizontalAlignment(SwingConstants.TRAILING);
	    lblTotalRooms.setBounds(771, 316, 136, 23);
	}
	return lblTotalRooms;
    }

    private JLabel getLblTotalExtras() {
	if (lblTotalExtras == null) {
	    lblTotalExtras = new JLabel("New label");
	    lblTotalExtras.setHorizontalAlignment(SwingConstants.TRAILING);
	    lblTotalExtras.setBounds(771, 344, 136, 23);
	}
	return lblTotalExtras;
    }

    private JLabel getLblTotalDiscount() {
	if (lblTotalDiscount == null) {
	    lblTotalDiscount = new JLabel("New label");
	    lblTotalDiscount.setHorizontalAlignment(SwingConstants.TRAILING);
	    lblTotalDiscount.setBounds(771, 371, 136, 23);
	}
	return lblTotalDiscount;
    }

    private JButton getBtnModifyRoom() {
	if (btnModifyRoom == null) {
	    btnModifyRoom = new JButton(Messages.getString("VentanaPrincipal.modify-room_label"));
	    btnModifyRoom.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    getPnRoom2Panel().setBorder(new TitledBorder(new LineBorder(Color.RED),
			    Messages.getString("VentanaPrincipal.modify-your-room_label")));
		    getBtnAddRoom().setText(Messages.getString("VentanaPrincipal.modify-the-room_label"));
		    Camarote c;
		    int row = getTbRooms().getSelectedRow();
		    if (row != -1) {
			c = getModeloNoEditable().getCamaroteAtRow(getTbRooms().getSelectedRow()).copy();
			currentViaje.setCamaroteAsFree(
				getModeloNoEditable().getCamaroteAtRow(getTbRooms().getSelectedRow()));
			checkIfIsThereRooms();
			updateCapacityLabels();
			getModeloNoEditable()
				.removeRow(getModeloNoEditable().getCamaroteAtRow(getTbRooms().getSelectedRow()));

			if (c instanceof CamaroteFamiliarInterior) {
			    getCmbTypeOfRoom2Panl()
				    .setSelectedItem(Messages.getString("VentanaPrincipal.familiar-interior_label"));
			} else if (c instanceof CamaroteFamiliarExterior) {
			    getCmbTypeOfRoom2Panl()
				    .setSelectedItem(Messages.getString("VentanaPrincipal.familiar-exterior_label"));
			} else if (c instanceof CamaroteDobleInterior) {
			    getCmbTypeOfRoom2Panl()
				    .setSelectedItem(Messages.getString("VentanaPrincipal.double-interior_label"));
			} else if (c instanceof CamaroteDobleExterior) {
			    getCmbTypeOfRoom2Panl()
				    .setSelectedItem(Messages.getString("VentanaPrincipal.double-exterior_label"));
			}
			modelPasajeros.removeAllElements();
			for (Pasajero p : c.getPasajeros()) {
			    modelPasajeros.addElement(p);
			}
			for (Extra ext : c.getExtras()) {
			    if (ext.getExtra().equals("Cama supletoria"))
				getChckbxAddExtraBed().setSelected(true);
			    if (ext.getExtra().equals("Desayuno especial"))
				getChckbxSpecialBreakfast().setSelected(true);
			    if (ext.getExtra().equals("Cama extragrande"))
				getChckbxExtrabigBed().setSelected(true);
			    if (ext.getExtra().equals("Jacuzzi"))
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

    private JButton getBtnEn() {
	if (btnEn == null) {
	    btnEn = new JButton("EN");
	    btnEn.setBorder(new LineBorder(new Color(0, 0, 0)));
	    btnEn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    loacalThread(new Locale("en_US"));
		}
	    });
	    btnEn.setBounds(6, 629, 35, 35);
	}
	return btnEn;
    }

    private JButton getBtnEs() {
	if (btnEs == null) {
	    btnEs = new JButton("ES");
	    btnEs.setEnabled(false);
	    btnEs.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
	    btnEs.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    loacalThread(new Locale("es_ES"));
		}
	    });
	    btnEs.setBounds(40, 629, 35, 35);
	}
	return btnEs;
    }

    private JPanel getPanel_4() {
	if (panel_4 == null) {
	    panel_4 = new JPanel();
	    panel_4.setPreferredSize(new Dimension(70, 10));
	    panel_4.setBackground(Color.WHITE);
	    panel_4.setLayout(new GridLayout(0, 2, 0, 0));
	    panel_4.add(getBtnEn2());
	    panel_4.add(getBtnES2());
	}
	return panel_4;
    }

    private JButton getBtnEn2() {
	if (btnEn2 == null) {
	    btnEn2 = new JButton("EN");
	    btnEn2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    loacalThread(new Locale("en_US"));
		}
	    });
	    btnEn2.setBorder(new LineBorder(new Color(0, 0, 0)));
	}
	return btnEn2;
    }

    private JButton getBtnES2() {
	if (btnES2 == null) {
	    btnES2 = new JButton("ES");
	    btnES2.setEnabled(false);
	    btnES2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    loacalThread(new Locale("es_ES"));
		}
	    });
	    btnES2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
	}
	return btnES2;
    }

    private JPanel getPanel_5() {
	if (panel_5 == null) {
	    panel_5 = new JPanel();
	    panel_5.setBorder(new TitledBorder(null, "Receipt", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    panel_5.setBackground(Color.WHITE);
	    panel_5.setBounds(203, 143, 629, 367);
	    panel_5.setLayout(new BorderLayout(0, 0));
	    panel_5.add(getScrollPane_2(), BorderLayout.CENTER);
	}
	return panel_5;
    }

    private JScrollPane getScrollPane_2() {
	if (scrollPane_2 == null) {
	    scrollPane_2 = new JScrollPane();
	    scrollPane_2.setBorder(null);
	    scrollPane_2.setViewportView(getTxtReceipt());
	}
	return scrollPane_2;
    }

    private JPanel getPanel_6() {
	if (panel_6 == null) {
	    panel_6 = new JPanel();
	    panel_6.setPreferredSize(new Dimension(70, 10));
	    panel_6.setBackground(Color.WHITE);
	    panel_6.setLayout(new GridLayout(0, 2, 0, 0));
	    panel_6.add(getBtnEn3());
	    panel_6.add(getBtnEs3());
	}
	return panel_6;
    }

    private JButton getBtnEn3() {
	if (btnEn3 == null) {
	    btnEn3 = new JButton("EN");
	    btnEn3.setBorder(new LineBorder(new Color(0, 0, 0)));
	    btnEn3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    loacalThread(new Locale("en_US"));
		}
	    });
	}
	return btnEn3;
    }

    private JButton getBtnEs3() {
	if (btnEs3 == null) {
	    btnEs3 = new JButton("ES");
	    btnEs3.setEnabled(false);
	    btnEs3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
	    btnEs3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    loacalThread(new Locale("es_ES"));
		}
	    });
	}
	return btnEs3;
    }

    private JPanel getPanel_7() {
	if (panel_7 == null) {
	    panel_7 = new JPanel();
	    panel_7.setPreferredSize(new Dimension(10, 35));
	    panel_7.setBackground(Color.WHITE);
	    panel_7.setLayout(new BorderLayout(0, 0));
	    panel_7.add(getPanel_8(), BorderLayout.WEST);
	}
	return panel_7;
    }

    private JPanel getPanel_8() {
	if (panel_8 == null) {
	    panel_8 = new JPanel();
	    panel_8.setPreferredSize(new Dimension(70, 10));
	    panel_8.setBackground(Color.WHITE);
	    panel_8.setLayout(new GridLayout(0, 2, 0, 0));
	    panel_8.add(getBntEn4());
	    panel_8.add(getBtnEs4());
	}
	return panel_8;
    }

    private JButton getBntEn4() {
	if (bntEn4 == null) {
	    bntEn4 = new JButton("EN");
	    bntEn4.setBorder(new LineBorder(new Color(0, 0, 0)));
	    bntEn4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    loacalThread(new Locale("en_US"));
		}
	    });
	}
	return bntEn4;
    }

    private JButton getBtnEs4() {
	if (btnEs4 == null) {
	    btnEs4 = new JButton("ES");
	    btnEs4.setEnabled(false);
	    btnEs4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
	    btnEs4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    loacalThread(new Locale("es_ES"));
		}
	    });
	}
	return btnEs4;
    }

    private JPanel getPanel_9() {
	if (panel_9 == null) {
	    panel_9 = new JPanel();
	    panel_9.addComponentListener(new ComponentAdapter() {
		@Override
		public void componentResized(ComponentEvent e) {
		    resizePanel9();
		}
	    });
	    panel_9.setBorder(
		    new TitledBorder(null, "Cruise data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    panel_9.setBackground(Color.WHITE);
	    panel_9.setBounds(6, 41, 1024, 119);
	    panel_9.setLayout(null);
	    panel_9.add(getLblCruceroname());
	    panel_9.add(getLblBarconombre());
	    panel_9.add(getLblFechasalida());
	    panel_9.add(getLblDiascrucero());
	    panel_9.add(getLblSalidapuerto());
	    panel_9.add(getLblNpasajeros());
	    panel_9.add(getLblLblpicture());
	}
	return panel_9;
    }

    private void resizePanel9() {
	getLblLblpicture().setBounds(getPnCpn3().getWidth() - 173, getLblLblpicture().getY(),
		getLblLblpicture().getWidth(), getLblLblpicture().getHeight());
	revalidate();
	repaint();
    }

    private JLabel getLblCruceroname() {
	if (lblCruceroname == null) {
	    lblCruceroname = new JLabel(Messages.getString("VentanaPrincipal.lblCruceroname.text")); //$NON-NLS-1$
	    lblCruceroname.setBounds(6, 19, 259, 16);
	    lblCruceroname.setFont(text);
	}
	return lblCruceroname;
    }

    private JLabel getLblBarconombre() {
	if (lblBarconombre == null) {
	    lblBarconombre = new JLabel(Messages.getString("VentanaPrincipal.lblBarconombre.text")); //$NON-NLS-1$
	    lblBarconombre.setBounds(277, 19, 259, 16);
	    lblBarconombre.setFont(text);
	}
	return lblBarconombre;
    }

    private JLabel getLblFechasalida() {
	if (lblFechasalida == null) {
	    lblFechasalida = new JLabel(Messages.getString("VentanaPrincipal.lblFechasalida.text")); //$NON-NLS-1$
	    lblFechasalida.setBounds(558, 19, 259, 16);
	    lblFechasalida.setFont(text);
	}
	return lblFechasalida;
    }

    private JLabel getLblDiascrucero() {
	if (lblDiascrucero == null) {
	    lblDiascrucero = new JLabel(Messages.getString("VentanaPrincipal.lblDiascrucero.text")); //$NON-NLS-1$
	    lblDiascrucero.setBounds(6, 47, 259, 16);
	    lblDiascrucero.setFont(text);
	}
	return lblDiascrucero;
    }

    private JLabel getLblSalidapuerto() {
	if (lblSalidapuerto == null) {
	    lblSalidapuerto = new JLabel(Messages.getString("VentanaPrincipal.lblSalidapuerto.text")); //$NON-NLS-1$
	    lblSalidapuerto.setBounds(277, 47, 259, 16);
	    lblSalidapuerto.setFont(text);
	}
	return lblSalidapuerto;
    }

    private JLabel getLblNpasajeros() {
	if (lblNpasajeros == null) {
	    lblNpasajeros = new JLabel(Messages.getString("VentanaPrincipal.lblNpasajeros.text")); //$NON-NLS-1$
	    lblNpasajeros.setBounds(558, 47, 259, 16);
	    lblNpasajeros.setFont(text);
	}
	return lblNpasajeros;
    }

    private JLabel getLblLblpicture() {
	if (lblLblpicture == null) {
	    lblLblpicture = new JLabel(); // $NON-NLS-1$
	    lblLblpicture.setBounds(862, 11, 156, 103);
	}
	return lblLblpicture;
    }

    private JLabel getLblTotalrooms() {
	if (lblTotalrooms == null) {
	    lblTotalrooms = new JLabel(); // $NON-NLS-1$
	    lblTotalrooms.setHorizontalAlignment(SwingConstants.TRAILING);
	    lblTotalrooms.setBounds(938, 316, 92, 23);
	    lblTotalRooms.setFont(text);
	}
	return lblTotalrooms;
    }

    private JLabel getLblTotalextras() {
	if (lblTotalextras == null) {
	    lblTotalextras = new JLabel(); // $NON-NLS-1$
	    lblTotalextras.setHorizontalAlignment(SwingConstants.TRAILING);
	    lblTotalextras.setBounds(938, 344, 92, 23);
	    lblTotalextras.setFont(text);
	}
	return lblTotalextras;
    }

    private JLabel getLblTotaldiscount() {
	if (lblTotaldiscount == null) {
	    lblTotaldiscount = new JLabel(); // $NON-NLS-1$
	    lblTotaldiscount.setHorizontalAlignment(SwingConstants.TRAILING);
	    lblTotaldiscount.setBounds(938, 371, 92, 23);
	    lblTotaldiscount.setFont(text);
	}
	return lblTotaldiscount;
    }

    private JLabel getLblTotalPriceTotal() {
	if (lblTotalPriceTotal == null) {
	    lblTotalPriceTotal = new JLabel("New label");
	    lblTotalPriceTotal.setHorizontalAlignment(SwingConstants.TRAILING);
	    lblTotalPriceTotal.setBounds(771, 398, 136, 23);
	    lblTotalPriceTotal.setFont(textMedium);
	}
	return lblTotalPriceTotal;
    }

    private JLabel getLblTotalTotal() {
	if (lblTotalTotal == null) {
	    lblTotalTotal = new JLabel("totalDiscount");
	    lblTotalTotal.setHorizontalAlignment(SwingConstants.TRAILING);
	    lblTotalTotal.setBounds(938, 398, 92, 23);
	    lblTotalTotal.setFont(textMedium);
	}
	return lblTotalTotal;
    }

    // BEGIN CORE METHODS

    /**
     * Updates the list of available cruises taking in to account all the
     * filters. <br>
     * **FILTEERING**<br>
     * 1. Filters by are.<br>
     * 2. Filters by starting date.<br>
     * 3. Filters by starting port.<br>
     * 4. Filters by child acceptance.<br>
     * 5. Filters by discount availability.<br>
     * <br>
     * **SORTING**<br>
     * 6. Sorts the list as the user defines.<br>
     * <br>
     * **CHECKING EMTYNESS**<br>
     * 7. If empty throw a JOption pane warning and restore one combo to get
     * some cruises.<br>
     */
    private void updateListaCruceros() {

	// Initializing the list of cruise, just a good practice to avoid null
	// pointers...
	listaDeCruceros = new ArrayList<Crucero>();
	listaDeCruceros = Cruceros.getCruceros();

	// First filter: Filtering by area.
	if (getComboDestino().getSelectedItem() != Messages.getString("VentanaPrincipal.default_combo")
		&& getComboDestino().getSelectedItem() != null) {
	    listaDeCruceros = CollectionsCPM.filter(new FilterByArea(), listaDeCruceros,
		    getComboDestino().getSelectedItem().toString());
	}

	// Second filter: Filtering by starting date.
	if (getComboStartingDate().getSelectedItem() != Messages.getString("VentanaPrincipal.default_combo")
		&& getComboStartingDate().getSelectedItem() != null) {
	    SimpleDateFormat sdf = new SimpleDateFormat(CargarDatos.DATE_FORMAT_LONG, Messages.localization);
	    try {
		listaDeCruceros = CollectionsCPM.filter(new FilterByStartingDate(), listaDeCruceros,
			sdf.parse(getComboStartingDate().getSelectedItem().toString()));
	    } catch (ParseException e) {
		Files.writeLog(log, e.getMessage());
	    }
	}

	// Third filter: Filtering by starting port.
	if (getComboStartingPort().getSelectedItem() != Messages.getString("VentanaPrincipal.default_combo")
		&& getComboStartingPort().getSelectedItem() != null) {
	    listaDeCruceros = CollectionsCPM.filter(new FilterByStartingPort(), listaDeCruceros,
		    getComboStartingPort().getSelectedItem().toString());
	}

	// Fourth filter: Filtering by child acceptance.
	if (getCkbxAcceptsKids().isSelected()) {
	    listaDeCruceros = CollectionsCPM.filter(new FilterByChild(), listaDeCruceros,
		    getCkbxAcceptsKids().isSelected());
	}

	// Fifth filter: Filtering by discount availability.
	if (getCkbxDiscount().isSelected()) {
	    listaDeCruceros = CollectionsCPM.filter(new FilterByDiscount(), listaDeCruceros,
		    getCkbxDiscount().isSelected());
	}

	// Sorter and comparators implemented here.
	if (getComboSort().getSelectedItem() != Messages.getString("VentanaPrincipal.default_combo")
		&& getComboSort().getSelectedItem() != null) {
	    if (getComboSort().getSelectedItem().toString()
		    .equals(Messages.getString("VentanaPrincipal.ascending-price_label")))
		listaDeCruceros = CollectionsCPM.sort(listaDeCruceros, new CompareByPrice());
	    else if (getComboSort().getSelectedItem().toString()
		    .equals(Messages.getString("VentanaPrincipal.duration_label")))
		listaDeCruceros = CollectionsCPM.sort(listaDeCruceros, new CompareByDuration());
	    else if (getComboSort().getSelectedItem().toString()
		    .equals(Messages.getString("VentanaPrincipal.starting-date-comparator_label")))
		listaDeCruceros = CollectionsCPM.sort(listaDeCruceros, new CompareByStartingdate());
	}

	// Controlling that the resulting list is not empty.
	if (listaDeCruceros.isEmpty()) {
	    JOptionPane.showMessageDialog(this, Messages.getString("VentanaPrincipal.no-creuises-avaliable_message"));
	    getComboDestino().setSelectedItem(Messages.getString("VentanaPrincipal.default_combo"));
	}
    }

    /**
     * Initialize all the models corresponding with any combo box.<br>
     * Initialize the cruises list. Remove all the previous elements from the
     * models just in case. Insert the default element for each model and the
     * rest of the elements. Then will sort the models, call the
     * updateModelSortBy() and re-validate and repaint.
     */
    private void initializeModels() {
	// Creating a simple date format object to parse / format any date.
	SimpleDateFormat sdf = new SimpleDateFormat(CargarDatos.DATE_FORMAT_LONG, Messages.localization);

	// Updating the cruises list.
	listaDeCruceros = Cruceros.getCruceros();

	// Removing all the previous elements from the models. Good practice.
	modelDestination.removeAllElements();
	modelDate.removeAllElements();
	modelStartingPort.removeAllElements();

	// Inserting the default element at position 0 for all models
	modelDestination.insertElementAt(Messages.getString("VentanaPrincipal.default_combo"), 0);
	modelDate.insertElementAt(Messages.getString("VentanaPrincipal.default_combo"), 0);
	modelStartingPort.insertElementAt(Messages.getString("VentanaPrincipal.default_combo"), 0);

	// Inserting the rest of the elements for each combo box.
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

	// Sorting the combo boxes from the position 1 in order not to sort the
	// first and default element.
	modelDestination.sortFrom(1);
	modelDate.sortFrom(1);
	modelStartingPort.sortFrom(1);

	// The sort model has its own method to be initialize and updated.
	updateModelSortBy();

	// Finally we re-validate and repaint all the mainPane to ensure proper
	// display of cruises.
	revalidate();
	repaint();
    }

    /**
     * Updates the model described for the date combo box. Creates a toRemove
     * list of cruises that will be the ones deleted from the model. Then saves
     * the old state of the combo and add any extra ship to it. Finally if
     * possible will re-instantiate the old date as the selected one and will
     * sort the model again.
     */
    private void updateDateModel() {
	// Creates a list of elements that will be removed from the list of
	// cruises.
	List<Crucero> toRemove = CollectionsCPM.getDiference(Cruceros.getCruceros(), listaDeCruceros);

	// Creates the old-date object by checking the selected item. And create
	// a date format object.
	Object oldDate = getComboStartingDate().getSelectedItem();
	SimpleDateFormat sdf = new SimpleDateFormat(CargarDatos.DATE_FORMAT_LONG, Messages.localization);

	// For each date contained in the toRemove list we remove it from the
	// model.
	for (Crucero c : toRemove)
	    for (Date d : c.getSalidas())
		modelDate.removeElement(sdf.format(d));

	// Just checking if there is any cruise in the list cruise that is not
	// contained in the model and should we added now.
	for (Crucero c : listaDeCruceros)
	    for (Date d : c.getSalidas())
		if (modelDate.getIndexOf(sdf.format(d)) == -1)
		    modelDate.addElement(sdf.format(d));

	// Finally if the old date is in the new model we selected as the new
	// selected one.
	if (modelDate.getIndexOf(oldDate) != -1)
	    getComboStartingDate().setSelectedItem(oldDate);

	// Finally we sort the model.
	modelDate.sortFrom(1);
    }

    /**
     * Updates the model described for the date combo box. Creates a toRemove
     * list of cruises that will be the ones deleted from the model. Then saves
     * the old state of the combo and add any extra ship to it. Finally if
     * possible will re-instantiate the old date as the selected one and will
     * sort the model again.
     */
    private void updateStartingPortModel() {
	// Creates a list of elements that will be removed from the list of
	// cruises.
	List<Crucero> toRemove = CollectionsCPM.getDiference(Cruceros.getCruceros(), listaDeCruceros);

	// Creates the old-port object by checking the selected item.
	Object oldPort = getComboStartingPort().getSelectedItem();

	// For each cruise in toRemove we remove it from the model.
	for (Crucero c : toRemove)
	    modelStartingPort.removeElement(c.getStartPort());

	// Just checking if there is any cruise in the list of cruises that is
	// not contained in the model and should we added now.
	for (Crucero c : listaDeCruceros)
	    if (modelStartingPort.getIndexOf(c.getStartPort()) == -1)
		modelStartingPort.addElement(c.getStartPort());

	// Finally we try to restore the old state in the new combo box.
	if (modelStartingPort.getIndexOf(oldPort) != -1)
	    getComboStartingPort().setSelectedItem(oldPort);

	// Sorting the model.
	modelStartingPort.sortFrom(1);
    }

    /**
     * Load the cruises in the list of cruises in the list of results. For that
     * creates a container that will be displayed in the viewPort of an scroll
     * pane, then will create a CruceroListPanel for each cruise in the
     * listaCruceros and finally after setting some preferences will add this
     * component to the container and this container to the viewport of the
     * scroll pane. Finally will repaint and re-validate everything.
     */
    private void loadCruisesInList() {
	// Creating the container that will the displayed in the viewport of the
	// scroll pane.
	Container cont = new Container();

	// For each cruise in the list of cruises will create a
	// CruceroListPanel, set the action command and implement a new action
	// listener to travel between panes.
	for (Crucero c : listaDeCruceros) {
	    CruceroListPanel aux = new CruceroListPanel(c);
	    aux.getBtnSelect().setActionCommand(c.getCodigoCrucero());
	    aux.getBtnSelect().addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    // Loading the second pane.
		    loadSecondPane(c);

		    // Setting the current working ship.
		    setCurrentShip(c);
		}
	    });

	    // Setting the preferred size.
	    aux.setPreferredSize(new Dimension(getScSearch().getWidth(), 233));

	    // Finally adding the CruceroListPanel to the container.
	    cont.add(aux);
	}

	// Setting the layout for the container.
	cont.setLayout(new GridLayout(listaDeCruceros.size(), 1));

	// We re-validate and repaint all the mainPane
	revalidate();
	repaint();

	// Finally we set the viewport, we re-validate and we repaint to ensure
	// everything is being displayed correctly.
	getScSearch().getViewport().setView(cont);
	revalidate();
	repaint();
    }

    /**
     * Sets the current cruise.
     * 
     * @param c
     *            is the cruise advocated to be the new cruise.
     */
    private void setCurrentShip(Crucero c) {
	this.currentShip = c;
    }

    /**
     * For each extra will set its combo box to not visible (default state).
     */
    private void resetExtras() {
	for (Component c : getPnExtras2Panel().getComponents())
	    ((JCheckBox) c).setSelected(false);
    }

    /**
     * Removes all elements from the passengers model.
     */
    private void resetListaPasajeros() {
	getModelPasajeros().removeAllElements();
    }

    /**
     * Resets the configure your room pane.
     */
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
	((CardLayout) mainPane.getLayout()).show(mainPane, "info_crucero");
	getLblDuration2Panel().setText(
		Messages.getString("VentanaPrincipal.Duration-two-points_label") + Integer.toString(c.getDuracion())
			+ Messages.getString("VentanaPrincipal.days.-from_label") + Strings.deAccent(c.getStartPort()));
	getLblShipName2Panel()
		.setText(Messages.getString("VentanaPrincipal.onboard-the_label") + c.getBarco().getName());
	getTxtrTxtdescriptionlong().setText(Strings.deAccent(c.getDescripcion()));
	getPnRoom2Panel().setBorder(new TitledBorder(new LineBorder(Color.gray),
		Messages.getString("VentanaPrincipal.configure-your-room_label")));
	getBtnAddRoom().setText(Messages.getString("VentanaPrincipal.add-room_label"));

	DefaultComboBoxModel<String> dates = new DefaultComboBoxModel<String>();
	dates.addElement(Messages.getString("VentanaPrincipal.select-date_label"));
	for (Date d : c.getSalidas()) {
	    SimpleDateFormat sdf = new SimpleDateFormat(CargarDatos.DATE_FORMAT_LONG, Messages.localization);
	    dates.addElement(sdf.format(d));
	}
	getCmbDate2Panel().setModel(dates);
	getCmbDate2Panel().setSelectedIndex(0);

	getCmbTypeOfRoom2Panl().removeAllItems();
	getCmbTypeOfRoom2Panl().addItem(Messages.getString("VentanaPrincipal.double-exterior_label"));
	getCmbTypeOfRoom2Panl().addItem(Messages.getString("VentanaPrincipal.double-interior_label"));
	getCmbTypeOfRoom2Panl().addItem(Messages.getString("VentanaPrincipal.familiar-exterior_label"));
	getCmbTypeOfRoom2Panl().addItem(Messages.getString("VentanaPrincipal.familiar-interior_label"));
	getCmbTypeOfRoom2Panl().setSelectedIndex(0);

	resetConfigureRoomPanel();
	updateRoomCapacityLabel();
	getModeloNoEditable().removeAll();

    }

    private void updateRoomCapacityLabel() {
	if (getCmbTypeOfRoom2Panl().getSelectedItem() != null) {
	    if (getCmbTypeOfRoom2Panl().getSelectedItem().toString()
		    .equals(Messages.getString("VentanaPrincipal.double-exterior_label"))) {
		getLblCapacity2Panel().setText(Messages.getString("VentanaPrincipal.this-room-has-capacity-for_label")
			+ Integer.toString(CamaroteDoble.N_PERSONS)
			+ Messages.getString("VentanaPrincipal.this-room-has-capacity-for_tail_label"));
	    } else if (getCmbTypeOfRoom2Panl().getSelectedItem().toString()
		    .equals(Messages.getString("VentanaPrincipal.double-interior_label"))) {
		getLblCapacity2Panel().setText(Messages.getString("VentanaPrincipal.this-room-has-capacity-for_label")
			+ Integer.toString(CamaroteDoble.N_PERSONS)
			+ Messages.getString("VentanaPrincipal.this-room-has-capacity-for_tail_label"));
	    } else if (getCmbTypeOfRoom2Panl().getSelectedItem().toString()
		    .equals(Messages.getString("VentanaPrincipal.familiar-exterior_label"))) {
		getLblCapacity2Panel().setText(Messages.getString("VentanaPrincipal.this-room-has-capacity-for_label")
			+ Integer.toString(CamaroteFamiliar.N_PERSONS)
			+ Messages.getString("VentanaPrincipal.this-room-has-capacity-for_tail_label"));
	    } else if (getCmbTypeOfRoom2Panl().getSelectedItem().toString()
		    .equals(Messages.getString("VentanaPrincipal.familiar-interior_label"))) {
		getLblCapacity2Panel().setText(Messages.getString("VentanaPrincipal.this-room-has-capacity-for_label")
			+ Integer.toString(CamaroteFamiliar.N_PERSONS)
			+ Messages.getString("VentanaPrincipal.this-room-has-capacity-for_tail_label"));
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
	currentReserva.setCamarotes(getModeloNoEditable().getCamarotes());
	resetPersonalInfo();
	update3Panel();
	((CardLayout) getContentPane().getLayout()).show(mainPane, "resumen_de_compra");
    }

    private void update3Panel() {
	SimpleDateFormat sdf = new SimpleDateFormat(CargarDatos.DATE_FORMAT_LONG, Messages.localization);
	double precioHabitaciones = currentReserva.getCamarotesPrice();
	double precioExtras = currentReserva.getExtrasPrice();
	double descuento = currentReserva.getDiscount();

	getPanel_9().setBorder(new TitledBorder(new LineBorder(Color.lightGray),
		Messages.getString("VentanaPrincipal.datos-crucero_border")));
	getLblCruceroname().setText(Messages.getString("VentanaPrincipal.lblCruceroname.text") + ": "
		+ currentReserva.getCrucero().getDenominacion());
	getLblBarconombre().setText(Messages.getString("VentanaPrincipal.lblBarconombre.text") + ": "
		+ currentReserva.getCrucero().getBarco().getName());
	getLblFechasalida().setText(Messages.getString("VentanaPrincipal.lblFechasalida.text") + ": "
		+ sdf.format(currentReserva.getFechaSalida()));
	getLblDiascrucero().setText(Messages.getString("VentanaPrincipal.lblDiascrucero.text") + ": "
		+ Integer.toString(currentReserva.getCrucero().getDuracion()));
	getLblSalidapuerto().setText((Messages.getString("VentanaPrincipal.lblSalidapuerto.text") + ": "
		+ currentReserva.getCrucero().getStartPort()));
	getLblNpasajeros().setText(
		Messages.getString("VentanaPrincipal.lblNpasajeros.text") + ": " + currentReserva.getTotalPasajeros());
	getLblLblpicture().setIcon(Images.resize(getLblLblpicture(), currentReserva.getCrucero().getPicturePath()));

	getLblTotalRooms().setText(Messages.getString("VentanaPrincipal.total-rooms_lable") + ": ");
	getLblTotalrooms().setText(precioHabitaciones + " " + Messages.getString("VentanaPrincipal.money_symbol"));

	getLblTotalExtras().setText(Messages.getString("VentanaPrincipal.total-extras_label") + ": ");
	getLblTotalextras().setText(precioExtras + " " + Messages.getString("VentanaPrincipal.money_symbol"));

	getLblTotalDiscount().setText(Messages.getString("VentanaPrincipal.total-descuento_label") + ": ");

	getLblTotaldiscount()
		.setText(Double.toString(descuento) + " " + Messages.getString("VentanaPrincipal.money_symbol"));
	getLblTotalTotal().setText(Double.toString(precioHabitaciones + precioExtras - descuento) + " "
		+ Messages.getString("VentanaPrincipal.money_symbol"));

	getLblTotalPriceTotal().setText(Messages.getString("VentanaPrincipal.total-price_label") + ": ");
    }

    private void initializeModeloTable() {
	List<String> nombreColumnas = new ArrayList<String>();
	nombreColumnas.add(Messages.getString("VentanaPrincipal.number_symbol"));
	nombreColumnas.add(Messages.getString("VentanaPrincipal.type-of-room_label"));
	nombreColumnas.add(Messages.getString("VentanaPrincipal.passengers_label"));
	for (Extra e : Extras.getExtras()) {
	    nombreColumnas.add(e.getExtra());
	}
	nombreColumnas.add(Messages.getString("VentanaPrincipal.room-price-per-nigth_label"));
	nombreColumnas.add(Messages.getString("VentanaPrincipal.room-price-total_label"));
	String[] stringArray = nombreColumnas.toArray(new String[nombreColumnas.size()]);
	modeloTable = new ModeloTablaNoEditable(stringArray, 0, currentReserva);
    }

    private void checkDate2Panel() throws ParseException {
	if (cmbDate2Panel.getSelectedItem() != null && cmbDate2Panel.getSelectedIndex() != 0) {

	    enablePnRoomsAll();

	    SimpleDateFormat sdf = new SimpleDateFormat(CargarDatos.DATE_FORMAT_LONG, Messages.localization);
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
	    getCmbTypeOfRoom2Panl().addItem(Messages.getString("VentanaPrincipal.double-exterior_label"));
	if (currentViaje.getCamarotesDoblesInterioresLibres() > 0)
	    getCmbTypeOfRoom2Panl().addItem(Messages.getString("VentanaPrincipal.double-interior_label"));
	if (currentViaje.getCamarotesFamiliaresEterioresLibres() > 0)
	    getCmbTypeOfRoom2Panl().addItem(Messages.getString("VentanaPrincipal.familiar-exterior_label"));
	if (currentViaje.getCamarotesFamiliaresInterioresLibres() > 0)
	    getCmbTypeOfRoom2Panl().addItem(Messages.getString("VentanaPrincipal.familiar-interior_label"));

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
	getLblFreeDoubleExterior().setText(Messages.getString("VentanaPrincipal.free-double-exterior-two-points_label")
		+ Integer.toString(currentViaje.getCamarotesDoblesExterioresLibres()));
	getLblFreeDoubleInterior().setText(Messages.getString("VentanaPrincipal.free-double-interior-two-points_label")
		+ Integer.toString(currentViaje.getCamarotesDoblesInterioresLibres()));
	getLblFreeFamiliarExterior()
		.setText(Messages.getString("VentanaPrincipal.free-familiar-exterior-two-points_label")
			+ Integer.toString(currentViaje.getCamarotesFamiliaresEterioresLibres()));
	getLblFreeFamiliarInterior()
		.setText(Messages.getString("VentanaPrincipal.free-familiar-interior-two-points_label")
			+ Integer.toString(currentViaje.getCamarotesFamiliaresInterioresLibres()));
    }

    private void locateViaje(Crucero c, Date d) {
	this.currentViaje = c.getViaje(d);
    }

    private void checkAddPasajero() {
	int people = getLstPassengers2Panel().getModel().getSize();
	int size = getPeopleInCabin();
	if (people > size) {
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
	    if (getCmbTypeOfRoom2Panl().getSelectedItem().toString()
		    .equals(Messages.getString("VentanaPrincipal.double-exterior_label"))) {
		size = CamaroteDoble.N_PERSONS;
	    } else if (getCmbTypeOfRoom2Panl().getSelectedItem().toString()
		    .equals(Messages.getString("VentanaPrincipal.double-interior_label"))) {
		size = CamaroteDoble.N_PERSONS;
	    } else if (getCmbTypeOfRoom2Panl().getSelectedItem().toString()
		    .equals(Messages.getString("VentanaPrincipal.familiar-exterior_label"))) {
		size = CamaroteFamiliar.N_PERSONS;
	    } else if (getCmbTypeOfRoom2Panl().getSelectedItem().toString()
		    .equals(Messages.getString("VentanaPrincipal.familiar-interior_label"))) {
		size = CamaroteFamiliar.N_PERSONS;
	    }
	}
	return size;
    }

    private Pasajero addPasajero() {
	String input = JOptionPane.showInputDialog(mainPane, Messages.getString("VentanaPrincipal.insert-age_message"));
	int age = -1;
	if (input != null)
	    try {
		age = Integer.parseInt(input);
	    } catch (NumberFormatException e1) {
		Files.writeLog(log, e1.getMessage());
	    }
	while ((age < 0 || age > 150) && input != null) {
	    input = JOptionPane.showInputDialog(mainPane,
		    Messages.getString("VentanaPrincipal.insert-age_message_warning"));
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
	String input = JOptionPane.showInputDialog(mainPane,
		Messages.getString("VentanaPrincipal.insert-age-kid_message"));
	int age = -1;
	if (input != null)
	    try {
		age = Integer.parseInt(input);
	    } catch (NumberFormatException e1) {
		Files.writeLog(log, e1.getMessage());
	    }
	while ((age < 0 || age > 16) && input != null) {
	    input = JOptionPane.showInputDialog(mainPane,
		    Messages.getString("VentanaPrincipal.insert-age-kid_message_warning"));
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
	if (getModeloNoEditable().getRowCount() > 0) {
	    getPnRooms2Panel().setEnabled(true);
	    getTbRooms().setEnabled(true);
	} else {
	    getPnRooms2Panel().setEnabled(false);
	    getTbRooms().setEnabled(false);
	}
    }

    private void checkIfIsThereRooms() {
	if (getCmbTypeOfRoom2Panl().getSelectedItem() != null) {
	    if (getCmbTypeOfRoom2Panl().getSelectedItem().toString()
		    .equals(Messages.getString("VentanaPrincipal.double-exterior_label"))
		    && currentViaje.getCamarotesDoblesExterioresLibres() == 0) {
		getBtnAddRoom().setEnabled(false);
	    } else if (getCmbTypeOfRoom2Panl().getSelectedItem().toString()
		    .equals(Messages.getString("VentanaPrincipal.double-interior_label"))
		    && currentViaje.getCamarotesDoblesInterioresLibres() == 0) {
		getBtnAddRoom().setEnabled(false);
	    } else if (getCmbTypeOfRoom2Panl().getSelectedItem().toString()
		    .equals(Messages.getString("VentanaPrincipal.familiar-exterior_label"))
		    && currentViaje.getCamarotesFamiliaresEterioresLibres() == 0) {
		getBtnAddRoom().setEnabled(false);
	    } else if (getCmbTypeOfRoom2Panl().getSelectedItem().toString()
		    .equals(Messages.getString("VentanaPrincipal.familiar-interior_label"))
		    && currentViaje.getCamarotesDoblesInterioresLibres() == 0) {
		getBtnAddRoom().setEnabled(false);
	    } else {
		getBtnAddRoom().setEnabled(true);
	    }
	}
    }

    private void loadRoomOnToTable() {
	Camarote c = null;
	if (getCmbTypeOfRoom2Panl().getSelectedItem() != null) {
	    if (getCmbTypeOfRoom2Panl().getSelectedItem().toString()
		    .equals(Messages.getString("VentanaPrincipal.double-exterior_label"))) {
		c = currentViaje.getCamaroteDobleExteriorLibre();
	    } else if (getCmbTypeOfRoom2Panl().getSelectedItem().toString()
		    .equals(Messages.getString("VentanaPrincipal.double-interior_label"))) {
		c = currentViaje.getCamaroteDobleInteriorLibre();
	    } else if (getCmbTypeOfRoom2Panl().getSelectedItem().toString()
		    .equals(Messages.getString("VentanaPrincipal.familiar-exterior_label"))) {
		c = currentViaje.getCamaroteFamiliarExteriorLibre();
	    } else if (getCmbTypeOfRoom2Panl().getSelectedItem().toString()
		    .equals(Messages.getString("VentanaPrincipal.familiar-interior_label"))) {
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

	modeloTable.addRow(c, currentShip.getDuracion());
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
	getLblFreeDoubleExterior().setText(Messages.getString("VentanaPrincipal.free-double-exterior_label"));
	getLblFreeDoubleInterior().setText(Messages.getString("VentanaPrincipal.free-double-interior_label"));
	getLblFreeFamiliarExterior().setText(Messages.getString("VentanaPrincipal.free-familiar-exterior_label"));
	getLblFreeFamiliarInterior().setText(Messages.getString("VentanaPrincipal.free-familiar-interior_label"));
    }

    private void resetPersonalInfo() {
	getTxtName().setText("");
	getTxtSurname().setText("");
	getTxtDNI().setText("");
	getTxtPhone().setText("");
    }

    private void loacalThread(Locale local) {
	Messages.localization = local;
	LoadingDialog loading = new LoadingDialog(mainPane, Messages.getString("LoadingDialog.changing-language_label"),
		Messages.getString("LoadingDialog.changing-language_title"));

	SwingWorker<Void, Void> sw = new SwingWorker<Void, Void>() {
	    @Override
	    protected Void doInBackground() throws Exception {
		local(local);
		return null;
	    }

	    @Override
	    protected void done() {
		loading.dispose();// close the modal dialog
	    }
	};

	sw.execute(); // this will start the processing on a separate thread
	loading.setVisible(true); // this will block user input as long as
				  // the processing task is working
    }

    private void resizePnRoom2Panel() {
	getPnExtras2Panel().setBounds(getPnRoom2Panel().getWidth() - 350, getPnExtras2Panel().getY(),
		getPnExtras2Panel().getWidth(), getPnExtras2Panel().getHeight());
	getPnPassengers2Panel().setBounds(getPnPassengers2Panel().getX(), getPnPassengers2Panel().getY(),
		getPnRoom2Panel().getWidth() - 386, getPnPassengers2Panel().getHeight());
	getBtnAddRoom().setBounds(getPnRoom2Panel().getWidth() - 153, getBtnAddRoom().getY(),
		getBtnAddRoom().getWidth(), getBtnAddRoom().getHeight());
	repaint();
	revalidate();
    }

    private void resize2Pane() {
	getPnTripStatus().setBounds(getPanel2CPanel().getWidth() - 239, getPnTripStatus().getY(),
		getPnTripStatus().getWidth(), getPnTripStatus().getHeight());
	getPanel_3().setBounds(getPanel_3().getX(), getPanel_3().getY(), getPanel2CPanel().getWidth() - 680,
		getPanel_3().getHeight());
	getPnRoom2Panel().setBounds(getPnRoom2Panel().getX(), getPnRoom2Panel().getY(),
		getPanel2CPanel().getWidth() - 12, getPnRoom2Panel().getHeight());
	getPnRooms2Panel().setBounds(getPnRooms2Panel().getX(), getPnRooms2Panel().getY(),
		getPanel2CPanel().getWidth() - 12, getPanel2CPanel().getHeight() - 446);
	repaint();
	revalidate();
    }

    private void local(Locale local) {
	setButtonLanguage(local);
	// Updating the title of the application
	setTitle(Messages.getString("VentanaPrincipal.title_window"));

	initializeModels();
	getLblSerach().setText(Messages.getString("VentanaPrincipal.search_label"));
	getLblDestino().setText(Messages.getString("VentanaPrincipal.destination_label"));
	getLblStartingDate().setText(Messages.getString("VentanaPrincipal.starting-date_label"));
	getLblStartingPort().setText(Messages.getString("VentanaPrincipal.starting-port_label"));
	getLblListOfAvaliable().setText(Messages.getString("VentanaPrincipal.title-search_label"));
	getCkbxAcceptsKids().setText(Messages.getString("VentanaPrincipal.accepts-kids_label"));
	getCkbxDiscount().setText(Messages.getString("VentanaPrincipal.discount_label"));
	getLblMoreCriteria().setText(Messages.getString("VentanaPrincipal.more-criteria_label"));
	getLblSortBy().setText(Messages.getString("VentanaPrincipal.sort-by_label"));
	getPnRoom2Panel()
		.setBorder(new TitledBorder(null, Messages.getString("VentanaPrincipal.configure-the-room_label"),
			TitledBorder.LEADING, TitledBorder.TOP, null, null));
	getPnRooms2Panel().setBorder(new TitledBorder(null, Messages.getString("VentanaPrincipal.your-rooms_label"),
		TitledBorder.LEADING, TitledBorder.TOP, null, null));
	getBtnConfirm().setText(Messages.getString("VentanaPrincipal.continue-to-summary_label"));
	getLblTypeOfRoom2Panel().setText(Messages.getString("VentanaPrincipal.type-of-room-two-points_label"));
	getLblCapacity2Panel().setText(Messages.getString("VentanaPrincipal.capacity-for_label"));
	getPnPassengers2Panel()
		.setBorder(new TitledBorder(null, Messages.getString("VentanaPrincipal.passengers_label"),
			TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	getBtnAddPassanger().setText(Messages.getString("VentanaPrincipal.add-passenger_label"));
	getBtnDeletePassanger().setText(Messages.getString("VentanaPrincipal.delete-passenger_label"));
	getBtnModifyPassenger().setText(Messages.getString("VentanaPrincipal.modify_label"));
	getChckbxAddExtraBed().setText(Messages.getString("VentanaPrincipal.add-extra-bed_label"));
	getChckbxJacuzzi().setText(Messages.getString("VentanaPrincipal.jacuzzy_label"));
	getChckbxSpecialBreakfast().setText(Messages.getString("VentanaPrincipal.special-breakfast_label"));
	getChckbxExtrabigBed().setText(Messages.getString("VentanaPrincipal.extra-big-bed_label"));
	getPnExtras2Panel().setBorder(new TitledBorder(null, Messages.getString("VentanaPrincipal.extras_label"),
		TitledBorder.LEADING, TitledBorder.TOP, null, null));
	getBtnAddRoom().setText(Messages.getString("VentanaPrincipal.add-room_label"));
	getBtnDeleteRoom().setText(Messages.getString("VentanaPrincipal.delete-room_label"));
	getBtnNewButton_1().setText(Messages.getString("VentanaPrincipal.go-back_label"));
	getBtnConfirmAndPay().setText(Messages.getString("VentanaPrincipal.confirm-and-pay_label"));
	getLblSummary().setText(Messages.getString("VentanaPrincipal.summary_label"));
	getPanel().setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
		Messages.getString("VentanaPrincipal.personal-payment-info_label"), TitledBorder.LEADING,
		TitledBorder.TOP, null, new Color(0, 0, 0)));
	getLblName().setText(Messages.getString("VentanaPrincipal.name_label"));
	getLblSurname().setText(Messages.getString("VentanaPrincipal.surname_label"));
	getLblDni().setText(Messages.getString("VentanaPrincipal.dni_label"));
	getLblPhone().setText(Messages.getString("VentanaPrincipal.phone_label"));
	getPanel_5().setBorder(new TitledBorder(null, Messages.getString("VentanaPrincipal.purchase-receipt_label"),
		TitledBorder.LEADING, TitledBorder.TOP, null, null));
	getLblReceiptTitle().setText(Messages.getString("VentanaPrincipal.purchase-receipt_label"));
	getPanel_3().setBorder(new TitledBorder(null, Messages.getString("VentanaPrincipal.description-cruise_label"),
		TitledBorder.LEADING, TitledBorder.TOP, null, null));
	getPnTripStatus().setBorder(new TitledBorder(null, Messages.getString("VentanaPrincipal.cruise-status_label"),
		TitledBorder.LEADING, TitledBorder.TOP, null, null));
	getLblFreeDoubleInterior().setText(Messages.getString("VentanaPrincipal.free-double-interior_label"));
	getLblFreeDoubleExterior().setText(Messages.getString("VentanaPrincipal.free-double-exterior_label"));
	getLblFreeFamiliarInterior().setText(Messages.getString("VentanaPrincipal.free-familiar-interior_label"));
	getLblFreeFamiliarExterior().setText(Messages.getString("VentanaPrincipal.free-familiar-exterior_label"));
	getBtnGoToInicio().setText(Messages.getString("VentanaPrincipal.start-app_label"));
	getBtnCheckDate().setText(Messages.getString("VentanaPrincipal.change-date_label"));
	getBtnModifyRoom().setText(Messages.getString("VentanaPrincipal.modify-room_label"));
	getBtnNewButton().setText(Messages.getString("VentanaPrincipal.back-to-search_label"));
	update3Panel();
    }

    private void updateModelSortBy() {
	modeloSortBy.removeAllElements();
	modeloSortBy.insertElementAt(Messages.getString("VentanaPrincipal.default_combo"), 0);
	modeloSortBy.addElement(Messages.getString("VentanaPrincipal.ascending-price_label"));
	modeloSortBy.addElement(Messages.getString("VentanaPrincipal.starting-date_label"));
	modeloSortBy.addElement(Messages.getString("VentanaPrincipal.duration_label"));
	modeloSortBy.sortFrom(1);
    }

    private void setButtonLanguage(Locale locale) {
	if (locale.equals(new Locale("en_US"))) {
	    getBtnEn().setEnabled(false);
	    getBtnEn2().setEnabled(false);
	    getBtnEn3().setEnabled(false);
	    getBntEn4().setEnabled(false);
	    getBtnEs().setEnabled(true);
	    getBtnES2().setEnabled(true);
	    getBtnEs3().setEnabled(true);
	    getBtnEs4().setEnabled(true);
	} else {
	    getBtnEn().setEnabled(true);
	    getBtnEn2().setEnabled(true);
	    getBtnEn3().setEnabled(true);
	    getBntEn4().setEnabled(true);
	    getBtnEs().setEnabled(false);
	    getBtnES2().setEnabled(false);
	    getBtnEs3().setEnabled(false);
	    getBtnEs4().setEnabled(false);
	}
    }

    private void setUpHelp() {
	try {
	    File fichero = new File("com/guille/cpm/help/Ayuda.hs");
	    hsURL = fichero.toURI().toURL();
	    hs = new HelpSet(null, hsURL);
	}

	catch (Exception e) {
	    System.out.println("Help not found/Ayuda no encontrada");
	    return;
	}

	hb = hs.createHelpBroker();
	hb.enableHelpKey(getRootPane(), "introduction", hs);
    }
}
