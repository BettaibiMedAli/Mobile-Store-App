package com.project.mobileStore.controllers;

import com.project.mobileStore.services.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.mobileStore.models.Income;

import java.util.List;


@Controller
@RequestMapping("/incomes")
public class IncomeController {
    @Autowired
    private IncomeService incomeService;
    @GetMapping
    public String viewIncomes(Model model)
    {
        double totalIncomes = incomeService.getTotalIncome();
        List<Income> incomeList = incomeService.getAllIncomes();
        model.addAttribute("totalIncomes",totalIncomes);
        model.addAttribute("incomeList",incomeList);
        return "incomes";
    }
}
