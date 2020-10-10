package com.louay.model.service;

import com.louay.model.dao.CourseDao;
import com.louay.model.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    private final CourseDao courseDao;

    @Autowired
    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Transactional
    @Override
    public List<Course> findAll() {
        return this.courseDao.findAll();
    }

    @Transactional
    @Override
    public Course save(Course course) {
        return this.courseDao.save(course);
    }

    @Transactional
    @Override
    public void delete(Integer courseId) {
        this.courseDao.deleteById(courseId);
    }
}
