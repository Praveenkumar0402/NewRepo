package jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TitleRepo extends CrudRepository<Title, String> {

	@Query("from Title where price > 10")
	List<Title> MoreTitles();

}
