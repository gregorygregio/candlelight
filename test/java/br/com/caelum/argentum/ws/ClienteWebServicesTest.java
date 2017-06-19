package br.com.caelum.argentum.ws;

import java.util.List;

import org.junit.Test;

import br.com.gregory.candlelight.modelo.Negociacao;
import br.com.gregory.candlelight.ws.ClienteWebServices;

public class ClienteWebServicesTest {

	@Test
	public void testarRecebimentoDasNegociacoesDoWebService() {
		ClienteWebServices cliente = new ClienteWebServices();
		
		@SuppressWarnings("unused")
		List<Negociacao> negociacoes = cliente.getNegociacoes();

		
	}

}
