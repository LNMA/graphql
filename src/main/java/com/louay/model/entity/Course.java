package com.louay.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "course")
public class Course implements Serializable {
    private static final long serialVersionUID = 5568505761449000549L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", columnDefinition = "INT(10)")
    private Integer courseId;
    @Column(name = "name", columnDefinition = "VARCHAR(45)")
    private String name;
    @Column(name = "instructor_name", columnDefinition = "VARCHAR(45)")
    private String instructorName;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    @Transient
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return getCourseId().equals(course.getCourseId());
    }

    @Transient
    @Override
    public int hashCode() {
        return Objects.hash(getCourseId());
    }

    @Transient
    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", name='" + name + '\'' +
                ", instructorName='" + instructorName + '\'' +
                '}';
    }
}
