package com.GabrielaAlmeidaSilva.TrainSys.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String contact;
    private LocalDate dateOfBirth;
    private String city;
    private String neighborhood;
    private String street;
    private String number;
    private String state;
    private String cep;
    private Long userId;
}

