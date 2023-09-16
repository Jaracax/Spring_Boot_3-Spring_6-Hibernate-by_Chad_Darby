package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // Define @PostConstruct to load the student data only once

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Jose","Dominguez"));
        theStudents.add(new Student("Daniel","Chirinos"));
        theStudents.add(new Student("Brandon","Chacon"));
    }


    // define endpoint for "/students" - return a lost of students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }


    // Define endpoint for "/students/{studentsId}"  - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){

        // Index into the list

        // Check the studentId against the list size

        if (studentId >= theStudents.size() || studentId < 0){
            throw new StudentNotFoundException("Student id not found: " + studentId);
        }

        return theStudents.get(studentId);
    }


}
