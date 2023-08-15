package com.example.demo_calculator.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping ("/hello")
    public String hello() {
        return "Hello, world";
    }
}