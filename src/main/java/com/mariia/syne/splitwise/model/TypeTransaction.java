package com.mariia.syne.splitwise.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class TypeTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id_type_transaction;

    @Column
    private String name_type_transaction;

    @OneToMany
    @JoinColumn(name = "id_type_transaction")
    @Column
    private List<Transactions> transactions;


    public Integer getId_type_transaction() {
        return id_type_transaction;
    }

    @JsonIgnore
    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

}
