package com.louay.model.service;

import com.louay.model.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();

    Course save(Course course);

    void delete(Integer courseId);
}
