package it.uniroma3.diadia;
import java.util.Scanner;

public class IOConsole implements IO {
	
	private Scanner scannerDiLinee;
	
	public IOConsole() {
		this.scannerDiLinee = new Scanner(System.in);
	}
	
	public IOConsole(Scanner scannerDiLinee) {
		this.scannerDiLinee = scannerDiLinee;
	}

	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}

	public String leggiRiga() {
		String riga = this.scannerDiLinee.nextLine();
		return riga;
	}
}