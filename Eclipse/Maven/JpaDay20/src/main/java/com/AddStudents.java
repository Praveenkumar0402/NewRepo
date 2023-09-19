package com;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddStudents {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mssqlserver_msdb_ddl");
		EntityManager em=emf.createEntityManager();
		
		Student s=new Student();
		s.setStu_Name("hari");
		
		Payments p=new Payments();
		p.setAmount(5000);
		p.setDateofpayment("02/19/2022");
		
		s.setPayments(p);
		
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
