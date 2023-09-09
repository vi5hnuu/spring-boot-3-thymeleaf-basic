package com.vishnu.thymeleaf_crud.service;

import com.vishnu.thymeleaf_crud.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student addStudent(Student student);
    Student getStudent(Long id);
    Student updateStudent(Student student,Long id);

    Student deleteStudent(Long id);
}
