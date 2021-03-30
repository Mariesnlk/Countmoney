package com.mariia.syne.splitwise.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_users;

    private String first_name;

    private String last_name;

    @Size(min=2, message = "Not less then 5 symbols")
    private String login;

    @Size(min=2, message = "Not less then 5 symbols")
    private String password;

    @Transient
    private String passwordConfirm;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

//    private String role;

    @ManyToOne
    @JoinColumn(name = "id_group")
    private Groups id_group;

    @OneToMany
    @JoinColumn(name = "id_user")
    private List<Income> incomes;

    @OneToMany
    @JoinColumn(name = "id_user")
    private List<Transactions> transactions;

    public Users() {
    }

    public Users(String first_name, String last_name, String login, String password, Set<Role> roles, Groups id_group) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.login = login;
        this.password = password;
        this.roles = roles;
        this.id_group = id_group;
    }

    public Users(Integer id_users, String first_name, String last_name, String login, String password, Set<Role> roles,
                 Groups id_group) {
        this.id_users = id_users;
        this.first_name = first_name;
        this.last_name = last_name;
        this.login = login;
        this.password = password;
        this.roles = roles;
        this.id_group = id_group;
    }

    public Users(Integer id_users, String first_name, String last_name, String login, String password, Set<Role> roles,
                 Groups id_group, List<Income> incomes, List<Transactions> transactions) {
        this.id_users = id_users;
        this.first_name = first_name;
        this.last_name = last_name;
        this.login = login;
        this.password = password;
        this.roles = roles;
        this.id_group = id_group;
        this.incomes = incomes;
        this.transactions = transactions;
    }


    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setId_users(Integer users) {
        this.id_users = users;
    }

    public Integer getId_users() {
        return id_users;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role>  getRole() {
        return roles;
    }

    public void setRole(Set<Role> roles ) {
        this.roles = roles;
    }

    public Groups getId_group() {
        return id_group;
    }

    public void setId_group(Groups id_group) {
        this.id_group = id_group;
    }

    public List<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<Income> incomes) {
        this.incomes = incomes;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id_user=" + id_users +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + roles + '\'' +
                ", id_group='" + id_group + '\'' +
                '}';
    }
}
