package br.com.gregory.candlelight.indicadores;

import java.math.BigDecimal;

import br.com.gregory.candlelight.modelo.SerieTemporal;

public class IndicadorFechamento implements Indicador{

	@Override
	public BigDecimal calcula(int posicao, SerieTemporal serie) {
		return serie.getCandle(posicao).getFechamento();
	}

	
	public String toString(){
		return "Fechamento";
	}
}
