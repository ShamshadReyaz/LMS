package com.mobiquel.lms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mobiquel.lms.model.Course;


public interface CourseRepository extends CrudRepository<Course, Integer>{
	//List<Course> findByFirstName(String FirstName);
	List<Course> findAll();
}