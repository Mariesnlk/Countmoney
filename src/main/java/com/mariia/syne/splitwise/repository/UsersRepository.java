package com.mariia.syne.splitwise.repository;

import com.mariia.syne.splitwise.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Integer> {
}