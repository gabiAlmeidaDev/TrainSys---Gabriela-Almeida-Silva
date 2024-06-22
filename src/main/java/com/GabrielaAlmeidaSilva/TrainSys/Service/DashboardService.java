package com.GabrielaAlmeidaSilva.TrainSys.Service;

import com.GabrielaAlmeidaSilva.TrainSys.Entities.Plan;
import com.GabrielaAlmeidaSilva.TrainSys.Entities.Student;
import com.GabrielaAlmeidaSilva.TrainSys.Entities.User;
import com.GabrielaAlmeidaSilva.TrainSys.Repository.PlanRepository;
import com.GabrielaAlmeidaSilva.TrainSys.Repository.StudentRepository;
import com.GabrielaAlmeidaSilva.TrainSys.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PlanRepository planRepository;

    public Map<String, Object> getDashboardData() {
        Map<String, Object> dashboardData = new HashMap<>();

        long userCount = userRepository.count();
        long studentCount = studentRepository.count();
        long planCount = planRepository.count();

        List<User> users = userRepository.findAll();
        List<Student> students = studentRepository.findAll();
        List<Plan> plans = planRepository.findAll();

        dashboardData.put("userCount", userCount);
        dashboardData.put("studentCount", studentCount);
        dashboardData.put("planCount", planCount);
        dashboardData.put("users", users);
        dashboardData.put("students", students);
        dashboardData.put("plans", plans);

        return dashboardData;
    }
}

