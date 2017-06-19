package br.com.gregory.candlelight.grafico;

import java.math.BigDecimal;

import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.OhlcChartModel;
import org.primefaces.model.chart.OhlcChartSeries;

import br.com.gregory.candlelight.indicadores.Indicador;
import br.com.gregory.candlelight.modelo.Candle;
import br.com.gregory.candlelight.modelo.SerieTemporal;

public class GeradorModeloGrafico {
	private final int fim;
	private final int comeco;
	private SerieTemporal serie;
	private LineChartModel modeloGraficoIndicador;
	private OhlcChartModel modeloGraficoCandles;
	
	public OhlcChartModel getModeloGraficoCandles() {
		return modeloGraficoCandles;
	}

	public GeradorModeloGrafico(SerieTemporal serie, int comeco, int fim){
		this.serie=serie;
		this.comeco=comeco;
		this.fim=fim;
		this.modeloGraficoIndicador=new LineChartModel();
		this.modeloGraficoCandles=new OhlcChartModel();
	}

	public ChartModel getModeloGraficoLine() {
		return modeloGraficoIndicador;
	}
	
	public void plotaIndicador(Indicador indicador){

		LineChartSeries chartSeries = new LineChartSeries(indicador.toString());
		
		for (int i = comeco; i <= fim; i++) {
			BigDecimal valor=indicador.calcula(i, serie);
			chartSeries.set(i,valor);
		}
		
		this.modeloGraficoIndicador.addSeries(chartSeries);
	    this.modeloGraficoIndicador.setLegendPosition("w");
	    this.modeloGraficoIndicador.setTitle("indicadores");
	}

	public void plotaCandle(){
		
		for (int i = comeco; i <= fim; i++) {
			Candle candle=serie.getCandle(i);   
			modeloGraficoCandles.add(new OhlcChartSeries(i, candle.getAbertura().doubleValue(),
					candle.getMaximo().doubleValue(), candle.getMinimo().doubleValue(),
					candle.getFechamento().doubleValue()));
		}
		
		modeloGraficoCandles.setTitle("Candlestick");
		modeloGraficoCandles.setCandleStick(true);
		
	}
	
	
	
}
