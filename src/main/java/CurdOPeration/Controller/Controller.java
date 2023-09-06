package CurdOPeration.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CurdOPeration.Entity.Course;
import CurdOPeration.Interface.CourseRepository;

@RestController
public class Controller {
	@Autowired
	CourseRepository courseRepository;
	@RequestMapping("/test")
	public String show() {
		return "Show Database";
	}
	@PostMapping("/course")
	public String addCourse(@RequestBody Course course)
	{
		courseRepository.save(course);
		return "Create database sucessfully";
	}
	@GetMapping("/course")
	public List<Course> getall()
	{
		return courseRepository.findAll();
	}
	@GetMapping("/course/{courseid}")
	public ResponseEntity<Course> getemployee(@PathVariable long courseid){
		Optional<Course> newCourse = courseRepository.findById(courseid);
		if(newCourse.isPresent())
		{
			return new ResponseEntity<Course>(newCourse.get(),HttpStatus.FOUND);
		}
		else
		{
			return new ResponseEntity<Course>(newCourse.get(),HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/course/{courseid}")
	public String update(@PathVariable long courseid,@RequestBody Course course)
	{
		Optional<Course> newCourse = courseRepository.findById(courseid);
		if(newCourse.isPresent())
		{
		Course newCours = newCourse.get();
		newCours.setAge(course.getAge());
		newCours.setCity(course.getCity());
		newCours.setStuname(course.getStuname());
		courseRepository.save(newCours);
		return "employee Details against id "+courseid+" updated";
		}
		else
		{
			return "employee Details does not exist for  id "+courseid+" updated";
		}
	}
	@DeleteMapping("/course/{courseid}")
	public String deldata(@PathVariable long courseid)
	{
		courseRepository.deleteById(courseid);
		return "Course Deleted Sucessfully!"; 
	}

}
