package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("demo")
@RestController
public class DemoController {

    @GetMapping("/message")
    public String sayHello() {
        return "Hello and welcome to docker demo";
    }
}
