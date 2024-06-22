package com.GabrielaAlmeidaSilva.TrainSys.Controller;

import com.GabrielaAlmeidaSilva.TrainSys.DTO.ExerciseDTO;
import com.GabrielaAlmeidaSilva.TrainSys.Service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @PostMapping
    public ResponseEntity<ExerciseDTO> registerExercise(@RequestBody ExerciseDTO exerciseDTO) {
        ExerciseDTO createdExercise = exerciseService.registerExercise(exerciseDTO);
        return new ResponseEntity<>(createdExercise, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ExerciseDTO>> listAllExercises() {
        List<ExerciseDTO> exercises = exerciseService.listAllExercises();
        return ResponseEntity.ok(exercises);
    }
}

