package com.guille.cpm.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	public boolean isDiscounted() {
		return this.discount;
	}
	
	public void discount() {
		this.discount = true;
	}
	
	public String getCodigoCrucero() {
		return this.crCode;
	}
	
	public String getArea() {
		return this.area;
	}
	
	public String getDenominacion() {
		return this.denominacion;
	}
	
	public String getStartPort() {
		return this.startPort;
	}
	
	public String getItinerario() {
		return this.itinerario;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public boolean getAcceptUnder16() {
		return this.acceptUnder16;
	}
	
	public int getDuracion() {
		return this.duration;
	}
	
	public List<Date> getSalidas() {
		return this.salidas;
	}
	
	public Barco getBarco() {
		return this.barco;
	}
	
	public String getPicturePath() {
		return this.picturePath;
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
	
	//---
	
	public CamaroteDobleInterior getCamaroteDobleInteriorLibre() {
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteDobleInterior && c.isFree())
				return (CamaroteDobleInterior) c;
		} return null;
	}
	
	public CamaroteDobleExterior getCamaroteDobleExteriorLibre() {
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteDobleExterior && c.isFree()) 
				return (CamaroteDobleExterior) c;
		} return null;
	}
	
	public CamaroteFamiliarInterior getCamaroteFamiliarInteriorLibre() {
		for(Camarote c : camarotes) {
			if(c instanceof CamaroteFamiliarInterior && c.isFree()) 
				return (CamaroteFamiliarInterior) c;
		} return null;
	}
	
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
