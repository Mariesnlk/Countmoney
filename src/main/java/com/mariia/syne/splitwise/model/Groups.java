package com.mariia.syne.splitwise.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Groups {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_group;

    private String name_group;

    @OneToMany
    @JoinColumn(name = "id_group")
    private List<Users> users;

    public Groups() {
    }

    public Groups(String name_group) {
        this.name_group = name_group;
    }

    public Groups(Integer id_group, String name_group) {
        this.id_group = id_group;
        this.name_group = name_group;
    }

    public Integer getId_group() {
        return id_group;
    }

    public void setId_group(Integer id_group) {
        this.id_group = id_group;
    }

    public String getName_group() {
        return name_group;
    }

    public void setName_group(String name_group) {
        this.name_group = name_group;
    }

    @Override
    public String toString() {
        return "Groups{" +
                "id_group=" + id_group +
                ", name_group='" + name_group + '\'' +
                '}';
    }
}
