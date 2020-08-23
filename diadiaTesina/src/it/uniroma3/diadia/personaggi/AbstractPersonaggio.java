package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractPersonaggio {

	@NonNull @Getter private String nome;
	@NonNull private String presentazione;
	private boolean haSalutato = false;
//
//	public AbstractPersonaggio(String nome, String presentaz) {
//		this.nome = nome;
//		this.presentazione = presentaz;
//	}

	//	public String getNome() {
	//		return this.nome;
	//	}

	public boolean haSalutato() {
		return this.haSalutato;
	}

	public String saluta() {
		StringBuilder risposta = new StringBuilder("Ciao, io sono ");
		risposta.append(this.getNome()+".");
		if (!this.haSalutato)
			risposta.append(this.presentazione);
		else
			risposta.append("Ci siamo gia' presentati!");
		this.haSalutato = true;
		return risposta.toString();
	}

	abstract public String agisci(Partita partita);

	abstract public String riceviRegalo(Attrezzo regalo, Partita partita);

	@Override
	public String toString() {
		return this.getNome();
	}

}

