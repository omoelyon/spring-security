package com.spring.springsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Map hello() {
        return Map.of("message","Hello!");
    }
}
