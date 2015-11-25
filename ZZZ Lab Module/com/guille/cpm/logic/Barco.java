package com.guille.cpm.logic;

public class Barco {

	private String shipID;
	private String name;
	private String description;
	private String picturePath;

	private double[] prices;
	
	private int NCamDI;
	private int NCamDE;
	private int NCamFI;
	private int NCamFE;
	
	public Barco(String ShipID, String Name, String Desc, int NCamDI, int NCamDE, int NCamFI, int NCamFE, double PCamDI, double PCamDE, double PCamFI, double PCamFE) {
		this.shipID = ShipID;
		this.name = Name;
		this.description = Desc;
		this.picturePath = ("com/guille/cpm/img/"+ShipID+".jpg");
		
		this.prices = new double[4];
		
		this.NCamDI = NCamDI;
		this.NCamDE = NCamDE;
		this.NCamFI = NCamFI;
		this.NCamFE = NCamFE;
		
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
		return this.NCamDI;
	}
	
	public int getNCamarotesDoblesExteriores() {
		return this.NCamDE;
	}
	
	public int getNCamarotesFamiliaresInteriores() {
		return this.NCamFI;
	}
	
	public int getNCamarotesFamiliaresExteriores() {
		return this.NCamFE;
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
	
	public int getNCamarotesDoblesTotal() {
		return (this.getNCamarotesDoblesInteriores()+this.getNCamarotesDoblesExteriores());
	}
	
	public int getNCamarotesFamiliaresTotal() {
		return (this.getNCamarotesFamiliaresInteriores()+this.getNCamarotesFamiliaresExteriores());
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
}
