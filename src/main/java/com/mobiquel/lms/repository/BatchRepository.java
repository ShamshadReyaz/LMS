package com.mobiquel.lms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mobiquel.lms.model.Batch;
import com.mobiquel.lms.model.Course;


public interface BatchRepository extends CrudRepository<Batch, Integer>{
	//List<Course> findByFirstName(String FirstName);
	List<Batch> findAll();
}
