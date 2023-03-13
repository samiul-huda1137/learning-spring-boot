package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/")
    public GreetResponse greet(){
        GreetResponse response = new GreetResponse("this is a json object",
                List.of("Java", "Python", "Flutter", "Spring"),
                new Person("Huda",24,10000)
        );
        return  response;
    }
    record Person(String name,int age, double savings){

    }
    record GreetResponse(
            String greet,
            List<String> programmingLanguages,
            Person person
    ){}
}
