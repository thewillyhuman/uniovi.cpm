package com.guille.cpm.logic.crucero;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.guille.cpm.logic.barco.Barco;
import com.guille.cpm.logic.camarote.Camarote;
import com.guille.cpm.logic.camarote.CamaroteDobleExterior;
import com.guille.cpm.logic.camarote.CamaroteDobleInterior;
import com.guille.cpm.logic.camarote.CamaroteFamiliarExterior;
import com.guille.cpm.logic.camarote.CamaroteFamiliarInterior;
import com.guille.cpm.logic.interfaces.CanBeFull;

public class Crucero implements CanBeFull{
	
	private String crCode;
	private String area;
	private String denominacion;
	private String startPort;
	private String itinerario;
	private String descripcion;
	private boolean acceptUnder16;
	private int duration;
	private List<Date> salidas;
	private Barco barco;
	private boolean discount = false;
	private List<Camarote> camarotes;
	
	private String picturePath;
	
	/**
	 * Main constructor.
	 * 
	 * @param crCode Code for the crucero.
	 * @param area where the crucero will take place.
	 * @param den, denomination of the crucero.
	 * @param stPort starting port for the crucero.
	 * @param it itinerario of the crucero.
	 * @param desc, decription for the crucero.
	 * @param u16, if thew crucero accepts child under 16.
	 * @param dur duration of the crucero.
	 * @param salidas dates where the crucero will take place.
	 * @param barco that will perform the trip.
	 */
	public Crucero(String crCode, String area, String den, String stPort, String it, String desc, boolean u16, int dur, List<Date> salidas, Barco barco) {
		this.crCode = crCode;
		this.area = area;
		this.denominacion = den;
		this.startPort = stPort;
		this.itinerario = it;
		this.descripcion = desc;
		this.acceptUnder16 = u16;
		this.duration = dur;
		this.salidas = salidas;
		this.barco = barco;
		this.camarotes = new ArrayList<Camarote>();
		
		createRooms(barco.getNCamarotesDoblesInteriores(), barco.getNCamarotesDoblesExteriores(), barco.getNCamarotesFamiliaresInteriores(), barco.getNCamarotesFamiliaresExteriores());
		
		this.picturePath = ("com/guille/cpm/img/"+crCode+".jpg");
	}
	
	/**
	 * Given some ship properties will fill the ship with the necessary rooms.
	 * 
	 * @param NCamDI Number of double interior cabins.
	 * @param NCamDE Number of double exterior cabins.
	 * @param NCamFI Number of familiar interior cabins.
	 * @param NCamFE Number of familiar exterior cabins.
	 */
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
	
	/**
	 * Return whether the trip has a discount or not.
	 * 
	 * @return true if the trip has a discount, false otherwise.
	 */
	public boolean isDiscounted() {
		return this.discount;
	}
	
	/**
	 * Will change the actual state of the trip to discounted.
	 */
	public void discount() {
		this.discount = true;
	}
	
	/**
	 * Return the code of the trip.
	 * 
	 * @return the code of the trip.
	 */
	public String getCodigoCrucero() {
		return this.crCode;
	}
	
	/**
	 * Returns the area where the trip will take place.
	 * 
	 * @return the area where the trip will take place.
	 */
	public String getArea() {
		return this.area;
	}
	
	/**
	 * Return the denomination of the trip.
	 * 
	 * @return the denomination of the trip.
	 */
	public String getDenominacion() {
		return this.denominacion;
	}
	
	/**
	 * Returns the starting port of the tree.
	 * 
	 * @return the starting port of the tree.
	 */
	public String getStartPort() {
		return this.startPort;
	}
	
	/**
	 * Return the itinerary of the trip.
	 * 
	 * @return the itinerary of the trip.
	 */
	public String getItinerario() {
		return this.itinerario;
	}
	
	/**
	 * Return the description of the tree.
	 * 
	 * @return the description of the tree.
	 */
	public String getDescripcion() {
		return this.descripcion;
	}
	
