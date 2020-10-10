package com.louay.model.resolver;

import com.louay.model.entity.Course;
import com.louay.model.entity.Student;
import com.louay.model.factory.ServiceFactory;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    private final ServiceFactory serviceFactory;

    @Autowired
    public Query(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    public List<Course> allCourse() {
        return this.serviceFactory.getCourseService().findAll();
    }

    public List<Student> allStudent() {
        return this.serviceFactory.getStudentService().findAll();
    }
}
