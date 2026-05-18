package com.kafkaproducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig 
{
    @Bean
    public NewTopic createTopic()
    {
    	return new NewTopic("topic3",5,(short)1);
    }
}
