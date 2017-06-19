package br.com.gregory.candlelight.indicadores;

import java.math.BigDecimal;

import br.com.gregory.candlelight.modelo.SerieTemporal;

public interface Indicador {

	BigDecimal calcula(int posicao, SerieTemporal serie);

}