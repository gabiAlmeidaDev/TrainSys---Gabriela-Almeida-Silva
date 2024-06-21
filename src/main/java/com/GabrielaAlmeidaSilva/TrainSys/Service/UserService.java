package com.GabrielaAlmeidaSilva.TrainSys.Service;

import com.GabrielaAlmeidaSilva.TrainSys.DTO.UserDTO;
import com.GabrielaAlmeidaSilva.TrainSys.Entities.Plan;
import com.GabrielaAlmeidaSilva.TrainSys.Entities.User;
import com.GabrielaAlmeidaSilva.TrainSys.Repository.PlanRepository;
import com.GabrielaAlmeidaSilva.TrainSys.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserDTO registerUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setCpf(userDTO.getCpf());
        user.setDateOfBirth(userDTO.getDateOfBirth());

        Plan plan = planRepository.findById(userDTO.getPlanId())
                .orElseThrow(() -> new RuntimeException("Plan not found"));
        user.setPlan(plan);

        userRepository.save(user);
        userDTO.setPassword(null);
        return userDTO;
    }
}
