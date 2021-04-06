package com.mariia.syne.splitwise.controller.rest;

import com.mariia.syne.splitwise.entity.Users;
import com.mariia.syne.splitwise.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
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
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping
    public List<Users> getAllUsers() {

        return usersService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Users getUser(@PathVariable Integer id) {

        return usersService.getUser(id);
    }

    @PostMapping
    public void addUser(@RequestBody Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        usersService.addUser(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody Users user, @PathVariable Integer id) {
        System.out.println("Work " + id);
        usersService.updateUser(user, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {

        usersService.deleteUser(id);
    }
}
