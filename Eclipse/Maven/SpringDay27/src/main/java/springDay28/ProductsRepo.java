package springDay28;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepo extends JpaRepository<Product, Integer>  {

	List<Product> findByIdContaining(Integer prodid);

}
