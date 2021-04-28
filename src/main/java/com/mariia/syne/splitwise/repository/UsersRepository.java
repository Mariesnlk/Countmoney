package com.mariia.syne.splitwise.repository;

import com.mariia.syne.splitwise.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UsersRepository extends CrudRepository<Users, Integer> {

    public UserDetails  getUserByLogin(String login);

    @Query(value ="SELECT *\n" +
            "    FROM Users \n" +
            "    INNER JOIN User_groups\n" +
            "    ON Users.id_group=User_groups.id_groups\n" +
            "    WHERE Users.id_group = ?;", nativeQuery = true)
    public List<Users> getListUsersByGroup(Integer id_group);
}
