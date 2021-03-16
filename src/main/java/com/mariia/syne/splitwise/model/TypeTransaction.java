package com.mariia.syne.splitwise.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TypeTransaction {

    @Id
    private Integer id_type_transaction;

    private String name_type_transaction;

    public TypeTransaction() {
    }

    public TypeTransaction(String name_type_transaction) {
        this.name_type_transaction = name_type_transaction;
    }

    public TypeTransaction(Integer id_type_transaction, String name_type_transaction) {
        this.id_type_transaction = id_type_transaction;
        this.name_type_transaction = name_type_transaction;
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

    @Override
    public String toString() {
        return "TypeTransaction{" +
                "id_type_transaction=" + id_type_transaction +
                ", name_type_transaction='" + name_type_transaction + '\'' +
                '}';
    }
}
