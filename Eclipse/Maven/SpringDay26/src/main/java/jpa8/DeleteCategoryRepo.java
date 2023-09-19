package jpa8;

import org.springframework.data.repository.CrudRepository;

public interface DeleteCategoryRepo extends CrudRepository<DeleteCategory, String> {
	
//	 @Transactional
//	 DeleteCategory deleteBycatcode(String catcode);

}
