package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.ConfigurazioniIniziali;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Giocatore {

	static final public int CFU_INIZIALI = ConfigurazioniIniziali.getCFU();

	@Getter @Setter private int cfu = CFU_INIZIALI;
	//@Getter private Borsa borsa = new Borsa();
	@Getter private Borsa borsa = Borsa.builder().build();
	/*
	 * 
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	public Borsa getBorsa() {
		return this.borsa;
	}
	*/
	
	@Override
	public String toString() {
		return "CFU: " + this.cfu + "\nBorsa: " + this.borsa.toString();
	}
	
}
