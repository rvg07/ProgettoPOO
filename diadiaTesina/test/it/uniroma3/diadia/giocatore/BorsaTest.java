package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;


public class BorsaTest {

	private static final String ATTREZZO = "attrezzoSemplice";
	private static final String SECONDO_ATTREZZO = "secondoAttrezzo";
	private Borsa borsa;
	private static final int PESO_MAX_BORSA = 20;

	@Before
	public void setUp() {
		this.borsa = new Borsa(PESO_MAX_BORSA);
	}

	@Test
	public void testAddAttrezzoSingolo() {
		Attrezzo attrezzo = creaAttrezzoEAggiungiBorsa(this.borsa, ATTREZZO, 1);
		assertEquals(attrezzo, this.borsa.getAttrezzo(ATTREZZO));
	}

	@Test
	public void testAddAttrezzoTroppoPesante() {
		Attrezzo attrezzoPesante = new Attrezzo("attrezzoPesante", PESO_MAX_BORSA+1);
		assertFalse(this.borsa.addAttrezzo(attrezzoPesante));
	}	

	@Test
	public void testGetAttrezzoBorsaVuota() {
		assertNull(this.borsa.getAttrezzo(ATTREZZO));
	}

	@Test
	public void testGetAttrezzoInesistente() {
		creaAttrezzoEAggiungiBorsa(this.borsa, ATTREZZO, 1);
		assertNull(this.borsa.getAttrezzo("inesistente"));
	}

	@Test
	public void testGetPesoMax() {
		assertEquals(PESO_MAX_BORSA, this.borsa.getPesoMax());
	}

	@Test
	public void testGetPesoIniziale() {
		assertEquals(0, this.borsa.getPeso());
	}

	@Test
	public void testGetPesoDopoAggiuntaAttrezzo() {
		creaAttrezzoEAggiungiBorsa(this.borsa, ATTREZZO, 1);
		assertEquals(1, this.borsa.getPeso());
	}

	@Test
	public void testIsEmptyIniziale() {
		assertTrue(this.borsa.isEmpty());
	}

	@Test
	public void testIsEmptyDopoAggiunta() {
		creaAttrezzoEAggiungiBorsa(this.borsa, ATTREZZO, 1);
		assertFalse(this.borsa.isEmpty());
	}

	@Test
	public void testHasAttrezzoEsistente() {
		creaAttrezzoEAggiungiBorsa(this.borsa, ATTREZZO, 1);
		assertTrue(this.borsa.hasAttrezzo(ATTREZZO));
	}

	@Test
	public void testHasAttrezzoInesistente() {
		creaAttrezzoEAggiungiBorsa(this.borsa, ATTREZZO, 1);
		assertFalse(this.borsa.hasAttrezzo("inesistente"));
	}

	@Test
	public void testHasAttrezzoBorsaVuota() {
		assertFalse(this.borsa.hasAttrezzo(ATTREZZO));
	}

	@Test
	public void testRemoveAttrezzo() {
		creaAttrezzoEAggiungiBorsa(this.borsa, ATTREZZO, 1);
		this.borsa.removeAttrezzo(ATTREZZO);
		assertFalse(this.borsa.hasAttrezzo(ATTREZZO));
	}

	@Test
	public void testRemoveAttrezzoPesoZero() {
		creaAttrezzoEAggiungiBorsa(this.borsa, ATTREZZO, 1);
		this.borsa.removeAttrezzo(ATTREZZO);
		assertEquals(0, this.borsa.getPeso());
	}

	@Test
	public void testGetContenutoOrdinatoPerPeso() {
		creaAttrezzoEAggiungiBorsa(this.borsa, SECONDO_ATTREZZO,2);
		creaAttrezzoEAggiungiBorsa(this.borsa, ATTREZZO,1);
		List<Attrezzo> expected = Arrays.asList(new Attrezzo(ATTREZZO, 1), new Attrezzo(SECONDO_ATTREZZO, 2));
		assertEquals(expected, this.borsa.getContenutoOrdinatoPerPeso());
	}

	@Test
	public void testGetContenutoOrdinatoPerNome() {
		creaAttrezzoEAggiungiBorsa(this.borsa, SECONDO_ATTREZZO,2);
		creaAttrezzoEAggiungiBorsa(this.borsa, ATTREZZO,1);
		Set<Attrezzo> expected = new TreeSet<>(Arrays.asList(new Attrezzo(ATTREZZO, 1),
				new Attrezzo(SECONDO_ATTREZZO, 2)));
		assertEquals(expected, this.borsa.getContenutoOrdinatoPerNome());
	}

	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		creaAttrezzoEAggiungiBorsa(this.borsa, SECONDO_ATTREZZO,2);
		creaAttrezzoEAggiungiBorsa(this.borsa, ATTREZZO,1);
		Map<Integer, Set<Attrezzo>> expected = new HashMap<>();
		expected.put(1, Collections.singleton(new Attrezzo(ATTREZZO, 1)));
		expected.put(2, Collections.singleton(new Attrezzo(SECONDO_ATTREZZO, 2)));
		assertEquals(expected, this.borsa.getContenutoRaggruppatoPerPeso());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso() {
		creaAttrezzoEAggiungiBorsa(this.borsa, SECONDO_ATTREZZO,1);
		creaAttrezzoEAggiungiBorsa(this.borsa, ATTREZZO,1);
		Set<Attrezzo> expected = new TreeSet<>(Arrays.asList(new Attrezzo(ATTREZZO, 1),
				new Attrezzo(SECONDO_ATTREZZO, 1)));
		assertEquals(expected, this.borsa.getSortedSetOrdinatoPerPeso());
	}

	private Attrezzo creaAttrezzoEAggiungiBorsa(Borsa borsa, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		borsa.addAttrezzo(attrezzo);
		return attrezzo;
	}

}
