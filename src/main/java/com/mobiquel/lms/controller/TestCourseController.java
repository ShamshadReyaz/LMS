package com.mobiquel.lms.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

import com.mobiquel.lms.model.Students;
import com.mobiquel.lms.model.TestCourse;
import com.mobiquel.lms.repository.StudentRepository;
import com.mobiquel.lms.repository.TestCourseRepository;

@RestController
public class TestCourseController {
	
	@Autowired
	TestCourseRepository testCourseRepository;
	
	@PostMapping("/LMS/createTest")
	public String create(@RequestBody TestCourse test) {

		testCourseRepository.save(new TestCourse(test.getCourseId(),test.getCourseName(), test.getTestName(),test.getTestDetails(),test.getTestType(),test.getTestDuration(),test.getTotalQuestion()));
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("errorCode", "0");
		jsonObject.put("errorMessage", "Test created successfully!");
		return jsonObject.toString();
	}
	
	@PostMapping("/LMS/getAllTests")
	public String getAllTests() {
		JSONObject jsonObject=new JSONObject();
		List<TestCourse> allstudentss=testCourseRepository.findAll();
		jsonObject.put("errorCode", "0");
		jsonObject.put("errorMessage", "success");
		jsonObject.put("tests", allstudentss);
		return jsonObject.toString();
	}
	@PostMapping("/LMS/getCourseTests/{id}")
	public String getCourseTests(@PathVariable String id) {
		JSONObject jsonObject=new JSONObject();
		List<TestCourse> allTests=testCourseRepository.findAll();
		List<TestCourse> refinedTests=new ArrayList<TestCourse>();
		for (TestCourse stud : allTests) {
			String t_id = stud.getCourseId();
			if(t_id.equals(id))
				refinedTests.add(stud);
			//customerUI.add(new CustomerUI(customer.getFirstName(), customer.getLastName()));
		}
		
		jsonObject.put("errorCode", "0");
		jsonObject.put("errorMessage", "success");
		jsonObject.put("tests", refinedTests);
		return jsonObject.toString();
	}
	
	
	
	
	@PostMapping(value ="/LMS/deleteTest/{id}")
	public String deletestudents(@PathVariable Integer id) {
		JSONObject json = new JSONObject();
		boolean isFound = testCourseRepository.existsById(id);
		if (isFound) {
			json.put("errorCode", "0");
			json.put("errorMessage", "Test deleted");

			testCourseRepository.deleteById(id);
		}
		else {
			json.put("errorCode", "1");
			json.put("errorMessage", "Test not exits");

		}	
		return json.toString();
	}
	
	
	@PostMapping("/LMS/updateTest/{id}")
	public String updateTest(@PathVariable(value = "id") Integer id, @Validated @RequestBody TestCourse testUpdate) {

		JSONObject json = new JSONObject();
		boolean isFound = testCourseRepository.existsById(id);
		if (isFound) {
			json.put("errorCode", "0");
			json.put("errorMessage", "Test Updated");

			Optional<TestCourse> tests = testCourseRepository.findById(id);

			tests.get().setCourseId(testUpdate.getCourseId());
			tests.get().setCourseName(testUpdate.getCourseName());
			tests.get().setTestName(testUpdate.getTestName());
			tests.get().setTestDetails(testUpdate.getTestDetails());
			tests.get().setTestType(testUpdate.getTestType());
			tests.get().setTestDuration(testUpdate.getTestDuration());
			tests.get().setTotalQuestion(testUpdate.getTotalQuestion());
			
			TestCourse updatedstudents = tests.get();
			testCourseRepository.save(updatedstudents);

		} else {
			json.put("errorCode", "1");
			json.put("errorMessage", "Test not exits");

		}

		return json.toString();
	}
	
	
}
