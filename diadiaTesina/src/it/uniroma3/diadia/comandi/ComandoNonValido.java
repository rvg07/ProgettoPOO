package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {

	private static final String NOME = "non_valido";
	
	public ComandoNonValido() {
		super.setNome(NOME);
	}
	
	@Override
	public void esegui(Partita partita) {
		super.getIO().mostraMessaggio("Comando non valido!");
	}

}
