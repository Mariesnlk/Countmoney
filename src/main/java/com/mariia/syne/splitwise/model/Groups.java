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
@Table(name = "user_groups")
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id_groups;

    @Column
    private String name_group;

    @OneToMany
    @JoinColumn(name = "id_group")
    @Column
    private List<Users> users;

    public Integer getId_groups() {
        return id_groups;
    }
}
