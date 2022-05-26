package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dockerdemo2")
public class DockerDemoController {

    @GetMapping("method")
    public String greeting() {
        return "Hello Everyone";
    }
}
