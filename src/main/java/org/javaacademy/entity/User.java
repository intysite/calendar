package org.javaacademy.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;


@Data
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @NonNull
    @Column(unique = true)
    private String email;

    @NonNull
    @Column
    private String password;

    @NonNull
    @Column
    private String name;
}
