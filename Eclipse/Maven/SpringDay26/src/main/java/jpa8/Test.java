package jpa8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test implements CommandLineRunner {

	@Autowired
	DeleteCategoryRepo dcr;

	public static void main(String[] args) {
		SpringApplication.run(Test.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dcr.deleteById("Mr");
		//System.out.println(dcr.deleteBycatcode("Mr"));
	}

}
