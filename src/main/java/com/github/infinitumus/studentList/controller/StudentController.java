package com.github.infinitumus.studentList.controller;

import com.github.infinitumus.studentList.model.Student;
import com.github.infinitumus.studentList.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public String students(Model model){
        model.addAttribute("studentList", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/new")
    public String addStudent(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "new_student";
    }

    @PostMapping("")
    public String saveStudent(@ModelAttribute Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable long id){
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
