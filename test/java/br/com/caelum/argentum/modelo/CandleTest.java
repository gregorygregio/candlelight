package br.com.caelum.argentum.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Test;

import br.com.gregory.candlelight.modelo.Candle;

import static org.junit.Assert.*;

public class CandleTest {

	@Test(expected=IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		BigDecimal abertura= new BigDecimal("10");
		BigDecimal fechamento= new BigDecimal("10");
		BigDecimal minimo= new BigDecimal("9");
		BigDecimal maximo= new BigDecimal("8");
		BigDecimal volume= new BigDecimal("1000");
		
		Calendar data = Calendar.getInstance();
		@SuppressWarnings("unused")
		Candle c = new Candle(abertura, fechamento, maximo, minimo, volume, data);
	}
	
	
	
	@Test
	public void quandoAberturaIgualFechamentoEhAlta(){
		BigDecimal abertura= new BigDecimal("10");
		BigDecimal fechamento= new BigDecimal("10");
		BigDecimal minimo= new BigDecimal("9");
		BigDecimal maximo= new BigDecimal("15");
		BigDecimal volume= new BigDecimal("1000");
		
		Calendar data = Calendar.getInstance();
		Candle c = new Candle(abertura, fechamento, maximo, minimo, volume, data);
		
		assertEquals(true,c.isAlta());
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void dataNaoPodeSerNulo(){
		BigDecimal abertura= new BigDecimal("10");
		BigDecimal fechamento= new BigDecimal("20");
		BigDecimal minimo= new BigDecimal("9");
		BigDecimal maximo= new BigDecimal("22");
		BigDecimal volume= new BigDecimal("1000");
		
		Calendar data = null;
		@SuppressWarnings("unused")
		Candle c = new Candle(abertura, fechamento, maximo, minimo, volume, data);
	
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void aberturaNaoPodeSerNulo(){
		BigDecimal abertura= null;
		BigDecimal fechamento= new BigDecimal("20");
		BigDecimal minimo= new BigDecimal("9");
		BigDecimal maximo= new BigDecimal("22");
		BigDecimal volume= new BigDecimal("1000");
		
		Calendar data = Calendar.getInstance();
		@SuppressWarnings("unused")
		Candle c = new Candle(abertura, fechamento, maximo, minimo, volume, data);
	
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void fechamentoNaoPodeSerNulo(){
		BigDecimal abertura= new BigDecimal("20");
		BigDecimal fechamento= null;
		BigDecimal minimo= new BigDecimal("9");
		BigDecimal maximo= new BigDecimal("22");
		BigDecimal volume= new BigDecimal("1000");
		
		Calendar data = Calendar.getInstance();
		@SuppressWarnings("unused")
		Candle c = new Candle(abertura, fechamento, maximo, minimo, volume, data);
	
	}	
	
	@Test(expected=IllegalArgumentException.class)
	public void minimoNaoPodeSerNulo(){
		BigDecimal abertura= new BigDecimal("20");
		BigDecimal fechamento= new BigDecimal("20");
		BigDecimal minimo= null;
		BigDecimal maximo= new BigDecimal("22");
		BigDecimal volume= new BigDecimal("1000");
		
		Calendar data = Calendar.getInstance();
		@SuppressWarnings("unused")
		Candle c = new Candle(abertura, fechamento, maximo, minimo, volume, data);
	
	}	
	
	@Test(expected=IllegalArgumentException.class)
	public void maximoNaoPodeSerNulo(){
		BigDecimal abertura= new BigDecimal("20");
		BigDecimal fechamento= new BigDecimal("20");
		BigDecimal minimo= new BigDecimal("9");
		BigDecimal maximo= null;
		BigDecimal volume= new BigDecimal("1000");
		
		Calendar data = Calendar.getInstance();
		@SuppressWarnings("unused")
		Candle c = new Candle(abertura, fechamento, maximo, minimo, volume, data);
	
	}	
	
	
	@Test(expected=IllegalArgumentException.class)
	public void volumeNaoPodeSerNulo(){
		BigDecimal abertura= new BigDecimal("20");
		BigDecimal fechamento= new BigDecimal("20");
		BigDecimal minimo= new BigDecimal("9");
		BigDecimal maximo= new BigDecimal("22");
		BigDecimal volume= null;
		
		Calendar data = Calendar.getInstance();
		@SuppressWarnings("unused")
		Candle c = new Candle(abertura, fechamento, maximo, minimo, volume, data);
	
	}	
	
}	
	