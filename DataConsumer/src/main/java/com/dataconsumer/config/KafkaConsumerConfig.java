package com.dataconsumer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerConfig {
	
	private Logger logger = LoggerFactory.getLogger(KafkaConsumerConfig.class);
	
	@KafkaListener(topics = AppConstants.DATA_CONSUMING_TOPIC, groupId = AppConstants.GROUP_ID)
	public void updateDataIf(String data) {
		logger.info("Log Statement -> Get the update data - ", data);
		System.out.println(data);
	}

}
