package com.GabrielaAlmeidaSilva.TrainSys.Service;

import com.GabrielaAlmeidaSilva.TrainSys.DTO.StudentDTO;
import com.GabrielaAlmeidaSilva.TrainSys.Entities.Student;
import com.GabrielaAlmeidaSilva.TrainSys.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentDTO registerStudent(StudentDTO studentDTO) {
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

        Student savedStudent = studentRepository.save(student);
        studentDTO.setId(savedStudent.getId());
        return studentDTO;
    }

    public List<StudentDTO> listAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> new StudentDTO(
                        student.getId(),
                        student.getName(),
                        student.getEmail(),
                        student.getCpf(),
                        student.getContact(),
                        student.getDateOfBirth(),
                        student.getCity(),
                        student.getNeighborhood(),
                        student.getStreet(),
                        student.getNumber(),
                        student.getState(),
                        student.getCep(),
                        student.getUser().getId()
                ))
                .collect(Collectors.toList());
    }
}

