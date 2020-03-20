package com.tyss.trainingmaintainence.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.trainingmaintainence.dto.CalenderInfo;
import com.tyss.trainingmaintainence.dto.Response;
import com.tyss.trainingmaintainence.service.CalenderService;

@RestController
@RequestMapping("/calender")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class CalenderController {

	@Autowired
	private CalenderService calenderService;

	Response response = new Response();

	private CalenderInfo info;

	@PostMapping(path = "/calender", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response calenderInfo(@RequestBody CalenderInfo calenderinfo) {
		CalenderInfo calinfo = calenderService.addCalenderInfo(calenderinfo);
		if (calinfo != null) {
			response.setStatuscode(200);
		} else {
			response.setStatuscode(400);
		}
		return response;
	}

	@GetMapping(path = "/calender", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CalenderInfo> getCalenderInfo() {
		List<CalenderInfo> callist = calenderService.getCalenderInfo();
		if (callist != null) {
			response.setStatuscode(200);
			response.setCalenderinfo(callist);
		} else {
			response.setStatuscode(400);
		}
		return callist;
	}
}
