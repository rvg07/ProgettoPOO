package it.uniroma3.diadia;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;


public class PartitaTest {

	private Partita partita;
	private Labirinto labirinto;

	@Before
	public void setUp() {

		Stanza stanzaVincente = new Stanza("vincente");
		Stanza stanzaIniziale = new Stanza("iniziale");


		this.labirinto = Labirinto.builder()
				.addStanzaIniziale(stanzaIniziale)
				.addStanzaVincente(stanzaVincente)
				.build();

		this.partita = new Partita(this.labirinto);
	}

	@Test
	public void testGetStanzaVincenteNotNull() {
		assertNotNull(this.partita.getStanzaVincente());
	}

	@Test
	public void testVintaSeStanzaCorrenteEVincente() {
		this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
		assertTrue(this.partita.vinta());
	}

	@Test
	public void testNonVintaSeStanzaCorrenteNonEVincente() {
		this.partita.setStanzaCorrente(new Stanza("NonVincente"));
		assertFalse(this.partita.vinta());
	}

	@Test
	public void testNonVintaInizioPartita() {
		assertFalse(this.partita.vinta());
	}

	@Test
	public void testFinitaSeVinta() {
		this.partita.setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.isFinita());
	}

	@Test
	public void testFinitaSeEsplicitamenteSettato() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}

	@Test
	public void testFinitaSeCFUFiniti() {
		this.partita.setCfu(0);
		assertTrue(this.partita.isFinita());
	}

	@Test
	public void testNonFinitaInizioPartita() {
		assertFalse(this.partita.isFinita());
	}
}
