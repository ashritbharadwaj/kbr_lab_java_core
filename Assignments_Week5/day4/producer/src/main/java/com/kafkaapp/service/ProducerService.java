package com.kafkaapp.service;

import com.kafkaapp.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public void produce(Order order) {
        System.out.println("message is send....");
        kafkaTemplate.send("my_topic2_order",0,null, order);
    }
}
