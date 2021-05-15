package com.mariia.syne.splitwise.controller.rest;

import com.mariia.syne.splitwise.model.Frequency;
import com.mariia.syne.splitwise.model.Transactions;
import com.mariia.syne.splitwise.model.Users;
import com.mariia.syne.splitwise.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @GetMapping("/allDescriptions")
    public List<String> getDescription() {

        return transactionsService.getDescription();
    }

    @GetMapping("/allFrequency")
    public List<Frequency> getFrequency() {

        return transactionsService.getAllFrequency();
    }


    @GetMapping("user/{user_id}")
    public List<Transactions> getTransactionsByUser(@PathVariable Integer user_id) {

        return transactionsService.getTransactionsByUser(user_id);
    }

    @GetMapping("group/{group_id}")
    public List<Transactions> getTransactionsByGroup(@PathVariable Integer group_id) {

        return transactionsService.getTransactionsByGroup(group_id);
    }

    @GetMapping("/sum")
    public Double getSum() {
        Integer id = ((Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId_users();
        return transactionsService.getSumUserTransactions(id);
    }

    @GetMapping("/sum_by_group")
    public Double getSumByGroup() {
        Integer id = ((Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId_group().getId_groups();
        return transactionsService.getSumGroupTransactions(id);
    }

    @GetMapping("/regular_transactions/{user_id}")
    public List<Transactions> getRegularTransactions(@PathVariable Integer user_id) {

        return transactionsService.getRegularTransactionsByUserAndMonth(user_id);
    }


    @GetMapping("user/{user_id}/period")
    public List<Transactions> findAllByDateBetweenByIdUser(@PathVariable Integer user_id, @RequestParam String start, @RequestParam String end) {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = format.parse(start);
            endDate = format.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return transactionsService.findAllByDateBetweenByIdUser(user_id, startDate, endDate);
    }

    @GetMapping("group/{group_id}/period")
    public List<Transactions> findAllByDateBetweenByIdGroup(@PathVariable Integer group_id, @RequestParam String start, @RequestParam String end) {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = format.parse(start);
            endDate = format.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return transactionsService.findAllByDateBetweenByIdGroup(group_id, startDate, endDate);
    }

    @GetMapping("/{id}")
    public Transactions getTransaction(@PathVariable Integer id) {

        return transactionsService.getTransaction(id);
    }

    @PostMapping
    public void addTransaction(@RequestBody Transactions transaction) {
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        transaction.setIdUser(user);
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
