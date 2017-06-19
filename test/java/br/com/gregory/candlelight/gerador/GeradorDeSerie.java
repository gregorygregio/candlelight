package br.com.gregory.candlelight.gerador;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.gregory.candlelight.modelo.Candle;
import br.com.gregory.candlelight.modelo.SerieTemporal;

public class GeradorDeSerie {

	public static SerieTemporal criarSerie(String... valores) {
		List<Candle> candles = new ArrayList<Candle>();
		
		for (String d: valores) {
			BigDecimal b = new BigDecimal(d);
			candles.add(new Candle(b,b,b,b,b,Calendar.getInstance()));
		}
		return new SerieTemporal(candles);
	}

}
