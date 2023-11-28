package com.example.AOP_Demo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneImpl implements TrafficFortune{

    @Override
    public String getFortune() {

        // Simulate a delay

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // return a fortune

        return "Expect heavy traffic this morning";
    }
}
