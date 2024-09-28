package com.project.mobileStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class GreetingController {
    @GetMapping
    public String greeting()
    {
        return "Greeting Soldier!";
    }
}
