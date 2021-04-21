package com.mariia.syne.splitwise.service;

import com.mariia.syne.splitwise.entity.Transactions;
import com.mariia.syne.splitwise.entity.Users;
import com.mariia.syne.splitwise.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionsService {

    @Autowired
    private TransactionsRepository transactionsRepository;


    public List<Transactions> getAllTransactions() {

        List<Transactions> transactions = new ArrayList<>();
        transactionsRepository.findAll().forEach(transactions::add);
        return transactions;
    }

    public Transactions getTransaction(Integer id) {
        return transactionsRepository.findById(id).orElse(null);
    }

    public List<Transactions> getTransactionsByUser(Integer user_id) {
        Users user=new Users();
        user.setId_users(user_id);
        return transactionsRepository.getAllByIdUser(user);
    }

    public void addTransaction(Transactions transactions) {

        transactionsRepository.save(transactions);
    }

    public void updateTransaction(Transactions transactions, Integer id) {

        transactionsRepository.save(transactions);
    }

    public void deleteTransaction(Integer id) {
        transactionsRepository.deleteById(id);
    }
}