	/**
	 * Return true if the trip accepts travelers under 16.
	 * 
	 * @return true if the trip accepts child under 16. False otherwise.
	 */
	public boolean getAcceptUnder16() {
		return this.acceptUnder16;
	}
	
	/**
	 * Return the duration of the hole trip.
	 * 
	 * @return the duration of the trip.
	 */
	public int getDuracion() {
		return this.duration;
	}
	
	/**
	 * Returns a list containing all the dates of the trip.
	 * 
	 * @return a list containing all the dates of the trip.
	 */
	public List<Date> getSalidas() {
		return this.salidas;
	}
	
	/**
	 * Returns the ship that will perform the trip.
	 * 
	 * @return the ship that will perform the trip.
	 */
	public Barco getBarco() {
		return this.barco;
	}
	
	/**
	 * Return the path of the picture file for the trip.
	 * 
	 * @return the path of the picture file for the trip.
	 */
	public String getPicturePath() {
		return this.picturePath;
	}
	
	/**
	 * Returns the number of free cabins in the trip.
	 * 
	 * @return the number of free cabins in the trip.
	 */
	public int getCamarotesLibres() {
		int i = 0;
		for(Camarote c : camarotes) {
			if(c.isFree()) {
				i++;
			}
		} return i;
	}
	
	/**
	 * Returns the number of free double interior cabins.
	 * 
	 * @return the number of free double interior cabins.
	 */
	public int getCamarotesDoblesInterioresLibres() {
		int i = 0;
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteDobleInterior && c.isFree()) {
				i++;
			}
		} return i;
	}
	
	/**
	 * Returns the number of free double exterior cabins.
	 * 
	 * @return the number of free double exterior cabins.
	 */
	public int getCamarotesDoblesExterioresLibres() {
		int i = 0;
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteDobleExterior && c.isFree()) {
				i++;
			}
		} return i;
	}
	
	/**
	 * Returns the number of free familiar interior cabins.
	 * 
	 * @return the number of free familiar interior cabins.
	 */
	public int getCamarotesFamiliaresInterioresLibres() {
		int i = 0;
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteFamiliarInterior && c.isFree()) {
				i++;
			}
		} return i;
	}
	
	/**
	 * Returns the number of free familiar exterior cabins.
	 * 
	 * @return the number of free familiar exterior cabins.
	 */
	public int getCamarotesFamiliaresEterioresLibres() {
		int i = 0;
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteFamiliarExterior && c.isFree()) {
				i++;
			}
		} return i;
	}
	
	//---
	
	/**
	 * Returns the first free double interior cabin.
	 * 
	 * @return the first free double interior cabin.
	 */
	public CamaroteDobleInterior getCamaroteDobleInteriorLibre() {
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteDobleInterior && c.isFree())
				return (CamaroteDobleInterior) c;
		} return null;
	}
	
	/**
	 * Returns the first free double exterior cabin.
	 * 
	 * @return the first free double exterior cabin.
	 */
	public CamaroteDobleExterior getCamaroteDobleExteriorLibre() {
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteDobleExterior && c.isFree()) 
				return (CamaroteDobleExterior) c;
		} return null;
	}
	
	/**
	 * Returns the first free familiar interior cabin.
	 * 
	 * @return the first free familiar interior cabin.
	 */
	public CamaroteFamiliarInterior getCamaroteFamiliarInteriorLibre() {
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteFamiliarInterior && c.isFree()) 
				return (CamaroteFamiliarInterior) c;
		} return null;
	}
	
	/**
	 * Returns the first free familiar exterior cabin.
	 * 
	 * @return the first free familiar exterior cabin.
	 */
	public CamaroteFamiliarExterior getCamaroteFamiliarExteriorLibre() {
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteFamiliarExterior && c.isFree())
				return (CamaroteFamiliarExterior) c;
		} return null;
	}

	@Override
	public boolean isFull() {
		if(getCamarotesLibres() == 0)
			return true;
		return false;
	}

}
