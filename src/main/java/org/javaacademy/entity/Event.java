package org.javaacademy.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_name", nullable = false)
    private User user;

    @NonNull
    @Column
    private LocalDate datetime;

    @Column
    private String description;

    @NonNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;
}
