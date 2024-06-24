package com.GabrielaAlmeidaSilva.TrainSys.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutDTO {
    private Long id;
    private Long studentId;
    private Long exerciseId;
    private int repetitions;
    private double weight;
    private int breakTime;
    private DayOfWeek day;
    private String observations;
    private int time;
}
