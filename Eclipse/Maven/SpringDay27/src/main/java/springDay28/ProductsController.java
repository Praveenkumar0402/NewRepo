package springDay28;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ProductsController {
	@Autowired
	private ProductsRepo prepo;

	
	@GetMapping("/prod/{id}")
	public Product getProductsById(@PathVariable("id") int id) {
		var pro = prepo.findById(id);
		if (pro.isPresent())
			return pro.get();
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product id Not Found");
	}

	@DeleteMapping("/prods/{id}")
	public void deleteProductById(@PathVariable("id") int id) {
		var pro = prepo.findById(id);
		if (pro.isPresent())
			prepo.deleteById(id);
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Id Not Found");
	}
	
	@PostMapping("/prod")
	public Product addProduct(@RequestBody Product prod) {
		try {
			prepo.save(prod);
			return prod;
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid data!");
		}
	}

	@PutMapping("/prod/{id}")
	public Product updateProductprodname(@PathVariable("id") int prodid,@RequestParam("prodname") String prodname) {
		if (prodname.length()==0)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Prodname");
		
		var pd = prepo.findById(prodid);
		if (pd.isPresent()) {
			var prod = pd.get();
			prod.setProdname(prodname);
			prepo.save(prod);
			return prod;
		} else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "product Id Not Found");
	}
}