package com.example.demo.Student;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, UUID> {
}
