package aop;

import org.springframework.stereotype.Component;

@Component
public class Payment {	
	public void process() {
		   System.out.println("Processing Payment");
	   }
}
