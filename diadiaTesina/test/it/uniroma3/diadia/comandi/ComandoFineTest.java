package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.fixture.Fixture;

public class ComandoFineTest {

	@Test
	public void testPartitaConComandoFine() throws Exception {
		Stanza stanzaIniziale = new Stanza("iniziale");
		String[] righeDaLeggere = {"fine"};
		Labirinto labirinto = Labirinto.builder()
				.addStanzaIniziale(stanzaIniziale)
				.build();
		IOSimulator io = Fixture.creaSimulazionePartitaEGioca(labirinto, righeDaLeggere);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
	}

}
