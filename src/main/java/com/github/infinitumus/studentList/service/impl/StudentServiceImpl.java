package com.github.infinitumus.studentList.service.impl;

import com.github.infinitumus.studentList.model.Student;
import com.github.infinitumus.studentList.service.StudentService;
import com.github.infinitumus.studentList.util.CrudStudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    private final CrudStudentRepository studentRepository;

    public StudentServiceImpl(CrudStudentRepository studentRepository) {
        this.studentRepository = studentRepository;

        //Test filling DB
        studentRepository.save(new Student("Alex", "Finch", "alex1976@gmail.com"));
        studentRepository.save(new Student("Diana", "Prince", "diana@yandex.ru"));
        studentRepository.save(new Student("Irina", "Blind", "irbl2017_07@mail.ru"));
        studentRepository.save(new Student("Alena", "Smith", "lala@gmail.com"));
    }

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public void deleteStudentById(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id);
    }
}
