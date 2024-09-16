package com.datasource.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datasource.service.KafkaService;

@RestController
@RequestMapping("/update")
public class KafkaController {
	
	@Autowired
	private KafkaService kafkaService;
	
	private Logger logger  = LoggerFactory.getLogger(KafkaService.class);
	
	@PostMapping("/data")
	public ResponseEntity<?> updateData(){
		for(int i = 1; i <= 100000; i++) {
		this.kafkaService.updatedData("Data is updated with frequent number of interval - "+Math.random());
		logger.info("Data updated "+i+ " time");
		System.out.println("--------------------");
		}
		return new ResponseEntity<>(Map.of("message","Data Updated successfully"), HttpStatus.OK);
	}

}
