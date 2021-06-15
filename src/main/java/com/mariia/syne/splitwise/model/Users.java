package com.mariia.syne.splitwise.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id_users;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @NotNull
    @Column
    private String login;

    @NotNull
    @Column
    private String password;

    @Transient
    private String passwordConfirm;

    @ManyToMany(fetch = FetchType.EAGER)
    @Column
    private Set<Role> roles;

    @ManyToOne
    @JoinColumn(name = "id_group")
    @Column
    private Groups id_group;

    @OneToMany
    @JoinColumn(name = "id_user")
    @Transient
    private List<Income> incomes;

    @OneToMany
    @JoinColumn(name = "id_user")
    @Transient
    private List<Transactions> transactions;

    @Transient
    private Double sumTransactions;


    @Transient
    private Double sumIncomes;

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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setId_users(Integer users) {
        this.id_users = users;
    }

    public Integer getId_users() {
        return id_users;
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

    @JsonIgnore
    public List<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<Income> incomes) {
        this.incomes = incomes;
    }

    @JsonIgnore
    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

}
