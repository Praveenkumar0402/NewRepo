package spring.SpringDay23;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ShowQuotations implements CommandLineRunner{

	//@Autowired(required = false)
	Quotations quo;
	
	public ShowQuotations() {
		System.out.println("ShowQuotations()");
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Quotations : " + quo);
		
	}

}
