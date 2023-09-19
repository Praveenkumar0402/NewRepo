package day5;

abstract class Products {
	protected String name;
	protected double price;
	protected int quantity;

	public Products(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public void print() {
		System.out.println(this.name);
		System.out.println(this.price);
		System.out.println(this.quantity);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public abstract double getNetPrice();
}

class LocalProduct extends Products {
	protected static double tax = 0.05;

	public LocalProduct(String name, double price, int quantity) {
		super(name, price, quantity);
	}

	public static double getTax() {
		return tax;
	}

	public static void setTax(double tax) {
		LocalProduct.tax = tax;
	}

	@Override
	public void print() {
		super.print();
	}

	public double getNetPrice() {
		this.price = price * quantity;
		this.price = (price + (price * tax));
		return price;
	}

}

class Discount extends Products {
	private static double discount = 0.7;

	public Discount(String name, double price, int quantity) {
		super(name, price, quantity);
	}

	public static double getDiscount() {
		return discount;
	}

	public static void setDiscount(double discount) {
		Discount.discount = discount;
	}

	@Override
	public void print() {
		super.print();
	}

	public double getNetPrice() {
		this.price = price * quantity;
		this.price = (price - (price * discount));
		return price;
	}
}

class Imported extends LocalProduct {
	protected static double imptax = 0.1;

	public Imported(String name, double price, int quantity) {
		super(name, price, quantity);
	}

	public void setTax(int tax) {
		LocalProduct.tax = tax;
	}

	public static double getTax() {
		return getTax();
	}

	public static double getImptax() {
		return imptax;
	}

	public static void setImptax(double imptax) {
		Imported.imptax = imptax;
	}

	@Override
	public void print() {
		super.print();
	}

	public double getNetPrice() {
		this.price = price * quantity;
		this.price = (price + (price * tax + price * imptax));
		return price;
	}
}

public class StoreDetails {
	public static void main(String[] args) {
		LocalProduct ld = new LocalProduct("Soap", 30, 2);
		Discount dt = new Discount("Bottle", 100, 3);
		Imported ip = new Imported("Shirt", 500, 5);
		ld.print();
		System.out.println(ld.getNetPrice());
		System.out.println("----------------------");
		dt.print();
		System.out.println(dt.getNetPrice());
		System.out.println("----------------------");
		ip.print();
		System.out.println(ip.getNetPrice());
	}

}
