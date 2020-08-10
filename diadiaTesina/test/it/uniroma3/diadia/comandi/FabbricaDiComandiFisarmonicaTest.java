package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;

public class FabbricaDiComandiFisarmonicaTest {
	
	private FabbricaDiComandiFisarmonica fabbricaDiComandi;

	@Before
	public void setUp() throws Exception {
		this.fabbricaDiComandi = new FabbricaDiComandiFisarmonica();
	}

	@Test
	public void testAiuto() {
		testaNomeParametroComando("aiuto", "aiuto", null);
	}
	
	@Test
	public void testVai() {
		testaNomeParametroComando("vai","vai", "nord");
	}
	
	@Test
	public void testFine() {
		testaNomeParametroComando("fine","fine",  null);
	}
	
	@Test
	public void testPrendi() {
		testaNomeParametroComando("prendi","prendi", "osso");
	}
	
	@Test
	public void testPosa() {
		testaNomeParametroComando("posa","posa",  "osso");
	}	

	@Test
	public void testComandoVuoto() {
		testaNomeParametroComando("","non_valido", null);
	}	
	
	@Test
	public void testComandoNonValido() {
		testaNomeParametroComando("tgregregrt","non_valido", null);
	}	

	private void testaNomeParametroComando(String nomeComando, String comandoAtteso, String parametroDaFornire) {
		AbstractComando comando = this.fabbricaDiComandi.costruisciComando(nomeComando, new IOConsole());
		if (parametroDaFornire != null) 
			comando.setParametro(parametroDaFornire);
		assertEquals(comandoAtteso, comando.getNome());
		assertEquals(parametroDaFornire, comando.getParametro());
	}

}
