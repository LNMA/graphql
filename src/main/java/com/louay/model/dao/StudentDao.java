package com.louay.model.dao;

import com.louay.model.entity.Student;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepositoryImplementation<Student, Integer> {
}
