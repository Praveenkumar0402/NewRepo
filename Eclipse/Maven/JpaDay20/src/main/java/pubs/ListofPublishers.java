package pubs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListofPublishers {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mssqlserver_pubs_query");
		EntityManager em = emf.createEntityManager();

		List<Publisher> publishers = em.createQuery("from Publisher p join fetch p.titles", Publisher.class).getResultList();
		
		for (Publisher p : publishers) {

			System.out.printf(" %-7s %-30s %-15s %-5s %-20s\n",p.getPub_id(), p.getPub_name(), p.getCity(), p.getState(),
					p.getCountry());
		}

		em.close();
		emf.close();
	}

}
