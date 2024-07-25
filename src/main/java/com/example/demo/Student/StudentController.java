package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/student")
public class StudentController {
private final StudentRepo studentRepo;
private final StudentService studentService;

@Autowired
    public StudentController(StudentRepo studentRepo, StudentService studentService) {
        this.studentRepo = studentRepo;
        this.studentService = studentService;
}

    @GetMapping(path = "/name/{name}")
    public ResponseEntity<Student> getByName(@PathVariable String name){
        Optional<Student> studentData = studentService.findByName(name);
        if(studentData.isPresent()){
            return new ResponseEntity<>(studentData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Optional<Student> studentData = studentService.findById(id);
        if(studentData.isPresent()){
            return new ResponseEntity<>(studentData.get(), HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentRepo.findAll();
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return student;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id){
        studentService.deleteById(id);
        return new ResponseEntity<>("Delete Book with Id "+id, HttpStatus.OK);
    }
}
