package com.project.mobileStore.controllers;

import com.project.mobileStore.models.Mobile;
import com.project.mobileStore.services.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private MobileService mobileService;
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    @GetMapping("/Homepage")
    public String home(Model model)
    {
        List<Mobile> mobiles = mobileService.getAllMobiles();
        model.addAttribute("mobiles", mobiles);
        System.out.println("Mobiles in model: " + mobiles);
        return "index";
    }
}
