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

import com.mobiquel.lms.model.Faculty;
import com.mobiquel.lms.repository.FacultyRepository;
import com.mobiquel.lms.repository.StudentRepository;

@RestController
public class FacultyController {
	
	@Autowired
	FacultyRepository facultyRepo;
	
	@PostMapping("/LMS/createFaculty")
	public String create(@RequestBody Faculty faculty) {

		facultyRepo.save(new Faculty(faculty.getFacultyName(), faculty.getMobile(),faculty.getCourseIds(),faculty.getQualification(),faculty.getImageURL(),faculty.getPassword()));
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("errorCode", "0");
		jsonObject.put("errorMessage", "Faculty created successfully!");
		return jsonObject.toString();
	}
	
	@PostMapping("/LMS/getAllfaculty")
	public String getAllfacultys() {
		JSONObject jsonObject=new JSONObject();
		List<Faculty> allfacultys=facultyRepo.findAll();
		jsonObject.put("errorCode", "0");
		jsonObject.put("errorMessage", "success");
		jsonObject.put("facultys", allfacultys);
		return jsonObject.toString();
	}
	
	@PostMapping(value ="/LMS/deletefaculty/{id}")
	public String deletefaculty(@PathVariable Integer id) {
		JSONObject json = new JSONObject();
		boolean isFound = facultyRepo.existsById(id);
		if (isFound) {
			json.put("errorCode", "0");
			json.put("errorMessage", "Faculty deleted");

			facultyRepo.deleteById(id);
		}
		else {
			json.put("errorCode", "1");
			json.put("errorMessage", "Faculty not exits");

		}	
		return json.toString();
	}
	
	
	@PostMapping("/LMS/updatefaculty/{id}")
	public String updatefaculty(@PathVariable(value = "id") Integer id, @Validated @RequestBody Faculty facultyUpdate) {

		JSONObject json = new JSONObject();
		boolean isFound = facultyRepo.existsById(id);
		if (isFound) {
			json.put("errorCode", "0");
			json.put("errorMessage", "Faculty Updated");

			Optional<Faculty> faculty = facultyRepo.findById(id);

			faculty.get().setFacultyName(facultyUpdate.getFacultyName());
			faculty.get().setMobile(facultyUpdate.getMobile());
			faculty.get().setCourseIds(facultyUpdate.getCourseIds());
			faculty.get().setImageURL(facultyUpdate.getImageURL());
			faculty.get().setQualification(facultyUpdate.getQualification());
			faculty.get().setPassword(facultyUpdate.getPassword());
			Faculty updatedfaculty = faculty.get();
			facultyRepo.save(updatedfaculty);

		} else {
			json.put("errorCode", "1");
			json.put("errorMessage", "Faculty not exits");

		}

		return json.toString();
	}
}
