package br.com.caelum.argentum.indicadores;

import java.math.BigDecimal;

import org.junit.Test;
import static org.junit.Assert.*;

import br.com.gregory.candlelight.gerador.GeradorDeSerie;
import br.com.gregory.candlelight.indicadores.Indicador;
import br.com.gregory.candlelight.indicadores.IndicadorFactory;
import br.com.gregory.candlelight.modelo.SerieTemporal;

public class IndicadorFactoryTest {

	@Test
	public void mediaMovelSimplesDeFechamento() {
		IndicadorFactory factory = new IndicadorFactory("MediaMovelSimples", "IndicadorFechamento");
		
		Indicador indicador=factory.defineIndicador();
		
		SerieTemporal serie = GeradorDeSerie.criarSerie("2","3","4");
		
		BigDecimal resultado = indicador.calcula(2, serie);
		
		
		assertEquals(new BigDecimal("3"),resultado);
		
	}

	@Test
	public void mediaMovelSimplesDeAbertura() {
		IndicadorFactory factory = new IndicadorFactory("MediaMovelSimples", "IndicadorAbertura");
		
		Indicador indicador=factory.defineIndicador();
		
		SerieTemporal serie = GeradorDeSerie.criarSerie("2","3","4");
		
		BigDecimal resultado = indicador.calcula(2, serie);
		
		
		assertEquals(new BigDecimal("3"),resultado);
		
	}
	

	@Test
	public void mediaMovelPonderadaDeFechamento() {
		IndicadorFactory factory = new IndicadorFactory("MediaMovelPonderada", "IndicadorFechamento");
		
		Indicador indicador=factory.defineIndicador();
		
		SerieTemporal serie = GeradorDeSerie.criarSerie("2","3","4");
		
		BigDecimal resultado = indicador.calcula(2, serie);
		
		
		assertEquals(new BigDecimal("4"),resultado);
		
	}
	

	@Test
	public void mediaMovelPonderadaDeAbertura() {
		IndicadorFactory factory = new IndicadorFactory("MediaMovelPonderada", "IndicadorAbertura");
		
		Indicador indicador=factory.defineIndicador();
		
		SerieTemporal serie = GeradorDeSerie.criarSerie("2","3","4");
		
		BigDecimal resultado = indicador.calcula(2, serie);
		
		
		assertEquals(new BigDecimal("4"),resultado);
		
	}
	
	

	@Test
	public void calculoComApenasUmIndicadorRetornaPadrao() {
		
		IndicadorFactory factory = new IndicadorFactory("MediaMovelPonderada", null);
		
		Indicador indicador=factory.defineIndicador();
		
		SerieTemporal serie = GeradorDeSerie.criarSerie("2","3","4");
		
		BigDecimal resultado = indicador.calcula(2, serie);
		
		assertEquals(new BigDecimal("3"),resultado);
		
	}

}
