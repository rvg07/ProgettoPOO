package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{

	private String ciboPreferito;
	private Attrezzo regaloDelCane;
	private boolean regaloPosato = false;

	public Cane(String nome, String presentaz, String ciboPreferito, Attrezzo regalo) {
		super(nome, presentaz);
		this.ciboPreferito = ciboPreferito;
		this.regaloDelCane = regalo;
	}

	@Override
	public String agisci(Partita partita) {
		partita.setCfu(partita.getCfu() -1);
		return "Il cane ci ha morso";
	}

	@Override
	public String riceviRegalo(Attrezzo regalo, Partita partita) {
		if(regalo.getNome().equals(ciboPreferito)) {
			if(!this.regaloPosato){
				partita.getStanzaCorrente().addAttrezzo(this.regaloDelCane);
				this.regaloPosato = true;
			}
			return "Il cane accetta il cibo e lascia cadere un attrezzo";
		} else {
			partita.getStanzaCorrente().addAttrezzo(regalo);
			partita.setCfu(partita.getCfu() -1);
			return "Il cane non accetta il tuo regalo e ti morde";
		}
	}

}
