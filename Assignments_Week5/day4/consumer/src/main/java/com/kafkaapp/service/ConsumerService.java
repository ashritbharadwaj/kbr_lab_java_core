package com.kafkaapp.service;

import com.kafkaapp.dto.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @KafkaListener(topics = "my_topic2_order", groupId = "my_topic_group_id")
    public void consume(Order order) {
        System.out.println("message is received....");
        System.out.println(order);
    }
}
