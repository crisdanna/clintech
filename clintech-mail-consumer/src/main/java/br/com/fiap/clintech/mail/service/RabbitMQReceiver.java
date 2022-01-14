package br.com.fiap.clintech.mail.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.fiap.clintech.mail.model.bean.Appointment;


@RabbitListener(bindings = @QueueBinding(value = @Queue(name = "${rabbitmq.queue}", durable = "true"), 
	exchange = @Exchange(value = "${rabbitmq.exchange}", type = ExchangeTypes.DIRECT)))
@Component
public class RabbitMQReceiver {
	private static transient Logger logger = LoggerFactory.getLogger(RabbitMQReceiver.class);
    
	@Autowired
	public SimpleMailMessage template;

	@Autowired
	private EmailService mailService;
	
	@RabbitHandler
    public void receiver(String message) {
		logger.info("Message received: " + message);
		Gson gson = new Gson();
		try {
			Appointment appointment = gson.fromJson(message, Appointment.class);
			
			String text = String.format(template.getText(), appointment.getTreatment().getPatient().getName(),
					appointment.getTreatment().getPatient().getLastname(), appointment.getDate(),
					appointment.getTime());

			template.setTo(appointment.getTreatment().getPatient().getEmail());
			
			mailService.sendSimpleMessage(template.getTo()[0], template.getSubject(), text);
			
		} catch (Exception e) {
			logger.error("Unable to process received message.",e);
		}
    }
}
