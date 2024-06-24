package com.GabrielaAlmeidaSilva.TrainSys.Service;

import com.GabrielaAlmeidaSilva.TrainSys.DTO.WorkoutDTO;
import com.GabrielaAlmeidaSilva.TrainSys.Entities.Exercise;
import com.GabrielaAlmeidaSilva.TrainSys.Entities.Student;
import com.GabrielaAlmeidaSilva.TrainSys.Entities.Workout;
import com.GabrielaAlmeidaSilva.TrainSys.Repository.ExerciseRepository;
import com.GabrielaAlmeidaSilva.TrainSys.Repository.StudentRepository;
import com.GabrielaAlmeidaSilva.TrainSys.Repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    public WorkoutDTO registerWorkout(WorkoutDTO workoutDTO) {
        Student student = studentRepository.findById(workoutDTO.getStudentId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado!"));

        Exercise exercise = exerciseRepository.findById(workoutDTO.getExerciseId())
                .orElseThrow(() -> new RuntimeException("Exercício não encontrado!"));

        Workout workout = new Workout();
        workout.setStudent(student);
        workout.setExercise(exercise);
        workout.setRepetitions(workoutDTO.getRepetitions());
        workout.setWeight(workoutDTO.getWeight());
        workout.setBreakTime(workoutDTO.getBreakTime());
        workout.setDay(workoutDTO.getDay());
        workout.setObservations(workoutDTO.getObservations());
        workout.setTime(workoutDTO.getTime());

        Workout savedWorkout = workoutRepository.save(workout);
        workoutDTO.setId(savedWorkout.getId());
        return workoutDTO;
    }
    public List<WorkoutDTO> listWorkoutsByStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado!"));

        List<Workout> workouts = workoutRepository.findByStudent(student);
        return workouts.stream()
                .map(workout -> new WorkoutDTO(
                        workout.getId(),
                        workout.getStudent().getId(),
                        workout.getExercise().getId(),
                        workout.getRepetitions(),
                        workout.getWeight(),
                        workout.getBreakTime(),
                        workout.getDay(),
                        workout.getObservations(),
                        workout.getTime()
                ))
                .collect(Collectors.toList());
    }
    public void deleteWorkout(Long workoutId) {
        workoutRepository.deleteById(workoutId);
    }
}

