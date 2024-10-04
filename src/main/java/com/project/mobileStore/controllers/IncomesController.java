package com.project.mobileStore.controllers;

import com.project.mobileStore.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/incomes")
public class IncomesController {
    @Autowired
    private CartService cartService;
    @GetMapping
    public String viewIncomes(Model model)
    {
        double totalIncomes = cartService.calculateTotal();
        model.addAttribute("totalIncomes",totalIncomes);
        return "incomes";
    }
}
