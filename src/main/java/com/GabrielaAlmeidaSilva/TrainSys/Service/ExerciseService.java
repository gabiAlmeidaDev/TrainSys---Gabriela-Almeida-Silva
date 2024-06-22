package com.GabrielaAlmeidaSilva.TrainSys.Service;

import com.GabrielaAlmeidaSilva.TrainSys.DTO.ExerciseDTO;
import com.GabrielaAlmeidaSilva.TrainSys.Entities.Exercise;
import com.GabrielaAlmeidaSilva.TrainSys.Entities.User;
import com.GabrielaAlmeidaSilva.TrainSys.Repository.ExerciseRepository;
import com.GabrielaAlmeidaSilva.TrainSys.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private UserRepository userRepository;

    public ExerciseDTO registerExercise(ExerciseDTO exerciseDTO) {
        User user = userRepository.findById(exerciseDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Exercise exercise = new Exercise();
        exercise.setDescription(exerciseDTO.getDescription());
        exercise.setUser(user);

        Exercise savedExercise = exerciseRepository.save(exercise);
        exerciseDTO.setId(savedExercise.getId());
        return exerciseDTO;
    }
}

