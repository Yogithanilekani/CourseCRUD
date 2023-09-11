package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseRepository;
import com.example.demo.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepo;
	

	@Override
	public String addCourse(Course course) {
		// TODO Auto-generated method stub
		courseRepo.save(course);
		Course c= new Course();
//		String abc = course.getTitle().toLowerCase();
		return "added course "+course.getTitle();
	}


	@Override
	public List<Course> getCourse() {
		// TODO Auto-generated method stub
		return courseRepo.findAll();
	}


	@Override
	public Optional<Course> getById(long id) {
		return courseRepo.findById(id).stream().findAny();
		
//		Optional<Integer> op = Optional.empty();
//		op.
		
		// TODO Auto-generated method stub
	}


	@Override
	public String addCourses(List<Course> courses) {
		courseRepo.saveAll(courses);
		return "added courses ";
	}


	@Override
	public String deleteCourses() {
		courseRepo.deleteAll();
		// TODO Auto-generated method stub
		return "deleted all courses";
	}


	@Override
	public String deleteCourseById(long id) {
		courseRepo.deleteById(id);
		
		return "deleted successfully";
	}


	@Override
	public Course updateCourse(long id, String titles) {
		// TODO Auto-generated method stub
		if(courseRepo.findById(id).isPresent()) {
//			courseRepo.save(courseRepo.findById(id).get().setTitle(titles));
			Course obj = courseRepo.findById(id).get();
			obj.setTitle(titles);
			courseRepo.save(obj);
			return obj;
		}
		else {
			return null ;
	}
	}


	@Override
	public Course updateCourses(long id, Course obj) {
		if(courseRepo.findById(id).isPresent()) {
			Course object = courseRepo.findById(id).get();
			object.setDescription(obj.getDescription());
			object.setTitle(obj.getTitle());
			courseRepo.save(object);
			return object;
		}
		else {
				return null ;
		}
		}


	@Override
	public List<Course> updateMany(List<Course> courseList) {
		List<Course> list  = new ArrayList<>();	
		for(Course i: courseList) {
			if(courseRepo.findById(i.getId()).isPresent()) {
				Course object = courseRepo.findById(i.getId()).get();
				object.setDescription(i.getDescription());
				object.setTitle(i.getTitle());
				courseRepo.save(object);
				list.add(object);
				}			
		}
		return list;
	}
		
	
	
	
//	@Override
//	public List<Course> getCourses() {
//		// TODO Auto-generated method stub
//		return list;
//	}
//	@Override
//	public Course getCourse(long courseId) {
//		Course c= null;
//		for(Course course:list) {
//			if(course.getId()==courseId) {
//				c= course;
//				break;
//			}
//		}
//		return c;
//		// TODO Auto-generated method stub
//	}

}
