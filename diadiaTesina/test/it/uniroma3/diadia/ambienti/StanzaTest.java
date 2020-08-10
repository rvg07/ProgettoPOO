package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;


public class StanzaTest {

	private static final int MAX_ATTREZZI = 10;
	private static final String ATTREZZO = "AttrezzoDiTest";
	private static final String STANZA = "StanzaTest";
	private static final String STANZA_ADIACENTE = "StanzaAdiacente";
	private static final Direzione NORD = Direzione.NORD;

	protected Stanza stanza;

	@Before
	public void setUp() {
		this.stanza = new Stanza(STANZA);
	}

	@Test
	public void testImpostaStanzaAdiacenteSingola() {
		Stanza adiacente = creaStanzaEImpostaAdiacente(this.stanza, STANZA_ADIACENTE, NORD);
		assertEquals(adiacente, this.stanza.getStanzaAdiacente(NORD));
	}

	@Test
	public void testCambiaStanzaAdiacente() {
		creaStanzaEImpostaAdiacente(this.stanza, STANZA_ADIACENTE, NORD);
		Stanza nuovaAdiacente = creaStanzaEImpostaAdiacente(this.stanza, "nuovaAdiacente", NORD);
		assertEquals(nuovaAdiacente, this.stanza.getStanzaAdiacente(NORD));
	}

	@Test
	public void testGetStanzaAdiacenteNonEsistente() {
		assertNull(this.stanza.getStanzaAdiacente(NORD));
	}

	@Test
	public void testGetStanzaAdiacenteEsistente() {
		Stanza adiacente = creaStanzaEImpostaAdiacente(this.stanza, STANZA_ADIACENTE, NORD);
		assertEquals(this.stanza.getStanzaAdiacente(NORD),adiacente);
	}

	@Test
	public void testGetStanzaAdiacenteDirezioneNonValida() {
		creaStanzaEImpostaAdiacente(this.stanza, STANZA_ADIACENTE, NORD);
		assertNull(this.stanza.getStanzaAdiacente(Direzione.SUD));
	}

	@Test
	public void testGetDirezioniVuoto() {
		assertArrayEquals(new String[0], this.stanza.getDirezioni().toArray());
	}

	@Test
	public void testGetDirezioniSingleton() {
		creaStanzaEImpostaAdiacente(this.stanza, STANZA_ADIACENTE, NORD);
		Direzione[] direzioni = new Direzione[1];
		direzioni[0] = NORD;
		assertArrayEquals(direzioni, this.stanza.getDirezioni().toArray());
	}


	@Test
	public void testAddAttrezzoSingolo() {
		Attrezzo attrezzoSemplice = new Attrezzo(ATTREZZO, 1);
		this.stanza.addAttrezzo(attrezzoSemplice);
		assertEquals(attrezzoSemplice, this.stanza.getAttrezzo(ATTREZZO));
	}

	@Test
	public void testAddAttrezziOltreMassimo() {
		for (int i = 0; i < MAX_ATTREZZI; i++) {
			Attrezzo attrezzoSemplice = new Attrezzo(ATTREZZO+i, 1);
			assertTrue(this.stanza.addAttrezzo(attrezzoSemplice));
		}
		Attrezzo attrezzoDiTroppo =  new Attrezzo(ATTREZZO+MAX_ATTREZZI, 1);
		assertFalse(this.stanza.addAttrezzo(attrezzoDiTroppo));
	}

	@Test
	public void testHasAttrezzoSingolo() {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO, 1);
		this.stanza.addAttrezzo(attrezzo);
		assertTrue(this.stanza.hasAttrezzo(ATTREZZO));
	}

	@Test
	public void testHasAttrezzoStanzaVuota() {
		assertFalse(this.stanza.hasAttrezzo(ATTREZZO));
	}

	@Test
	public void testHasAttrezzoInesistente() {
		assertFalse(this.stanza.hasAttrezzo("inesistente"));
	}

	private Stanza creaStanzaEImpostaAdiacente(Stanza stanzaDiPartenza, String nomeStanzaAdiacente, 
			Direzione direzione) {
		Stanza stanzaAdiacente = new Stanza(nomeStanzaAdiacente);
		stanzaDiPartenza.impostaStanzaAdiacente(direzione, stanzaAdiacente);
		return stanzaAdiacente;
	}
}
