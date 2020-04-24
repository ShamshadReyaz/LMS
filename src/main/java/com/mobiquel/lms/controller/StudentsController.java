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
import com.mobiquel.lms.repository.StudentRepository;

@RestController
public class StudentsController {
	
	@Autowired
	StudentRepository studentsRepo;
	
	@PostMapping("/LMS/createStudents")
	public String create(@RequestBody Students students) {

		studentsRepo.save(new Students(students.getName(), students.getMobile(),students.getEmail(),students.getStudentType(),students.getDetails(),students.getSessionType(),students.getInterestedCourseIds(),students.getSource(),students.getPassword()));
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("errorCode", "0");
		jsonObject.put("errorMessage", "Students created successfully!");
		return jsonObject.toString();
	}
	
	@PostMapping("/LMS/getAllStudents")
	public String getAllstudentss() {
		JSONObject jsonObject=new JSONObject();
		List<Students> allstudentss=studentsRepo.findAll();
		jsonObject.put("errorCode", "0");
		jsonObject.put("errorMessage", "success");
		jsonObject.put("studentss", allstudentss);
		return jsonObject.toString();
	}
	
	
	@PostMapping("/LMS/getStudentByDate/{date}")
	public String getStudentsByDate(@PathVariable String date) {
		JSONObject jsonObject=new JSONObject();
		List<Students> allstudentss=studentsRepo.findAll();
		List<Students> refinedStudentss=new ArrayList<Students>();
		for (Students stud : allstudentss) {
			LocalDateTime d=stud.getCreatedOn();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			String formatDateTime = d.format(format);   
			if(formatDateTime.equals(date))
				refinedStudentss.add(stud);
			//customerUI.add(new CustomerUI(customer.getFirstName(), customer.getLastName()));
		}
		
		jsonObject.put("errorCode", "0");
		jsonObject.put("errorMessage", "success");
		jsonObject.put("studentss", refinedStudentss);
		return jsonObject.toString();
	}
	
	@PostMapping(value ="/LMS/deleteStudents/{id}")
	public String deletestudents(@PathVariable Integer id) {
		JSONObject json = new JSONObject();
		boolean isFound = studentsRepo.existsById(id);
		if (isFound) {
			json.put("errorCode", "0");
			json.put("errorMessage", "Student deleted");

			studentsRepo.deleteById(id);
		}
		else {
			json.put("errorCode", "1");
			json.put("errorMessage", "students not exits");

		}	
		return json.toString();
	}
	
	
	@PostMapping("/LMS/updatestudents/{id}")
	public String updatestudents(@PathVariable(value = "id") Integer id, @Validated @RequestBody Students studentsUpdate) {

		JSONObject json = new JSONObject();
		boolean isFound = studentsRepo.existsById(id);
		if (isFound) {
			json.put("errorCode", "0");
			json.put("errorMessage", "Student Updated");

			Optional<Students> students = studentsRepo.findById(id);

			students.get().setName(studentsUpdate.getName());
			students.get().setMobile(studentsUpdate.getMobile());
			students.get().setEmail(studentsUpdate.getEmail());
			students.get().setStudentType(studentsUpdate.getStudentType());
			students.get().setInterestedCourseIds(studentsUpdate.getInterestedCourseIds());
			students.get().setDetails(studentsUpdate.getDetails());
			students.get().setSource(studentsUpdate.getSource());
			students.get().setSessionType(studentsUpdate.getSessionType());
			students.get().setPassword(studentsUpdate.getPassword());
			Students updatedstudents = students.get();
			studentsRepo.save(updatedstudents);

		} else {
			json.put("errorCode", "1");
			json.put("errorMessage", "Student not exits");

		}

		return json.toString();
	}
	
	@PostMapping("/LMS/studentLogin")
	public String studentLogin( @Validated @RequestBody Students studentsUpdate) {

		JSONObject json = new JSONObject();
		List<Students> data = studentsRepo.findByName(studentsUpdate.getName());
		boolean isFound = false;
		if(data.size()>0)
			isFound=true;
		else
			isFound=false;
		
		if (isFound) {
			if(data.get(0).getPassword().equals(studentsUpdate.getPassword())) {
				JSONObject dataObject=new JSONObject();
				dataObject.put("id",data.get(0).getId());
				dataObject.put("name",data.get(0).getName());
				dataObject.put("mobile",data.get(0).getMobile());
				dataObject.put("email",data.get(0).getEmail());
				dataObject.put("studentType",data.get(0).getStudentType());
				dataObject.put("interestedCourseIds",data.get(0).getInterestedCourseIds());
				dataObject.put("details",data.get(0).getDetails());
				dataObject.put("sessionType",data.get(0).getSessionType());
				dataObject.put("source",data.get(0).getSource());
				
				json.put("errorCode", "0");
				json.put("errorMessage", "LoggedIn successfully!");
				json.put("data",dataObject);
			}
			else
			{
				json.put("errorCode", "1");
				json.put("errorMessage", "Password not matched");
			}
	

		} else {
			json.put("errorCode", "1");
			json.put("errorMessage", "Username dont exits");

		}

		return json.toString();
	}
}
