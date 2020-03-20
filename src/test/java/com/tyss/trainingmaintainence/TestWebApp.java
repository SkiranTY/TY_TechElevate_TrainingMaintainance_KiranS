package com.tyss.trainingmaintainence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import com.tyss.trainingmaintainence.controller.BatchInfoController;
import com.tyss.trainingmaintainence.service.BatchInfoService;

public class TestWebApp extends TrainingMaintainenceApplicationTests {

	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private BatchInfoService service;
	
	private MockMvc mvc;
	
	@BeforeAll
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	
	@Test
	public void testBatch() throws Exception{
		 Mockito.when(service.getBatchDetails().toString()).thenReturn("Mock Product Name");
		 String testName = service.getBatchDetails().toString(); 
		 System.out.println(testName);
		 assertEquals("testname", testName);
		
	}
}
