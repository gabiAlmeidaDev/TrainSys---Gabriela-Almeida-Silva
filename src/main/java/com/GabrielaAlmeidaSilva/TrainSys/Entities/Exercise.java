package com.GabrielaAlmeidaSilva.TrainSys.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "exercises")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}

