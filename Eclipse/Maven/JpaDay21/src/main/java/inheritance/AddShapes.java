package inheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddShapes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mssqlserver_msdb_ddl");
		EntityManager em = emf.createEntityManager();

		Circle c = new Circle();
		c.setRadius(5);
		c.setX(4);
		c.setY(2);

		Square s = new Square();
		s.setX(6);
		s.setY(3);
		s.setSide(6);

		Rectangle r = new Rectangle();
		r.setX(7);
		r.setY(5);
		r.setLength(4);
		r.setBreadth(3);

		em.getTransaction().begin();
		em.persist(c);
		em.persist(s);
		em.persist(r);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}

}
