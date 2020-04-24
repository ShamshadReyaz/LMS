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
import com.mobiquel.lms.model.TestQuestion;
import com.mobiquel.lms.repository.StudentRepository;
import com.mobiquel.lms.repository.TestCourseRepository;
import com.mobiquel.lms.repository.TestQuestionRepository;

@RestController
public class TestQuestionController {
	
	@Autowired
	TestQuestionRepository testQuestionRepository;
	
	@PostMapping("/LMS/addQuestion")
	public String addQuestion(@RequestBody TestQuestion test) {

		testQuestionRepository.save(new TestQuestion(test.getCourseId(),test.getTestId(), test.getTestName(),test.getInstruction(),test.getQuestion(),test.getQuestionType(),test.getOptionA(),test.getOptionB(),test.getOptionC(),test.getOptionD(),test.getSolution()));
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("errorCode", "0");
		jsonObject.put("errorMessage", "Question added successfully!");
		return jsonObject.toString();
	}
	
	@PostMapping("/LMS/addBulkQuestion")
	public String addBulkQuestion(@RequestBody List<TestQuestion> test) {

		testQuestionRepository.saveAll(test);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("errorCode", "0");
		jsonObject.put("errorMessage", "Questions added successfully!");
		return jsonObject.toString();
	}
	
	@PostMapping("/LMS/getAllQuestions")
	public String getAllTests() {
		JSONObject jsonObject=new JSONObject();
		List<TestQuestion> allstudentss=testQuestionRepository.findAll();
		jsonObject.put("errorCode", "0");
		jsonObject.put("errorMessage", "success");
		jsonObject.put("studentss", allstudentss);
		return jsonObject.toString();
	}
	@PostMapping("/LMS/getQuestionTests/{id}")
	public String getCourseTests(@PathVariable String id) {
		JSONObject jsonObject=new JSONObject();
		List<TestQuestion> allTests=testQuestionRepository.findAll();
		List<TestQuestion> refinedTests=new ArrayList<TestQuestion>();
		for (TestQuestion stud : allTests) {
			String t_id = stud.getTestId();
			if(t_id.equals(id))
				refinedTests.add(stud);
			//customerUI.add(new CustomerUI(customer.getFirstName(), customer.getLastName()));
		}
		
		jsonObject.put("errorCode", "0");
		jsonObject.put("errorMessage", "success");
		jsonObject.put("studentss", refinedTests);
		return jsonObject.toString();
	}
	
	
	
	
	@PostMapping(value ="/LMS/deleteQuestion/{id}")
	public String deletestudents(@PathVariable Integer id) {
		JSONObject json = new JSONObject();
		boolean isFound = testQuestionRepository.existsById(id);
		if (isFound) {
			json.put("errorCode", "0");
			json.put("errorMessage", "Question deleted");

			testQuestionRepository.deleteById(id);
		}
		else {
			json.put("errorCode", "1");
			json.put("errorMessage", "Question not exits");

		}	
		return json.toString();
	}
	
	
	@PostMapping("/LMS/updateQuestion/{id}")
	public String updateTest(@PathVariable(value = "id") Integer id, @Validated @RequestBody TestQuestion testUpdate) {

		JSONObject json = new JSONObject();
		boolean isFound = testQuestionRepository.existsById(id);
		if (isFound) {
			json.put("errorCode", "0");
			json.put("errorMessage", "Question Updated");

			Optional<TestQuestion> tests = testQuestionRepository.findById(id);

			tests.get().setCourseId(testUpdate.getCourseId());
			tests.get().setTestName(testUpdate.getTestName());
			tests.get().setTestId(testUpdate.getTestId());
			tests.get().setInstruction(testUpdate.getInstruction());
			tests.get().setQuestion(testUpdate.getQuestion());
			tests.get().setQuestionType(testUpdate.getQuestionType());
			tests.get().setOptionA(testUpdate.getOptionA());
			tests.get().setOptionB(testUpdate.getOptionB());
			tests.get().setOptionC(testUpdate.getOptionC());
			tests.get().setOptionD(testUpdate.getOptionD());
			tests.get().setSolution(testUpdate.getSolution());
			TestQuestion updatedstudents = tests.get();
			testQuestionRepository.save(updatedstudents);

		} else {
			json.put("errorCode", "1");
			json.put("errorMessage", "Question not exits");

		}

		return json.toString();
	}
	
	
}
