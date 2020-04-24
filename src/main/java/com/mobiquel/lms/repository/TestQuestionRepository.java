package com.mobiquel.lms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mobiquel.lms.model.Course;
import com.mobiquel.lms.model.Students;
import com.mobiquel.lms.model.TestCourse;
import com.mobiquel.lms.model.TestQuestion;


public interface TestQuestionRepository extends CrudRepository<TestQuestion, Integer>{
	List<TestQuestion> findByTestId(String testId);
	List<TestQuestion> findById(String id);
	List<TestQuestion> findAll();
}