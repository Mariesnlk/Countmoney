package com.mariia.syne.splitwise.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_income;

    @Temporal(TemporalType.DATE)
    private Date period_from_income;

    @Temporal(TemporalType.DATE)
    private Date period_to_income;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users id_user;

    private Double sum_income;

    public Income() {
    }

    public Income(Date period_from_income, Date period_to_income, Users id_user, Double sum_income) {
        this.period_from_income = period_from_income;
        this.period_to_income = period_to_income;
        this.id_user = id_user;
        this.sum_income = sum_income;
    }

    public Income(Integer id_income, Date period_from_income, Date period_to_income, Users id_user, Double sum_income) {
        this.id_income = id_income;
        this.period_from_income = period_from_income;
        this.period_to_income = period_to_income;
        this.id_user = id_user;
        this.sum_income = sum_income;
    }

    public Income(Integer id_income, Date period_from_income, Date period_to_income, Double sum_income) {
        this.id_income = id_income;
        this.period_from_income = period_from_income;
        this.period_to_income = period_to_income;
        this.sum_income = sum_income;
    }

    public Integer getId_income() {
        return id_income;
    }

    public void setId_income(Integer id_income) {
        this.id_income = id_income;
    }

    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    public Date getPeriod_from_income() {
        return period_from_income;
    }

    public void setPeriod_from_income(Date period_from_income) {
        this.period_from_income = period_from_income;
    }

    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    public Date getPeriod_to_income() {
        return period_to_income;
    }

    public void setPeriod_to_income(Date period_to_income) {
        this.period_to_income = period_to_income;
    }

    public Users getId_user() {
        return id_user;
    }

    public void setId_user(Users id_user) {
        this.id_user = id_user;
    }

    public Double getSum_income() {
        return sum_income;
    }

    public void setSum_income(Double sum_income) {
        this.sum_income = sum_income;
    }

    @Override
    public String toString() {
        return "Income{" +
                "id_income=" + id_income +
                ", period_from_income=" + period_from_income +
                ", period_to_income=" + period_to_income +
                ", id_user=" + id_user +
                ", sum_income=" + sum_income +
                '}';
    }
}