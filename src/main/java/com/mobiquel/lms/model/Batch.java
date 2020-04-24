package com.mobiquel.lms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "batch")
public class Batch implements Serializable {
 
	private static final long serialVersionUID = -2343243243242432341L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
 
	@Column(name = "course_id")
	private String courseId;
 
	
	
	@Column(name = "start_date")
	private String startDate;
 
	@Column(name = "end_date")
	private String endtDate;
 
	@Column(name = "details")
	private String details;
 
	@Column(name = "batch_size")
	private String batchSize;
 
	protected Batch() {
	}
 
	
 
	public Batch(String courseId, String startDate, String endtDate,String details,String batchSize) {
		
		this.courseId = courseId;
		this.startDate = startDate;
		this.endtDate = endtDate;
		this.details = details;
		this.batchSize = batchSize;
	}



	public String getBatchSize() {
		return batchSize;
	}



	public void setBatchSize(String batchSize) {
		this.batchSize = batchSize;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	public String getCourseId() {
		return courseId;
	}



	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}



	public String getStartDate() {
		return startDate;
	}



	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}



	public String getEndtDate() {
		return endtDate;
	}



	public void setEndtDate(String endtDate) {
		this.endtDate = endtDate;
	}



	public String getDetails() {
		return details;
	}



	public void setDetails(String details) {
		this.details = details;
	}
	
}