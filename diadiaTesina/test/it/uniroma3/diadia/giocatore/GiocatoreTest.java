package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ConfigurazioniIniziali;


public class GiocatoreTest {

	private Giocatore giocatore;

	@Before
	public void setUp() {
		this.giocatore = new Giocatore();
	}

	@Test
	public void testCfuNonFinitiInizioPartita() {
		assertNotEquals(0,this.giocatore.getCfu());
	}

	@Test
	public void testCfuIniziali() {
		assertEquals(Giocatore.CFU_INIZIALI,this.giocatore.getCfu());
	}

	@Test
	public void testBorsaPesoMax() {
		assertEquals(Borsa.DEFAULT_PESO_MAX_BORSA,this.giocatore.getBorsa().getPesoMax());
	}

}
