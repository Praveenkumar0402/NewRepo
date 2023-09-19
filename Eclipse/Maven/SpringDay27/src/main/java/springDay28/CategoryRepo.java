package springDay28;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, String>{

	boolean findByCatcodeContaining(Category cat);
	//boolean existsByCatcode(Category catcode);
}

