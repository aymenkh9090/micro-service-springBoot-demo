package tn.aymen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.aymen.models.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllBySchoolId(Integer schoolId);
}
