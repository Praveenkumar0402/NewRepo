package pubs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListofTitles {

	public static void main(String[] args) throws Exception{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mssqlserver_pubs_query");
		EntityManager em = emf.createEntityManager();

		List<Title> titles = em.createQuery("from Title", Title.class).getResultList();

		
		for (Title t : titles) {
			System.out.printf("%-5s  %-70s %-15s %-10s %-20s %-5s %-10s %-200s %-20s\n", t.getTitle_id(),t.getTitle(),t.getType(),t.getPrice(),t.getAdvance(),t.getRoyalty(),t.getYtd_sales(),t.getNotes(),t.getPubdate());
		}
		

		em.close();
		emf.close();

	}

}
