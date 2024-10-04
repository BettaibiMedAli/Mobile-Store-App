package com.project.mobileStore.services;

import com.project.mobileStore.models.Income;
import com.project.mobileStore.repositories.IncomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IncomeSerivceImpl implements IncomeService{
    @Autowired
    private IncomeRepo incomeRepo;
    @Override
    public void addIncome(Income income) {
        incomeRepo.save(income);
    }

    @Override
    public List<Income> getAllIncomes() {
        return incomeRepo.findAll();
    }

    @Override
    public double getTotalIncome() {
        return incomeRepo.findAll().stream().mapToDouble(Income::getAmount).sum();
    }
}
