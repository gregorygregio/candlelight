package br.com.gregory.candlelight.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CandleFactory {
	
	public Candle constroiCandlestickParaData(Calendar data,List<Negociacao> negociacoes){
		BigDecimal inicializador=negociacoes.isEmpty() ? 
				new BigDecimal("0"):negociacoes.get(0).getPreco();
		BigDecimal maximo=inicializador;
		
		BigDecimal minimo = inicializador;
		
		BigDecimal volume= new BigDecimal("0");
		BigDecimal abertura = inicializador;
		BigDecimal fechamento = negociacoes.isEmpty() ? 
				new BigDecimal("0"):negociacoes.get(negociacoes.size()-1).getPreco();
		
		for (Negociacao negociacao : negociacoes) {
			
			volume=volume.add(negociacao.getVolume());
			BigDecimal preco = negociacao.getPreco();
			
			if(preco.compareTo(maximo)>0){
				
				maximo = preco;
				
			}else if(preco.compareTo(minimo)<0){
				
				minimo = preco;
				
			}
			
		}
		
		return new Candle(abertura,fechamento,maximo,minimo,volume,data);
		
		
		
	}

	public List<Candle> constroiCandles(List<Negociacao> negociacoes) {
		Calendar diaAtual = negociacoes.get(0).getData();
		
		List<Candle> candles=new ArrayList<Candle>();
		List<Negociacao> negociacoesDoDia = new ArrayList<>();

		
		for (Negociacao negociacao : negociacoes) {
			if(negociacao.getData().before(diaAtual)) 
				throw new IllegalArgumentException();
			if(!negociacao.isMesmoDia(diaAtual)){
				
				criaEGuardaCandle(diaAtual, candles, negociacoesDoDia);
				
				diaAtual=negociacao.getData();
				negociacoesDoDia.clear();
			}
			negociacoesDoDia.add(negociacao);
		}
		
		criaEGuardaCandle(diaAtual, candles, negociacoesDoDia);
		
		return candles;
	}

	private void criaEGuardaCandle(Calendar diaAtual, List<Candle> candles, List<Negociacao> negociacoesDoDia) {
		Candle candle;
		candle=constroiCandlestickParaData(diaAtual, negociacoesDoDia);
		candles.add(candle);
	}
	
}
