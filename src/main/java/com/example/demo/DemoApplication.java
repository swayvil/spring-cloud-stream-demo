package com.example.demo;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.integration.support.MessageBuilder;

@SpringBootApplication
public class DemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Consumer<Message<String>> myConsumer() {
		return v -> {
			logger.info("Received myConsumer: " + v.getPayload());
			logger.info("Destination: " + v.getHeaders().get("solace_destination"));
			logger.info("TTL: " + v.getHeaders().get("solace_timeToLive"));
			logger.info("My Custom Header: " + v.getHeaders().get("Key"));;
		};
	}

	@Bean
	Supplier<Message<String>> mySupplier(){
		return () -> {
			logger.info("");
			logger.info("Publish a message");
			return MessageBuilder.withPayload("Hello Headers").setHeader("Key", "Value").build();
		};
	}
}
