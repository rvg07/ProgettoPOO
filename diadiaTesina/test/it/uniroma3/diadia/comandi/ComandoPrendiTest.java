package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendiTest {
	
	private static final String ATTREZZO_INIZIALMENTE_NELLA_STANZA = "AttrezzoDaPrendere";
	private ComandoPrendi comandoPrendi;
	private Partita partita;

	@Before
	public void setUp() throws Exception {
		this.comandoPrendi = new ComandoPrendi();
		this.comandoPrendi.setIO(new IOConsole());
		Labirinto labirinto = Labirinto.newBuilder()
				.addStanzaIniziale("iniziale")
				.getLabirinto();
		this.partita = new Partita(labirinto);
		Attrezzo attrezzoNuovo = new Attrezzo(ATTREZZO_INIZIALMENTE_NELLA_STANZA, 1);
		this.partita.getStanzaCorrente().addAttrezzo(attrezzoNuovo);
	}

	@Test
	public void testEseguiAttrezzoPresente() {
		this.comandoPrendi.setParametro(ATTREZZO_INIZIALMENTE_NELLA_STANZA);
		this.comandoPrendi.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_INIZIALMENTE_NELLA_STANZA));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo(ATTREZZO_INIZIALMENTE_NELLA_STANZA));
	}
	
	@Test
	public void testEseguiAttrezzoNonPresente() {
		String nonPresente = "attrezzoNonPresente";
		this.comandoPrendi.setParametro(nonPresente);
		this.comandoPrendi.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(nonPresente));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_INIZIALMENTE_NELLA_STANZA));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo(ATTREZZO_INIZIALMENTE_NELLA_STANZA));
	}
	
	@Test
	public void testEseguiBorsaPiena() {
		Borsa borsa = partita.getGiocatore().getBorsa();
		borsa.addAttrezzo(new Attrezzo("attrezzoPesante", borsa.getPesoMax()));
		this.comandoPrendi.setParametro(ATTREZZO_INIZIALMENTE_NELLA_STANZA);
		this.comandoPrendi.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_INIZIALMENTE_NELLA_STANZA));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo(ATTREZZO_INIZIALMENTE_NELLA_STANZA));
	}

}
