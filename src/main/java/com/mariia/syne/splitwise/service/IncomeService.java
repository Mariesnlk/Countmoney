package com.mariia.syne.splitwise.service;

import com.mariia.syne.splitwise.entity.Income;
import com.mariia.syne.splitwise.entity.Users;
import com.mariia.syne.splitwise.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;


    public List<Income> getAllIncome() {

        List<Income> incomes = new ArrayList<>();
        incomeRepository.findAll().forEach(incomes::add);
        return incomes;
    }

    public Double getSumAllIncomes(Integer user_id) {

        return incomeRepository.getSumAllIncomes(user_id);
    }

    public Double getSumUserGroupIncomes(Integer user_id) {

        return incomeRepository.getSumUserGroupIncomes(user_id);
    }

    public List<Income> getIncomeByUser(Integer user_id) {
        Users user = new Users();
        user.setId_users(user_id);
        return incomeRepository.getAllByIdUser(user);
    }

    public Income getIncome(Integer id) {
        return incomeRepository.findById(id).orElse(null);
    }

    public void addIncome(Income income) {

        incomeRepository.save(income);
    }

    public void updateIncome(Income income, Integer id) {

        incomeRepository.save(income);
    }

    public void deleteIncome(Integer id) {
        incomeRepository.deleteById(id);
    }
}
