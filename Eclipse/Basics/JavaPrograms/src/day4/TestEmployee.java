package day4;

class Employee {
	private String name;
	private String job;

	public Employee(String name, String job) {
		this.name = name;
		this.job = job;
	}

	public void print() {
		System.out.println(this.name);
		System.out.println(this.job);
	}
}

class SalariedEmployee extends Employee {
	protected int salary;

	public SalariedEmployee(String name, String job, int salary) {
		super(name, job);
		this.salary = salary;
	}

	@Override
	public void print() {
		super.print();
		System.out.println(this.salary);
	}

	public int getSalary() {
		return this.salary;
	}
}

class Consultant extends Employee {
	private int hours;
	private double price;

	public Consultant(String name, String job, int hours, double price) {
		super(name, job);
		this.hours = hours;
		this.price = price;
	}

	@Override
	public void print() {
		super.print();
		System.out.println(this.hours);
		System.out.println(this.price);
	}

	public double getPayment() {
		return hours * price;
	}
}

class OverseasEmp extends SalariedEmployee {

	private int allowance;

	public OverseasEmp(String name, String job, int salary, int allowance) {
		super(name, job, salary);
		this.allowance = allowance;
	}

	@Override
	public void print() {
		super.print();
		System.out.println(this.allowance);
	}

	public double getAllowance() {
		return salary + allowance;
	}
}

public class TestEmployee {

	public static void main(String[] args) {
		SalariedEmployee se = new SalariedEmployee("Jack", "Developer", 10000);
		Consultant ct = new Consultant("David", "Java", 5, 1000);
		OverseasEmp oe = new OverseasEmp("Kane", "Python", 20000, 4000);
		se.print();
		ct.print();
		System.out.println(ct.getPayment());
		oe.print();
		System.out.println(oe.getAllowance());

	}

}