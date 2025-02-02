package com.saveIt.backend.server.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/health")
public class Health {

    @GetMapping("/")
    public String health() {
        return "OK";
    }
}
