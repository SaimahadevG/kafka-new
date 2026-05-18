package com.kafkaproducer.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.kafkaproducer.dto.Customer;

@Service
public class KafkaProucerService {
	@Autowired
	private KafkaTemplate<String, Object> template;

	public void sendMessage(String message) {
		CompletableFuture<SendResult<String, Object>> send = template.send("topic1", 0,null,message);
		send.whenComplete((result, ex) -> {
			if (ex == null) {
				System.out.println("sent message :" + result.getRecordMetadata().offset() + " " + message);
			} else {
				System.out.println("couldnt send message" + ex.getMessage());
				ex.printStackTrace();
			}
		});
	}

	public void sendCustomer(Customer customer) {
		CompletableFuture<SendResult<String, Object>> send = template.send("topic1",customer);
		send.whenComplete((result, ex) -> {
			if (ex == null) {
				System.out.println("sent message :" + result.getRecordMetadata().offset() + " " + customer.toString());
			} else {
				System.out.println("couldnt send message" + ex.getMessage());
				ex.printStackTrace();
			}
		});
	}
}
