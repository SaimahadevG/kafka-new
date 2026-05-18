package com.kafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafkaproducer.dto.Customer;
import com.kafkaproducer.service.KafkaProucerService;

@RestController
@RequestMapping("/producer-app")
public class KafkaProducerController {
	@Autowired
	private KafkaProucerService service;

	@PostMapping("/{message}")
	public String sendMessage(@PathVariable String message) {
		for (int i = 0; i < 10000; i++) {
			service.sendMessage(message);
		}
		return "sent message successfully";
	}

	@PostMapping()
	public String sendMessage(@RequestBody Customer customer) {
			service.sendCustomer(customer);
		return "sent message successfully";
	}

}
