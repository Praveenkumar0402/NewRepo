package concurency;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdatePerson {

	public static void main(String[] args) throws Exception {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("mssqlserver_msdb_ddl");
		EntityManager em=emf.createEntityManager();
		
		em.getTransaction().begin();
		Person p=em.find(Person.class,1);
		p.setName("Praveen1");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter to Continue!");
		em.persist(p);
		em.getTransaction().commit();
		sc.close();
		em.close();
		emf.close();
	}

}
