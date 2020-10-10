package com.louay.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "student", indexes = @Index(name = "course-course_id-IX", columnList = "course_id"))
public class Student implements Serializable {
    private static final long serialVersionUID = -6291145623319537057L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", columnDefinition = "INT(10)")
    private Integer studentId;
    @Column(name = "forename", columnDefinition = "VARCHAR(45)")
    private String forename;
    @Column(name = "surname", columnDefinition = "VARCHAR(45)")
    private String surname;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", columnDefinition = "INT(10)", foreignKey =
    @ForeignKey(name = "course_id-student_course_id-fk", foreignKeyDefinition = "FOREIGN KEY (course_id) REFERENCES " +
            "course (course_id) ON DELETE CASCADE ON UPDATE CASCADE"))
    private Course course;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Transient
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getStudentId().equals(student.getStudentId());
    }

    @Transient
    @Override
    public int hashCode() {
        return Objects.hash(getStudentId());
    }

    @Transient
    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course.getCourseId() +
                '}';
    }
}
