package com.guille.cpm.logic.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.guille.cpm.logic.Barco;

public class BarcoTest {
	
	Barco barco;
	
	@Before
	public void setUp() {
		barco = new Barco("B01", "Queen Mary - 2", "El mejor barco de la historia.", 50, 60, 70, 80, 50, 60, 70, 80);
	}

	@Test
	public void gettersTest() {
		assertEquals("B01", barco.getShipID());
		assertEquals("Queen Mary - 2", barco.getName());
		assertEquals("El mejor barco de la historia.", barco.getDescription());
		assertEquals("com/guille/cpm/img/B01.jpg", barco.getPicturePath());
		assertEquals((50+60+70+80), barco.getNCamarotesDoblesTotal()+barco.getNCamarotesFamiliaresTotal());
		assertEquals(4, barco.getPrices().length);
	}

}
