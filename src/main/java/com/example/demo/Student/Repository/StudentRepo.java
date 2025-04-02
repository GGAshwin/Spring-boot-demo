package com.example.demo.Student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.example.demo.Student.Entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Optional<Student> findByName(String name);
}
