package com;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NamedQuery {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mssqlserver_msdb_query");
		EntityManager em = emf.createEntityManager();

		var query = em.createNamedQuery("Costly").getResultList();
		
		for(var j:query) {
			System.out.println(j);
		}
			
		em.close();
		emf.close();

	}

}
