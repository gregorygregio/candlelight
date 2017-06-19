package br.com.gregory.candlelight.modelo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Candle {
	
	public BigDecimal getAbertura() {
		return abertura;
	}

	public BigDecimal getFechamento() {
		return fechamento;
	}

	public BigDecimal getMaximo() {
		return maximo;
	}

	public BigDecimal getMinimo() {
		return minimo;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public Calendar getData() {
		return data;
	}

	private final BigDecimal abertura;
	private final BigDecimal fechamento;
	private final BigDecimal maximo;
	private final BigDecimal minimo;
	private final BigDecimal volume;
	private final Calendar data;
	
	public Candle(BigDecimal abertura, BigDecimal fechamento, BigDecimal maximo, BigDecimal minimo, BigDecimal volume, Calendar data) {
		

		if(abertura==null || fechamento==null || maximo==null
				|| minimo==null || volume==null || data==null){
			throw new IllegalArgumentException();
		}
		if(minimo.compareTo(maximo)>0){
			throw new IllegalArgumentException();
		}
		
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.maximo = maximo;
		this.minimo = minimo;
		this.volume = volume;
		this.data = data;
	}
	
	public boolean isAlta(){
		return this.fechamento.compareTo(this.abertura)>=0;
	}
	public boolean isBaixa(){
		return this.abertura.compareTo(this.fechamento)>0;
	}
	
	
	@Override
	public String toString() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String data = sdf.format(this.data.getTime());
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("[Abertura ");
		sb.append(this.abertura);
		sb.append(", Fechamento ");
		sb.append(this.fechamento);
		sb.append(", Minimo ");
		sb.append(this.minimo);
		sb.append(", Maximo ");
		sb.append(this.maximo);
		sb.append(", Volume ");
		sb.append(this.volume);
		sb.append(", Data ");
		sb.append(data);
		
		
		sb.append(']');
		return sb.toString();
	}
	
}
