package com.louay.model.factory;

import com.louay.model.service.CourseService;
import com.louay.model.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class ServiceFactory {
    private final StudentService studentService;
    private final CourseService courseService;

    @Autowired
    public ServiceFactory(StudentService studentService, CourseService courseService) {
        Assert.notNull(studentService, "studentService cannot be null!");
        Assert.notNull(courseService, "courseService cannot be null!");
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public CourseService getCourseService() {
        return courseService;
    }
}
