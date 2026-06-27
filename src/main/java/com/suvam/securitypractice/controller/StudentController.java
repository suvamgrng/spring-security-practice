package com.suvam.securitypractice.controller;

import com.suvam.securitypractice.model.Student;
import com.suvam.securitypractice.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/students")
    public List<Student> getStudent() {
        return service.getStudent();
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }
}
