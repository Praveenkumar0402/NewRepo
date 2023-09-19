package manytomany;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "mtm_courses")
@Entity(name = "Course")
public class Course {

	@Id
	private int course_id;
	private String course_name;

	@ManyToMany
	@JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "stu_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	Set<Student> mtm_students;

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public Set<Student> getMtm_students() {
		return mtm_students;
	}

	public void setMtm_students(Set<Student> mtm_students) {
		this.mtm_students = mtm_students;
	}

}
