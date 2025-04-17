package com.ilan.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "BLOG_DETAILS", schema = "BLOG_SCHEMA")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "category")
    private String category;

    @Column(name = "content")
    private String content;
}
