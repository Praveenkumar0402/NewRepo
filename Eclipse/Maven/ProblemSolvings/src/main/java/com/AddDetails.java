package com;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddDetails {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mssqlserver_msdb_ddl");
		EntityManager em = emf.createEntityManager();

		Persons p = new Persons();
		p.setName("Hari");

		Employees e = new Employees();
		e.setEmpid(251);
		e.setName("Praveen");
		e.setMonth(7);
		e.setSalaries(10000);
		e.setSalaries(e.getSalaries());

		Customers c = new Customers();
		c.setCustid(105);
		c.setName("Sardhar");
		c.setProduct("dewq");
		c.setPrice(1000);
		c.setLpoints(c.getLpoints());

		em.getTransaction().begin();
		em.persist(p);
		em.persist(e);
		em.persist(c);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}