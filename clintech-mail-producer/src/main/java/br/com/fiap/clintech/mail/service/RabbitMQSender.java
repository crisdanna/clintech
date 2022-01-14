package br.com.fiap.clintech.mail.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.fiap.clintech.mail.model.bean.Appointment;

@Service
public class RabbitMQSender {
	private static transient Logger logger = LoggerFactory.getLogger(RabbitMQSender.class);
	
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private Queue queue;
    
    public void send(Appointment appointment) {
    	Gson gson = new Gson();
    	String message = gson.toJson(appointment);
    	logger.info("Sending Message to the Queue("+queue.getName()+") : "+ message);
        rabbitTemplate.convertAndSend(queue.getName(), message);
    }
}
