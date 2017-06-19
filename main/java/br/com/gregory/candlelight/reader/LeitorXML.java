package br.com.gregory.candlelight.reader;

import java.io.InputStream;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.gregory.candlelight.modelo.Negociacao;

public class LeitorXML {
	@SuppressWarnings("unchecked")
	public List<Negociacao> carrega(InputStream input){
		XStream xstream =new XStream(new DomDriver());
		xstream.alias("negociacao", Negociacao.class);
		return (List<Negociacao>) xstream.fromXML(input);
		
	}
}
