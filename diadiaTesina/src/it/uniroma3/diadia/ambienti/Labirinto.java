package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import lombok.Builder;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
public class Labirinto {

	//	public static LabirintoBuilder newBuilder() {
	//		return new LabirintoBuilder();
	//	}

	@Getter @Setter private Stanza stanzaIniziale;
	@Getter @Setter private Stanza stanzaVincente;
	//
	//	public Stanza getStanzaIniziale() {
	//		return this.stanzaIniziale;
	//	}
	//
	//	public Stanza getStanzaVincente() {
	//		return this.stanzaVincente;
	//	}
	//
	//	public void setStanzaIniziale(Stanza stanzaIniziale) {
	//		this.stanzaIniziale = stanzaIniziale;
	//	}
	//
	//	public void setStanzaVincente(Stanza stanzaVincente) {
	//		this.stanzaVincente = stanzaVincente;
	//	}


	public static class LabirintoBuilder {

		//private Labirinto labirinto;
		private Stanza ultimaAggiunta; //ultimaStanzaAggiunta

		private Map<String,Stanza> nome2stanza =  new HashMap <String, Stanza>(); //stanzeLabirinto

		//		public LabirintoBuilder() {
		//			//	this.labirinto = new Labirinto();
		//			this.nome2stanza = new HashMap<String, Stanza>();
		//		}

		public LabirintoBuilder addStanzaIniziale(Stanza stanzaIniziale) {
			this.stanzaIniziale = stanzaIniziale;
			this.aggiungiAMappaEAggiornaUltima(stanzaIniziale);
			return this;
		}

		public LabirintoBuilder addStanzaVincente(Stanza stanzaVincente) {
			this.stanzaVincente = stanzaVincente;
			//			this.labirinto.setStanzaVincente(stanzaVincente);
			this.aggiungiAMappaEAggiornaUltima(stanzaVincente);
			return this;
		}

		public LabirintoBuilder addAdiacenza(Stanza partenza, Stanza adiacente, String direzione) {
			Stanza stanzaPartenza = partenza;
			Stanza stanzaAdiacente = adiacente;
			stanzaPartenza.impostaStanzaAdiacente(Direzione.valueOf(direzione.toUpperCase()), stanzaAdiacente);
			return this;
		}

		public LabirintoBuilder addAttrezzo(String nomeStanza, String nome, int peso) {
			Attrezzo a= new Attrezzo(nome, peso);
			//this.nome2stanza = new HashMap<String, Stanza>();
			this.nome2stanza.get(nomeStanza).addAttrezzo(a);
			return this;
		}

		public LabirintoBuilder addAttrezzo(Attrezzo attrezzo) {
			//Attrezzo a= new Attrezzo(nome, peso);
			this.ultimaAggiunta.addAttrezzo(attrezzo);
			return this;
		}

		public LabirintoBuilder addStanza(String nome) {
			Stanza stanza = new Stanza(nome);
			this.aggiungiAMappaEAggiornaUltima(stanza);
			return this;
		}

		public LabirintoBuilder addStanzaMagica(String nome) {
			Stanza stanza = new StanzaMagica(nome);
			this.aggiungiAMappaEAggiornaUltima(stanza);
			return this;
		}

		public LabirintoBuilder addStanzaBuia(String nome, String attrezzoPerVedere) {
			Stanza stanza = new StanzaBuia(nome,attrezzoPerVedere);
			this.aggiungiAMappaEAggiornaUltima(stanza);
			return this;
		}

		public LabirintoBuilder addStanzaBloccata(String nome, String attrezzoSbloccante, String direzioneBloccata) {
			Stanza stanza = new StanzaBloccata(nome, attrezzoSbloccante, Direzione.valueOf(direzioneBloccata.toUpperCase()));
			this.aggiungiAMappaEAggiornaUltima(stanza);
			return this;
		}

		//		public Labirinto getLabirinto() {
		//			return this.labirinto;
		//		}

		private void aggiungiAMappaEAggiornaUltima(Stanza stanza) {
			this.ultimaAggiunta = stanza;
			this.nome2stanza.put(stanza.getNome(), stanza);
		}
	}
}