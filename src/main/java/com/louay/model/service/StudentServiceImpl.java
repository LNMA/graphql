package com.louay.model.service;

import com.louay.model.dao.StudentDao;
import com.louay.model.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Transactional
    @Override
    public List<Student> findAll() {
        return this.studentDao.findAll();
    }

    @Transactional
    @Override
    public Student save(Student student) {
        return this.studentDao.save(student);
    }

    @Transactional
    @Override
    public void delete(Integer studentId) {
        this.studentDao.deleteById(studentId);
    }
}
