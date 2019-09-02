/**
 * This is a SpringKafkaConfiguration File
 */
package com.tricon.dataAnalyticsProjectIO.springkafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

/**
 * @author Shubham Arora
 *
 */
@Configuration
public class springKafka {
	
	@Bean
	public ProducerFactory<String, JSONObject> producerFactory(){
		Map<String, Object> config = new HashMap<>();
		//IP Address , and Kafka port is given on next line
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
		//key
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		//value
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(config);
	}
	
	@Bean
	public KafkaTemplate<String, JSONObject> kafkaTemplate(){
		return new KafkaTemplate<String, JSONObject>(producerFactory());
	}
	
}
