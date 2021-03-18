package com.mariia.syne.splitwise.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Transactions {

    @Id
    private Integer id_transaction;

    private Date date;

    private String destination;

    //double ?
    private double sum;

    private Date period_from;

    private Date period_to;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users id_user;

    @ManyToOne
    @JoinColumn(name = "id_type_transaction")
    private TypeTransaction id_type_transaction;

    public Transactions() {
    }

    public Transactions(Date date, String destination, double sum, Date period_from, Date period_to, Users id_user,
                        TypeTransaction id_type_transaction) {
        this.date = date;
        this.destination = destination;
        this.sum = sum;
        this.period_from = period_from;
        this.period_to = period_to;
        this.id_user = id_user;
        this.id_type_transaction = id_type_transaction;
    }

    public Transactions(Integer id_transaction, Date date, String destination, double sum, Date period_from,
                        Date period_to, Users id_user, TypeTransaction id_type_transaction) {
        this.id_transaction = id_transaction;
        this.date = date;
        this.destination = destination;
        this.sum = sum;
        this.period_from = period_from;
        this.period_to = period_to;
        this.id_user = id_user;
        this.id_type_transaction = id_type_transaction;
    }

    public Integer getId_transaction() {
        return id_transaction;
    }

    public void setId_transaction(Integer id_transaction) {
        this.id_transaction = id_transaction;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Date getPeriod_from() {
        return period_from;
    }

    public void setPeriod_from(Date period_from) {
        this.period_from = period_from;
    }

    public Date getPeriod_to() {
        return period_to;
    }

    public void setPeriod_to(Date period_to) {
        this.period_to = period_to;
    }

    public Users getId_user() {
        return id_user;
    }

    public void setId_user(Users id_user) {
        this.id_user = id_user;
    }

    public TypeTransaction getId_type_transaction() {
        return id_type_transaction;
    }

    public void setId_type_transaction(TypeTransaction id_type_transaction) {
        this.id_type_transaction = id_type_transaction;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "id_transaction=" + id_transaction +
                ", date=" + date +
                ", destination='" + destination + '\'' +
                ", sum=" + sum +
                ", period_from=" + period_from +
                ", period_to=" + period_to +
                ", id_user=" + id_user +
                ", id_type_transaction=" + id_type_transaction +
                '}';
    }
}
