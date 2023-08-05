package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Course;

public interface CourseService {
	public String addCourse(Course course);
	
	
	public List<Course> getCourse();
	
	public Optional<Course> getById(long id);

	public String addCourses(List<Course> course);
	
	public String deleteCourses();

	public String deleteCourseById(long id);
	
	public Course updateCourse(long id, String titles);
	
	public Course updateCourses(long id,Course obj);
	
	public List<Course> updateMany(List<Course> courseList);
	
//	public List<Course> getCourses();
//
//	public Course getCourse(long courseId);


}
