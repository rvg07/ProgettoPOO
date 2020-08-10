package it.uniroma3.diadia.ambienti;

import java.util.Comparator;

public class ComparatoreStanzePerNumeroAttrezzi implements Comparator<Stanza>{

	@Override
	public int compare(Stanza o1, Stanza o2) {
		return o2.getAttrezzi().size() - o1.getAttrezzi().size();
	}

}
