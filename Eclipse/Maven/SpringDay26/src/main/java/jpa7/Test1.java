package jpa7;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test1 implements CommandLineRunner {

	@Autowired
	CategoryRepo cat;
	
	public static void main(String[] args) {
		SpringApplication.run(Test1.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		Category c= new Category();
		c.setCatcode("Hd");
		c.setCatdesc("HardDisk");
		Category c1= new Category();
		c1.setCatcode("Dg");
		c1.setCatdesc("DigitalWatch");
		
		cat.saveAll(List.of(c,c1));

	}

}
