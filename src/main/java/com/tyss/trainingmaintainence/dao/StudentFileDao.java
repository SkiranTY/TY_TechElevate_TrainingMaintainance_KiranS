package com.tyss.trainingmaintainence.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tyss.trainingmaintainence.dto.BatchInfo;
import com.tyss.trainingmaintainence.dto.StudentsFile;

public interface StudentFileDao {

	public boolean uploadFile(MultipartFile file, String batchcode) throws Exception;

	public List<StudentsFile> getDetails();
	
	public List<StudentsFile> getFreeBatchStudents();

}
