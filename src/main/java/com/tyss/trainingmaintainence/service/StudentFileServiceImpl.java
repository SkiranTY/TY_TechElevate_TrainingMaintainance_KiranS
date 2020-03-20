package com.tyss.trainingmaintainence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tyss.trainingmaintainence.dao.StudentFileDao;
import com.tyss.trainingmaintainence.dto.BatchInfo;
import com.tyss.trainingmaintainence.dto.StudentsFile;

@Service
public class StudentFileServiceImpl implements StudentFileService {

	@Autowired
	private StudentFileDao filedao;

	List<StudentsFile> student;

	private StudentsFile studentfile;

	@Override
	public boolean uploadFile(MultipartFile file, String batchcode) throws Exception {
		return filedao.uploadFile(file, batchcode);
	}

	@Override
	public List<StudentsFile> getDetails() {
		return filedao.getDetails();
	}

	@Override
	public List<StudentsFile> getFreeBatchStudents() {
		return filedao.getFreeBatchStudents();
	}

}
