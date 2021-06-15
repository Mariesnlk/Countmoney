package com.mariia.syne.splitwise.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id_transaction;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column
    private String destination;

    @Column
    private double sum;

    @Temporal(TemporalType.DATE)
    private Date period_from;

    @Temporal(TemporalType.DATE)
    private Date period_to;

    @ManyToOne
    @JoinColumn(name = "id_user")
    @Column
    private Users idUser;

    @ManyToOne
    @JoinColumn(name = "id_type_transaction")
    @Column
    private TypeTransaction id_type_transaction;

    @ManyToOne
    @JoinColumn(name = "id_frequency")
    @Column
    private Frequency id_frequency;

    public Frequency getId_frequency() {
        return id_frequency;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
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

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    public Date getPeriod_from() {
        return period_from;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    public Date getPeriod_to() {
        return period_to;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users id_user) {
        this.idUser = id_user;
    }

    public TypeTransaction getId_type_transaction() {
        return id_type_transaction;
    }

}
