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
import com.mobiquel.lms.model.CourseDetails;
import com.mobiquel.lms.repository.CourseDetailsRepository;
import com.mobiquel.lms.repository.CourseRepository;

@RestController
public class CourseDetailsController {
	
	@Autowired
	CourseDetailsRepository courseRepo;
	
	@PostMapping("/LMS/createCourseDetails")
	public String create(@RequestBody CourseDetails course) {

		courseRepo.save(new CourseDetails(course.getCourseId(),course.getCourseFees(),course.getCourseDetails(),course.getImageURL()));
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("errorCode", "0");
		jsonObject.put("errorMessage", "Course created successfully!");
		return jsonObject.toString();
	}
	
	@PostMapping("/LMS/getAllCourseDetails")
	public String getAllCourses() {
		JSONObject jsonObject=new JSONObject();
		List<CourseDetails> allCourses=courseRepo.findAll();
		jsonObject.put("errorCode", "0");
		jsonObject.put("errorMessage", "success");
		jsonObject.put("courses", allCourses);
		return jsonObject.toString();
	}
	
	
}
