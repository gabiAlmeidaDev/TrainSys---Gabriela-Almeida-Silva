package com.GabrielaAlmeidaSilva.TrainSys.Repository;

import com.GabrielaAlmeidaSilva.TrainSys.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}


