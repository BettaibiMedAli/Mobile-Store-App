package com.project.mobileStore.controllers;

import com.project.mobileStore.dto.UserRegistrationDto;
import com.project.mobileStore.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    private UserService userService;
    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }
    @ModelAttribute("user")
    public UserRegistrationDto registrationDto()
    {
        return new UserRegistrationDto();
    }
    @GetMapping
    public String registrationForm()
    {
        return "registration";
    }
    @PostMapping
    public String registerUser(@ModelAttribute("user") UserRegistrationDto registrationDto)
    {
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }
}
