package com.mobiquel.lms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mobiquel.lms.model.Course;
import com.mobiquel.lms.model.Students;


public interface StudentRepository extends CrudRepository<Students, Integer>{
	List<Students> findByName(String name);
	List<Students> findAll();
}