package com.rodrigo7prado.sisGestEduc.utils;

import java.sql.Timestamp;

//@Entity
//@Table(name = "consolidado_manual_alunos")
public class Review {
	private String courseName;
    private String studentName;
    private Timestamp timestamp;
    private double rating;
    private String comment;
 
    public Review() {
    }

	public String getCourseName() {
		return courseName;
	}

//	@Column(name = "courseNamed")
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
