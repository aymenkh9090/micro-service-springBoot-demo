package tn.aymen.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.aymen.client.StudentClient;
import tn.aymen.models.School;
import tn.aymen.repository.SchoolRepository;
import tn.aymen.schoolresponse.FullSchoolResponse;

import java.util.List;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    public SchoolService(SchoolRepository schoolRepository,  StudentClient studentClient) {
        this.schoolRepository = schoolRepository;
        this.studentClient = studentClient;
    }

        public void save(School school) {
        schoolRepository.save(school);
        }

        public List<School> findAll() {
        return schoolRepository.findAll();
        }


    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {

        var school =
                schoolRepository.findById(schoolId)
                        .orElse(School.builder()
                                .name("Not found")
                                .email("Not found")
                                .build());
        var students = studentClient.findAllStudentsBySchoolId(schoolId); //find all students from student microservice

        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();

    }
}
