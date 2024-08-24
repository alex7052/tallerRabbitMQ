package com.rabbitMQ.rabitMq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabitMqApplication implements CommandLineRunner {

	private static final String MESSAGE = "Hello world!";

	@Autowired
	RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RabitMqApplication.class, args);
	}


	@Override
	public void run(String... args) throws InterruptedException {
		System.out.println("[Application] Enviando el mensaje \"" + MESSAGE + "\"...");
		rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME, RabbitMqConfig.ROUTING_KEY, MESSAGE);
	}

}
