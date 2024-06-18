package com.GabrielaAlmeidaSilva.TrainSys.Repository;


import com.GabrielaAlmeidaSilva.TrainSys.Entities.Exercise;
import com.GabrielaAlmeidaSilva.TrainSys.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findByUser(User user);
}

