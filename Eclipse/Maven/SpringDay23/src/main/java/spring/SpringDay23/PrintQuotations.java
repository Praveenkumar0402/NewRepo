package spring.SpringDay23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class PrintQuotations implements CommandLineRunner {

	@Autowired
	@Qualifier("quotations")
	Quotations quotations;
	
	public PrintQuotations() {
		System.out.println("PrintCatalog()");
		System.out.println(quotations);
	}

	@PostConstruct
	public void init() {
		System.out.println("PostConstruct");
		System.out.println(quotations);
	}
	
	@PreDestroy
	public void beforeDestory() {
		System.out.println("PreDestory");
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println(quotations.hashCode());
	
		for (var q : quotations.getQuote()) {
			System.out.println(q);
		}

	}

}
