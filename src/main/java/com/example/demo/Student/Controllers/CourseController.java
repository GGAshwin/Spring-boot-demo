package com.example.demo.Student.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Student.Entity.Course;
import com.example.demo.Student.Repository.CourseRepo;

@RestController
@RequestMapping(path = "/api/course")
public class CourseController {
@Autowired
	CourseRepo courseRepo;

	@PostMapping
	public String addCourse(@RequestBody Course course){
		courseRepo.save(course);
		return "Course '"+course.getName()+"' was added to the database";
	}
}
