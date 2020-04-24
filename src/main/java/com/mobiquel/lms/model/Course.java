package com.mobiquel.lms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course implements Serializable {
 
	private static final long serialVersionUID = -2343243243242432341L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
 
	@Column(name = "course_name")
	private String courseName;
 
	@Column(name = "course_fees")
	private String courseFees;
 
	@Column(name = "course_details")
	private String courseDetails;
 
	@Column(name = "image_url")
	private String imageURL;
 
	
	protected Course() {
	}
 
	
 
	public Course(String courseName, String courseFees, String courseDetails, String imageURL) {
		
		this.courseName = courseName;
		this.courseFees = courseFees;
		this.courseDetails = courseDetails;
		this.imageURL = imageURL;
	}



	public String getImageURL() {
		return imageURL;
	}



	public Course setImageURL(String imageURL) {
		this.imageURL = imageURL;
		return this;
	}



	public int getId() {
		return id;
	}



	public Course setId(int id) {
		this.id = id;
		return this;
	}



	public String getCourseName() {
		return courseName;
	}



	public Course setCourseName(String courseName) {
		this.courseName = courseName;
		return this;
	}



	public String getCourseFees() {
		return courseFees;
	}



	public Course setCourseFees(String courseFees) {
		this.courseFees = courseFees;
		return this;
	}



	public String getCourseDetails() {
		return courseDetails;
	}



	public Course setCourseDetails(String courseDetails) {
		this.courseDetails = courseDetails;
		return this;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}




}