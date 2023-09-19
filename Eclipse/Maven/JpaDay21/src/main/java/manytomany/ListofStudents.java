package manytomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListofStudents {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mssqlserver_msdb");
		EntityManager em = emf.createEntityManager();

		var students = em.createQuery("from Student", Student.class).getResultList();

		for (var s : students) {
			System.out.printf("%-5d %-10s", s.getStu_Id(), s.getStu_name());
			for (var c : s.getMtm_courses()) {
				System.out.printf("%-5s", c.getCourse_name());
			}
			System.out.println("\n");
		}
	}

}
