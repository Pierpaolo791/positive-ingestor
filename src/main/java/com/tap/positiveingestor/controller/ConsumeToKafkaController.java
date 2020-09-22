package com.tap.positiveingestor.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tap.positiveingestor.kafka.KafkaConsumer;

@RestController
@RequestMapping("/api/v1/recive")
public class ConsumeToKafkaController {

	@Autowired
	private KafkaConsumer kafkaConsumer;
	
	@PostMapping("/send/{topic}")
	public void send(@PathVariable String topic) {
		try {
			kafkaConsumer.consume(topic);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
