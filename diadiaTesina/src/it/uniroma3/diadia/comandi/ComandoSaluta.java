package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando {

	private static final String MESSAGGIO_CHI = "Chi devo salutare?";
	private static final String NOME = "saluta";
	
	public ComandoSaluta() {
		super.setNome(NOME);
	}
	
	@Override
	public void esegui(Partita partita) {
		if(partita.getStanzaCorrente().getPersonaggio() == null)
			super.getIO().mostraMessaggio(MESSAGGIO_CHI);
		else 
			super.getIO().mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().saluta());
	}

}
