package ecm;

class Person {
	protected int id;
	protected String name;

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void print() {
		System.out.println(id);
		System.out.println(name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

class Employee extends Person {
	protected double salary;

	public Employee(int id, String name, double salary) {
		super(id, name);
		this.salary = salary;
	}

	@Override
	public void print() {
		super.print();
	}

	public double getSalary() {
		var x = salary + (salary * 0.1);
		return x;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}

class Customer extends Person {
	protected String product;
	protected double price;
	protected int lpoints;

	public Customer(int id, String name, String product, double price) {
		super(id, name);
		this.price = price;
		this.product = product;
	}

	@Override
	public void print() {
		super.print();
		System.out.println(price);
		System.out.println(product);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getLpoints() {
		int lp = (int) (price / 250);
		return lp;
	}

	public void setLpoints(int lpoints) {
		this.lpoints = lpoints;
	}

}

public class Details {
	public static void main(String[] args) {

		Person p= new Person(100, "Hari");
		Employee e = new Employee(1, "Ajay", 20000);
		Customer c = new Customer(2, "Jack", "Shirt", 2000);
		p.print();
		System.out.println("===========");
		e.print();
		//System.out.println(e.getSalary());
		System.out.println("=============");
		c.print();
		System.out.println(c.getLpoints());
	}
}
