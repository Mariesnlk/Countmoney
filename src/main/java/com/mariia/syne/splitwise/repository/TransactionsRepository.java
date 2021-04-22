package com.mariia.syne.splitwise.repository;

import com.mariia.syne.splitwise.entity.Transactions;
import com.mariia.syne.splitwise.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionsRepository extends CrudRepository<Transactions, Integer> {

    public List<Transactions> getAllByIdUser(Users id_user);

    @Query(value ="SELECT SUM(sum) FROM Transactions WHERE id_user=?", nativeQuery = true)
    public Double getSumUserTransactions(Integer id_user);

}
