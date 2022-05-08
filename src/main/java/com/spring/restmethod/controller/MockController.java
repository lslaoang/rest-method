package com.spring.restmethod.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockController {

    @PostMapping(value = "/post-some",consumes = "application/json")
    public HttpEntity<?> postSomething(){
        return new HttpEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/get-some",consumes = "application/json")
    public HttpEntity<?> getSomething(){
        return new HttpEntity<>(HttpStatus.ACCEPTED);
    }
}
