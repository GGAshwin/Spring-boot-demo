package com.example.demo.Student.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Student.Entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, UUID> {
}
