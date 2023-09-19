package com;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetCategories {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mssqlserver_msdb");
		EntityManager em = emf.createEntityManager();

		Scanner s = new Scanner(System.in);
		String query;
		while (true) {
			System.out.println("Enter Query [enter to stop] : ");
			query = s.nextLine();
			if (query.length() == 0)
				break;
			try {
				var result = em.createQuery(query).getResultList();
				System.out.println("Query Result");

				for (Object obj : result) {
					if (obj instanceof Object[]) {
						for (Object o : (Object[]) obj) {
							System.out.print(o == null ? "  " : o.toString() + "  ");
						}
						System.out.println();
					} else
						System.out.println(obj.toString());

				}
			} catch (Exception ex) {
				System.out.println("Error-->" + ex.getMessage());
			}
		}
		s.close();
		em.close();
		emf.close();
	}
}
