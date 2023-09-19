package com;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetSale {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mssqlserver_msdb_query");
		EntityManager em = emf.createEntityManager();

		var query = em.createQuery("select invno,products.prodName,amount,transdate from com.Sales").getResultList();
		for (Object o : query) {
			if (o instanceof Object[] obj) {
				for (var a : obj) {
					System.out.println(a.toString());
				}
			} else {
				System.out.println(o.toString());
			}
		}
		em.close();
		emf.close();
	}

}
