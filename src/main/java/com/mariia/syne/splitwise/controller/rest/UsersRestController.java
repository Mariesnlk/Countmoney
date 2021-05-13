package com.mariia.syne.splitwise.controller.rest;

import com.mariia.syne.splitwise.entity.Groups;
import com.mariia.syne.splitwise.entity.Users;
import com.mariia.syne.splitwise.service.TransactionsService;
import com.mariia.syne.splitwise.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsersRestController {
    /*
    GET     /users
    GET     /users/1
    POST    /users
    PUT     /users/1
    DELETE  /users/1
    */

    @Autowired
    private UsersService usersService;

    @Autowired
    private TransactionsService transactionsService;


    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping
    public List<Users> getAllUsers() {

        return usersService.getAllUsers();
    }

    @GetMapping("/list_users")
    public List<Users> getListUsersByGroup() {
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Groups group = user.getId_group();


        return usersService.getListUsersByGroup(group.getId_groups());
    }

    @GetMapping("/{id}")
    public Users getUser(@PathVariable Integer id) {

        return usersService.getUser(id);
    }

    @PostMapping
    public Integer addUser(@RequestBody Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return usersService.addUser(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody Users user, @PathVariable Integer id) {
        Users currentUser = (Users) SecurityContextHolder.getContext().
                getAuthentication().getPrincipal();
        if (user.getPassword().equals("")) {
            user.setPassword(currentUser.getPassword());
        } else {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        user.setRole(currentUser.getRole());

        usersService.updateUser(user, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {

        usersService.deleteUser(id);
    }
}
