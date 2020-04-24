package com.mobiquel.lms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty implements Serializable {
 
	private static final long serialVersionUID = -2343243243242432341L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
 
	@Column(name = "faculty_name")
	private String facultyName;
 
	@Column(name = "mobile")
	private String mobile;
 
	@Column(name = "course_ids")
	private String courseIds;
 
	@Column(name = "qualification")
	private String qualification;
 
	@Column(name = "image_url")
	private String imageURL;
 
	@Column(name = "password")
	private String password;
 
	
	protected Faculty() {
	}
 
	
 


	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public Faculty(String facultyName, String mobile, String courseIds, String qualification, String imageURL,String password) {
		
		this.facultyName = facultyName;
		this.mobile = mobile;
		this.courseIds = courseIds;
		this.qualification = qualification;
		this.imageURL = imageURL;
		this.password = password;
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getFacultyName() {
		return facultyName;
	}





	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}





	public String getMobile() {
		return mobile;
	}





	public void setMobile(String mobile) {
		this.mobile = mobile;
	}





	public String getCourseIds() {
		return courseIds;
	}





	public void setCourseIds(String courseIds) {
		this.courseIds = courseIds;
	}





	public String getQualification() {
		return qualification;
	}





	public void setQualification(String qualification) {
		this.qualification = qualification;
	}





	public String getImageURL() {
		return imageURL;
	}





	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}





	
	
}