package jpademo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListProducts {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mssqlserver_msdb");
		EntityManager em = emf.createEntityManager();

		var query = em.createQuery("from Product", Product.class); // JPQL
		var products = query.getResultList();

		for (var pro : products) {
			System.out.printf("%-15s %-15.2f %-5d %-20s %-10s \n", pro.getProdName(), pro.getPrice(), pro.getQoh(),
					pro.getRemarks(), pro.getCatcode());
		}
		em.close();
		emf.close();
	}
}
