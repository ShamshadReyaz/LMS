package com.mobiquel.lms.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "coursedetails")
public class CourseDetails implements Serializable {
 
	private static final long serialVersionUID = -2343243243242432341L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
 
	@Column(name = "course_id")
	private Integer courseId;
	
	@Column(name = "course_fees")
	private String courseFees;
 
	@Column(name = "course_details")
	private String courseDetails;
 
	@Column(name = "image_url")
	private String imageURL;
 
	
	protected CourseDetails() {
	}
 
	
 
	public CourseDetails(Integer courseId,String courseFees, String courseDetails, String imageURL) {
		this.courseId = courseId;
		this.courseFees = courseFees;
		this.courseDetails = courseDetails;
		this.imageURL = imageURL;
	}



	public Integer getCourseId() {
		return courseId;
	}



	public CourseDetails setCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}



	public String getImageURL() {
		return imageURL;
	}



	public CourseDetails setImageURL(String imageURL) {
		this.imageURL = imageURL;
		return this;
	}



	public int getId() {
		return id;
	}



	public CourseDetails setId(int id) {
		this.id = id;
		return this;
	}







	public String getCourseFees() {
		return courseFees;
	}



	public CourseDetails setCourseFees(String courseFees) {
		this.courseFees = courseFees;
		return this;
	}



	public String getCourseDetails() {
		return courseDetails;
	}



	public CourseDetails setCourseDetails(String courseDetails) {
		this.courseDetails = courseDetails;
		return this;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}




}