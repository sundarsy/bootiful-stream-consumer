package com.github.sundarsy.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;


@SpringBootApplication
@EnableBinding(Sink.class)
public class StreamConsumerApplication {
	protected Logger logger = LoggerFactory.getLogger(StreamConsumerApplication.class.getName());


	public static void main(String[] args) {
		SpringApplication.run(StreamConsumerApplication.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void loggerSink(String message) {
		logger.info("Received: " + message);
	}
 
}
