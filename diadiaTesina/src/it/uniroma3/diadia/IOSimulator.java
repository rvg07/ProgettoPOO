package it.uniroma3.diadia;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class IOSimulator implements IO {
	
	private List<String> righeDaLeggere;
	private int indiceRigheDaLeggere;
	private Map<Integer, List<String>> indice2messaggiProdotti;
	private int ultimoIndiceMappaMostrato;
	private int ultimoIndiceListaMostrato;
	
	public IOSimulator(List<String> righeDaLeggere) {
		this.righeDaLeggere = righeDaLeggere;
		this.indiceRigheDaLeggere = 0;
		this.indice2messaggiProdotti = new HashMap<Integer, List<String>>();
		this.ultimoIndiceListaMostrato = 0;
		this.ultimoIndiceListaMostrato = 0;
	}

	@Override
	public void mostraMessaggio(String messaggio) {
		if(!this.indice2messaggiProdotti.containsKey(this.indiceRigheDaLeggere))
			this.indice2messaggiProdotti.put(this.indiceRigheDaLeggere, new LinkedList<String>());
		List<String> l = this.indice2messaggiProdotti.get(this.indiceRigheDaLeggere);
		l.add(messaggio);
	}

	@Override
	public String leggiRiga() {
		String rigaLetta = this.righeDaLeggere.get(this.indiceRigheDaLeggere);
		this.indiceRigheDaLeggere++;
		return rigaLetta;
	}
	
	public String nextMessaggio() {
		List<String> messaggiDaMostrare = this.indice2messaggiProdotti.get(this.ultimoIndiceMappaMostrato);
		if(this.ultimoIndiceListaMostrato < messaggiDaMostrare.size()) {
			String messaggio = messaggiDaMostrare.get(this.ultimoIndiceListaMostrato);
			this.ultimoIndiceListaMostrato++;
			return messaggio;
		}
		this.ultimoIndiceListaMostrato = 0;
		this.ultimoIndiceMappaMostrato++;
		return this.nextMessaggio();
	}
	
	public boolean hasNextMessaggio() {
		List<String> messaggiDaMostrare = this.indice2messaggiProdotti.get(this.ultimoIndiceMappaMostrato);
		if(this.ultimoIndiceListaMostrato < messaggiDaMostrare.size()) 
			return true;
		else
			return this.indice2messaggiProdotti.containsKey(this.ultimoIndiceMappaMostrato +1);
	}

}
