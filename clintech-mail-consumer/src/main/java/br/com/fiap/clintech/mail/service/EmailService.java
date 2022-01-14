package br.com.fiap.clintech.mail.service;

public interface EmailService {
	public void sendSimpleMessage(String to, String subject, String text);
}
