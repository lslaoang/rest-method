package com.spring.restmethod.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockController {

    @PostMapping(value = "/mock",consumes = "application/json")
    public HttpEntity<?> mockServer(){
        return new HttpEntity<>(HttpStatus.ACCEPTED);
    }
}
