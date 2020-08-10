package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando {

	private static final String NOME = "prendi";

	public ComandoPrendi() {
		super.setNome(NOME);
	}
	
	@Override
	public void esegui(Partita partita) {
		if(!partita.getStanzaCorrente().hasAttrezzo(super.getParametro())) {
			super.getIO().mostraMessaggio("Attrezzo " + super.getParametro() + " non presente nella stanza");
			return;
		}
		Attrezzo attrezzoDaPrendere = partita.getStanzaCorrente().getAttrezzo(super.getParametro());
		boolean attrezzoPreso = partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere);
		if (!attrezzoPreso) {
			super.getIO().mostraMessaggio("Non c'è più spazio per nuovi attrezzi nella borsa");
			return;
		}
		partita.getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);
		super.getIO().mostraMessaggio("Attrezzo " + super.getParametro() + " preso!");
	}

}
