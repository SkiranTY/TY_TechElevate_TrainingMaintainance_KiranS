package com.tyss.trainingmaintainence.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tyss.trainingmaintainence.dao.BatchInfoDao;
import com.tyss.trainingmaintainence.dto.BatchInfo;
import com.tyss.trainingmaintainence.dto.StudentsFile;

@Service
public class BatchInfoServiceImpl implements BatchInfoService {

	@Autowired
	private BatchInfoDao batchinfodao;

	@Override
	public String addbatch(BatchInfo batchinfo) {
//		if (batchinfo.getStudentfile() != null) {
//			for (StudentsFile students : batchinfo.getStudentfile()) {
//				students.setBatchinfo(batchinfo);
//			}
//		}
		return batchinfodao.addbatch(batchinfo);
	}

	@Override
	public boolean updateBatch(BatchInfo batchinfo) {
		return batchinfodao.updateBatch(batchinfo);
	}

	@Override
	public List<BatchInfo> getBatchDetails() {
		return batchinfodao.getBatchDetails();
	}

	@Override
	public List<BatchInfo> getTechnologywise() {
		return batchinfodao.getTechnologywise();
	}

	@Override
	public List<BatchInfo> getBatchStatus() throws ParseException {
		return batchinfodao.getBatchStatus();
	}

	@Override
	public List<BatchInfo> getBatchOngoing() {
		return batchinfodao.getBatchOngoing();
	}

	@Override
	public List<BatchInfo> getbatchYetTostart() {
		return batchinfodao.getbatchYetTostart();
	}

	@Override
	public List<BatchInfo> getFreeBatches() {
		return batchinfodao.getFreeBatches();
	}

	@Override
	public List<BatchInfo> getPaidBatches() {
		return batchinfodao.getPaidBatches();
	}

}
