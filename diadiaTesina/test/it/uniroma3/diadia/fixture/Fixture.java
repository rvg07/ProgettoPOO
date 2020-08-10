package it.uniroma3.diadia.fixture;

import java.util.Arrays;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Fixture {
	
	public static IOSimulator creaSimulazionePartitaEGioca(Labirinto labirinto, String... righeDaLeggere) throws Exception {
		IOSimulator io = new IOSimulator(Arrays.asList(righeDaLeggere));
		new DiaDia(io,labirinto).gioca();
		return io;
	}
	
	public static Attrezzo creaAttrezzoEAggiungiAStanza(Stanza stanzaDaRiempire, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		stanzaDaRiempire.addAttrezzo(attrezzo);
		return attrezzo;
	}

}
