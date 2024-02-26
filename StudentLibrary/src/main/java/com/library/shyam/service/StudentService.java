package com.library.shyam.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.library.shyam.entity.Student;
import com.library.shyam.entity.StudentRecord;
import com.library.shyam.exception.StudentAlreadyExistException;
import com.library.shyam.exception.StudentNotFoundException;
import com.library.shyam.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

	private final StudentRepository studentRepository;
	private final PasswordEncoder passwordEncoder;

	public Student addStudent(Student student) {
		Optional<Student> theStudent = studentRepository.findByEmail(student.getEmail());
		if (theStudent.isPresent()) {
			throw new StudentAlreadyExistException("A Student '" + student.getEmail() + "' already Exists");
		}
		student.setPassword(passwordEncoder.encode(student.getPassword()));

		return studentRepository.save(student);
	}
	
	public List<StudentRecord> getAllStudent(){
		return studentRepository.findAll().stream().map(
				stu-> new StudentRecord(stu.getId(),stu.getFirstName(),stu.getLastName(),stu.getEmail())).
				collect(Collectors.toList());
	}
	
	public void delete(String email) {
		studentRepository.deleteByEmail(email);
	}
	
	public Student findByEmail(String email) {
		return studentRepository.findByEmail(email).orElseThrow(()-> new StudentNotFoundException("Student Not Found With "+email));
	}
	
	public Student update(Student student) {
		return studentRepository.save(student);
				
	}
}
