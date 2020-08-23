package it.uniroma3.diadia;


import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */


@AllArgsConstructor
@Builder
public class DiaDia {

	static final public String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";


	private IO io;
	private Partita partita;
	private ConfigurazioniIniziali config;

	//		public DiaDia(IO io, Labirinto labirinto) {
	//			this.partita = new Partita(labirinto);
	//			this.io = io;
	//		}

	public void gioca() {
		String istruzione; 

		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do		
			istruzione = this.io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 * @throws Exception 
	 */
	private boolean processaIstruzione(String istruzione) {
		AbstractComando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiRiflessiva();
		comandoDaEseguire = factory.costruisciComando(istruzione,this.io);

		comandoDaEseguire.esegui(partita);

		if (partita.vinta())

			this.io.mostraMessaggio("Hai vinto!");
		if (!partita.giocatoreIsVivo())

			this.io.mostraMessaggio("Hai esaurito i CFU...");

		return partita.isFinita();
	}   

	public static void main(String[] argc) {
		Scanner scannerDiLinee = new Scanner(System.in);
		IO ioConsole = new IOConsole(scannerDiLinee);
		Stanza labCampus = new Stanza("LabCampusOne");
		Stanza biblioteca = new Stanza("Biblioteca");

		ConfigurazioniIniziali config = ConfigurazioniIniziali.builder().cfuIniziali(20).pesoMaxBorsa(30).build();

		Labirinto labirinto = Labirinto.builder()
				.addStanzaIniziale(labCampus)
				.addStanzaVincente(biblioteca)
				.addAdiacenza(labCampus,biblioteca,"ovest")
				.build();

		Partita partita = Partita.builder().labirinto(labirinto).build();

		//		DiaDia gioco = new DiaDia(ioConsole, labirinto);
		DiaDia gioco = new DiaDia(ioConsole, partita, config );
		try {
			gioco.gioca();
		} catch (Exception e) {
			ioConsole.mostraMessaggio("Errore inaspettato!");
		} finally {
			scannerDiLinee.close();
		}
	}
}