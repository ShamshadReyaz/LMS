package com.mobiquel.lms.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "testcourse")
public class TestCourse implements Serializable {
 
	private static final long serialVersionUID = -2343243243242432341L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
 
	@Column(name = "course_id")
	private String courseId;
 
	@Column(name = "course_name")
	private String courseName;
 
	
	@Column(name = "test_name")
	private String testName;
 
	@Column(name = "test_details")
	private String testDetails;
 
	@Column(name = "test_type")
	private String testType;
 
	@Column(name = "test_duration")
	private String testDuration;
 
	@Column(name = "total_question")
	private String totalQuestion;
 
	
	
	@CreationTimestamp
	@Column(name = "created_on")
	private LocalDateTime  createdOn;
 
	@UpdateTimestamp
	@Column(name = "updated_on")
	private LocalDateTime  updatedOn;

	protected TestCourse() {
	}

	public TestCourse(String courseId,String courseName, String testName, String testDetails, String testType,
			String testDuration, String totalQuestion) {
		
		this.courseId = courseId;
		this.courseName = courseName;
		this.testName = testName;
		this.testDetails = testDetails;
		this.testType = testType;
		this.testDuration = testDuration;
		this.totalQuestion = totalQuestion;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
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

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestDetails() {
		return testDetails;
	}

	public void setTestDetails(String testDetails) {
		this.testDetails = testDetails;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public String getTestDuration() {
		return testDuration;
	}

	public void setTestDuration(String testDuration) {
		this.testDuration = testDuration;
	}

	public String getTotalQuestion() {
		return totalQuestion;
	}

	public void setTotalQuestion(String totalQuestion) {
		this.totalQuestion = totalQuestion;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}
 
			
 
	
}