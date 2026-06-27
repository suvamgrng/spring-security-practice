package com.suvam.securitypractice.service;

import com.suvam.securitypractice.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    public List<Student> students = new ArrayList<>(List.of(
            new Student(
                    1,
                    "Suvam",
                    50),
            new Student(2,
                    "Amisha",
                    80),
            new Student(3,
                    "Samir",
                    90)
    ));

    public List<Student> getStudent() {
        return students;
    }

    public Student addStudent(Student student) {
         students.add(student);
         return student;
    }
}
