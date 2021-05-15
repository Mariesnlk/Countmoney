package com.mariia.syne.splitwise.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Frequency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_frequency;

    private String value;

    @OneToMany
    @JoinColumn(name = "id_frequency")
    private List<Transactions> transactions;

    public Integer getId_frequency() {
        return id_frequency;
    }

    public void setId_frequency(Integer id_frequency) {
        this.id_frequency = id_frequency;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
