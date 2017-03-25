package com.ttn.rabbitMq.service;

import com.ttn.rabbitMq.Enums.Events;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

@Service
public class EventPublisherService {

    @Autowired
    AmqpTemplate template;

    public void publishEvent(Events event, String eMessages) throws IOException, TimeoutException {
        Map<String, Object> message = new HashMap<String, Object>();
        message.put("event", event);
        message.put("message", eMessages);
        template.convertAndSend("myqueue", message);
    }


}