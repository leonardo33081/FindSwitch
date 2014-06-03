package br.com.cabal.entity.core;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DAO<T> {

    private EntityManager em;
    private Class<T> classe;

    public DAO(EntityManager em, Class<T> classe){
    	this.em = em;
    	this.classe = classe;
    	if(em == null)
    		System.out.println("Entity manager está nulo!");
    }
    public boolean gravar(T t){
    	System.out.println("T="+t.toString());
    	this.em.persist(t);
    	return true;
    }
    
    public Object selecionar(Integer codigo){
    	return this.em.getReference(classe, codigo);
    }
   
    @SuppressWarnings("unchecked")
	public List<T> listar(String namedQuery){
    	List<T> results = null;
    	try {
    		//TrxBandCabalSuporte.findAll
    	   Query query = this.em.createNamedQuery(namedQuery);
    	   results = query.getResultList();
    	  } catch (RuntimeException re) {
    		  re.printStackTrace();
    	  }
    		System.out.println("Qtd de registros: " + results.size());
    		return results;
    }
    public List<T> listar(){
    	List<T> results = null;
    	try {
    		//TrxBandCabalSuporte.findAll
    		StringBuilder s = new StringBuilder();
    		s.append(" from ").append(classe.getSimpleName()).append(" c ");
    	   Query query = this.em.createQuery(s.toString() , classe);
    	   results = query.getResultList();
    	  } catch (RuntimeException re) {
    		  re.printStackTrace();
    	  }
    		System.out.println("Qtd de registros: " + results.size());
    		return results;
    }
    public boolean remover(T t){
    	this.em.remove(t);
    	return true;
    }
}


