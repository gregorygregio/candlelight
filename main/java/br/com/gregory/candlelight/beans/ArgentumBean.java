package br.com.gregory.candlelight.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.ChartModel;

import br.com.gregory.candlelight.grafico.GeradorModeloGrafico;
import br.com.gregory.candlelight.indicadores.IndicadorFactory;
import br.com.gregory.candlelight.modelo.Candle;
import br.com.gregory.candlelight.modelo.CandleFactory;
import br.com.gregory.candlelight.modelo.Negociacao;
import br.com.gregory.candlelight.modelo.SerieTemporal;
import br.com.gregory.candlelight.ws.ClienteWebServices;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ArgentumBean implements Serializable{
	private List<Negociacao> negociacoes;
	private ChartModel modeloGrafico1,modeloGrafico2;
	
	public ChartModel getModeloGrafico2() {
		return modeloGrafico2;
	}

	public void setModeloGrafico2(ChartModel modeloGrafico2) {
		this.modeloGrafico2 = modeloGrafico2;
	}

	private String nomeMedia;
	public String getNomeMedia() {
		return nomeMedia;
	}

	public void setNomeMedia(String nomeMedia) {
		this.nomeMedia = nomeMedia;
	}

	public String getNomeIndicadorBase() {
		return nomeIndicadorBase;
	}

	public void setNomeIndicadorBase(String nomeIndicadorBase) {
		this.nomeIndicadorBase = nomeIndicadorBase;
	}

	private String nomeIndicadorBase;

	public ArgentumBean(){
		  
		  this.negociacoes = new ClienteWebServices().getNegociacoes();
		  geraGrafico();
	}

	public void geraGrafico() {
		
		  List<Candle> candles = new CandleFactory().constroiCandles(negociacoes);
		  SerieTemporal serie = new SerieTemporal(candles);

		  
		  GeradorModeloGrafico gerador = new GeradorModeloGrafico(serie, 2, serie.getUltimaPosicao());
		  
		  gerador.plotaIndicador(new IndicadorFactory(nomeMedia,nomeIndicadorBase).defineIndicador());

		  gerador.plotaCandle();
		  
		  this.modeloGrafico1 = gerador.getModeloGraficoLine();
		  this.modeloGrafico2 = gerador.getModeloGraficoCandles();
	}
	


	public List<Negociacao> getNegociacoes(){
		return this.negociacoes;
	}
	
	public ChartModel getModeloGrafico1(){
		return this.modeloGrafico1;
	}
}
