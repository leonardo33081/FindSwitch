package br.com.cabal.entity.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vaadin.data.Container;
import com.vaadin.data.Container.Filter;
import com.vaadin.data.util.filter.Compare;

public class Filtro {

	public static Filter filtrarDadosWS(String origem){	
		Filter filter = new Compare.Equal("id.origem", origem);
		return filter;
	}
	
	public static Filter filtrarDadosWSPeriodoMaiorQue(String campo, Date data){	
		Filter filter = new Compare.GreaterOrEqual(campo, data);
		return filter;
	}
	
	public static Filter filtrarPorCodigo(String campo, String codigo){
		Filter filter = new Compare.Equal(campo, codigo);
		return filter;
	}
	public static List<Filter> filtrarPorPeriodo(String campo, Date dataMenor,Date dataMaior){
		List<Container.Filter> f = new ArrayList<Container.Filter>();
		
		Filter fMaiorOuIgual = new Compare.GreaterOrEqual(campo, dataMenor);
		f.add(fMaiorOuIgual);
		Filter fMenorOuIgual = new Compare.LessOrEqual(campo, dataMaior);
		f.add(fMenorOuIgual);
		return f;
	}
}
