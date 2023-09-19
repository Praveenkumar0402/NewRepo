package concurency;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddPerson {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("mssqlserver_msdb_ddl");
		EntityManager em=emf.createEntityManager();
		
		Person p=new Person();
		p.setName("Praveen");
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
}
