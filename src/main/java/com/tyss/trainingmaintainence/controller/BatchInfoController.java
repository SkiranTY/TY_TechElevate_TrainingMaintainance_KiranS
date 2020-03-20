package com.tyss.trainingmaintainence.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.executable.ValidateOnExecution;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import com.tyss.trainingmaintainence.dto.BatchInfo;
import com.tyss.trainingmaintainence.dto.CustomIdGenerator;
import com.tyss.trainingmaintainence.dto.Response;
import com.tyss.trainingmaintainence.dto.StudentsFile;
import com.tyss.trainingmaintainence.service.BatchInfoService;

@RestController
@RequestMapping("/batchinformation")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class BatchInfoController {

	@Autowired
	private BatchInfoService batchservice;

	@Autowired
	private CustomIdGenerator generator;

	private BatchInfo batchinfo;

	Response response = new Response();

	Logger logger = LogManager.getLogger(this.getClass());
	
	@InitBinder
	public void initbinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@PostMapping(path = "/batch", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response addbatch(@RequestBody BatchInfo batchinfo) {
		if (generator.generator(batchinfo)) {
			if (batchservice.addbatch(batchinfo) != null) {
				response.setStatuscode(200);
				response.setBatchcode(batchinfo.getBatchcode());
				SimpleDateFormat simdateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				LocalDateTime time = LocalDateTime.now();
				response.setDate(LocalDateTime.now());
			}
		} else {
			logger.error("adding batch getting failed");
			//response.setStatuscode(401);
		}
		return response;
	}

	@PutMapping(path = "/batch", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response batchUpdate(@RequestBody BatchInfo batchinfo) {
		Response response = new Response();
		if (batchservice.updateBatch(batchinfo)) {
			response.setStatuscode(200);
			response.setBatchcode(batchinfo.getBatchcode() + "is upadated");

		} else {
			response.setStatuscode(401);
		}
		return response;

	}

	@GetMapping(path = "/batch", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response batchDetails() {
		List<BatchInfo> batchlist = batchservice.getBatchDetails();
		if (batchlist == null) {
			response.setStatuscode(401);
			response.setBatchinfo(batchlist);
		} else {
			response.setStatuscode(200);
			response.setBatchinfo(batchlist);
			response.setDate(LocalDateTime.now());
			logger.info("getting batch details");
		}
		return response;
	}

	@GetMapping(path = "/gettechnology", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getTechnologyWise() {
		List<BatchInfo> technologylist = batchservice.getTechnologywise();
		if (technologylist == null) {
			response.setStatuscode(400);
		} else {
			response.setStatuscode(200);
			response.setBatchinfo(technologylist);
			logger.error("got batch details by technlogywise");
		}
		return response;
	}

	@GetMapping(path = "/getbycompleted", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getbydate() throws ParseException {
		List<BatchInfo> infobydate = batchservice.getBatchStatus();
		if (infobydate == null) {
			response.setStatuscode(400);
		} else {
			response.setStatuscode(200);
			response.setBatchinfo(infobydate);
		}
		return response;
	}

	@GetMapping(path = "/getbyongoing", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getbyOngoing() {
		List<BatchInfo> infobyOngoing= batchservice.getBatchOngoing();
		if (infobyOngoing == null) {
			response.setStatuscode(401);
		} else {
			response.setStatuscode(200);
			response.setBatchinfo(infobyOngoing);
		}
		return response;
	}
	
	@GetMapping(path ="/getbyTostart", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getByTostart() {
		List<BatchInfo> listbyToStart = batchservice.getbatchYetTostart();
		if(listbyToStart == null) {
			response.setStatuscode(401);
		} else {
			response.setStatuscode(200);
			response.setBatchinfo(listbyToStart);
		}
		return response;
	}
	
	@GetMapping(path ="/freebatches", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getFreebatches() {
		List<BatchInfo> freebatches = batchservice.getFreeBatches();
		if(freebatches == null) {
			response.setStatuscode(401);
		} else {
			response.setStatuscode(200);
			response.setBatchinfo(freebatches);
		}
		return response;
	}
	
	@GetMapping(path = "/paidbatches", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getPaidBatches() {
		List<BatchInfo> paidBatches = batchservice.getPaidBatches();
		if(paidBatches == null) {
			response.setStatuscode(401);
		} else {
			response.setStatuscode(200);
			response.setBatchinfo(paidBatches);
		}
		return response;
	}

}
