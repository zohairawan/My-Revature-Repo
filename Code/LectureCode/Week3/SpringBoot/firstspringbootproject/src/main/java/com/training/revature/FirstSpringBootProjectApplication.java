package com.training.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //Creates RESTful web services
public class FirstSpringBootProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(FirstSpringBootProjectApplication.class, args);
    }

    @RequestMapping                 //http://localhost:8081/ type this in the browser to display message
    public String index() {
        return "Welcome to Revature";
    }

    @RequestMapping("/home")        //http://localhost:8081/home type this in the browser to display message
    public String home() {
        return "Welcome to home page of Revature";
    }

    @RequestMapping("/contactUs")   //http://localhost:8081/contactUs type this in the browser to display message
    public String contactUs() {
        return "Welcome to Contact Us page";
    }
}
