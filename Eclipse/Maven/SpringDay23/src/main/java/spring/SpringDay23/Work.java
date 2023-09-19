package spring.SpringDay23;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Primary
@Component
@Lazy
@Scope(scopeName = "prototype")
public class Work implements Quotations {

	public Work() {
		System.out.println("Work()");
	}
	@Override
	public List<String> getQuote() {

		return List.of("Working Developer", "Working Engineer");
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
