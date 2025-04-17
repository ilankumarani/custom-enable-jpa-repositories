package com.ilan.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "BLOG_DETAILS", schema = "BLOG_SCHEMA")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
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
