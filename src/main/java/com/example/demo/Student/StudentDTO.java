package com.example.demo.Student;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO{
	private Long id;
	private String name;
	private LocalDate Dob;
	private String email;
	private Integer age;
	private UUID course_id = null;
}
