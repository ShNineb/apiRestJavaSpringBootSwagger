package com.pxp.SQLite.demo.service;

import com.pxp.SQLite.demo.entity.Student;
import com.pxp.SQLite.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public String createStudent(Student student){
        try {
        	System.out.println("Dans Service");
        	System.out.println(student);
        	
        	
            if (!studentRepository.existsByEmail(student.getEmail())){
                student.setId(null == studentRepository.findMaxId()? 0 : studentRepository.findMaxId() + 1);
                studentRepository.save(student);
                return "Student record created successfully.";
            }else {
                return "Student already exists in the database.";
            }
        }catch (Exception e){
            throw e;
        }
    }

    
    public List<Student> readStudents(){
      	System.out.println("Dans Service");
    	System.out.println(studentRepository.findAll());
         return studentRepository.findAll();          
    }

    @Transactional
    public String updateStudent(Student student){
        if (studentRepository.existsByEmail(student.getEmail())){
        	System.out.println("Update");
        	System.out.println(student);
            try {
                List<Student> students = studentRepository.findByEmail(student.getEmail());
                students.stream().forEach(s -> {
                    Student studentToBeUpdate = studentRepository.findById(s.getId()).get();
                    studentToBeUpdate.setName(student.getName());
                    studentToBeUpdate.setEmail(student.getEmail());
                    studentToBeUpdate.setAge(student.getAge());
                    studentToBeUpdate.setCity(student.getCity());
                    studentToBeUpdate.setStudentNumber(student.getStudentNumber());
                    
                    
                    studentRepository.save(studentToBeUpdate);
                });
                System.out.println("UpdateOKKK");
                return "Student record updated.";
            }catch (Exception e){
                throw e;
            }
        }else {
        	System.out.println("UpdateELSE");
            return "Student does not exists in the database.";
        }
    }

    @Transactional
    public String deleteStudent(Student student){
        if (studentRepository.existsByEmail(student.getEmail())){
            try {
                List<Student> students = studentRepository.findByEmail(student.getEmail());
                students.stream().forEach(s -> {
                    studentRepository.delete(s);
                });
                return "Student record deleted successfully.";
            }catch (Exception e){
                throw e;
            }

        }else {
            return "Student does not exist";
        }
    }
}
