package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    private InstanceInformationService instanceInformationService;

    @GetMapping(path="books")
    public String hello(){
        return "hello bookapp v4: "+instanceInformationService.retrieveInstanceInfo();
    }
}
