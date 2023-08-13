package com.example.springboot.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // Inject properties for: coach.name and team.name

    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    // Expose new endpoint for "TeamInfo"
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach name: " + coachName + " Team Name: " + teamName;
    }

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
