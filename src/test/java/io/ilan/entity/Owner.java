package io.ilan.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "OWNER_DETAILS", schema = "OWNER_SCHEMA")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

}
