package com;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListOfEmployee {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mssqlserver_msdb");
		EntityManager em = emf.createEntityManager();

		List<Employee> employees = em.createQuery("from Employee emp join fetch emp.otm_department", Employee.class)
				.getResultList();

		double sum = 0;
		for (Employee emp : employees) {

			System.out.printf("%-7d %-10s %-15.2f %-5s %15.2f \n", emp.getEmp_id(), emp.getEmp_Name(),emp.getSalary(),
					emp.getOtm_Department().getDep_code(),sum);
			sum = sum + emp.getSalary();
		}

		em.close();
		emf.close();
	}

}
