package InheritanceandPoly;

class Doctor {
	protected String name;
	protected String degree;

	public Doctor(String name, String degree) {
		this.name = name;
		this.degree = degree;
	}

	public void print() {
		System.out.println(this.name);
		System.out.println(this.degree);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

}

class Resident extends Doctor {
	private double salary;

	public Resident(String name, String degree, double salary) {
		super(name, degree);
		this.salary = salary;

	}

	@Override
	public void print() {
		super.print();
	}

	public double getPay() {
		return salary;
	}
}

class Consultant extends Doctor {
	private int visit;
	private int rate;

	public Consultant(String name, String degree, int visit, int rate) {
		super(name, degree);
		this.visit = visit;
		this.rate = rate;
	}

	@Override
	public void print() {
		super.print();

	}

	public double getPay() {
		return visit * rate;
	}
}

public class DoctorDetails {

	public static void main(String[] args) {
		Resident rt = new Resident("Jack", "MBBS", 50000);
		rt.print();
		System.out.println(rt.getPay());
		Consultant ct = new Consultant("James", "RMP", 2, 500);
		ct.print();
		System.out.println(ct.getPay());
	}

}
