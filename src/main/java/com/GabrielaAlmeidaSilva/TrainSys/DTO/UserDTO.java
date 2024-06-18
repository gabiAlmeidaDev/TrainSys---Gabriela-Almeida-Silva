package com.GabrielaAlmeidaSilva.TrainSys.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String name;
    private String email;
    private String password;
    private String cpf;
    private LocalDate dateOfBirth;
    private Long planId;
}

