package com.GabrielaAlmeidaSilva.TrainSys.Controller;

import com.GabrielaAlmeidaSilva.TrainSys.DTO.WorkoutDTO;
import com.GabrielaAlmeidaSilva.TrainSys.Service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @PostMapping
    public ResponseEntity<WorkoutDTO> registerWorkout(@RequestBody WorkoutDTO workoutDTO) {
        WorkoutDTO createdWorkout = workoutService.registerWorkout(workoutDTO);
        return new ResponseEntity<>(createdWorkout, HttpStatus.CREATED);
    }
    @GetMapping("/students/{id}/workouts")
    public ResponseEntity<List<WorkoutDTO>> listWorkoutsByStudent(@PathVariable Long id) {
        List<WorkoutDTO> workouts = workoutService.listWorkoutsByStudent(id);
        return ResponseEntity.ok(workouts);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkout(@PathVariable Long id) {
        workoutService.deleteWorkout(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<WorkoutDTO> updateWorkout(@PathVariable Long id, @RequestBody WorkoutDTO workoutDTO) {
        WorkoutDTO updatedWorkout = workoutService.updateWorkout(id, workoutDTO);
        return ResponseEntity.ok(updatedWorkout);
    }
    @GetMapping
    public ResponseEntity<List<WorkoutDTO>> listAllWorkouts() {
        List<WorkoutDTO> workouts = workoutService.listAllWorkouts();
        return ResponseEntity.ok(workouts);
    }
}
