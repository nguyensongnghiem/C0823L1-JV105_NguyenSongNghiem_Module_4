package com.codegym.demo_spring_mvc.controller;


import com.codegym.demo_spring_mvc.model.Student;
import com.codegym.demo_spring_mvc.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;

//    @RequestMapping(value = "/student", method = RequestMethod.GET)
    @GetMapping("/student")
    public String showList(Model model){
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList",studentList);
        return "list";
    }
    @GetMapping("/student/create")
    public String showFormCreate(){
        return "create";
    }
    @PostMapping("/student/create")
    public String save(@RequestParam int id, @RequestParam String name){
        Student student = new Student(id,name);
        // goi service lưu
        return "create";
    }
}
