package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping("hello")
    public String hello(){
        return "Demo Application...";
    }

    @GetMapping("students")
    public List<Students> welcome(){
        return List.of(
            new Students("John", "Doe", 20),
            new Students("Jane", "Smith", 22),
            new Students("Alice", "Johnson", 19)
        );
    }
}

class Students {
    private String firstName;
    private String lastName;
    private int age;

    public Students(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
