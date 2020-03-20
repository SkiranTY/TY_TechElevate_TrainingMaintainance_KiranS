package com.tyss.trainingmaintainence.dto;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Table(name = "Batch_Info")
public class BatchInfo {

	@Id
	@GenericGenerator(name = "string_based_custom_sequence", strategy = "com.tyss.trainingmaintainence.dto.CustomIdGenerator")
	@GeneratedValue(generator = "string_based_custom_sequence")
	@Column(name = "batch_code")
	private String batchcode;

	@Column(name = "Client")
	private String client;
	
	@Column(name = "Technologies")
	private String technologies;

	@Column(name = "Batch_Type")
	private String batchType;

	@Column(name = "Fee_info")
	private double feeInfo;

	@Column(name = "Cost_per_candidate")
	private double costPerCandidate;

	@Column(name = "Location")
	private String location;

	@Column(name = "Type_Of_Joining")
	private String typeOfJoining;

	@Column(name = "Start_Date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate startdate;

	@Column(name = "End_Date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate enddate;

	@Column(name = "Mode_of_Training")
	private String modeOfTraining;

	@Column(name = "Invoice_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate invoiceDate;

	@CreationTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "Posted_time")
	private Date postedTime;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "batchinfo")
	private List<StudentsFile> studentfile;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "batchinfo")
	private CalenderInfo calendarinfo;

	public CalenderInfo getCalendarinfo() {
		return calendarinfo;
	}

	public void setCalendarinfo(CalenderInfo calendarinfo) {
		this.calendarinfo = calendarinfo;
	}

	public List<StudentsFile> getStudentfile() {
		return studentfile;
	}

	public void setStudentfile(List<StudentsFile> studentfile) {
		this.studentfile = studentfile;
	}

	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Date getPostedTime() {
		return postedTime;
	}

	public void setPostedTime(Date postedTime) {
		this.postedTime = postedTime;
	}

	public String getBatchcode() {
		return batchcode;
	}

	public void setBatchcode(String batchcode) {
		this.batchcode = batchcode;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getTechnologies() {
		return technologies;
	}

	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}

	public String getBatchType() {
		return batchType;
	}

	public void setBatchType(String batchType) {
		this.batchType = batchType;
	}

	public double getFeeInfo() {
		return feeInfo;
	}

	public void setFeeInfo(double feeInfo) {
		this.feeInfo = feeInfo;
	}

	public double getCostPerCandidate() {
		return costPerCandidate;
	}

	public void setCostPerCandidate(double costPerCandidate) {
		this.costPerCandidate = costPerCandidate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTypeOfJoining() {
		return typeOfJoining;
	}

	public void setTypeOfJoining(String typeOfJoining) {
		this.typeOfJoining = typeOfJoining;
	}

	public LocalDate getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}

	public LocalDate getEnddate() {
		return enddate;
	}

	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}

	public String getModeOfTraining() {
		return modeOfTraining;
	}

	public void setModeOfTraining(String modeOfTraining) {
		this.modeOfTraining = modeOfTraining;
	}

}
