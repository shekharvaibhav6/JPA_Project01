package com.example.JPA_Project01.service;

import com.example.JPA_Project01.entity.Student;
import com.example.JPA_Project01.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getAllStudentData() {
        return studentRepo.findAll();
    }

    public Student getStudentById(Integer id) {
        return studentRepo.findById(id).orElse(null);
    }

    public Student updateStudent(Integer id, Student student) {
        return studentRepo.findById(id).map(dbStudentObject -> {
            dbStudentObject.setAge(student.getAge());
            dbStudentObject.setEmail(student.getEmail());
            dbStudentObject.setName(student.getName());
            return studentRepo.save(dbStudentObject);
        }).orElse(null);
    }

    public String deleteStudentByName(String name) {
        List<Student> students = studentRepo.findAll(); // Retrieve all students
        for (Student student : students) {
            if (student.getName().equals(name)) { // Check for name match
                studentRepo.delete(student);
                return "Student deleted successfully";
            }
        }
        return "Student not found";
    }
    public Student updatePartialStudent(Integer id, Student student) {
        Optional<Student> studentById = studentRepo.findById(id);

        if (studentById.isPresent()) {
            Student dbStudentObject = studentById.get();

            // Update only non-null fields
            if (student.getName() != null) {
                dbStudentObject.setName(student.getName());
            }
            if (student.getEmail() != null) {
                dbStudentObject.setEmail(student.getEmail());
            }


            return studentRepo.save(dbStudentObject);
        } else {
            return null; // Student not found
        }
    }
}
