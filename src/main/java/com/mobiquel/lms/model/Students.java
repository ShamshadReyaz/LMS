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
@Table(name = "students")
public class Students implements Serializable {
 
	private static final long serialVersionUID = -2343243243242432341L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
 
	@Column(name = "name")
	private String name;
 
	@Column(name = "mobile")
	private String mobile;
 
	@Column(name = "email")
	private String email;
 
	@Column(name = "student_type")
	private String studentType;
 
	@Column(name = "interested_course_ids")
	private String interestedCourseIds;
 
	@Column(name = "details")
	private String details;
 
	@Column(name = "session_type")
	private String sessionType;
	
	@Column(name = "source")
	private String source;
	
	@Column(name = "password")
	private String password;
 
	@CreationTimestamp
	@Column(name = "created_on")
	private LocalDateTime  createdOn;
 
	@UpdateTimestamp
	@Column(name = "updated_on")
	private LocalDateTime  updatedOn;
 
	protected Students() {
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




	public Students(String name, String mobile, String email, String studentType, String details, String sessionType,String interestedCourseIds,String source,String password) {
		
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.studentType = studentType;
		this.details = details;
		this.sessionType = sessionType;
		this.interestedCourseIds = interestedCourseIds;
		this.source = source;
		this.password = password;
	}





	



	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getMobile() {
		return mobile;
	}




	public void setMobile(String mobile) {
		this.mobile = mobile;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	



	public String getInterestedCourseIds() {
		return interestedCourseIds;
	}




	public void setInterestedCourseIds(String interestedCourseIds) {
		this.interestedCourseIds = interestedCourseIds;
	}




	public String getStudentType() {
		return studentType;
	}




	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}




	public String getDetails() {
		return details;
	}




	public void setDetails(String details) {
		this.details = details;
	}




	public String getSessionType() {
		return sessionType;
	}




	public void setSessionType(String sessionType) {
		this.sessionType = sessionType;
	}




	public String getSource() {
		return source;
	}




	public void setSource(String source) {
		this.source = source;
	}




	}