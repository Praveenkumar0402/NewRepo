package manytomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListOfCourses {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mssqlserver_msdb");
		EntityManager em = emf.createEntityManager();

		var courses = em.createQuery("from Course", Course.class).getResultList();

		for (var c : courses) {
			System.out.printf("%-5d %-10s ", c.getCourse_id(), c.getCourse_name());
			for (var s : c.getMtm_students()) {
				System.out.printf("%-10s", s.getStu_name());
			}
			System.out.println("\n");
		}

	}

}
