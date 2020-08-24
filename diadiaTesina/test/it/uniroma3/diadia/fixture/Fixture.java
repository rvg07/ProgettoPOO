package it.uniroma3.diadia.fixture;

import java.util.Arrays;

import it.uniroma3.diadia.ConfigurazioniIniziali;
import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Fixture {
	
	public static IOSimulator creaSimulazionePartitaEGioca(Labirinto labirinto, String... righeDaLeggere) throws Exception {
		IOSimulator io = new IOSimulator(Arrays.asList(righeDaLeggere));
		Partita partita = new Partita(labirinto);
		ConfigurazioniIniziali config = ConfigurazioniIniziali.builder().cfuIniziali(20).pesoMaxBorsa(30).build();
		new DiaDia(io,partita,config).gioca();
		return io;
	}
	
	public static Attrezzo creaAttrezzoEAggiungiAStanza(Stanza stanzaDaRiempire, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		stanzaDaRiempire.addAttrezzo(attrezzo);
		return attrezzo;
	}

}
