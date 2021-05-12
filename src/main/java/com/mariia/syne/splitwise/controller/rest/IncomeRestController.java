package com.mariia.syne.splitwise.controller.rest;

import com.mariia.syne.splitwise.entity.Income;
import com.mariia.syne.splitwise.entity.Users;
import com.mariia.syne.splitwise.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("incomes")
public class IncomeRestController {
        /*
    GET     /incomes
    GET     /incomes/1
    POST    /incomes
    PUT     /incomes/1
    DELETE  /incomes/1
    */

    @Autowired
    private IncomeService incomeService;

    @GetMapping
    public List<Income> getAllIncome() {

        return incomeService.getAllIncome();
    }

    @GetMapping("/{id}")
    public Income getIncome(@PathVariable Integer id) {

        return incomeService.getIncome(id);
    }

    @GetMapping("/sum")
    public Double getSum() {
        Integer id = ((Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId_users();
        return incomeService.getSumAllIncomes(id);
    }

    @GetMapping("/sum-by-group")
    public Double getSumByGroup() {
        Integer id = ((Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId_group().getId_groups();
        return incomeService.getSumUserGroupIncomes(id);
    }

    @PostMapping
    public void addIncome(@RequestBody Income income) {

        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        income.setIdUser(user);

        incomeService.addIncome(income);
    }

    @PutMapping("/{id}")
    public void updateIncome(@RequestBody Income income, @PathVariable Integer id) {

        incomeService.updateIncome(income, id);
    }

    @DeleteMapping("/{id}")
    public void deleteIncome(@PathVariable Integer id) {

        incomeService.deleteIncome(id);
    }

    @GetMapping("user/{user_id}")
    public List<Income> getIncomesByUser(@PathVariable Integer user_id) {

        return incomeService.getIncomeByUser(user_id);
    }
}
