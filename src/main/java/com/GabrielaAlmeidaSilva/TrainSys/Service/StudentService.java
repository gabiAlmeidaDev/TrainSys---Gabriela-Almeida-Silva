package com.GabrielaAlmeidaSilva.TrainSys.Service;

import com.GabrielaAlmeidaSilva.TrainSys.DTO.StudentDTO;
import com.GabrielaAlmeidaSilva.TrainSys.Entities.Student;
import com.GabrielaAlmeidaSilva.TrainSys.Entities.User;
import com.GabrielaAlmeidaSilva.TrainSys.Repository.StudentRepository;
import com.GabrielaAlmeidaSilva.TrainSys.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    public StudentDTO registerStudent(StudentDTO studentDTO) {
        User user = userRepository.findById(studentDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setCpf(studentDTO.getCpf());
        student.setContact(studentDTO.getContact());
        student.setDateOfBirth(studentDTO.getDateOfBirth());
        student.setCity(studentDTO.getCity());
        student.setNeighborhood(studentDTO.getNeighborhood());
        student.setStreet(studentDTO.getStreet());
        student.setNumber(studentDTO.getNumber());
        student.setState(studentDTO.getState());
        student.setCep(studentDTO.getCep());
        student.setUser(user);

        Student savedStudent = studentRepository.save(student);
        studentDTO.setId(savedStudent.getId());
        return studentDTO;
    }
}
