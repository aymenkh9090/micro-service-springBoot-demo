package tn.aymen.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.aymen.models.Student;
import tn.aymen.repository.StudentRepository;
import tn.aymen.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentRepository studentRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(
            @RequestBody Student student
    ){
            studentService.save(student);
    }
    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") Integer id) {
        studentRepository.deleteById(id);
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<Student>> findAllStudentsBySchoolId(@PathVariable("schoolId") Integer schoolId) {
        return  ResponseEntity.ok(studentService.findAllBySchoolId(schoolId));
    }










}
