package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {

	private static final String NOME = "guarda";
	
	public ComandoGuarda() {
		super.setNome(NOME);
	}

	@Override
	public void esegui(Partita partita) {
		super.getIO().mostraMessaggio("Stanza corrente: " + partita.getStanzaCorrente().toString());
		super.getIO().mostraMessaggio("Informazioni partita: " + partita.getGiocatore().toString());
	}

}
