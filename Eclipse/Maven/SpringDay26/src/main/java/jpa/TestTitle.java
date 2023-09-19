package jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

//@SpringBootApplication
public class TestTitle implements CommandLineRunner {

	@Autowired
	TitleRepo tit;

	public static void main(String[] args) {
		SpringApplication.run(TestTitle.class, args);
	}

	public void Titles() {
		for (var t : tit.MoreTitles()) {
			System.out.println(t.toString());
			// System.out.printf("%-7s %-5.2d",t.getTitle_id(),t.getPrice());
		}
	}

	@Override
	public void run(String... args) throws Exception {
		Titles();

	}
}