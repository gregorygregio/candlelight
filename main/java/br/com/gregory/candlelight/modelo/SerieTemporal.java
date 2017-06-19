package br.com.gregory.candlelight.modelo;

import java.util.List;

public class SerieTemporal {
	private List<Candle> candles;
	
	public SerieTemporal(List<Candle> candles){
		if(candles==null)
			throw new IllegalArgumentException();
		this.candles=candles;
	}
	
	public Candle getCandle(int i){
		if(i<0)
			throw new IllegalArgumentException();
		
		return this.candles.get(i);
	}
	
	public int getUltimaPosicao(){
		return this.candles.size()-1;
	}
}
