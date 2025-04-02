package com.example.demo.Student.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.example.demo.Student.Entity.Course;
import com.example.demo.Student.Entity.Student;
import com.example.demo.Student.Repository.CourseRepo;
import com.example.demo.Student.Repository.StudentRepo;
import com.example.demo.Student.DTO.StudentDTO;

@Service
public class StudentService {
    @Autowired
    final private StudentRepo studentRepo;
    final private CourseRepo courseRepo;

    public StudentService(StudentRepo studentRepo, CourseRepo courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    public StudentDTO saveStudent(StudentDTO student){
        Course course = courseRepo.findById(student.getCourse_id()).orElseThrow(() -> new RuntimeException("Course not found"));
//        Student studentObj = new Student();
//        studentObj.setAge(student.getAge());
//        studentObj.setName(student.getName());
//        studentObj.setDob(student.getDob());
//        studentObj.setEmail(student.getEmail());
//        studentObj.setCourse(course);

        Student studentBuilder = Student.builder()
                .name(student.getName())
                .age(student.getAge())
                .dob(student.getDob())
                .email(student.getEmail())
                .build();

        this.studentRepo.save(studentBuilder);
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
