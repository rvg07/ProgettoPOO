package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StregaTest {
	private static final String STANZA_OVEST = "stanzaOvest";
	private static final String INIZIALE = "iniziale";
	private static final String STANZA_EST = "stanzaEst";
	private Partita partita;
	private Strega strega;

	@Before
	public void setUp() throws Exception {
		Stanza stanzaIniziale = new Stanza(INIZIALE);
        Stanza stanzaEst = new Stanza(STANZA_EST);
        Stanza stanzaOvest = new Stanza(STANZA_OVEST);
        
		Labirinto labirinto = Labirinto.builder()
				.addStanzaIniziale(stanzaIniziale)
				.addStanza(stanzaEst)
				.addAttrezzo(STANZA_EST,"attrezzo1", 1)
				.addAttrezzo(STANZA_EST,"attrezzo2", 2)
				.addAdiacenza(stanzaIniziale, stanzaEst, "est")
				.addStanza(stanzaOvest)
				.addAttrezzo(STANZA_OVEST,"attrezzo3", 3)
				.addAdiacenza(stanzaIniziale, stanzaOvest, "ovest")
				.build();
		this.partita = new Partita(labirinto);
		this.strega = new Strega("Morgana", "Presentazione");
	}

	@Test
	public void testAgisci_SenzaSalutare() {
		this.strega.agisci(this.partita);
		assertEquals(STANZA_OVEST, this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testAgisci_Saluta() {
		this.strega.saluta();
		this.strega.agisci(this.partita);
		assertEquals(STANZA_EST, this.partita.getStanzaCorrente().getNome());
		
	}

	@Test
	public void testRiceviRegalo() {
		this.strega.riceviRegalo(new Attrezzo("test", 1), this.partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("test"));
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("test"));
	}
}
