package com.tyss.trainingmaintainence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.trainingmaintainence.dao.CalenderInfoDao;
import com.tyss.trainingmaintainence.dto.BatchInfo;
import com.tyss.trainingmaintainence.dto.CalenderInfo;

@Service
public class CalenderServiceImpl implements CalenderService {

	@Autowired
	private CalenderInfoDao calnderdao;

	@Override
	public CalenderInfo addCalenderInfo(CalenderInfo calenderinfo) {
		return calnderdao.addCalenderInfo(calenderinfo);
	}

	@Override
	public List<CalenderInfo> getCalenderInfo() {
		return calnderdao.getCalenderInfo();
	}

}
