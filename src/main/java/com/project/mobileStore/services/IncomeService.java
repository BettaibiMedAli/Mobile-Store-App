package com.project.mobileStore.services;

import com.project.mobileStore.models.Income;

import java.util.List;

public interface IncomeService {
    void addIncome(Income income);
    List<Income> getAllIncomes();
    double getTotalIncome();
}
