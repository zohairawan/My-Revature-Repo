package com.example.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dockerdemo")
public class DockerDemoController {
    @GetMapping("/message")
    public String message() {
        return "Hello, this is a docker demo";
    }
}
