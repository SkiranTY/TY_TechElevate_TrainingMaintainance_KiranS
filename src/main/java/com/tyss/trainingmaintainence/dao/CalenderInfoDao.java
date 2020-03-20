package com.tyss.trainingmaintainence.dao;

import java.util.List;

import com.tyss.trainingmaintainence.dto.CalenderInfo;

public interface CalenderInfoDao {

	public CalenderInfo addCalenderInfo(CalenderInfo calenderinfo);

	public List<CalenderInfo> getCalenderInfo();

}
