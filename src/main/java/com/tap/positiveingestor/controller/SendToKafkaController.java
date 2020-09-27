package com.tap.positiveingestor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tap.positiveingestor.kafka.KafkaProducer;
import com.tap.positiveingestor.model.Message;

@RestController
@RequestMapping("/api/v1/send")
public class SendToKafkaController {
	
	@Autowired
	private KafkaProducer kafkaProducer; 
	
	@PostMapping("/{topic}")
	public boolean send(@PathVariable String topic, @RequestBody Message message) {
		kafkaProducer.produce(topic, message);
		return true; 
	}
	
}
