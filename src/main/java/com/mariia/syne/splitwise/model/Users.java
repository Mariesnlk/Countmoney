package com.mariia.syne.splitwise.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {

    @Id
    private Integer id_user;

    private String first_name;

    private String last_name;

    private String login;

    private String password;

    private String role;

    //FK
    private Integer id_group;

    public Users() {
    }

    public Users(String first_name, String last_name, String login, String password, String role, Integer id_group) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.login = login;
        this.password = password;
        this.role = role;
        this.id_group = id_group;
    }

    public Users(Integer id_user, String first_name, String last_name, String login, String password, String role, Integer id_group) {
        this.id_user = id_user;
        this.first_name = first_name;
        this.last_name = last_name;
        this.login = login;
        this.password = password;
        this.role = role;
        this.id_group = id_group;
    }


    public void setId_user(Integer user) {
        this.id_user = user;
    }

    public Integer getId_user() {
        return id_user;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getId_group() {
        return id_group;
    }

    public void setId_group(Integer id_group) {
        this.id_group = id_group;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id_user=" + id_user +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", id_group='" + id_group + '\'' +
                '}';
    }
}
