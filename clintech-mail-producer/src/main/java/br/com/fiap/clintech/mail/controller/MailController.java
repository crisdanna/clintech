package br.com.fiap.clintech.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.clintech.mail.model.bean.Appointment;
import br.com.fiap.clintech.mail.service.RabbitMQSender;

@RestController
@RequestMapping(value = "/mail")
public class MailController {
    @Autowired
    RabbitMQSender rabbitMQSender;
    
    @PostMapping
    public String producer(@RequestBody Appointment appointment) {
        rabbitMQSender.send(appointment);
        return "Message sent to the RabbitMQ Queue Successfully";
    }
}
