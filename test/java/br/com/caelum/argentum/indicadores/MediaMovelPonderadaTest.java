package br.com.caelum.argentum.indicadores;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.gregory.candlelight.gerador.GeradorDeSerie;
import br.com.gregory.candlelight.indicadores.IndicadorFechamento;
import br.com.gregory.candlelight.indicadores.MediaMovelPonderada;
import br.com.gregory.candlelight.modelo.SerieTemporal;

public class MediaMovelPonderadaTest {

	@Test
	public void sequenciaSimplesDeCandles() {
		   SerieTemporal serie = GeradorDeSerie.criarSerie("1", "2", "3", "4", "5", "6");
		    MediaMovelPonderada mmp = new MediaMovelPonderada(new IndicadorFechamento());
		  
		    //ex: calcula(2): 1*1 + 2*2 +3*3 = 14. Divide por 6, da 14/6
		    assertEquals(new BigDecimal(14).divide(new BigDecimal("6"),BigDecimal.ROUND_UP), mmp.calcula(2, serie));
		    assertEquals(new BigDecimal(20).divide(new BigDecimal("6"),BigDecimal.ROUND_UP), mmp.calcula(3, serie));
		    assertEquals(new BigDecimal(26).divide(new BigDecimal("6"),BigDecimal.ROUND_UP), mmp.calcula(4, serie));
		    assertEquals(new BigDecimal(32).divide(new BigDecimal("6"),BigDecimal.ROUND_UP), mmp.calcula(5, serie));
	}

}
