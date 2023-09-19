package InheritanceandPoly;

class Course {
	protected String title;
	protected int fee;
	protected String time;

	public Course(String title, int fee, String time) {
		super();
		this.title = title;
		this.fee = fee;
		this.time = time;
	}

	public void print() {
		System.out.println(this.title);
		System.out.println(this.fee);
		System.out.println(this.time);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}

class Online extends Course {
	private String url = "mapsuewqyevci36862gcg.com";

	public Online(String title, int fee, String time) {
		super(title, fee, time);
	}

	@Override
	public void print() {
		super.print();
	}

	public String getUrl() {
		return url;
	}
}

class Classroom extends Course {
	private String address;
	private double discount;

	public Classroom(String title, int fee, String time) {
		super(title, fee, time);
	}

	@Override
	public void print() {
		super.print();
	}

	public String getAddress() {
		return address;
	}

	public double getDiscount() {
		return discount;
	}

	public double getFee() {
		this.fee = (int) (fee - (fee * 0.1));
		return fee;
	}
}

public class Courses {
	public static void main(String[] args) {
		Online on = new Online("Java", 20000, "45 hours");
		on.print();
		System.out.println(on.getUrl());
		Classroom cr = new Classroom("Python", 15000, "30 hours");
		cr.print();
		System.out.println(cr.getFee());

	}
}