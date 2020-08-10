package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.fixture.Fixture;

public class StanzaBuiaTest {

	private static final String ATTREZZO_LUCE_TEST = "attrezzoLuceTest";
	private StanzaBuia stanzaBuia;
	
	@Before
	public void setUp() {
		this.stanzaBuia = new StanzaBuia("StanzaBuia", ATTREZZO_LUCE_TEST);
	}

	@Test
	public void testGetDescrizioneLuceNonPresente() {
		assertEquals(StanzaBuia.DESCRIZIONE_STANZA_BUIA, this.stanzaBuia.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneConLuce() {
		Fixture.creaAttrezzoEAggiungiAStanza(this.stanzaBuia, ATTREZZO_LUCE_TEST, 1);
		assertNotEquals(StanzaBuia.DESCRIZIONE_STANZA_BUIA, this.stanzaBuia.getDescrizione());
	}
	
	@Test
	public void testGetAttrezzoInesistente() {
		Fixture.creaAttrezzoEAggiungiAStanza(this.stanzaBuia, "attrezzoDiTest", 1);
		assertNull(this.stanzaBuia.getAttrezzo("inesistente"));		
	}
	

}
