package com.tyss.trainingmaintainence.controller;

import java.util.List;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tyss.trainingmaintainence.dto.BatchInfo;
import com.tyss.trainingmaintainence.dto.StudentsFile;
import com.tyss.trainingmaintainence.service.StudentFileService;

@RestController
@RequestMapping("/Upload")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class StudentFilleController {

	@Autowired
	private StudentFileService fileService;

	@PostMapping(path = "/uploaddoc/{batchcode}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean uploadFileToDb(@RequestParam MultipartFile file, @PathVariable("batchcode") String batchcode)
			throws Exception {
		if (fileService.uploadFile(file, batchcode)) {
			return true;
		}
		return false;
	}

	@GetMapping(path = "/Studentdetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StudentsFile> getDetails() {
		List<StudentsFile> list = fileService.getDetails();
		if (list != null) {
			return list;
		} else {
			return null;
		}
	}
	
	@GetMapping(path = "/freebatchstudents" , produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StudentsFile> getFreeBatchDetails() {
		List<StudentsFile> list = fileService.getFreeBatchStudents();
		if(list != null) {
			return list;
		} else {
			return null;
		}
	}

}