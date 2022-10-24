package com.github.infinitumus.studentList.util;

import com.github.infinitumus.studentList.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Component
public class StudentRepository {
    private static List<Student> studentList;
    private static long id = 0;

    public StudentRepository() {
        if (studentList == null) {
            studentList = new ArrayList<>();
            studentList.add(new Student(++id, "Alex", "Finch", "alex1976@gmail.com"));
            studentList.add(new Student(++id, "Diana", "Prince", "diana@yandex.ru"));
            studentList.add(new Student(++id, "Irina", "Blind", "irbl2017_07@mail.ru"));
        }
    }

    public List<Student> getAllStudents() {
        return studentList;
    }

    public Optional<Student> findById(long id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    public Boolean deleteById(long id) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public void save(Student student) {
        student.setId(++id);
        studentList.add(student);
    }
}
