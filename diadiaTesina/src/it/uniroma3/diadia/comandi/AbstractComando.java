package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractComando {
	
	@Getter @Setter private IO io;
	@Getter @Setter private String nome;
	@Getter @Setter private String parametro;
	
	public abstract void esegui(Partita partita);
//	
//	protected IO getIO() {
//		return this.io;
//	}
//	
//	public void setIO(IO io) {
//		this.io = io;
//	}
//	
//	public String getNome() {
//		return this.nome;
//	}
//	
//	protected void setNome(String nome) {
//		this.nome = nome;
//	}
//	
//	public String getParametro() {
//		return this.parametro;
//	}
//	
//	public void setParametro(String parametro) {
//		this.parametro = parametro;
//	}
	
}
