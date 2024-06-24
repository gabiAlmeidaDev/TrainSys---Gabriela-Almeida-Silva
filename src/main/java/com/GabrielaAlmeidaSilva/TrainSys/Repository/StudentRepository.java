package com.GabrielaAlmeidaSilva.TrainSys.Repository;

import com.GabrielaAlmeidaSilva.TrainSys.Entities.Student;
import com.GabrielaAlmeidaSilva.TrainSys.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByUser(User user);
}
