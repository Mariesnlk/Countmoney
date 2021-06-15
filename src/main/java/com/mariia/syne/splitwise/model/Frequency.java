package com.mariia.syne.splitwise.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class Frequency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id_frequency;

    @Column
    private String value;

    @OneToMany
    @JoinColumn(name = "id_frequency")
    @Column
    private List<Transactions> transactions;

    public String getValue() {
        return value;
    }
}
