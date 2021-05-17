package com.mariia.syne.splitwise.model;

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
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users idUser;

    private Double sum_income;

    public Income() {
    }

    public Income(Date date, Users idUser, Double sum_income) {
        this.date = date;
        this.idUser = idUser;
        this.sum_income = sum_income;
    }

    public Income(Integer id_income, Date date, Users idUser, Double sum_income) {
        this.id_income = id_income;
        this.date = date;
        this.idUser = idUser;
        this.sum_income = sum_income;
    }

    public Income(Integer id_income, Date date,  Double sum_income) {
        this.id_income = id_income;
        this.date = date;
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
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
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
                ", date=" + date +
                ", id_user=" + idUser +
                ", sum_income=" + sum_income +
                '}';
    }
}