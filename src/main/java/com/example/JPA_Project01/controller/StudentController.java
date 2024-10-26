package com.example.JPA_Project01.controller;

import com.example.JPA_Project01.entity.Student;
import com.example.JPA_Project01.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/std")
public class StudentController {

    @Autowired
    private StudentService service;


    @PostMapping("/save")
    public Student createStudent(@RequestBody Student student)
    {
        return service.saveStudent(student);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents()
    {
        List<Student> allStudentData = service.getAllStudentData();
        return allStudentData;
    }

    @GetMapping
    public Student getStudentById(@RequestParam Integer id,@RequestParam String name)
    {
        return service.getStudentById(id);
    }


    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id,@RequestBody Student student)
    {
        Student updatedStudent = service.updateStudent(id, student);
        return updatedStudent;
    }

    @DeleteMapping("/name/{name}")
    public ResponseEntity<String> deleteStudentByName(@PathVariable String name) {
        String result = service.deleteStudentByName(name);  // Use 'service' instance here
        return ResponseEntity.ok(result);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Student> updatePartialStudent(@PathVariable Integer id, @RequestBody Student student) {
        Student updatedStudent = service.updatePartialStudent(id, student);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}