package com.GabrielaAlmeidaSilva.TrainSys.Service;

import com.GabrielaAlmeidaSilva.TrainSys.DTO.LoginRequest;
import com.GabrielaAlmeidaSilva.TrainSys.Entities.User;
import com.GabrielaAlmeidaSilva.TrainSys.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticate(LoginRequest loginRequest) {
        Optional<User> optionalUser = userRepository.findByEmail(loginRequest.getEmail());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                return "Autenticado com sucesso";
            }
        }

        throw new RuntimeException("Email ou senha inválidos");
    }
}

