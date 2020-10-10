package com.louay.model.dao;

import com.louay.model.entity.Course;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao extends JpaRepositoryImplementation<Course, Integer> {
}
