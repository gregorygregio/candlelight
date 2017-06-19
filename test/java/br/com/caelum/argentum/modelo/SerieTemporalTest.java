package br.com.caelum.argentum.modelo;

import java.util.List;

import org.junit.Test;

import br.com.gregory.candlelight.gerador.GeradorDeSerie;
import br.com.gregory.candlelight.modelo.Candle;
import br.com.gregory.candlelight.modelo.SerieTemporal;

public class SerieTemporalTest {

	@Test(expected=IllegalArgumentException.class)
	public void receberListaNula() {
		List<Candle> lista= null;
		@SuppressWarnings("unused")
		SerieTemporal serie = new SerieTemporal(lista);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void posicaoNegativaDeClass(){
			SerieTemporal serie=
					GeradorDeSerie.criarSerie("1","2");
			
			@SuppressWarnings("unused")
			Candle c =serie.getCandle(-1);

	}

}
