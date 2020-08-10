package it.uniroma3.diadia;

import java.io.IOException;
import java.util.Properties;

public final class ConfigurazioniIniziali {

	private static final String DIADIA_PROPERTIES = "diadia.properties";
	private static final String PESO_MAX = "pesoMax";
	private static final String CFU = "cfu";
	private static Properties prop = null;
	
	public static int getCFU() {
		if(prop == null)
			carica();
		return Integer.parseInt(prop.getProperty(CFU));
	}
	
	public static int getPesoMax() {
		if(prop == null)
			carica();
		return Integer.parseInt(prop.getProperty(PESO_MAX));
	}

	private static void carica() {
		prop = new Properties();
		try {
			prop.load(ConfigurazioniIniziali.class.getClassLoader().getResourceAsStream(DIADIA_PROPERTIES));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
