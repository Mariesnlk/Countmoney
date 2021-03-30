package com.mariia.syne.splitwise.service;

import com.mariia.syne.splitwise.entity.TypeTransaction;
import com.mariia.syne.splitwise.repository.TypeTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeTransactionService {

    @Autowired
    private TypeTransactionRepository typeTransactionRepository;


    public List<TypeTransaction> getAllTypeTransaction() {

        List<TypeTransaction> typeTransactions = new ArrayList<>();
        typeTransactionRepository.findAll().forEach(typeTransactions::add);
        return typeTransactions;
    }

    public TypeTransaction getTypeTransaction(Integer id) {
        return typeTransactionRepository.findById(id).orElse(null);
    }

    public void addTypeTransaction(TypeTransaction typeTransaction) {

        typeTransactionRepository.save(typeTransaction);
    }

    public void updateTypeTransaction(TypeTransaction typeTransaction, Integer id) {

        typeTransactionRepository.save(typeTransaction);
    }

    public void deleteTypeTransaction(Integer id) {
        typeTransactionRepository.deleteById(id);
    }
}
