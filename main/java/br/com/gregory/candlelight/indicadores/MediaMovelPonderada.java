package br.com.gregory.candlelight.indicadores;

import java.math.BigDecimal;

import br.com.gregory.candlelight.modelo.SerieTemporal;

public class MediaMovelPonderada implements Indicador{
	
	private Indicador outroIndicador;

	public MediaMovelPonderada(Indicador outroIndicador){
		this.outroIndicador=outroIndicador;
	}

	public BigDecimal calcula(int posicao,SerieTemporal serie){
		
		BigDecimal soma = new BigDecimal("0");
		int peso=3;
		int divisao=0;
		for (int i = posicao; i > posicao-3; i--) {
			soma=soma.add(outroIndicador.calcula(i, serie).multiply(new BigDecimal(peso)));
			
			divisao+=peso;
			peso--;
			
		}
		return soma.divide(new BigDecimal(divisao),BigDecimal.ROUND_UP);
		
	}
	
	public String toString(){
		return "MMP de "+outroIndicador.toString();
	}
}
