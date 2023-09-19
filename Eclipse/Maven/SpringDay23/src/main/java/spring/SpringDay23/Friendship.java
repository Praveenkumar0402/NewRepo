package spring.SpringDay23;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
//@Primary
@Component(value="quotations")
@Lazy
public class Friendship implements Quotations {

	public Friendship() {
		System.out.println("Friendship()");
	}

	@Override
	public List<String> getQuote() {
		return List.of("East or West Friendship is Best");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
