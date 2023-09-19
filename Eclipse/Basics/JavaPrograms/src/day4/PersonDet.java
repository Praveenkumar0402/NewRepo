package day4;

class Person {
	protected String name;
	protected String email;

	public Person(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public void print() {
		System.out.println(this.name);
		System.out.println(this.email);
	}
}

class Student extends Person {
	protected String course;

	public Student(String name, String email, String course) {
		super(name, email);
		this.course = course;
	}

	@Override
	public void print() {
		super.print();
		System.out.println(this.course);
	}

	public String getCourse() {
		return this.course;
	}
}

class Teacher extends Person {
	protected String subject;

	public Teacher(String name, String email, String subject) {
		super(name, email);
		this.subject = subject;
	}

	@Override
	public void print() {
		super.print();
		System.out.println(this.subject);
	}

	public String getSubject() {
		return this.subject;
	}

}

public class PersonDet {

	public static void main(String[] args) {
		Student st = new Student("David", "david@gmail.com", "Java");
		Teacher te = new Teacher("Jenny", "Jenny@gmail.com", "Python");
		st.print();
		te.print();
	}
}