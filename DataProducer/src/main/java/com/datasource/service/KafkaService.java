package com.datasource.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.datasource.config.AppConstants;

@Service
public class KafkaService {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	
	private Logger logger  = LoggerFactory.getLogger(KafkaService.class);
	
	public boolean updatedData(String data) {
		
		this.kafkaTemplate.send(AppConstants.TOPIC_NAME, data);
		logger.info("Data updated");
		return true;
	}

}
