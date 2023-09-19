package jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Transaction implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {InterruptedException.class})
	public void incandDec(int prodid1, int prodid2) {
		//TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
		System.out.println("Transaction Begins");

		int count = jdbcTemplate.update("update products set Price =price+(price*0.1) where ProdId = ?", prodid1);
		if (count == 0) {
			throw new RuntimeException();
			//status.setRollbackOnly();
		} else {

			System.out.println("First Update Done");
			
			count = jdbcTemplate.update("update products set Price =price-(price*0.1) where ProdId = ?", prodid2);
			if (count == 0)
				//status.setRollbackOnly();
				throw new RuntimeException();
			else
				System.out.println("Second update done!");

		}
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
