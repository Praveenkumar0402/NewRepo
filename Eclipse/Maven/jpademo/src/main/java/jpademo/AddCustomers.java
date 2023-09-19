package jpademo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddCustomers {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mssqlserver_msdb");
		EntityManager em = emf.createEntityManager();

		Customer c = new Customer();
		c.setCust_Name("David");
		c.setEmail("david@gmail.com");
		c.setMobile_Num("9874874344");

		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
