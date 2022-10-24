package com.github.infinitumus.studentList.service.impl;

import com.github.infinitumus.studentList.model.Student;
import com.github.infinitumus.studentList.service.StudentService;
import com.github.infinitumus.studentList.util.StudentRepository;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    public Student saveStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public Boolean deleteStudentById(long id) {
        return studentRepository.deleteById(id);
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id).get();
    }
}
