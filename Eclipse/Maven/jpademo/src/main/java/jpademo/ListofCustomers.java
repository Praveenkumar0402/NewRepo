package jpademo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListofCustomers {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("mssqlserver_msdb");
		EntityManager em=emf.createEntityManager();
		var query=em.createQuery("from Customer", Customer.class);
		var customers=query.getResultList();
		
		for(var cus:customers) {
			System.out.printf("%-10s  %-20s %-15s \n" ,cus.getCust_Name(),cus.getEmail(),cus.getMobile_Num());
		}
	}
}

