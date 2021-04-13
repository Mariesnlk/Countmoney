package com.mariia.syne.splitwise.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class TypeTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_type_transaction;

    private String name_type_transaction;

    @OneToMany
    @JoinColumn(name = "id_type_transaction")
    private List<Transactions> transactions;

    public TypeTransaction() {
    }

    public TypeTransaction(String name_type_transaction) {
        this.name_type_transaction = name_type_transaction;
    }

    public TypeTransaction(Integer id_type_transaction, String name_type_transaction) {
        this.id_type_transaction = id_type_transaction;
        this.name_type_transaction = name_type_transaction;
    }

    public TypeTransaction(Integer id_type_transaction, String name_type_transaction, List<Transactions> transactions) {
        this.id_type_transaction = id_type_transaction;
        this.name_type_transaction = name_type_transaction;
        this.transactions = transactions;
    }

    public Integer getId_type_transaction() {
        return id_type_transaction;
    }

    public void setId_type_transaction(Integer id_type_transaction) {
        this.id_type_transaction = id_type_transaction;
    }

    public String getName_type_transaction() {
        return name_type_transaction;
    }

    public void setName_type_transaction(String name_type_transaction) {
        this.name_type_transaction = name_type_transaction;
    }

    @JsonIgnore
    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "TypeTransaction{" +
                "id_type_transaction=" + id_type_transaction +
                ", name_type_transaction='" + name_type_transaction + '\'' +
                '}';
    }
}
