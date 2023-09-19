package com;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddEmployee {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("mssqlserver_msdb_ddl");
		EntityManager em = emf.createEntityManager();
		
		Department d=new Department();
		d.setDep_name("Civil");
		
		Employee e=new Employee();
		e.setEmp_Name("Chandhu");
		e.setSalary(25000.0);
		
		//d.setEmployee(e);
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}

}
