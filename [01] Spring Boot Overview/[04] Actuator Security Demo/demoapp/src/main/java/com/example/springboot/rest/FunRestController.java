package com.example.springboot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // Expose "/" that return "Hello World"

    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    // Expose a new endpoint for "workout"

    @GetMapping("/workout")
    public String getDailyWorkout(){
            return "run a hard 5k!";
        }

    @GetMapping("/something")
    public String something(){
        return "idk";
    }
}
