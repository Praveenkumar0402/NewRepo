package aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test implements CommandLineRunner{
	@Autowired
	private Order ord;
	@Autowired
	private Payment pay;

	public void run(String... args) throws Exception {
		//System.out.println(ord.getClass()); // Proxy, target is Order
		ord.placeOrder();
 		//ord.cancelOrder(1);
// 		System.out.println("Ord Status " + ord.getOrderStatus(1));
 		pay.process();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Test.class, args);
	}
     
}
