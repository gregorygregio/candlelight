package br.com.caelum.argentum.indicadores;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.gregory.candlelight.gerador.GeradorDeSerie;
import br.com.gregory.candlelight.indicadores.Indicador;
import br.com.gregory.candlelight.indicadores.IndicadorFechamento;
import br.com.gregory.candlelight.indicadores.MediaMovelSimples;
import br.com.gregory.candlelight.modelo.SerieTemporal;

public class MediaMovelSimplesTest {

	@Test
	public void test() throws Exception{
		SerieTemporal serie =GeradorDeSerie.criarSerie("1", "2", "3", "4", "3", "4", "5", "4", "3");
		Indicador mms = new MediaMovelSimples(new IndicadorFechamento());
		 
		
	    assertEquals(new BigDecimal("3"), mms.calcula(3, serie));
	    assertEquals(new BigDecimal(10).divide(new BigDecimal("3"),BigDecimal.ROUND_UP), mms.calcula(4, serie));
	    assertEquals(new BigDecimal(11).divide(new BigDecimal("3"),BigDecimal.ROUND_UP), mms.calcula(5, serie));
	    assertEquals(new BigDecimal("4"), mms.calcula(6, serie));
	    assertEquals(new BigDecimal(13).divide(new BigDecimal("3"),BigDecimal.ROUND_UP), mms.calcula(7, serie));
	    assertEquals(new BigDecimal("4"), mms.calcula(8, serie));
	}

}
