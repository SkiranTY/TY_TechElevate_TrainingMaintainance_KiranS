package com.tyss.trainingmaintainence.dto;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Students_file")
public class StudentsFile {

//	@EmbeddedId
//	private StudentPk id;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "user_type")
	private String userType;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "password")
	private String password;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "mobile_number")
	private double mobileNumber;

	@Column(name = "gender")
	private String gender;

	@Column(name = "home_town")
	private String homeTown;

	@Column(name = "State")
	private String state;

	@Column(name = "10th_aggregate")
	private int aggregate_10th;

	@Column(name = "12th_aggregate")
	private int aggregate_12th;

	@Column(name = "degree_aggregate")
	private int degreeAggregate;

	@Column(name = "degree")
	private String degree;

	@Column(name = "degree_stream")
	private String degreeStream;

	@Column(name = "degree_YOP")
	private int degree_YOP;

	@Column(name = "college_name")
	private String college_name;

	@Column(name = "college_location")
	private String college_location;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "batchcode")
	private BatchInfo batchinfo;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

//	public StudentPk getId() {
//		return id;
//	}
//
//	public void setId(StudentPk id) {
//		this.id = id;
//	}

	public String getFirstName() {
		return firstName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public double getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(double mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHomeTown() {
		return homeTown;
	}

	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getAggregate_10th() {
		return aggregate_10th;
	}

	public void setAggregate_10th(int aggregate_10th) {
		this.aggregate_10th = aggregate_10th;
	}

	public int getAggregate_12th() {
		return aggregate_12th;
	}

	public void setAggregate_12th(int aggregate_12th) {
		this.aggregate_12th = aggregate_12th;
	}

	public int getDegreeAggregate() {
		return degreeAggregate;
	}

	public void setDegreeAggregate(int degreeAggregate) {
		this.degreeAggregate = degreeAggregate;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getDegreeStream() {
		return degreeStream;
	}

	public void setDegreeStream(String degreeStream) {
		this.degreeStream = degreeStream;
	}

	public int getDegree_YOP() {
		return degree_YOP;
	}

	public void setDegree_YOP(int degree_YOP) {
		this.degree_YOP = degree_YOP;
	}

	public BatchInfo getBatchinfo() {
		return batchinfo;
	}

	public BatchInfo setBatchinfo(BatchInfo batchinfo) {
		return this.batchinfo = batchinfo;
	}

	public String getCollege_name() {
		return college_name;
	}

	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}

	public String getCollege_location() {
		return college_location;
	}

	public void setCollege_location(String college_location) {
		this.college_location = college_location;
	}

}
