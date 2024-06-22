package com.GabrielaAlmeidaSilva.TrainSys.Service;

import com.GabrielaAlmeidaSilva.TrainSys.DTO.ExerciseDTO;
import com.GabrielaAlmeidaSilva.TrainSys.Entities.Exercise;
import com.GabrielaAlmeidaSilva.TrainSys.Entities.User;
import com.GabrielaAlmeidaSilva.TrainSys.Repository.ExerciseRepository;
import com.GabrielaAlmeidaSilva.TrainSys.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private UserRepository userRepository;

    public ExerciseDTO registerExercise(ExerciseDTO exerciseDTO) {
        User user = userRepository.findById(exerciseDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        Exercise exercise = new Exercise();
        exercise.setDescription(exerciseDTO.getDescription());
        exercise.setUser(user);

        Exercise savedExercise = exerciseRepository.save(exercise);
        exerciseDTO.setId(savedExercise.getId());
        return exerciseDTO;
    }
    public List<ExerciseDTO> listAllExercises() {
        List<Exercise> exercises = exerciseRepository.findAll();
        return exercises.stream()
                .map(exercise -> new ExerciseDTO(exercise.getId(), exercise.getDescription(), exercise.getUser().getId()))
                .collect(Collectors.toList());
    }
    public void deleteExercise(Long id) {
        if (!exerciseRepository.existsById(id)) {
            throw new RuntimeException("Exercício não encontrado!");
        }
        exerciseRepository.deleteById(id);
    }
}

