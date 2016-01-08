package com.guille.cpm.logic.barco;


public class Barco {

	private String shipID;
	private String name;
	private String description;
	private String picturePath;
	private int NCamDI;
	private int NCamDE;
	private int NCamFI;
	private int NCamFE;

	private double[] prices;

	/**
	 * Main constructor.
	 * 
	 * @param ShipID the unique identifier for each ship.
	 * @param Name the name of the ship.
	 * @param Desc the description for the ship.
	 * @param NCamDI the number of double interior cabins.
	 * @param NCamDE the number of double exterior cabins.
	 * @param NCamFI the number of familiar interior cabins.
	 * @param NCamFE the number of familiar exterior cabins.
	 * @param PCamDI the price for the double interior cabins.
	 * @param PCamDE the price for the double exterior cabins.
	 * @param PCamFI the price for the double interior cabins.
	 * @param PCamFE the price for the familiar exterior cabins.
	 */
	public Barco(String ShipID, String Name, String Desc, int NCamDI, int NCamDE, int NCamFI, int NCamFE, double PCamDI,
			double PCamDE, double PCamFI, double PCamFE) {
		this.shipID = ShipID;
		this.name = Name;
		this.description = Desc;
		this.picturePath = ("com/guille/cpm/img/" + ShipID + ".jpg");

		this.prices = new double[4];

		this.NCamDI = NCamDI;
		this.NCamDE = NCamDE;
		this.NCamFI = NCamFI;
		this.NCamFE = NCamFE;

		loadPrices(PCamDI, PCamDE, PCamFI, PCamFE);
	}

	/**
	 * Return the id of the ship.
	 * 
	 * @return the ID of the ship.
	 */
	public String getShipID() {
		return this.shipID;
	}

	/**
	 * Return the name of the ship.
	 * 
	 * @return the name of the ship.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Return the description of the ship.
	 * 
	 * @return the description of the ship.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Return the relative path of the picture.
	 * 
	 * @return the path of the picture.
	 */
	public String getPicturePath() {
		return this.picturePath;
	}

	/**
	 * Return the number of double interior cabins specified for this ship.
	 * 
	 * @return the number of double interior cabins.
	 */
	public int getNCamarotesDoblesInteriores() {
		return this.NCamDI;
	}

	/**
	 * Return the number of double exterior cabins specified for this ship.
	 * 
	 * @return the number of double exterior cabins.
	 */
	public int getNCamarotesDoblesExteriores() {
		return this.NCamDE;
	}

	/**
	 * Return the number of familiar interior cabins specified for this ship.
	 * 
	 * @return the number of familiar interior cabins.
	 */
	public int getNCamarotesFamiliaresInteriores() {
		return this.NCamFI;
	}

	/**
	 * Return the number of familiar exterior cabins specified for this ship.
	 * 
	 * @return the number of familiar exterior cabins.
	 */
	public int getNCamarotesFamiliaresExteriores() {
		return this.NCamFE;
	}

	/**
	 * Return the price for the double interior cabin.
	 * 
	 * @return the price for the double interior cabin.
	 */
	public double getPrecioCamaroteDobleInterior() {
		return this.prices[0];
	}

	/**
	 * Return the price for the double exterior cabin.
	 * 
	 * @return the price for the double exterior cabin.
	 */
	public double getPrecioCamaroteDobleExterior() {
		return this.prices[1];
	}

	/**
	 * Return the price for the familiar interior cabin.
	 * 
	 * @return the price for the familiar interior cabin.
	 */
	public double getPrecioCamaroteFamiliarInterior() {
		return this.prices[2];
	}

	/**
	 * Return the price for the familiar exterior cabin.
	 * 
	 * @return the price for the familiar exterior cabin.
	 */
	public double getPrecioCamaroteFamiliarExterior() {
		return this.prices[3];
	}
	
	/**
	 * Return the total number of double cabins in the specifications ship.
	 * 
	 * @return the total number of double cabins.
	 */
	public int getNCamarotesDoblesTotal() {
		return (this.getNCamarotesDoblesInteriores() + this.getNCamarotesDoblesExteriores());
	}

	/**
	 * Return the total number of familiar cabins in the specifications ship.
	 * 
	 * @return the total number of familiar cabins.
	 */
	public int getNCamarotesFamiliaresTotal() {
		return (this.getNCamarotesFamiliaresInteriores() + this.getNCamarotesFamiliaresExteriores());
	}

	/**
	 * By specification each ship will have four types of rooms. So this method
	 * will load this values on to a predefined array.
	 * 
	 * @param PCamDI the price for the double interior cabin.
	 * @param PCamDE the price for the double exterior cabin.
	 * @param PCamFI the price for the familiar interior cabin.
	 * @param PCamFE the price for the familiar exterior cabin.
	 */
	private void loadPrices(double PCamDI, double PCamDE, double PCamFI, double PCamFE) {
		prices[0] = PCamDI;
		prices[1] = PCamDE;
		prices[2] = PCamFI;
		prices[3] = PCamFE;
	}

	/**
	 * Return the array that contains all the prices.
	 * 
	 * @return the array of prices.
	 */
	public double[] getPrices() {
		return this.prices;
	}
}
