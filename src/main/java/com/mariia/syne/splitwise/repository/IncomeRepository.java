package com.mariia.syne.splitwise.repository;

import com.mariia.syne.splitwise.entity.Income;
import com.mariia.syne.splitwise.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IncomeRepository extends CrudRepository<Income, Integer> {

    List<Income> getAllByIdUser(Users id_user);

    @Query(value = "SELECT SUM(sum_income) FROM Income WHERE id_user=?", nativeQuery = true)
    Double getSumAllIncomes(Integer id_user);

    @Query(value = "SELECT SUM(sum_income) FROM Income " +
            "LEFT JOIN Users " +
            "ON Users.id_users=Income.id_user " +
            "LEFT JOIN User_groups " +
            "ON User_groups.id_groups=Users.id_group " +
            "WHERE User_groups.id_groups=?", nativeQuery = true)
    Double getSumUserGroupIncomes(Integer id_groups);

//    List<Income> findAllByDateBetween(Date dateStart, Date dateEnd);

    @Query(value ="SELECT * FROM income " +
            "LEFT JOIN users " +
            "ON users.id_users=income.id_user " +
            "LEFT JOIN user_groups " +
            "ON user_groups.id_groups=users.id_group " +
            "WHERE user_groups.id_groups=? ", nativeQuery = true)
    List<Income> findAllIncomesByGroup(Integer id_groups);

}
