package com.example.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // Define init method
    @PostConstruct
    public void doMyStartUpStuff(){
        System.out.println("Inside init method");
    }
    // Definedestroy method
    @PreDestroy
    public void doMyCleanUpStuff(){
        System.out.println("Inside destroy method");
    }
    @Override
    public String getDailyWorkout() {
        return "Hey practice fast bowling for 15 minutes";
    }
}
