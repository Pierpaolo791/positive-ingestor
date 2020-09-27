package com.tap.positiveingestor.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.tap.positiveingestor.model.Message;

@Service
public class KafkaProducer {
	
	@Autowired
	private KafkaTemplate<String, Message> kafkaTemplate;
	
	public void produce(String topic, Message message) {
		kafkaTemplate.send(topic, message);
	}

}
