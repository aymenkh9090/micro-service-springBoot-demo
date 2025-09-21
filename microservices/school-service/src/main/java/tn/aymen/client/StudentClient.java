package tn.aymen.client;

import lombok.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.aymen.schoolresponse.Student;
import java.util.List;

@FeignClient(name = "student-service",
             url = "${application.config.students-url}")
public interface StudentClient {
   // @GetMapping("/school/{schoolId}")
   @GetMapping("/api/v1/students/school/{schoolId}")
    List<Student> findAllStudentsBySchoolId(@PathVariable("schoolId") Integer schoolId);
}
