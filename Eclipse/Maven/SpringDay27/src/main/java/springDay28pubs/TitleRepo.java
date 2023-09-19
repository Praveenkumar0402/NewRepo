package springDay28pubs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TitleRepo extends JpaRepository<Title, String> {

	List<Title> findByTypeContaining(String type);

	@Query("from Title order by sales desc limit 5")
	List<Title> getTopTitles();

	List<Title> findByPriceBetween(int min, int max);

	@Query("select t.title from Title t join t.authors a where a.auid=:ad")
	List<String> getTitlesByAuid(@Param("ad") String ad);

	@Query("select title from Title where publishers.city=:city")
	List<String> getTitlesByCity(@Param("city") String city);

}
