package com.GabrielaAlmeidaSilva.TrainSys.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(nullable = false, unique = true, length = 14)
    private String cpf;

    @Column(nullable = false, length = 20)
    private String contact;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(length = 50)
    private String city;

    @Column(length = 50)
    private String neighborhood;

    @Column(length = 30)
    private String street;

    @Column(length = 30)
    private String number;

    @Column(length = 2)
    private String state;

    @Column(length = 20)
    private String cep;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
