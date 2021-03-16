package com.mariia.syne.splitwise.controller.rest;

import com.mariia.syne.splitwise.model.Income;
import com.mariia.syne.splitwise.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("income")
public class IncomeRestController {
        /*
    GET     /income
    GET     /income/1
    POST    /income
    PUT     /income/1
    DELETE  /income/1
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

    @PostMapping
    public void addIncome(@RequestBody Income income) {

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
}
