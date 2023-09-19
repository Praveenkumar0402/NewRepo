package inheritance2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddShapes2 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mssqlserver_msdb_ddl");
		EntityManager em = emf.createEntityManager();

		Store2 st=new Store2();
		st.setX(10);
		st.setY(12);
		
		Circle2 c = new Circle2();
		c.setRadius(5);

		Square2 s = new Square2();
		s.setSide(7);

		Rectangle2 r = new Rectangle2();
		r.setLength(8);
		r.setBreadth(9);

		em.getTransaction().begin();
		em.persist(c);
		em.persist(s);
		em.persist(r);
		em.persist(st);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}

}
