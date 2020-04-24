package com.mobiquel.lms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mobiquel.lms.model.Course;
import com.mobiquel.lms.model.CourseDetails;


public interface CourseDetailsRepository extends CrudRepository<CourseDetails, Integer>{
	//List<Course> findByFirstName(String FirstName);
	List<CourseDetails> findAll();
}