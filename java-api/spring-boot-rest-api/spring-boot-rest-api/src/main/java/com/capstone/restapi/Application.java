package com.capstone.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main application for Rest API
 */
@SpringBootApplication
@ComponentScan({ "com.capstone.restapi*" })
public class Application {
  public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
