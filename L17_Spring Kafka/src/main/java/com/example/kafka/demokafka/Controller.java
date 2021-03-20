package com.example.kafka.demokafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ConsumerProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    // A. It will not go to 4
    // B. It can go to 4
    // C. It can go to any partition
    // D. It will definitely go to 4

    private static Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Value("${my_application.topic}")
    String topic;

    @PostMapping("/produce")
    public void produceMessage(@RequestParam("msg") String msg, @RequestParam("recipient") String recipient){
        this.kafkaTemplate.send(topic, recipient, msg);
        logger.info("Produced msg {} on topic {}", msg, topic);
    }

    @KafkaListener(topics = {"jbdl11_test_topic"})
    public void consume(String msg){
        logger.info("Consumed msg {}", msg);
    }
//
//    @KafkaListener(topics = {"jbdl11_test_topic"})
//    public void consume2(String msg){
//        logger.info("Consumed2 msg {}", msg);
//    }

    // 59740414
    // 1d1b6a74
}
