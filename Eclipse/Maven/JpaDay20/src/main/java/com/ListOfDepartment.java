package com;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListOfDepartment {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mssqlserver_msdb");
		EntityManager em = emf.createEntityManager();

		List<Department> department = em
				.createQuery("from Department", Department.class).getResultList();
		
		for (Department dep : department) {
			System.out.printf("%-10s",dep.getDep_name());
			for(var emp:dep.getOtm_employees()) {
				System.out.printf("%-10s %10.2f",emp.getEmp_Name(),emp.getSalary());

			}
				
		}
		em.close();
		emf.close();

	}

}
