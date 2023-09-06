package CurdOPeration.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	@Id
	@GeneratedValue
	private long id; 
	@Column(name="stuname")
	public String  stuname;
	@Column(name="age")
	public int age;
	@Column(name="city")
	public String city;
	public Course(long id, String stuname, int age, String city) {
		super();
		this.id = id;
		this.stuname = stuname;
		this.age = age;
		this.city = city;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStuname() {
		return stuname;
	}
	public Course() {
		
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", stuname=" + stuname + ", age=" + age + ", city=" + city + "]";
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}
