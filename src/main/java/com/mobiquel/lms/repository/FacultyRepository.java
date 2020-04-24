package com.mobiquel.lms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mobiquel.lms.model.Course;
import com.mobiquel.lms.model.Faculty;
import com.mobiquel.lms.model.Students;


public interface FacultyRepository extends CrudRepository<Faculty, Integer>{
	//List<Course> findByFirstName(String FirstName);
	List<Faculty> findAll();
}