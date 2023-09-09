package com.vishnu.thymeleaf_crud.controller;

import com.vishnu.thymeleaf_crud.entity.Student;
import com.vishnu.thymeleaf_crud.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/students")
public class StudentController {
    final private StudentService studentService;
    StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping(path = "")
    public String listAllStudents(Model model){
        List<Student> students=this.studentService.getAllStudents();
        model.addAttribute("students",students);
        return "students";
    }
    @PostMapping(path = "/{id}")
    public String updateStudent(@PathVariable(name = "id")Long id, @ModelAttribute(name = "student") Student student){
        this.studentService.updateStudent(student,id);
        return "redirect:/students";
    }
    @PostMapping(path = "")
    public String addStudent(@ModelAttribute("student") Student student){
        this.studentService.addStudent(student);
        return "redirect:/students";
    }
    @GetMapping(path = "/delete/{id}")
    public String deleteStudent(@PathVariable(name = "id")Long id){
        this.studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping(path = "/new")
    public String createStudentForm(Model model){
        Student student=new Student();
        model.addAttribute("student",student);
        return "createStudentForm";
    }
    @GetMapping(path = "/edit/{id}")
    public String createStudentForm(Model model,@PathVariable(name = "id")Long id){
        final Student student=this.studentService.getStudent(id);
        model.addAttribute("student",student);
        return "editStudent";
    }
}
