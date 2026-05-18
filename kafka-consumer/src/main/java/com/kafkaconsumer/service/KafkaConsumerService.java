package com.kafkaconsumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

	@KafkaListener(groupId = "topic1-group",topicPartitions = {@TopicPartition(topic = "topic1",partitions = {"0"})})
	public void consume1(String message) {
		System.out.println(message + " from consume1");
	}

//	@KafkaListener(topics = "topic1",groupId = "topic1-group")	
//	public void consume2(String message)
//	{
//		System.out.println(message+" from consume2");
//	}
//	
//	@KafkaListener(topics = "topic1",groupId = "topic1-group")	
//	public void consume3(String message)
//	{
//		System.out.println(message+" from consume3");
//	}

}
