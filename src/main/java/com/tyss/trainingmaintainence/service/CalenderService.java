package com.tyss.trainingmaintainence.service;

import java.util.List;

import com.tyss.trainingmaintainence.dto.CalenderInfo;

public interface CalenderService {

	public CalenderInfo addCalenderInfo(CalenderInfo calenderinfo);

	public List<CalenderInfo> getCalenderInfo();

}
