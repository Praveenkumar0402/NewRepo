package springDay28;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CategoryController {

	@Autowired
	CategoryRepo cr;

	@PostMapping("/cats")
	public Category addCategory(@RequestBody Category cat) {
		var c = cr.findById(cat.getCatcode());
		if (c.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "catcode is already present");
		} else {
			cr.save(cat);
			return cat;
		}
	}

}
