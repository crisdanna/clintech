package br.com.fiap.clintech.mail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

import br.com.fiap.clintech.mail.service.EmailService;
import br.com.fiap.clintech.mail.service.EmailServiceImpl;

@Configuration
public class ReceiverConfig {
	
	@Bean
	public EmailService emailService() {
		return new EmailServiceImpl();
	}
	
	@Bean
	public SimpleMailMessage templateSimpleMessage() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setText("Olá %s %s, \n\n" + "Sua consulta para o dia %s às %s foi agendada com sucesso.\n\n"
				+ "Obrigado.\n" + "Clintech");

		message.setSubject("Agendamento realizado com sucesso.");
		return message;
	}
}
