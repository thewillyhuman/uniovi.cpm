package com.guille.cpm.logic;

import java.util.Date;
import java.util.List;

public class Crucero {
	
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
		
		this.picturePath = ("com/guille/cpm/img/"+crCode+".jpg");
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

}
