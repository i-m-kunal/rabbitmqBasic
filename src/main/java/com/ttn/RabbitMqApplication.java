package com.ttn;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
@SpringBootApplication
public class RabbitMqApplication {
	@Bean
	public Queue myQueue() {
		return new Queue("myqueue");
	}
	public static void main(String[] args) {
		SpringApplication.run(RabbitMqApplication.class, args);
	}
}