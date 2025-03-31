package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.Map;
import java.util.Objects;
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
    public ResponseEntity<Object> getStudentById(@PathVariable Long id){
        Optional<Student> studentData = studentService.findById(id);
        if(studentData.isPresent()){
            return new ResponseEntity<>(studentData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(Map.of("error","Resource not found"), HttpStatus.NOT_FOUND);
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

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        String errorMessage = String.format("Invalid value for parameter '%s': %s", ex.getName(), ex.getValue());
        System.err.println("Type mismatch error: " + ex.getMessage()); // Logging
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

}
