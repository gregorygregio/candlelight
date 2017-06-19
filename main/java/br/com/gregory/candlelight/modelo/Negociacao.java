package br.com.gregory.candlelight.modelo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Negociacao {
	private final BigDecimal preco;
	private final int quantidade;
	private final Calendar data;
	
	public Negociacao(BigDecimal preco, int quantidade, Calendar data) {
		if(data==null){
			throw new IllegalArgumentException("data não pode ser nula");
		}
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		return (Calendar)this.data.clone();
	}
	
	public BigDecimal getVolume()
	{
		return preco.multiply(new BigDecimal(quantidade));
	}

	public boolean isMesmoDia(Calendar outraData) {
		return (this.data.get(Calendar.DAY_OF_MONTH) ==
				outraData.get(Calendar.DAY_OF_MONTH)) 
				
				&&
				
				(this.data.get(Calendar.MONTH) == 
				outraData.get(Calendar.MONTH))

				&&
				
				(this.data.get(Calendar.YEAR) == 
				outraData.get(Calendar.YEAR));
	}
	
	@Override
	public String toString() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String data = sdf.format(this.data.getTime());
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("[Preco ");
		sb.append(this.preco);
		sb.append(", Quantidade ");
		sb.append(this.quantidade);

		sb.append(", Data ");
		sb.append(data);
		
		
		sb.append(']');
		return sb.toString();
	}
}
