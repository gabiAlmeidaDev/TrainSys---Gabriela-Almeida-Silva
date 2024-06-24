package com.GabrielaAlmeidaSilva.TrainSys.Repository;

import com.GabrielaAlmeidaSilva.TrainSys.Entities.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
