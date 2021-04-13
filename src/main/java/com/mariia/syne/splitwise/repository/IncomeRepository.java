package com.mariia.syne.splitwise.repository;

import com.mariia.syne.splitwise.entity.Income;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IncomeRepository extends CrudRepository<Income, Integer> {

    @Query(value ="SELECT SUM(sum_income) FROM Income WHERE id_user=?", nativeQuery = true)
    public Double getSumAllIncomes(Integer id_user);


}
