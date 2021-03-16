package com.mariia.syne.splitwise.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Income {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_income;

    private Date period_from_income;

    private Date period_to_income;

    //FK
    private Integer id_user;

    public Income() {
    }

    public Income(Date period_from_income, Date period_to_income, Integer id_user) {
        this.period_from_income = period_from_income;
        this.period_to_income = period_to_income;
        this.id_user = id_user;
    }

    public Income(Integer id_income, Date period_from_income, Date period_to_income, Integer id_user) {
        this.id_income = id_income;
        this.period_from_income = period_from_income;
        this.period_to_income = period_to_income;
        this.id_user = id_user;
    }

    public Integer getId_income() {
        return id_income;
    }

    public void setId_income(Integer id_income) {
        this.id_income = id_income;
    }

    public Date getPeriod_from_income() {
        return period_from_income;
    }

    public void setPeriod_from_income(Date period_from_income) {
        this.period_from_income = period_from_income;
    }

    public Date getPeriod_to_income() {
        return period_to_income;
    }

    public void setPeriod_to_income(Date period_to_income) {
        this.period_to_income = period_to_income;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Income{" +
                "id_income=" + id_income +
                ", period_from_income=" + period_from_income +
                ", period_to_income=" + period_to_income +
                ", id_user=" + id_user +
                '}';
    }
}
