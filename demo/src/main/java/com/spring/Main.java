package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/")
    public GreetResponse greet(){
        return new GreetResponse("this is a json object");
    }
    record GreetResponse(String greet){}
}
