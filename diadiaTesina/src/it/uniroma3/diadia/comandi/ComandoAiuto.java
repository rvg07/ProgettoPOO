package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {

	private final static String NOME = "aiuto";

	static final private String[] ELENCO_COMANDI = {"vai", "aiuto", "fine", "prendi", "posa", "guarda",
			"interagisci", "saluta", "nonValido"};

	public ComandoAiuto(String[] elencoComandi) {
		super.setNome(NOME);
	}

	public ComandoAiuto() {

	}

	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< ELENCO_COMANDI.length; i++) 
			super.getIo().mostraMessaggio(ELENCO_COMANDI[i]+" ");
		super.getIo().mostraMessaggio("");
	}

}
