package com.mariia.syne.splitwise.repository;

import com.mariia.syne.splitwise.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UsersRepository extends CrudRepository<Users, Integer> {

    public UserDetails  getUserByLogin(String login);

    @Query(value ="SELECT U.last_name, U.first_name\n" +
            "    FROM Users U\n" +
            "    INNER JOIN Groups G\n" +
            "    ON U.id_group=G.id_groups\n" +
            "    WHERE U.id_group = ?;", nativeQuery = true)
    public List<Users> getListUsersByGroup(Integer id_group);
}
