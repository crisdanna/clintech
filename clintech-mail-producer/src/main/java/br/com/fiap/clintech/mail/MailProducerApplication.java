package br.com.fiap.clintech.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailProducerApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(MailProducerApplication.class, args);
	}
}