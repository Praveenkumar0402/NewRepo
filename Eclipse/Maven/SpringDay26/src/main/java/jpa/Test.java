package jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test implements CommandLineRunner {

	@Autowired
	CategoryRepo catRepo;

	public static void main(String[] args) {
		SpringApplication.run(Test.class, args);
	}

	public void update(String catdesc, String code) {
		Category cat = catRepo.findById(code).get();
		cat.setCatdesc(catdesc);
		catRepo.save(cat);
	}

	public void delete(String code) {
		catRepo.deleteById(code);
		System.out.println("deleted");
	}

	@Override
	public void run(String... args) throws Exception {
		update("Boat", "Buds");
		delete("rp");

	}
}
