package br.com.cabal.entity.core;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.cabal.entity.TrxBandCabalSuporte;

public class DaoTrxBandCabalSuporte extends DAO<TrxBandCabalSuporte>{

	public DaoTrxBandCabalSuporte(EntityManager em,	Class<TrxBandCabalSuporte> classe) {
		super(em, classe);
		// TODO Auto-generated constructor stub
	}

	public TrxBandCabalSuporte listarPorCodigo(Integer Cod) {
		return (TrxBandCabalSuporte) selecionar(Cod);
		
	}
	
	public List<TrxBandCabalSuporte> listarTodos(String namedQuery){
		return super.listar(namedQuery);
	}
	
	public List<TrxBandCabalSuporte> listarTodos(){
		return super.listar();
	}
	/*
	public static void main(String[] args) {
		EntityManager em = EManager.createEntityManager();
		DaoTrxBandCabalSuporte dao = new DaoTrxBandCabalSuporte(em, TrxBandCabalSuporte.class);
		
		for (TrxBandCabalSuporte trxBandCabalSuporte : dao.listar("TrxBandCabalSuporte.findAll")) {
			System.out.println(trxBandCabalSuporte.getCartao());
		}
		dao.listar();
		//dao.listarPorCodigo(Cod);
		//TrxBandCabalSuportePK
	}
	*/
}
