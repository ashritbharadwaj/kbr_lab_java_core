package com.kafkaapp.controller;

import com.kafkaapp.dto.Order;
import com.kafkaapp.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private ProducerService produceService;

    @PostMapping("producer")
    public String callProducer(@RequestBody Order order) {
        produceService.produce(order);
        return "product added";
    }
}
