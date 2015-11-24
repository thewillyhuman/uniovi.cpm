package com.guille.cpm.logic;

import java.util.ArrayList;
import java.util.List;

public class Barco {

	private String shipID;
	private String name;
	private String description;
	private String picturePath;

	private double[] prices;
	private List<Camarote> camarotes;
	
	public Barco(String ShipID, String Name, String Desc, int NCamDI, int NCamDE, int NCamFI, int NCamFE, double PCamDI, double PCamDE, double PCamFI, double PCamFE) {
		this.shipID = ShipID;
		this.name = Name;
		this.description = Desc;
		this.picturePath = ("/com/guille/cpm/img/"+ShipID+".jpg");
		
		this.camarotes = new ArrayList<Camarote>();
		this.prices = new double[4];
		
		createRooms(NCamDI, NCamDE, NCamFI, NCamFE);
		loadPrices(PCamDI, PCamDE, PCamFI, PCamFE);
	}
	
	/**
	 * Return the id of the ship.
	 * @return the ID of the ship.
	 */
	public String getShipID() {
		return this.shipID;
	}
	
	/**
	 * Return the name of the ship.
	 * @return the name of the ship.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Return the description of the ship.
	 * @return the description of the ship.
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Return the relative path of the picture.
	 * @return the path of the picture.
	 */
	public String getPicturePath() {
		return this.picturePath;
	}
	
	/**
	 * Return the total number of
	 * @return
	 */
	public int getNCamarotesDoblesInteriores() {
		int i = 0;
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteDobleInterior)
				i++;
		} return i;
	}
	
	public int getNCamarotesDoblesExteriores() {
		int i = 0;
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteDobleExterior)
				i++;
		} return i;
	}
	
	public int getNCamarotesFamiliaresInteriores() {
		int i = 0;
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteFamiliarInterior)
				i++;
		} return i;
	}
	
	public int getNCamarotesFamiliaresExteriores() {
		int i = 0;
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteFamiliarExterior)
				i++;
		} return i;
	}
	
	public double getPrecioCamaroteDobleInterior() {
		return this.prices[0];
	}
	
	public double getPrecioCamaroteDobleExterior() {
		return this.prices[1];
	}
	
	public double getPrecioCamaroteFamiliarInterior() {
		return this.prices[2];
	}
	
	public double getPrecioCamaroteFamiliarExterior() {
		return this.prices[3];
	}
	
	public List<Camarote> getCamarotes() {
		return this.camarotes;
	}
	
	public int getNCamarotesDoblesTotal() {
		return (this.getNCamarotesDoblesInteriores()+this.getNCamarotesDoblesExteriores());
	}
	
	public int getNCamarotesFamiliaresTotal() {
		return (this.getNCamarotesFamiliaresInteriores()+this.getNCamarotesFamiliaresExteriores());
	}
	
	private void createRooms(int NCamDI, int NCamDE, int NCamFI, int NCamFE) {
		// Creating the double interior rooms.
		for(int i = 0; i < NCamDI; i++) {
			CamaroteDobleInterior aux = new CamaroteDobleInterior();
			camarotes.add(aux);
		}
		
		// Creating the double exterior rooms
		for(int i = 0; i < NCamDE; i++) {
			CamaroteDobleExterior aux = new CamaroteDobleExterior();
			camarotes.add(aux);
		}
		
		// Creating the family interior rooms.
		for(int i = 0; i < NCamFI; i++) {
			CamaroteFamiliarInterior aux = new CamaroteFamiliarInterior();
			camarotes.add(aux);
		}
		
		// Creating the family exterior rooms.
		for(int i = 0; i < NCamFE; i++) {
			CamaroteFamiliarExterior aux = new CamaroteFamiliarExterior();
			camarotes.add(aux);
		}
	}
	
	private void loadPrices(double PCamDI, double PCamDE, double PCamFI, double PCamFE) {
		prices[0] = PCamDI;
		prices[1] = PCamDE;
		prices[2] = PCamFI;
		prices[3] = PCamFE;
	}
	
	public double[] getPrices() {
		return this.prices;
	}
	
	public int getCamarotesLibres() {
		int i = 0;
		for(Camarote c : camarotes) {
			if(c.isFree()) {
				i++;
			}
		} return i;
	}
	
	public int getCamarotesDoblesInterioresLibres() {
		int i = 0;
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteDobleInterior && c.isFree()) {
				i++;
			}
		} return i;
	}
	
	public int getCamarotesDoblesExterioresLibres() {
		int i = 0;
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteDobleExterior && c.isFree()) {
				i++;
			}
		} return i;
	}
	
	public int getCamarotesFamiliaresInterioresLibres() {
		int i = 0;
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteFamiliarInterior && c.isFree()) {
				i++;
			}
		} return i;
	}
	
	public int getCamarotesFamiliaresEterioresLibres() {
		int i = 0;
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteFamiliarExterior && c.isFree()) {
				i++;
			}
		} return i;
	}
}
