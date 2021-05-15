package com.mariia.syne.splitwise.controller.rest;

import com.mariia.syne.splitwise.model.Groups;
import com.mariia.syne.splitwise.model.Role;
import com.mariia.syne.splitwise.model.Users;
import com.mariia.syne.splitwise.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Autowired
    protected AuthenticationManager authenticationManager;

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

    @PostMapping("/add")
    public Integer addUser(@RequestBody Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Integer id = usersService.addUser(user);
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1, "ROLE_USER"));
        user.setRole(roles);
        user.setId_users(id);//здесь имя поля может быть неправильным
        authenticateUserAndSetSession(user);
        return id;
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

    private void authenticateUserAndSetSession(Users user) {
        String login = user.getLogin();
        String password = user.getPassword();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login, password);
        //request.getSession();

        //token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);

    }
}