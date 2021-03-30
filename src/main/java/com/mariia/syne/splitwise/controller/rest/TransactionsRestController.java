package com.mariia.syne.splitwise.controller.rest;

import com.mariia.syne.splitwise.entity.Transactions;
import com.mariia.syne.splitwise.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transactions")
public class TransactionsRestController {
        /*
    GET     /transactions
    GET     /transactions/1
    POST    /transactions
    PUT     /transactions/1
    DELETE  /transactions/1
    */

    @Autowired
    private TransactionsService transactionsService;

    @GetMapping
    public List<Transactions> getAllTransactions() {

        return transactionsService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Transactions getTransaction(@PathVariable Integer id) {

        return transactionsService.getTransaction(id);
    }

    @PostMapping
    public void addTransaction(@RequestBody Transactions transaction) {

        transactionsService.addTransaction(transaction);
    }

    @PutMapping("/{id}")
    public void updateTransaction(@RequestBody Transactions transaction, @PathVariable Integer id) {

        transactionsService.updateTransaction(transaction, id);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Integer id) {

        transactionsService.deleteTransaction(id);
    }
}
