package com.tyss.trainingmaintainence.dto;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Response {

	private int statuscode;
	private String batchcode;
	private List<BatchInfo> batchinfo;
	private LocalDateTime date;
	private List<CalenderInfo> calenderinfo;

	public List<CalenderInfo> getCalenderinfo() {
		return calenderinfo;
	}

	public void setCalenderinfo(List<CalenderInfo> calenderinfo) {
		this.calenderinfo = calenderinfo;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime localDateTime) {
		SimpleDateFormat simdateformat = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
		LocalDateTime time = LocalDateTime.now();
		this.date = time;

	}

	public List<BatchInfo> getBatchinfo() {
		return batchinfo;
	}

	public void setBatchinfo(List<BatchInfo> batchinfo) {
		this.batchinfo = batchinfo;
	}

	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}

	public String getBatchcode() {
		return batchcode;
	}

	public void setBatchcode(String batchcode) {
		this.batchcode = batchcode;
	}

}
