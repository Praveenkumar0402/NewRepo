package jpa5;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TitleCountRepo extends CrudRepository<TitleCount, String> {

	@Query("select count(title) from TitleCount")
	int countv();
}
