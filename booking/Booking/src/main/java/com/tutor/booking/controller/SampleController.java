package com.tutor.booking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class SampleController {

    @GetMapping
    public ResponseEntity<String> sampleMethod() {
        return ResponseEntity.ok("Hello World");
    }
}
