package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa extends AbstractComando {

	private static final String NOME = "posa";
	
	public ComandoPosa() {
		super.setNome(NOME);
	}

	@Override
	public void esegui(Partita partita) {
		Borsa borsa = partita.getGiocatore().getBorsa();
		Attrezzo attrezzoDaPosare = borsa.getAttrezzo(super.getParametro());
		if (attrezzoDaPosare == null) {
			super.getIo().mostraMessaggio("Attrezzo " + attrezzoDaPosare + " non presente nella borsa");
			return;
		}
		
		boolean attrezzoPosato = partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare);
		if (!attrezzoPosato) {
			super.getIo().mostraMessaggio("Non c'è più spazio per nuovi attrezzi nella stanza");
			return;
		}
		
		borsa.removeAttrezzo(super.getParametro());
		super.getIo().mostraMessaggio("Attrezzo " + super.getParametro() + " posato!");
	}

}
