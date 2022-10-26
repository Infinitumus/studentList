package com.github.infinitumus.studentList.service;

import com.github.infinitumus.studentList.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    void deleteStudentById(long id);

    Student getStudentById(long id);
}
