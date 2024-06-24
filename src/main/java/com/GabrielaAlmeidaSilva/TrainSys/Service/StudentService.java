package com.GabrielaAlmeidaSilva.TrainSys.Service;

import com.GabrielaAlmeidaSilva.TrainSys.DTO.StudentDTO;
import com.GabrielaAlmeidaSilva.TrainSys.Entities.Student;
import com.GabrielaAlmeidaSilva.TrainSys.Entities.User;
import com.GabrielaAlmeidaSilva.TrainSys.Repository.StudentRepository;
import com.GabrielaAlmeidaSilva.TrainSys.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

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

    public StudentDTO updateStudent(Long studentId, StudentDTO studentDTO) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado!"));

        User user = userRepository.findById(studentDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

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

        Student updatedStudent = studentRepository.save(student);
        studentDTO.setId(updatedStudent.getId());
        return studentDTO;
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}


