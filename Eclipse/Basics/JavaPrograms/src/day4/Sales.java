package day4;

class Transaction {
	private int quantity;
	private int price;
	private static double tax;
	static int count = 0;

	public Transaction(int quantity, int price, double tax) {
		this.quantity = quantity;
		this.price = price;
		this.tax = tax;
		count++;
	}

	public Transaction(int price) {
		count++;
		this.quantity = 1;
		this.price = price;

	}

	public Transaction() {
		count++;
	}

	public int getquantity() {
		return quantity;
	}

	public void setquantity(int quantity) {
		this.quantity = quantity;
	}

	public int getprice() {
		return price;
	}

	public void setprice(int price) {
		this.price = price;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public int getamount() {
		this.price = price * quantity;
		this.price = (int) (price + (price * tax));
		return price;
	}

}

public class Sales {

	public static void main(String[] args) {

		Transaction st = new Transaction(2, 25, 0.12);
		System.out.println(st.getamount());
		System.out.println(Transaction.count);
	}

}
