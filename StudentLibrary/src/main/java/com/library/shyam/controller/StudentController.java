package com.library.shyam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.shyam.entity.Student;
import com.library.shyam.entity.StudentRecord;
import com.library.shyam.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;

	@GetMapping("/all")
	public ResponseEntity<List<StudentRecord>> getAllStudents() {
		return new ResponseEntity<>(studentService.getAllStudent(),HttpStatus.FOUND);
		
	}

	@PostMapping("/add")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		return ResponseEntity.ok(studentService.addStudent(student));
	}
	
	@GetMapping("/{email}")
	public Student getByEmail(@PathVariable("email") String email) {
		return studentService.findByEmail(email);
	}
	
	@DeleteMapping("/{email}")
	public void deleteByEmail(@PathVariable("email") String email) {
		 studentService.delete(email);
	}
	@PutMapping("/update")
	public Student update(@RequestBody Student student) {
		return studentService.update(student);
	}
}
