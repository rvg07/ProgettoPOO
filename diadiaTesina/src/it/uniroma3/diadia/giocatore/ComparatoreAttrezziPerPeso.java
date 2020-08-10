package it.uniroma3.diadia.giocatore;

import java.util.Comparator;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComparatoreAttrezziPerPeso implements Comparator<Attrezzo> {

	
	@Override
	public int compare(Attrezzo o1, Attrezzo o2) {
		int pesoDiff = o1.getPeso() - o2.getPeso();
		if (pesoDiff != 0) {
			return pesoDiff;
		}
		
		return o1.getNome().compareTo(o2.getNome());
	}
}
