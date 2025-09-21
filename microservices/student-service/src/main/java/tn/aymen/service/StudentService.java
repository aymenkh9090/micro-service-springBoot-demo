package tn.aymen.service;

import org.springframework.stereotype.Service;
import tn.aymen.models.Student;
import tn.aymen.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public void save(Student student) {
        studentRepository.save(student);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public List<Student> findAllBySchoolId(Integer schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }



}
