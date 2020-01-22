package com.rodrigo7prado.sisGestEduc;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.application.Application;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        // This is how normal Spring Boot app would be launched
        // SpringApplication.run(SpringBootExampleApplication.class, args);

        // JavaFxApplication doesn't exist yet, 
        // we'll create it in the next step
//    	SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);
    	
        Application.launch(JavaFxApplication.class, args);    }
}