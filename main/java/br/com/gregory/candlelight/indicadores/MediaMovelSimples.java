package br.com.gregory.candlelight.indicadores;

import java.math.BigDecimal;

import br.com.gregory.candlelight.modelo.SerieTemporal;

public class MediaMovelSimples implements Indicador {
	private final Indicador outroIndicador;
	
	public MediaMovelSimples(Indicador outroIndicador){
		this.outroIndicador = outroIndicador;
	}
	
	@Override
	public BigDecimal calcula(int posicao,SerieTemporal serie){ 
		
		BigDecimal soma = new BigDecimal("0");
		
		for (int i = posicao; i > posicao-3; i--) {

			soma =soma.add(outroIndicador.calcula(i, serie));

			
		}

		return soma.divide(new BigDecimal(3),BigDecimal.ROUND_UP);
	}
	
	
	public String toString(){
		return "MMS de "+outroIndicador.toString();
	}
}
