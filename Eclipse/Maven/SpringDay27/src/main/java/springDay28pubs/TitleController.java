package springDay28pubs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class TitleController {
	@Autowired
	TitleRepo tr;
	@Autowired
	PublisherRepo pr;
	@Autowired
	AuthorRepo ar;

	/* 4 */@GetMapping("/getprice")
	public List<Title> getallwithprice(@RequestParam("max") int max, @RequestParam("min") int min) {
		return tr.findByPriceBetween(min, max);
	}

	/* 6 */ @PutMapping("/update/{id}")
	public Title updateTitleprice(@PathVariable("id") String id, @RequestParam("price") Double price) {

		var ts = tr.findById(id);
		if (ts.isPresent()) {
			var t = ts.get();
			t.setPrice(price);
			tr.save(t);
			return t;
		} else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Title Id Not Found");
	}

	/* 7 */@GetMapping("/sales")
	public List<Title> getTop5Titles() {
		return tr.getTopTitles();
	}

	/* 8 */@GetMapping("/types/{type}")
	public List<Title> getTitlesByType(@PathVariable("type") String type) {
		return tr.findByTypeContaining(type);

	}

	/* 5 */@GetMapping("/author/{ad}")
	public List<String> getTitleByAuthor(@PathVariable("ad") String ad) {
		return tr.getTitlesByAuid(ad);

	}

	/* 9 */@GetMapping("/title/{city}")
	public List<String> getcitypublisher(@PathVariable("city") String city) {
		return tr.getTitlesByCity(city);
	}

}
