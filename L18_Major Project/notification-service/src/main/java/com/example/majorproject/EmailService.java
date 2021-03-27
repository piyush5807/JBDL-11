package com.example.majorproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    SimpleMailMessage simpleMailMessage;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    ObjectMapper objectMapper;

    @KafkaListener(topics = {"send_email"}, groupId = "test1234")
    public void sendMail(String message) throws JsonProcessingException {

        JSONObject emailRequest = objectMapper.readValue(message, JSONObject.class);
        simpleMailMessage.setText((String)emailRequest.get("message"));
        simpleMailMessage.setTo((String) emailRequest.get("toUser"));
        simpleMailMessage.setSubject("Transaction Report");
        simpleMailMessage.setFrom("gfg.geeks.jbdl11@gmail.com");

        javaMailSender.send(simpleMailMessage);
    }
}
