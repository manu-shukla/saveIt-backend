package com.saveIt.backend.server.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Health {

    @GetMapping("/health/{id}")
    public String health(@PathVariable String id) {
        return id;
    }
}
