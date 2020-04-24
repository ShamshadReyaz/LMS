package com.mobiquel.lms.controller;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mobiquel.lms.model.Course;
import com.mobiquel.lms.repository.CourseRepository;

@RestController
public class CourseController {
	
	@Autowired
	CourseRepository courseRepo;
	
	@PostMapping("/LMS/createCourse")
	public String create(@RequestBody Course course) {

		courseRepo.save(new Course(course.getCourseName(), course.getCourseFees(),course.getCourseDetails(),course.getImageURL()));
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("errorCode", "0");
		jsonObject.put("errorMessage", "Course created successfully!");
		return jsonObject.toString();
	}
	
	@PostMapping("/LMS/getAllCourse")
	public String getAllCourses() {
		JSONObject jsonObject=new JSONObject();
		List<Course> allCourses=courseRepo.findAll();
		jsonObject.put("errorCode", "0");
		jsonObject.put("errorMessage", "success");
		jsonObject.put("courses", allCourses);
		return jsonObject.toString();
	}
	
	@PostMapping(value ="/LMS/deleteCourse/{id}")
	public String deleteCourse(@PathVariable Integer id) {
		JSONObject json = new JSONObject();
		boolean isFound = courseRepo.existsById(id);
		if (isFound) {
			json.put("errorCode", "0");
			json.put("errorMessage", "Course deleted");

			courseRepo.deleteById(id);
		}
		else {
			json.put("errorCode", "1");
			json.put("errorMessage", "Course not exits");

		}	
		return json.toString();
	}
	
	
	@PostMapping("/LMS/updateCourse/{id}")
	public String updateCourse(@PathVariable(value = "id") Integer id, @Validated @RequestBody Course courseUpdate) {

		JSONObject json = new JSONObject();
		boolean isFound = courseRepo.existsById(id);
		if (isFound) {
			json.put("errorCode", "0");
			json.put("errorMessage", "Course Updated");

			Optional<Course> course = courseRepo.findById(id);

			course.get().setCourseName(courseUpdate.getCourseName());
			course.get().setCourseFees(courseUpdate.getCourseFees());
			course.get().setCourseDetails(courseUpdate.getCourseDetails());
			course.get().setImageURL((courseUpdate.getImageURL()));

			Course updatedCourse = course.get();
			courseRepo.save(updatedCourse);

		} else {

			json.put("errorCode", "1");
			json.put("errorMessage", "Course not exits");

		}

		return json.toString();
	}
}
