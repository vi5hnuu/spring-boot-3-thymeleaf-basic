package com.vishnu.thymeleaf_crud.service.impl;

import com.vishnu.thymeleaf_crud.entity.Student;
import com.vishnu.thymeleaf_crud.respository.StudentRepository;
import com.vishnu.thymeleaf_crud.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    final private StudentRepository studentRepository;

    StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    @Override
    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public Student getStudent(Long id) {
        return this.studentRepository.findById(id).orElseThrow(()->new RuntimeException("No Student found"));
    }

    @Override
    public Student updateStudent(Student student,Long id) {
//        final Student exstudent=this.studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student not found"));
//        exstudent.setFirstName(student.getFirstName());
//        exstudent.setLastName(student.getLastName());
//        exstudent.setEmail(student.getEmail());
//        return this.studentRepository.save(exstudent);

        return this.studentRepository.save(student);
    }

    @Override
    public Student deleteStudent(Long id) {
        final Student exStudent=this.studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student not found"));
        this.studentRepository.deleteById(id);
        return exStudent;
    }
}
