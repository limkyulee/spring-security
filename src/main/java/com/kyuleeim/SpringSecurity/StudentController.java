package com.kyuleeim.SpringSecurity;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author limkyulee
 * @version 1.0, 7/3/25
 * @see {참조}
 */
@RestController
public class StudentController {

    private List<Student> students = new ArrayList<Student>(List.of(
        new Student(1, "kyuleelim", 10),
        new Student(2, "limkyulee", 20)
    ));

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);

        return student;
    }
}
