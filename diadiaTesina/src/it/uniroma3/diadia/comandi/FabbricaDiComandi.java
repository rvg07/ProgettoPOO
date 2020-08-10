package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

/**
 * Fabbrica per oggetti di tipo {@link Comando}
 * @author federico
 *
 */
public interface FabbricaDiComandi {
	
	/**
	 * Costruisce il comando con una stringa istruzione in input,
	 * che contiene il comando ed un eventuale parametro.
	 * @param istruzione
	 * @return
	 * @throws Exception 
	 */
	public AbstractComando costruisciComando(String istruzione, IO io);
}
