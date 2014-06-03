package br.com.cabal.entity.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EManager {

	public static EntityManager createEntityManager(){
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("EntityBandeira");
			return factory.createEntityManager();
		} catch (Exception e) {
			System.out.println(e.getCause() + "#" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	} 
	public static void main(String[] args) {
		EManager.createEntityManager();
		System.out.println("Ok");
	}
}
