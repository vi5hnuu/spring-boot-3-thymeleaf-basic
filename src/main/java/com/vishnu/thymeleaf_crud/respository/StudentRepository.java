package com.vishnu.thymeleaf_crud.respository;

import com.vishnu.thymeleaf_crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> { }
