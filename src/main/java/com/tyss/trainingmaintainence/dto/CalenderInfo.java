package com.tyss.trainingmaintainence.dto;

import java.sql.Time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "calender_info")
public class CalenderInfo {

	@Id
	@GeneratedValue
	@Column(name = "Cal_id")
	private int cal_id;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "event_Start_date")
	private Date eventStartDate;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "event_End_date")
	private Date eventEndDate;

	@JsonFormat(pattern = "hh:mm")
	@Column(name = "From_time")
	private Date fromTime;

	@JsonFormat(pattern = "hh:mm")
	@Column(name = "To_time")
	private Date toTime;

	@Column(name = "Technology")
	private String technology;

	@Column(name = "trainer")
	private String trainer;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "batchcode")
	private BatchInfo batchinfo;

	public Date getEventEndDate() {
		return eventEndDate;
	}

	public void setEventEndDate(Date eventEndDate) {
		this.eventEndDate = eventEndDate;
	}

	public BatchInfo getBatchinfo() {
		return batchinfo;
	}

	public void setBatchinfo(BatchInfo batchinfo) {
		this.batchinfo = batchinfo;
	}

	public int getCal_id() {
		return cal_id;
	}

	public void setCal_id(int cal_id) {
		this.cal_id = cal_id;
	}

	public Date getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public Date getFromTime() {
		return fromTime;
	}

	public void setFromTime(Date fromTime) {
		this.fromTime = fromTime;
	}

	public Date getToTime() {
		return toTime;
	}

	public void setToTime(Date toTime) {
		this.toTime = toTime;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

}
