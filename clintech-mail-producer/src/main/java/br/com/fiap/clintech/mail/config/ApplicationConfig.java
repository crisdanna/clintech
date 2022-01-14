package br.com.fiap.clintech.mail.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Value("${rabbitmq.queue}")
	private String queueName;


	@Bean
	public Queue queue() {
//		return QueueBuilder.durable(queueName).build();
		return new Queue(queueName);
	}
	
//	@Bean
//	public ConnectionFactory connectionFactory() {
//		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
//		return connectionFactory;
//	}
}
