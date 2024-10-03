package com.project.mobileStore.controllers;

import org.springframework.ui.Model;import com.project.mobileStore.models.Mobile;
import com.project.mobileStore.services.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mobiles")
public class MobileController {
    @Autowired
    private MobileService mobileService;

    /*@GetMapping("/Homepage")
    public String listMobiles(Model model)
    {
        List<Mobile> mobiles = mobileService.getAllMobiles();
        model.addAttribute("mobiles", mobiles);
        System.out.println("Mobiles in model: " + mobiles);
        return "index";
    }*/

    @GetMapping("/search")
    public String searchMobiles(@RequestParam("query") String query, Model model)
    {
        List<Mobile> mobiles = mobileService.searchMobiles(query);
        model.addAttribute("mobiles",mobiles);
        return "index";
    }
    @GetMapping("/new")
    public String showAddingForm(Model model)
    {
        model.addAttribute("mobile", new Mobile());
        return "addMobile";
    }
    @PostMapping("/add")
    public String addMobile(Mobile mobile)
    {
        mobileService.addMobile(mobile);
        return "redirect:/Homepage";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model)
    {
        Mobile existingMobile = mobileService.getMobileById(id).orElseThrow(() -> new RuntimeException("Mobile does noy exist!"));
        model.addAttribute("mobile", existingMobile);
        return "editMobile";
    }
    @PostMapping("/edit/{id}")
    public String updateMobile(@PathVariable Long id, @ModelAttribute Mobile mobile)
    {
        mobileService.updateMobile(id, mobile);
        return "redirect:/Homepage";
    }
    @GetMapping("/delete/{id}")
    public String deleteMobile(@PathVariable Long id)
    {
        mobileService.deleteMobile(id);
        return "redirect:/Homepage";
    }
}
