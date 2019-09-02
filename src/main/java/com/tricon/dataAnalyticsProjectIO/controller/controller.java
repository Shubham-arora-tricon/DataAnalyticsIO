/**
 * 
 */
package com.tricon.dataAnalyticsProjectIO.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shubham-arora
 *
 */

@RestController
public class controller {
	
	@Autowired
	KafkaTemplate<String, JSONObject> kafkaJsonTemplate;
	String TOPIC_NAME = "items-topic";//topic name of kafka
	
	@RequestMapping(value="/shubham", method=RequestMethod.POST)
	public ResponseEntity<Object> eventCapture(@RequestBody JSONObject jobj){
		kafkaJsonTemplate.send(TOPIC_NAME, jobj);
		System.out.println(jobj);
		return new ResponseEntity<>("successfully added", HttpStatus.CREATED);
	}
	
}