package com;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListofPublishers {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mssqlserver_pubs");
		EntityManager em = emf.createEntityManager();
		var query = em.createQuery("from Publishers", Publishers.class);
		var publishers = query.getResultList();

		for (var pub : publishers) {
			System.out.printf("%-5d %-30s %-15s %-10s %-10s \n", pub.getPub_id(), pub.getPub_name(), pub.getCity(),
					pub.getState(), pub.getCountry());
		}
		em.close();
		emf.close();
	}

}
