package day3;

public class SaleTransaction {
	private int quantity;
	private int price;

	public SaleTransaction(int quantity, int price) {
		this.quantity = quantity;
		this.price = price;
	}

	public SaleTransaction(int price) {
		this.quantity = 1;
		this.price = price;
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

	public int getamount() {
		this.price = price * quantity;
		this.price = (int) (price + (price * 0.12));
		return price;
	}

}
