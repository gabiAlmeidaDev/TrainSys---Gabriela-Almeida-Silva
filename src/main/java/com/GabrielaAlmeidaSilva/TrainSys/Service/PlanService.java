package com.GabrielaAlmeidaSilva.TrainSys.Service;

import com.GabrielaAlmeidaSilva.TrainSys.DTO.PlanDTO;
import com.GabrielaAlmeidaSilva.TrainSys.Entities.Plan;
import com.GabrielaAlmeidaSilva.TrainSys.Repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;

    public PlanDTO createPlan(PlanDTO planDTO) {
        Plan plan = new Plan();
        plan.setName(planDTO.getName());
        plan.setMaxStudents(planDTO.getMaxStudents());
        plan.setPrice(planDTO.getPrice());

        Plan savedPlan = planRepository.save(plan);
        planDTO.setId(savedPlan.getId());
        return planDTO;
    }

    public List<PlanDTO> getAllPlans() {
        return planRepository.findAll().stream()
                .map(plan -> new PlanDTO(plan.getId(), plan.getName(), plan.getMaxStudents(), plan.getPrice()))
                .collect(Collectors.toList());
    }

    public PlanDTO updatePlan(Long id, PlanDTO planDTO) {
        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado!"));

        plan.setName(planDTO.getName());
        plan.setMaxStudents(planDTO.getMaxStudents());
        plan.setPrice(planDTO.getPrice());

        Plan updatedPlan = planRepository.save(plan);
        return new PlanDTO(updatedPlan.getId(), updatedPlan.getName(), updatedPlan.getMaxStudents(), updatedPlan.getPrice());
    }

    public void deletePlan(Long id) {
        planRepository.deleteById(id);
    }
}

