package com.github.infinitumus.studentList.util;

import com.github.infinitumus.studentList.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudStudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByLastName(String lastName);

    Student findById(long id);



}
