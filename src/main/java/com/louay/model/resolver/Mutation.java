package com.louay.model.resolver;

import com.louay.model.entity.Course;
import com.louay.model.entity.Student;
import com.louay.model.factory.ServiceFactory;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    private final ServiceFactory serviceFactory;

    @Autowired
    public Mutation(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    public Course addCourse(Course course) {
        return this.serviceFactory.getCourseService().save(course);
    }

    public Student addStudent(Student student) {
        return this.serviceFactory.getStudentService().save(student);
    }

    public Course updateCourse(Course course) {
        return this.serviceFactory.getCourseService().save(course);
    }

    public Student updateStudent(Student student) {
        return this.serviceFactory.getStudentService().save(student);
    }

    public int deleteCourse(Integer courseId) {
        this.serviceFactory.getCourseService().delete(courseId);
        return 1;
    }

    public int deleteStudent(Integer studentId) {
        this.serviceFactory.getStudentService().delete(studentId);
        return 1;
    }
}
