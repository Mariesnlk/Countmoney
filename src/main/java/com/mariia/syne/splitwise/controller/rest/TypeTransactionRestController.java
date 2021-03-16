package com.mariia.syne.splitwise.controller.rest;

import com.mariia.syne.splitwise.model.TypeTransaction;
import com.mariia.syne.splitwise.service.TypeTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("typeTransaction")
public class TypeTransactionRestController {
        /*
    GET     /typeTransaction
    GET     /typeTransaction/1
    POST    /typeTransaction
    PUT     /typeTransaction/1
    DELETE  /typeTransaction/1
    */

    @Autowired
    private TypeTransactionService typeTransactionService;

    @GetMapping
    public List<TypeTransaction> getAllTypeTransaction() {

        return typeTransactionService.getAllTypeTransaction();
    }

    @GetMapping("/{id}")
    public TypeTransaction getTypeTransaction(@PathVariable Integer id) {

        return typeTransactionService.getTypeTransaction(id);
    }

    @PostMapping
    public void addTypeTransaction(@RequestBody TypeTransaction typeTransaction) {

        typeTransactionService.addTypeTransaction(typeTransaction);
    }

    @PutMapping("/{id}")
    public void updateTypeTransaction(@RequestBody TypeTransaction typeTransaction, @PathVariable Integer id) {

        typeTransactionService.updateTypeTransaction(typeTransaction, id);
    }

    @DeleteMapping("/{id}")
    public void deleteTypeTransaction(@PathVariable Integer id) {

        typeTransactionService.deleteTypeTransaction(id);
    }
}
