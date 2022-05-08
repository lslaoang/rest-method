package com.spring.restmethod.controller;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.EntityTemplate;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
public class ApiController {

    private final WebClient client;

    @Value("${client.url.base}")
    String clientBaseUrl;

    @Value("${client.url.endpoints.post}")
    String clientEndpoint;

    public ApiController(WebClient client) {
        this.client = client;
    }

    @PostMapping("/sendToMock")
    public ResponseEntity<?> postSomething() {

        HttpEntity entity = MultipartEntityBuilder.create()
                .addTextBody("This text", "This Value")
                .setContentType(ContentType.parse("application/json"))
                .build();

        try {
            client.post()
                    .uri(clientBaseUrl + clientEndpoint)
                    .contentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity<>("Request completed!",HttpStatus.ACCEPTED);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void printEntity(HttpEntity entity) throws IOException {
        ByteArrayOutputStream entityInBytes = new ByteArrayOutputStream();
        entity.writeTo(entityInBytes);
        String entityString = entityInBytes.toString();
        System.out.println(entityString);
    }
}

