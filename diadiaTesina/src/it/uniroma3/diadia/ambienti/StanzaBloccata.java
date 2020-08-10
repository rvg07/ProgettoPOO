package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	private String attrezzoSbloccante;
	private Direzione direzioneBloccata;

	public StanzaBloccata(String nome, String attrezzoSbloccante, Direzione direzioneBloccata) {
		super(nome);
		this.attrezzoSbloccante = attrezzoSbloccante;
		this.direzioneBloccata = direzioneBloccata;
	}
	
	@Override
	public Stanza getStanzaAdiacente(Direzione direzione) {
		if(direzione.equals(this.direzioneBloccata) && !super.hasAttrezzo(attrezzoSbloccante))
			return this;
		return super.getStanzaAdiacente(direzione);
	}

}
