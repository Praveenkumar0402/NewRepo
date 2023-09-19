package jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Products implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbcTemplate;

	// 1-Adding row in Products table
	public void addProducts(String ProdName, double Price, int Qoh, String Remarks, String CatCode) {
		jdbcTemplate.update("insert into products values(?,?,?,?,?)", ProdName, Price, Qoh, Remarks, CatCode);
		System.out.println("Added Successfully!");
	}

	// listProducts Table
	public void listProducts() {
		var cats = jdbcTemplate.queryForList(
				"select ProdName as name, Price as p,Qoh as q,Remarks as r,CatCode as code from products");

		for (var cat : cats) {
			System.out.printf("%-20s %-10.2f %-5d %-20s %-10s\n", cat.get("name"), cat.get("p"), cat.get("q"),
					cat.get("r"), cat.get("code"));
		}
	}

	// 2-Update a new price
	public void addNewPrice(double Price) {
		jdbcTemplate.update("update products set price=? where ProdId=108", Price);
		System.out.println("Added Successfully!");
	}

	// 3-Delete Sales
	public void deleteSales(int Invno) {
		jdbcTemplate.update("delete sales where Invno=?", Invno);
		System.out.println("Deleted Successfully!");
	}

	// 4-Total Units for given Product
	public void totalUnits(int ProdId) {
		var data = jdbcTemplate.queryForList(
				"select p.ProdName,s.ProdId,sum(s.Qty) as No_Of_Qty from sales s join products p on p.ProdId=s.Prodid "
						+ "group by s.ProdId,p.ProdName having s.Prodid=?",
				ProdId);

		for (var i : data) {
			System.out.printf("%-10s %-5d %-5d \n", i.get("ProdName"), i.get("ProdId"), i.get("No_Of_Qty"));
		}
	}

	// 5-AveragePrice
	public void avgPrice() {
		var data = jdbcTemplate.queryForList(
				"select c.CatDesc,avg(p.Price) as Average from categories c join products p on c.CatCode=p.CatCode group by CatDesc ");
		for (var l : data) {
			System.out.printf("%-20s %-10.2f \n", l.get("CatDesc"), l.get("Average"));
		}
	}

	// 6-Increase and Decrease
	public void incandDec(int ProdId, int id) {
		jdbcTemplate.update("update products set Price=Price*1.1 where ProdId=?", ProdId);
		System.out.println("Increased Successfully!");
		jdbcTemplate.update("update products set Price=Price-(Price*0.1) where ProdId=?", id);
		System.out.println("Decreased Successfully!");
	}

	@Override
	public void run(String... args) throws Exception {
		addProducts("Digital Watch", 10000, 2, "New Version", "Mp");
		listProducts();
		addNewPrice(7000);
		deleteSales(16);
		totalUnits(101);
		avgPrice();
		incandDec(106, 111);
	}
}
