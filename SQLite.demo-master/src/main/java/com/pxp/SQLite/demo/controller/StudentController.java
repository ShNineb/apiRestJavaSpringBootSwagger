package com.pxp.SQLite.demo.controller;

import com.pxp.SQLite.demo.entity.Student;
import com.pxp.SQLite.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService; 
    /*
    @RequestMapping("/swagger")  
    public String greeting() {
    	return "redirect:/swagger-ui.html"; 
    }

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info(){
        return "The application is up...";
    }*/

//    @RequestMapping(value="/student/createstudent", method = RequestMethod.POST)
    @PostMapping(value="/createstudent")//, method = RequestMethod.POST)
    public String createStudent(@RequestBody Student student){
    	System.out.println("Dans controller");
    	System.out.println(student);
        return studentService.createStudent(student);
    }

    @RequestMapping(value = "/student/readstudents", method = RequestMethod.GET)
    public List<Student> readStudents(){
        return studentService.readStudents();
    }

    @RequestMapping(value = "/student/updatestudent", method = RequestMethod.PUT)
    public String updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @RequestMapping(value = "/student/deletestudent", method = RequestMethod.DELETE)
    public String deleteStudent(@RequestBody Student student){
        return studentService.deleteStudent(student);
    }
}
