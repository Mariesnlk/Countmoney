package com.mariia.syne.splitwise.repository;

import com.mariia.syne.splitwise.entity.Transactions;
import org.springframework.data.repository.CrudRepository;

public interface TransactionsRepository extends CrudRepository<Transactions, Integer> {
}
