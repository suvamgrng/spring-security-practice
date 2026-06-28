package com.suvam.securitypractice.controller;

import com.suvam.securitypractice.model.Student;
import com.suvam.securitypractice.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
    @GetMapping("/students")
    public List<Student> getStudent() {
        return service.getStudent();
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }
}
