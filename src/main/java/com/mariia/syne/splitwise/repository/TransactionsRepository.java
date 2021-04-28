package com.mariia.syne.splitwise.repository;

import com.mariia.syne.splitwise.entity.Transactions;
import com.mariia.syne.splitwise.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface TransactionsRepository extends CrudRepository<Transactions, Integer> {

    List<Transactions> getAllByIdUser(Users id_user);

    @Query(value ="SELECT SUM(sum) FROM Transactions WHERE id_user=?", nativeQuery = true)
    Double getSumUserTransactions(Integer id_user);

    @Query(value ="SELECT SUM(sum) FROM Transactions " +
            "LEFT JOIN users " +
            "ON users.id_users=Transactions.id_user " +
            "LEFT JOIN user_groups " +
            "ON user_groups.id_groups=users.id_group " +
            "WHERE user_groups.id_groups=?", nativeQuery = true)
    Double getSumUserGroupTransactions(Integer id_groups);


    @Query(value ="SELECT DISTINCT destination FROM Transactions", nativeQuery = true)
    List<String> getDescription();

    List<Transactions> findAllByDateBetween(Date dateStart, Date dateEnd);

}
