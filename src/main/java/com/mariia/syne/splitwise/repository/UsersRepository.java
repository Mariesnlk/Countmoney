package com.mariia.syne.splitwise.repository;

import com.mariia.syne.splitwise.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsersRepository extends CrudRepository<Users, Integer> {

    public UserDetails  getUserByLogin(String login);
}
