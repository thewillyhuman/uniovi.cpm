package com.guille.cpm.igu;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.guille.cpm.logic.CargarDatos;
import com.guille.cpm.logic.CompareByPrice;
import com.guille.cpm.logic.Crucero;
import com.guille.cpm.logic.Cruceros;
import com.guille.cpm.logic.FilterByArea;
import com.guille.cpm.logic.FilterByChild;
import com.guille.cpm.logic.FilterByDiscount;
import com.guille.cpm.logic.FilterByStartingDate;
import com.guille.cpm.logic.FilterByStartingPort;
import com.guille.fonts.myriadSetPro.MyriadSetPro;
import com.guille.util.CollectionsCPM;
import com.guille.util.SortedComboBoxModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JList;
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
import javax.swing.DefaultListCellRenderer;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = -8029479718163458536L;
	protected static final Font text = new MyriadSetPro().getMyriad_Set_Pro_Text().deriveFont(14f);
	protected static final Font textBold = new MyriadSetPro().getMyriad_Set_Pro_Semibold().deriveFont(14f);
	protected static final Font subtitleBold = new MyriadSetPro().getMyriad_Set_Pro_Semibold().deriveFont(20f);
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

		for (Crucero c : listaDeCruceros)
			System.out.println(c.getAcceptUnder16());
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
					((CardLayout)mainPane.getLayout()).show(mainPane,"info_crucero");
					System.out.println(c.getCodigoCrucero());
					
				}
			});
			aux.setPreferredSize(new Dimension(820, 225));
			cont.add(aux);
		}
		cont.setLayout(new GridLayout(listaDeCruceros.size(), 1));
		cont.setVisible(true);
		getScSearch().getViewport().setView(cont);
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
			scSearch.setAutoscrolls(true);
			scSearch.setBorder(null);
			scSearch.getVerticalScrollBar().setValue(0);
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
			comboSort.addItem("Starting date");
			comboSort.addItem("Duration");
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
}
