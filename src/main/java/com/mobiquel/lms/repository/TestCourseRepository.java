package com.mobiquel.lms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mobiquel.lms.model.Course;
import com.mobiquel.lms.model.Students;
import com.mobiquel.lms.model.TestCourse;


public interface TestCourseRepository extends CrudRepository<TestCourse, Integer>{
	List<TestCourse> findByTestName(String testName);
	List<TestCourse> findById(String id);
	List<TestCourse> findAll();
}