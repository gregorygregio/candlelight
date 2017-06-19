package br.com.caelum.argentum.modelo;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import br.com.gregory.candlelight.modelo.Negociacao;

public class NegociacaoTest {

	@Test
	public void dataDaNegociacaoEhImutavel() {
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.DAY_OF_MONTH, 15);
		Negociacao n = new Negociacao(new BigDecimal("35.7"), 100, c);
		
		n.getData().set(Calendar.DAY_OF_MONTH, 20);
		
		assertEquals(15, n.getData().get(Calendar.DAY_OF_MONTH));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula(){
		new Negociacao(new BigDecimal("10"),5,null);
	}
	
	
	@Test
	public void mesmoMilisegundoEhMesmoDia(){
		Calendar agora= Calendar.getInstance();
		Calendar mesmoMomento= (Calendar)agora.clone();
		
		Negociacao negociacao = new Negociacao(new BigDecimal("40.0"),100,agora);
		assertTrue(negociacao.isMesmoDia(mesmoMomento));
	}
	@Test
	public void comHorariosDiferentesEhMesmoDia(){
		Calendar manha=new GregorianCalendar(2011,10,20,8,30);
		Calendar tarde=new GregorianCalendar(2011,10,20,15,30);
		
		Negociacao negociacao = new Negociacao(new BigDecimal("40.0"),100,manha);
		
		assertTrue(negociacao.isMesmoDia(tarde));
	}
	
	@Test
	public void mesmoDiaMasMesDiferenteNaoEhMesmoDia(){
		Calendar mes1=new GregorianCalendar(2011,11,20,15,30);
		Calendar mes2=new GregorianCalendar(2011,10,20,15,30);
		
		Negociacao negociacao = new Negociacao(new BigDecimal("40.0"),100,mes1);
		
		assertTrue(!negociacao.isMesmoDia(mes2));
	}
	@Test
	public void mesmoDiaEMesMasAnosDiferentesNaoSaoDoMesmoDia(){
		Calendar ano1=new GregorianCalendar(2011,11,20,15,30);
		Calendar ano2=new GregorianCalendar(2012,11,20,15,30);
		
		Negociacao negociacao = new Negociacao(new BigDecimal("40.0"),100,ano1);
		
		assertTrue(!negociacao.isMesmoDia(ano2));
	}

}
