package com.library.shyam.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.shyam.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	Optional<Student> findByEmail(String email);

	void deleteByEmail(String email);
}
