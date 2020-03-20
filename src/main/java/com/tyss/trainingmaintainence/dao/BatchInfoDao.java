package com.tyss.trainingmaintainence.dao;

import java.text.ParseException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tyss.trainingmaintainence.dto.BatchInfo;

public interface BatchInfoDao {

	public String addbatch(BatchInfo batchinfo);

	public List<BatchInfo> getBatchDetails();

	public List<BatchInfo> getTechnologywise();

	public List<BatchInfo> getBatchStatus() throws ParseException;
	
	public List<BatchInfo> getBatchOngoing();
	
	public List<BatchInfo> getbatchYetTostart();
	
	public List<BatchInfo> getFreeBatches();
	
	public List<BatchInfo> getPaidBatches();

	public boolean updateBatch(BatchInfo batchinfo);
}
