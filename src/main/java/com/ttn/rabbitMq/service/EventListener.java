package com.ttn.rabbitMq.service;

import com.ttn.rabbitMq.Enums.Events;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@EnableRabbit
@Service
public class EventListener {
    @Autowired
    EventHandlerService handler;
    @RabbitListener(queues = "myqueue")
    public void processQueue(Map<String, Object> message) {

        handler.handler((Events) message.get("event"), message.get("message"));
    }

}
