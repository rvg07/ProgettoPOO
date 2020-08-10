package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.fixture.Fixture;

public class StanzaMagicaTest {
	
	private static final String ATTREZZO_DA_MODIFICARE = "AttrezzoTest2";
	private static final String ATTREZZO_TEST = "AttrezzoTest";
	private static final int SOGLIA_MAGICA = 3;
	private static final String STANZA_MAGICA_TEST = "StanzaMagicaTest";
	
	private StanzaMagica stanzaMagicaTest;

	@Before
	public void setUp() {
		 this.stanzaMagicaTest = new StanzaMagica(STANZA_MAGICA_TEST, SOGLIA_MAGICA);
	}

	@Test
	public void testAddAttrezzoOltreSogliaMagica() {
		for (int i = 0; i < SOGLIA_MAGICA; i++) 
			Fixture.creaAttrezzoEAggiungiAStanza(this.stanzaMagicaTest, ATTREZZO_TEST, 1);
		Fixture.creaAttrezzoEAggiungiAStanza(this.stanzaMagicaTest, ATTREZZO_DA_MODIFICARE, 1);
		String nomeAttrezzoModificato = new StringBuilder(ATTREZZO_DA_MODIFICARE).reverse().toString();
		Attrezzo attrezzoModificato = this.stanzaMagicaTest.getAttrezzo(nomeAttrezzoModificato);
		assertNotNull(attrezzoModificato);
		assertEquals(2, attrezzoModificato.getPeso());
		assertFalse(this.stanzaMagicaTest.hasAttrezzo(ATTREZZO_DA_MODIFICARE));
	}
	
	@Test
	public void testAddAttrezzoSingolo() {
		Attrezzo attrezzoSemplice = Fixture.creaAttrezzoEAggiungiAStanza(this.stanzaMagicaTest, ATTREZZO_TEST, 1);
		assertEquals(attrezzoSemplice, this.stanzaMagicaTest.getAttrezzo(ATTREZZO_TEST));
	}
}
