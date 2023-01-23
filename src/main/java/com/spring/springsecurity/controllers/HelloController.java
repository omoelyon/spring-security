package com.spring.springsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }
    @PostMapping("/a")
    public String postEndpointA() {
        System.out.println("post");
        return "Works!";
    }
    @GetMapping("/a")
    public String getEndpointA() {
        System.out.println("get");
        return "Works!";
    }
    @GetMapping("/a/b")
    public String getEnpointB() {
        System.out.println("get ab");
        return "Works!";
    }
    @GetMapping("/a/b/c")
    public String getEnpointC() {
        System.out.println("get abc");
        return "Works!";
    }
}
