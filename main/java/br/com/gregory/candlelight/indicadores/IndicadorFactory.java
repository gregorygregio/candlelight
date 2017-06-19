package br.com.gregory.candlelight.indicadores;

import java.lang.reflect.Constructor;

public class IndicadorFactory {

	private final String nomeMedia;
	private final String nomeIndicadorBase;

	public IndicadorFactory(String nomeMedia,String nomeIndicadorBase) {
		this.nomeMedia=nomeMedia;
		this.nomeIndicadorBase=nomeIndicadorBase;
	}
	
	public Indicador defineIndicador() {
		
		if(nomeIndicadorBase==null || nomeMedia==null){
			return new MediaMovelSimples(new IndicadorFechamento());
		}

		try{
			
				String pacote ="br.com.gregory.candlelight.indicadores.";
				Class<?> classeIndicadorBase=Class.forName(pacote+nomeIndicadorBase);
				Indicador indicadorBase = (Indicador)classeIndicadorBase.newInstance();
				
				Class<?> classeMedia=Class.forName(pacote+nomeMedia);
				Constructor<?> construtorMedia=classeMedia.getConstructor(Indicador.class);
				
				Indicador indicador= (Indicador)construtorMedia.newInstance(indicadorBase);
				
				return indicador;
				
		}catch(Exception e){
			throw new RuntimeException();
		}
	}
}
