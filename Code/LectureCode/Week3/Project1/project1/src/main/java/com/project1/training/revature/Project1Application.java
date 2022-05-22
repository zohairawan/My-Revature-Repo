package com.project1.training.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Project1Application {

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}

	@RequestMapping			//localhost:8089/
	public String index() {
		return "Welcome to the index page";
	}

	@RequestMapping("/registerUser")	//localhost:8089/registerUser to go to register user page
	public String registerUser() {
		return "Welcome to the register user page";
	}

	@RequestMapping("login")		//localhost:8089/registerUser to go to login page
	public String login() {
		return "Welcome to the login page";
	}

}
