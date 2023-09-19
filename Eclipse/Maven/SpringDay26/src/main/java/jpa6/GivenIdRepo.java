package jpa6;

import org.springframework.data.repository.CrudRepository;

public interface GivenIdRepo extends CrudRepository<Title, String> {

	Title findByTitleid(String Titleid);

}
