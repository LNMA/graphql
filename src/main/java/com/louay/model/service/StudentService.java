package com.louay.model.service;

import com.louay.model.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student save(Student student);

    void delete(Integer studentId);
}
