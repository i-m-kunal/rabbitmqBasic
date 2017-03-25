package com.ttn.rabbitMq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailService;

    public void sendMail(String message){

        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setTo("amitraturi36@gmail.com");
        mailMessage.setSubject("Registration");
        mailMessage.setText("Hello Amit job message="+message);
        javaMailService.send(mailMessage);

    }
}
