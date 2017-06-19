package br.com.caelum.argentum.reader;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import br.com.gregory.candlelight.modelo.Candle;
import br.com.gregory.candlelight.modelo.CandleFactory;
import br.com.gregory.candlelight.modelo.Negociacao;
import br.com.gregory.candlelight.reader.LeitorXML;

public class LeitorXMLTest {

	@Test
	public void carregaXmlComUmaNegociacaoEmListaUnitaria() {
		String xmlTeste= "<list>" +
		          "  <negociacao>" +
		          "    <preco>43.5</preco>" +
		          "    <quantidade>1000</quantidade>" +
		          "    <data>" +
		          "      <time>1322233344455</time>" +
		          "    </data>" +
		          "  </negociacao>" +
		          "</list>";
		LeitorXML leitor = new LeitorXML();
		InputStream xml = new ByteArrayInputStream(xmlTeste.getBytes());
		
		List<Negociacao> negociacoes=leitor.carrega(xml);
		
		assertEquals(1,negociacoes.size());
		assertEquals(1000,negociacoes.get(0).getQuantidade());
		assertEquals(new BigDecimal("43.5"),negociacoes.get(0).getPreco());
	}
	
	
	@Test
	public void carregaXmlComMultiplasNegociacoesEmListaUnitaria() {
		String xmlTeste= "<list>" +
		          "  <negociacao>" +
		          "    <preco>43.5</preco>" +
		          "    <quantidade>1000</quantidade>" +
		          "    <data>" +
		          "      <time>1322233344455</time>" +
		          "    </data>" +
		          "  </negociacao>" +
		          "  <negociacao>" +
		          "    <preco>45.5</preco>" +
		          "    <quantidade>1000</quantidade>" +
		          "    <data>" +
		          "      <time>1322233345455</time>" +
		          "    </data>" +
		          "  </negociacao>" +
		          "</list>"
		        
		        ;
		LeitorXML leitor = new LeitorXML();
		InputStream xml = new ByteArrayInputStream(xmlTeste.getBytes());
		
		List<Negociacao> negociacoes=leitor.carrega(xml);
		CandleFactory cfactory=new CandleFactory();
		
		Candle candle=cfactory.constroiCandlestickParaData(Calendar.getInstance(), negociacoes);
		
		assertEquals(2,negociacoes.size());
		assertEquals(new BigDecimal("89000.0"),candle.getVolume());
		assertEquals(new BigDecimal("45.5"),candle.getMaximo());
	}

}
