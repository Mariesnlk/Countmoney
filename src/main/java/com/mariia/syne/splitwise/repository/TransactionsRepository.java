package com.mariia.syne.splitwise.repository;

import com.mariia.syne.splitwise.model.Transactions;
import org.springframework.data.repository.CrudRepository;

public interface TransactionsRepository extends CrudRepository<Transactions, Integer> {
}
