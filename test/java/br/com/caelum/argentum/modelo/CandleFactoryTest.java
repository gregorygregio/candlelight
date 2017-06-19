package br.com.caelum.argentum.modelo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import br.com.gregory.candlelight.modelo.Candle;
import br.com.gregory.candlelight.modelo.CandleFactory;
import br.com.gregory.candlelight.modelo.Negociacao;

import static org.junit.Assert.*;

public class CandleFactoryTest {

	@Test
	public void sequenciaSimplesDeNegociacoes() {
		Calendar hoje = Calendar.getInstance();
		int _100 = 100;

		Negociacao negociacao1=new Negociacao(new BigDecimal("40.5"),_100,hoje);
		Negociacao negociacao2=new Negociacao(new BigDecimal("45.0"),_100,hoje);
		Negociacao negociacao3=new Negociacao(new BigDecimal("39.8"),_100,hoje);
		Negociacao negociacao4=new Negociacao(new BigDecimal("42.3"),_100,hoje);
		
		List<Negociacao> negociacoes= Arrays.asList(negociacao1,
														negociacao2,
														negociacao3,
														negociacao4);
		
		
		CandleFactory cfactory = new CandleFactory();
		Candle cs = cfactory.constroiCandlestickParaData(hoje, negociacoes);

		assertEquals(new BigDecimal("40.5"), cs.getAbertura());
		assertEquals(new BigDecimal("42.3"), cs.getFechamento());
		assertEquals(new BigDecimal("39.8"), cs.getMinimo());
		assertEquals(new BigDecimal("45.0"), cs.getMaximo());
		assertEquals(new BigDecimal("16760.0"), cs.getVolume());
		
	}
	
	
	@Test
	public void semNegociacoesGeraCandleComZeros(){
		Calendar hoje = Calendar.getInstance();
		List<Negociacao> negociacoes= Arrays.asList();
		
		
		CandleFactory cfactory = new CandleFactory();
		Candle cs = cfactory.constroiCandlestickParaData(hoje, negociacoes);

		assertEquals(new BigDecimal("0"), cs.getAbertura());
		assertEquals(new BigDecimal("0"), cs.getFechamento());
		assertEquals(new BigDecimal("0"), cs.getMinimo());
		assertEquals(new BigDecimal("0"), cs.getMaximo());
	
		assertEquals(new BigDecimal("0"), cs.getVolume());
	}
	
	@Test
	public void apenasUmaNegociacaoGeraCandleComValoresIguais(){
		Calendar hoje = Calendar.getInstance();

		Negociacao negociacao1=new Negociacao(new BigDecimal("40.5"),100,hoje);
		
		List<Negociacao> negociacoes= Arrays.asList(negociacao1);
		
		
		CandleFactory cfactory = new CandleFactory();
		Candle cs = cfactory.constroiCandlestickParaData(hoje, negociacoes);

		assertEquals(new BigDecimal("40.5"), cs.getAbertura());
		assertEquals(new BigDecimal("40.5"), cs.getFechamento());
		assertEquals(new BigDecimal("40.5"), cs.getMinimo());
		assertEquals(new BigDecimal("40.5"), cs.getMaximo());
		assertEquals(new BigDecimal("4050.0"), cs.getVolume());
	}
	
	@Test
	public void paraNegociacoesDeTresDiasDistintosGeraTresCandles(){
		Calendar hoje = Calendar.getInstance();
		int _100=100;

		Negociacao n1 = new Negociacao(new BigDecimal("43.5"), _100, hoje);
		Negociacao n2 = new Negociacao(new BigDecimal("45.5"), _100, hoje);
		Negociacao n3 = new Negociacao(new BigDecimal("42.0"), _100, hoje);
		Negociacao n4 = new Negociacao(new BigDecimal("46.0"), _100, hoje);
		
		Calendar amanha=(Calendar)hoje.clone();
		amanha.add(Calendar.DAY_OF_MONTH, 1);
		

		Negociacao n5 = new Negociacao(new BigDecimal("42.5"), _100, amanha);
		Negociacao n6 = new Negociacao(new BigDecimal("43.0"), _100, amanha);
		
		Calendar depois = (Calendar)amanha.clone();
		depois.add(Calendar.DAY_OF_MONTH, 1);
		

		Negociacao n7 = new Negociacao(new BigDecimal("43.5"), _100, depois);
		Negociacao n8 = new Negociacao(new BigDecimal("44.3"), _100, depois);
		
		List<Negociacao> negociacoes = Arrays.asList(n1,n2,n3,n4,n5,n6,n7,n8);
		
		
		CandleFactory factory = new CandleFactory();
		List<Candle> candles = factory.constroiCandles(negociacoes);
		
		assertEquals(3,candles.size());
		assertEquals(new BigDecimal("43.5"),candles.get(0).getAbertura());
		assertEquals(new BigDecimal("46.0"),candles.get(0).getFechamento());

		assertEquals(new BigDecimal("42.5"),candles.get(1).getAbertura());
		assertEquals(new BigDecimal("43.0"),candles.get(1).getFechamento());

		assertEquals(new BigDecimal("43.5"),candles.get(2).getAbertura());
		assertEquals(new BigDecimal("44.3"),candles.get(2).getFechamento());
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoPermiteConstruirCandlesComNegociacoesForaDeOrdem(){
		Calendar hoje = Calendar.getInstance();
		int _100=100;

		Negociacao n1 = new Negociacao(new BigDecimal("43.5"), _100, hoje);
		Negociacao n2 = new Negociacao(new BigDecimal("45.5"), _100, hoje);
		Negociacao n3 = new Negociacao(new BigDecimal("42.0"), _100, hoje);
		Negociacao n4 = new Negociacao(new BigDecimal("46.0"), _100, hoje);
		
		Calendar amanha=(Calendar)hoje.clone();
		amanha.add(Calendar.DAY_OF_MONTH, 1);
		

		Negociacao n5 = new Negociacao(new BigDecimal("42.5"), _100, amanha);
		Negociacao n6 = new Negociacao(new BigDecimal("43.0"), _100, amanha);
		
		Calendar depois = (Calendar)amanha.clone();
		depois.add(Calendar.DAY_OF_MONTH, 1);
		

		Negociacao n7 = new Negociacao(new BigDecimal("43.5"), _100, depois);
		Negociacao n8 = new Negociacao(new BigDecimal("44.3"), _100, depois);
		
		List<Negociacao> negociacoes = Arrays.asList(n1,n2,n6,n7,n3,n4,n5,n8);
		
		
		CandleFactory factory = new CandleFactory();
		@SuppressWarnings("unused")
		List<Candle> candles = factory.constroiCandles(negociacoes);

	}

}
