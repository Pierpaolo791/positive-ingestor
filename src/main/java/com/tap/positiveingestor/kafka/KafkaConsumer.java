package com.tap.positiveingestor.kafka;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.tap.positiveingestor.model.Message;

@Service
public class KafkaConsumer {

	@KafkaListener(topics = "telegram-action")
	public void consume(Message message) throws IOException {
		CompletableFuture<Void> action = CompletableFuture.runAsync(
				() -> System.out.println("Esegue un azione nel bot telegram e consuma il messaggio. \n" +message.getMessage())
				);
	}
	

}
