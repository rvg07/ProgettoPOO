package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StregaTest {
	private static final String STANZA_OVEST_1_ATTREZZO = "stanzaOvest1attrezzo";
	private static final String INIZIALE = "iniziale";
	private static final String STANZA_EST_2_ATTREZZI = "stanzaEst2Attrezzi";
	private Partita partita;
	private Strega strega;

	@Before
	public void setUp() throws Exception {
		Labirinto labirinto = Labirinto.newBuilder()
				.addStanzaIniziale(INIZIALE)
				.addStanza(STANZA_EST_2_ATTREZZI)
				.addAttrezzo("attrezzo1", 1)
				.addAttrezzo("attrezzo2", 2)
				.addAdiacenza(INIZIALE, STANZA_EST_2_ATTREZZI, "est")
				.addStanza(STANZA_OVEST_1_ATTREZZO)
				.addAttrezzo("attrezzo3", 3)
				.addAdiacenza(INIZIALE, STANZA_OVEST_1_ATTREZZO, "ovest")
				.getLabirinto();
		this.partita = new Partita(labirinto);
		this.strega = new Strega("Morgana", "Presentazione");
	}

	@Test
	public void testAgisci_SenzaSalutare() {
		this.strega.agisci(this.partita);
		assertEquals(STANZA_OVEST_1_ATTREZZO, this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testAgisci_Saluta() {
		this.strega.saluta();
		this.strega.agisci(this.partita);
		assertEquals(STANZA_EST_2_ATTREZZI, this.partita.getStanzaCorrente().getNome());
		
	}

	@Test
	public void testRiceviRegalo() {
		this.strega.riceviRegalo(new Attrezzo("test", 1), this.partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("test"));
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("test"));
	}
}
