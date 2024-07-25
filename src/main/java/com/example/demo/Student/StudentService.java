package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    final private StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student saveStudent(Student student){
        this.studentRepo.save(student);
        return student;
    }

    public Optional<Student> findByName(String name) {
        return studentRepo.findByName(name);
    }

    public Optional<Student> findById(Long id) {
        return studentRepo.findById(id);
    }

    public void deleteById(Long id) {
        studentRepo.deleteById(id);
    }
}
