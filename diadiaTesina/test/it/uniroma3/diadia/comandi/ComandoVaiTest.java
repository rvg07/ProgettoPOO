package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.fixture.Fixture;

public class ComandoVaiTest {

	private static final String NOME_STANZA_PARTENZA = "Partenza";
	private static final String NORD = "nord";
	private static final Direzione DIREZIONE_NORD = Direzione.NORD;
	private Partita partita;
	private AbstractComando comandoVai;
	private Stanza partenza;

	@Before
	public void setUp() throws Exception {
		this.comandoVai = new ComandoVai();
		this.comandoVai.setIO(new IOConsole());

		Stanza stanzaPartenza = new Stanza("Partenza");
		Labirinto labirinto = Labirinto.builder()
				.addStanzaIniziale(stanzaPartenza)
				.build();
		this.partita = new Partita(labirinto);
		this.partenza = this.partita.getStanzaCorrente();
	}

	@Test
	public void testVaiStanzaNonPresente() {
		this.comandoVai.setParametro(NORD);
		this.comandoVai.esegui(this.partita);
		assertEquals(NOME_STANZA_PARTENZA, this.partita.getStanzaCorrente().getNome());
	}

	@Test
	public void testVaiStanzaPresente() {
		Stanza destinazione = new Stanza("Destinazione");
		this.partenza.impostaStanzaAdiacente(DIREZIONE_NORD, destinazione);
		this.comandoVai.setParametro(NORD);
		this.comandoVai.esegui(partita);
		assertEquals("Destinazione", this.partita.getStanzaCorrente().getNome());
	}

	@Test
	public void testVaiStanzaPresenteInDirezioneSbagliata() {
		Stanza destinazione = new Stanza("Destinazione");
		this.partenza.impostaStanzaAdiacente(Direzione.SUD, destinazione);
		this.comandoVai.setParametro(NORD);
		this.comandoVai.esegui(partita);
		assertEquals(NOME_STANZA_PARTENZA, this.partita.getStanzaCorrente().getNome());
	}

	@Test
	public void testPartitaConComandoVai() throws Exception {
		Stanza stanzaPartenza = new Stanza("iniziale");
		Stanza stanzaAdiacente = new Stanza("Aula N10");
		
		String[] comandiDaEseguire = {"vai sud","fine"};
		Labirinto labirinto = Labirinto.builder() //new LabirintoBuilder()
				.addStanzaIniziale(stanzaPartenza)
				.addStanza(stanzaAdiacente)
				.addAdiacenza(stanzaPartenza, stanzaAdiacente, "sud")
				.build();
		IOSimulator io = Fixture.creaSimulazionePartitaEGioca(labirinto, comandiDaEseguire);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertContains("Aula N10", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
	}

	public void assertContains(String expected, String interaRiga) {
		assertTrue(interaRiga.contains(expected));
	}

}
