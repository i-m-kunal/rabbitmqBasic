package com.ttn.rabbitMq.service;

import com.ttn.rabbitMq.Enums.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.ttn.rabbitMq.Enums.Events.Event1;
@Service
public class EventHandlerService {
    @Autowired
    EmailService emailService;

     void handler(Events event, Object message) {
        switch (event) {
            case Event1:
                emailService.sendMail(message.toString());
                break;
            case Event2:
                emailService.sendMail( message.toString());
                break;
        }
    }
}
