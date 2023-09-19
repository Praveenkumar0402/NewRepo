package jpa4;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TitleRepo extends CrudRepository<Titles, String> {

	@Query("from Titles where title like '%The%'")
	List<Titles> titles();
}
