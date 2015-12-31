package com.guille.cpm.igu;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import com.guille.fonts.myriadSetPro.MyriadSetPro;
import com.guille.util.CollectionsCPM;
import com.guille.util.Images;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
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
import javax.swing.ScrollPaneLayout;
import javax.swing.border.MatteBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = -8029479718163458536L;
	protected static final Font text = new MyriadSetPro().getMyriad_Set_Pro_Text().deriveFont(14f);
	protected static final Font textBold = new MyriadSetPro().getMyriad_Set_Pro_Semibold().deriveFont(14f);
	protected static final Font subtitleBold = new MyriadSetPro().getMyriad_Set_Pro_Semibold().deriveFont(20f);
	protected static final Font textMedium = new MyriadSetPro().getMyriad_Set_Pro_Medium().deriveFont(17f);
	public static final String DEFAULT_COMBO_TEXT = "It doesn't matter";

	private JPanel mainPane;
	private JPanel panel1;
	private JPanel wPanel;
	private JLabel lblSerach;
	private JSeparator separator;
	private JLabel lblDestino;
	private JComboBox<String> comboDestino;
	private JLabel lblStartingDate;
	private JComboBox<String> comboStartingDate;

	private List<Crucero> listaDeCruceros = new ArrayList<Crucero>();
	private JLabel lblStartingPort;
	private JComboBox<String> comboStartingPort;
	private JPanel cPanel;
	private JScrollPane scSearch;
	private JPanel cPanelNPanel;
	private JLabel lblListOfAvaliable;
	private JCheckBox ckbxAcceptsKids;
	private JCheckBox ckbxDiscount;
	private JLabel lblMoreCriteria;
	private JSeparator separator_1;
	private JPanel panel2;
	private JLabel lblSortBy;
	private JSeparator separator_2;
	private JComboBox<String> comboSort;
	private JComboBox<String> comboDuration;
	private JLabel lblDuration;

	private DefaultComboBoxModel<String> modelDestination;
	private DefaultComboBoxModel<String> modelDate;
	private DefaultComboBoxModel<String> modelStartingPort;
	private JPanel panel2NPanel;
	private JPanel panel2SPanel;
	private JPanel panel2CPanel;
	private JPanel panel2NPanelEPanel;
	private JPanel panel2NPanelWPanel;
	private JPanel panel2NPanelNpanel;
	private JButton btnNewButton;
	private JLabel lblImgShipPanel2;
	private JPanel pnRoom2Panel;
	private JPanel pnRooms2Panel;
	private JButton btnConfirm;
	private JScrollPane scrollPane;
	private JTable tbRooms;
	private ModeloNoEditable modeloTable;
	private JLabel lblDescripcion2Panel;
	private JLabel lblDuration2Panel;
	private JLabel lblShipName2Panel;
	private JComboBox<String> cmbDate2Panel;
	private JLabel lblTypeOfRoom2Panel;
	private JComboBox<String> cmbTypeOfRoom2Panl;
	private JLabel lblCapacity2Panel;
	private JPanel pnPassengers2Panel;
	private JScrollPane scPassengers2Panel;
	private JList lstPassengers2Panel;
	private JPanel pnSouthPassengers2Panel;
	private JButton btnAddPassanger;
	private JButton btnDeletePassanger;
	private JButton btnModifyPassenger;
	private JCheckBox chckbxAddExtraBed;
	private JCheckBox chckbxJacuzzi;
	private JCheckBox chckbxSpecialBreakfast;
	private JCheckBox chckbxExtrabigBed;
	private JPanel pnExtras2Panel;
	private JButton btnAddRoob;

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
	 * 
	 * @throws IOException
	 */
	public VentanaPrincipal() throws IOException {
		setMinimumSize(new Dimension(1046, 661));
		CargarDatos.cargarDatos();
		modelDestination = new DefaultComboBoxModel<String>();
		modelDate = new DefaultComboBoxModel<String>();
		modelStartingPort = new DefaultComboBoxModel<String>();

		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/com/guille/cpm/img/appIcon.png")));
		setLocationByPlatform(true);
		setTitle("EII CRUCEROS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1046, 661);
		mainPane = new JPanel();
		mainPane.setBackground(Color.WHITE);
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(new CardLayout(0, 0));
		mainPane.add(getPanel1(), "busqueda_inicio");
		mainPane.add(getPanel2(), "info_crucero");
		initializeModels();
		loadCruisesInList();
	}

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

				System.err.println("Error while parsing date from the starting date combo.");

				e.printStackTrace();

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
		/**
		 * comboSort.addItem("Ascending price"); comboSort.addItem("Duration");
		 * comboSort.addItem("Starting date");
		 */
		if (getComboSort().getSelectedItem() != DEFAULT_COMBO_TEXT && getComboSort().getSelectedItem() != null) {
			if (getComboSort().getSelectedItem().toString().equals("Ascending price"))
				listaDeCruceros = CollectionsCPM.sort(listaDeCruceros, new CompareByPrice());
			else if (getComboSort().getSelectedItem().toString().equals("Duration"))
				listaDeCruceros = CollectionsCPM.sort(listaDeCruceros, new CompareByDuration());
			else if (getComboSort().getSelectedItem().toString().equals("Starting date"))
				listaDeCruceros = CollectionsCPM.sort(listaDeCruceros, new CompareByStartingdate());
		}
		if (listaDeCruceros.isEmpty()) {
			JOptionPane.showMessageDialog(this, "There're no cruises avaliable for your search. Try another");

			getComboDestino().setSelectedItem(DEFAULT_COMBO_TEXT);
		}
	}

	private void initializeModels() {
		SimpleDateFormat sdf = new SimpleDateFormat(CargarDatos.DATE_FORMAT_LONG);
		listaDeCruceros = Cruceros.getCruceros();

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
	
	private void loadSecondPane(Crucero c) {
		System.out.println(c.getCodigoCrucero());
		getLblImgShipPanel2().setIcon(Images.resize(getLblImgShipPanel2(), c.getPicturePath()));
		getLblDescripcion2Panel().setText(c.getDenominacion());
		 ((CardLayout)mainPane.getLayout()).show(mainPane,"info_crucero");
		
	}

	protected ModeloNoEditable getModeloNoEditable() {
		return this.modeloTable;
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
			wPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) Color.LIGHT_GRAY));
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
			lblSerach = new JLabel("Search");
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
			lblDestino = new JLabel("Destino");
			lblDestino.setFont(text);
			lblDestino.setBounds(6, 52, 61, 16);
		}
		return lblDestino;
	}

	private JComboBox<String> getComboDestino() {
		if (comboDestino == null) {
			comboDestino = new JComboBox<String>();
			comboDestino.setModel(modelDestination);
			comboDestino.addItemListener(new ItemListener() {
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
			lblStartingDate = new JLabel("Starting Date");
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
			lblStartingPort = new JLabel("Starting Port");
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
			cPanelNPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
			cPanelNPanel.setBackground(Color.WHITE);
			cPanelNPanel.setPreferredSize(new Dimension(0, 30));
			cPanelNPanel.setLayout(new BorderLayout(0, 0));
			cPanelNPanel.add(getLblListOfAvaliable(), BorderLayout.CENTER);
		}
		return cPanelNPanel;
	}

	private JLabel getLblListOfAvaliable() {
		if (lblListOfAvaliable == null) {
			lblListOfAvaliable = new JLabel("LIST OF AVALIABLE CRUISES");
			lblListOfAvaliable.setHorizontalAlignment(SwingConstants.CENTER);
			lblListOfAvaliable.setFont(subtitleBold);
		}
		return lblListOfAvaliable;
	}

	private JCheckBox getCkbxAcceptsKids() {
		if (ckbxAcceptsKids == null) {
			ckbxAcceptsKids = new JCheckBox("Accepts kids");
			ckbxAcceptsKids.addActionListener(new ActionListener() {
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
			ckbxDiscount = new JCheckBox("Discount");
			ckbxDiscount.setBounds(6, 296, 128, 23);
			ckbxDiscount.setFont(text);
			ckbxDiscount.addActionListener(new ActionListener() {
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
			lblMoreCriteria = new JLabel("More Criteria");
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
			lblSortBy = new JLabel("Sort By...");
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
			comboSort.addItem("Ascending price");
			comboSort.addItem("Duration");
			comboSort.addItem("Starting date");
			comboSort.addActionListener(new ActionListener() {
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
			lblDuration = new JLabel("Duration");
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
			panel2SPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel2SPanel.add(getBtnConfirm());
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
			btnNewButton = new JButton("go back");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) getContentPane().getLayout()).show(mainPane, "busqueda_inicio");
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
			pnRoom2Panel.setEnabled(false);
			pnRoom2Panel.setBackground(Color.WHITE);
			pnRoom2Panel.setBorder(new TitledBorder(null, "Configure the room", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnRoom2Panel.setBounds(6, 197, 1024, 179);
			pnRoom2Panel.setLayout(null);
			pnRoom2Panel.add(getLblTypeOfRoom2Panel());
			pnRoom2Panel.add(getCmbTypeOfRoom2Panl());
			pnRoom2Panel.add(getLblCapacity2Panel());
			pnRoom2Panel.add(getPnPassengers2Panel());
			pnRoom2Panel.add(getPnExtras2Panel());
			pnRoom2Panel.add(getBtnAddRoob());
		}
		return pnRoom2Panel;
	}

	private JPanel getPnRooms2Panel() {
		if (pnRooms2Panel == null) {
			pnRooms2Panel = new JPanel();
			pnRooms2Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			pnRooms2Panel.setBackground(Color.WHITE);
			pnRooms2Panel.setBounds(6, 388, 1024, 167);
			pnRooms2Panel.setLayout(new BorderLayout(0, 0));
			pnRooms2Panel.add(getScrollPane(), BorderLayout.CENTER);
		}
		return pnRooms2Panel;
	}

	private JButton getBtnConfirm() {
		if (btnConfirm == null) {
			btnConfirm = new JButton("Confirm");
		}
		return btnConfirm;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTbRooms());
		}
		return scrollPane;
	}

	private JTable getTbRooms() {
		if (tbRooms == null) {
			List<String> nombreColumnas = new ArrayList<String>();
			nombreColumnas.add("Nº");
			nombreColumnas.add("Type of Room");
			nombreColumnas.add("Passengers");
			for (Extra e : Extras.getExtras()) {
				nombreColumnas.add(e.getExtra());
			}
			nombreColumnas.add("Room Price");
			modeloTable = new ModeloNoEditable(nombreColumnas.toArray(), 0);
			tbRooms = new JTable(modeloTable);
			tbRooms.setShowVerticalLines(false);
			tbRooms.getTableHeader().setReorderingAllowed(false);
			tbRooms.getTableHeader().setResizingAllowed(false);
		}
		return tbRooms;
	}

	private JLabel getLblDescripcion2Panel() {
		if (lblDescripcion2Panel == null) {
			lblDescripcion2Panel = new JLabel("New label");
			lblDescripcion2Panel.setBounds(188, 6, 154, 28);
		}
		return lblDescripcion2Panel;
	}

	private JLabel getLblDuration2Panel() {
		if (lblDuration2Panel == null) {
			lblDuration2Panel = new JLabel("New label");
			lblDuration2Panel.setBounds(188, 35, 310, 28);
		}
		return lblDuration2Panel;
	}

	private JLabel getLblShipName2Panel() {
		if (lblShipName2Panel == null) {
			lblShipName2Panel = new JLabel("New label");
			lblShipName2Panel.setBounds(188, 66, 310, 28);
		}
		return lblShipName2Panel;
	}

	private JComboBox<String> getCmbDate2Panel() {
		if (cmbDate2Panel == null) {
			cmbDate2Panel = new JComboBox<String>();
			cmbDate2Panel.setBounds(188, 110, 154, 28);
		}
		return cmbDate2Panel;
	}

	private JLabel getLblTypeOfRoom2Panel() {
		if (lblTypeOfRoom2Panel == null) {
			lblTypeOfRoom2Panel = new JLabel("Type of Room:");
			lblTypeOfRoom2Panel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTypeOfRoom2Panel.setBounds(6, 23, 99, 23);
		}
		return lblTypeOfRoom2Panel;
	}

	private JComboBox<String> getCmbTypeOfRoom2Panl() {
		if (cmbTypeOfRoom2Panl == null) {
			cmbTypeOfRoom2Panl = new JComboBox<String>();
			cmbTypeOfRoom2Panl.setEnabled(false);
			cmbTypeOfRoom2Panl.setBounds(106, 22, 146, 27);
		}
		return cmbTypeOfRoom2Panl;
	}

	private JLabel getLblCapacity2Panel() {
		if (lblCapacity2Panel == null) {
			lblCapacity2Panel = new JLabel("This room has capacity for:");
			lblCapacity2Panel.setBounds(264, 23, 207, 23);
		}
		return lblCapacity2Panel;
	}

	private JPanel getPnPassengers2Panel() {
		if (pnPassengers2Panel == null) {
			pnPassengers2Panel = new JPanel();
			pnPassengers2Panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Passengers", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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

	private JList getLstPassengers2Panel() {
		if (lstPassengers2Panel == null) {
			lstPassengers2Panel = new JList();
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
			btnAddPassanger = new JButton("Add Passanger");
			btnAddPassanger.setEnabled(false);
		}
		return btnAddPassanger;
	}

	private JButton getBtnDeletePassanger() {
		if (btnDeletePassanger == null) {
			btnDeletePassanger = new JButton("Delete Passanger");
			btnDeletePassanger.setEnabled(false);
		}
		return btnDeletePassanger;
	}

	private JButton getBtnModifyPassenger() {
		if (btnModifyPassenger == null) {
			btnModifyPassenger = new JButton("Modify");
			btnModifyPassenger.setEnabled(false);
		}
		return btnModifyPassenger;
	}
	private JCheckBox getChckbxAddExtraBed() {
		if (chckbxAddExtraBed == null) {
			chckbxAddExtraBed = new JCheckBox("Add extra bed");
			chckbxAddExtraBed.setEnabled(false);
		}
		return chckbxAddExtraBed;
	}
	private JCheckBox getChckbxJacuzzi() {
		if (chckbxJacuzzi == null) {
			chckbxJacuzzi = new JCheckBox("Jacuzzi");
			chckbxJacuzzi.setEnabled(false);
		}
		return chckbxJacuzzi;
	}
	private JCheckBox getChckbxSpecialBreakfast() {
		if (chckbxSpecialBreakfast == null) {
			chckbxSpecialBreakfast = new JCheckBox("Special breakfast");
			chckbxSpecialBreakfast.setEnabled(false);
		}
		return chckbxSpecialBreakfast;
	}
	private JCheckBox getChckbxExtrabigBed() {
		if (chckbxExtrabigBed == null) {
			chckbxExtrabigBed = new JCheckBox("Extra-big bed");
			chckbxExtrabigBed.setEnabled(false);
		}
		return chckbxExtrabigBed;
	}
	private JPanel getPnExtras2Panel() {
		if (pnExtras2Panel == null) {
			pnExtras2Panel = new JPanel();
			pnExtras2Panel.setBorder(new TitledBorder(null, "Extras", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnExtras2Panel.setBackground(Color.WHITE);
			pnExtras2Panel.setBounds(674, 26, 318, 120);
			pnExtras2Panel.setLayout(new GridLayout(2, 2, 0, 0));
			pnExtras2Panel.add(getChckbxAddExtraBed());
			pnExtras2Panel.add(getChckbxJacuzzi());
			pnExtras2Panel.add(getChckbxSpecialBreakfast());
			pnExtras2Panel.add(getChckbxExtrabigBed());
		}
		return pnExtras2Panel;
	}
	private JButton getBtnAddRoob() {
		if (btnAddRoob == null) {
			btnAddRoob = new JButton("Add Roob");
			btnAddRoob.setEnabled(false);
			btnAddRoob.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnAddRoob.setBounds(872, 144, 117, 29);
		}
		return btnAddRoob;
	}
}
