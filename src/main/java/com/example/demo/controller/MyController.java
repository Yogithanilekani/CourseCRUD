package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Course;
import com.example.demo.services.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/add")
	public String addingCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}
	
	@PostMapping("/addlistofcourses")
	public String addingCourses(@RequestBody List<Course> course) {
		return courseService.addCourses(course);
	}
	
	@GetMapping("/getall")
	public List<Course> gettingCourse(){
		return courseService.getCourse();
	}
	
	@GetMapping("/course/{id}")
	public Optional<Course> gettingCourseById(@PathVariable long id){
		return courseService.getById(id);
	}
	
	@DeleteMapping("/deleteallcourses")
	public String deletingCourses() {
		return courseService.deleteCourses();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deletingCourseById(@PathVariable long id) {
		return courseService.deleteCourseById(id);
	}
	
	@PutMapping("/update")
	public Course updateCourse(@RequestParam long id, @RequestParam String title) {
		return courseService.updateCourse(id, title);
	}
	 
	@PutMapping("/updatemany")
	public List<Course> updateManyCourse(@RequestBody List<Course> courses){
		return courseService.updateMany(courses);
	}
	
//	
//	@GetMapping("/courses")
//	public List<Course> getCourses()
//	{
//		return this.courseService.getCourses();
//		
//	}
//	
//	@GetMapping("/courses/{courseId}")
//	public Course getCourse(@PathVariable String courseId)
//	{
//		return this.courseService.getCourse(Long.parseLong(courseId));
//		
//	}

}
