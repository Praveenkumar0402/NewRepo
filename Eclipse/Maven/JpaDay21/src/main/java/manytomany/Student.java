package manytomany;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "Student")
@Table(name = "mtm_students")
public class Student {

	@Id
	private int stu_id;
	private String stu_name;

	@ManyToMany(mappedBy = "mtm_students")
	Set<Course> mtm_courses;

	public int getStu_Id() {
		return stu_id;
	}

	public void setStu_Id(int id) {
		this.stu_id = id;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public Set<Course> getMtm_courses() {
		return mtm_courses;
	}

	public void setMtm_courses(Set<Course> mtm_courses) {
		this.mtm_courses = mtm_courses;
	}

}
