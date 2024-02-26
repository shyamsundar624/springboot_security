package com.library.shyam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.library.shyam.model.User;
import com.library.shyam.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserRepository repository;

	@GetMapping("/all")
	public List<User> getAllUsers() {
		log.info("Get All Method Call");
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable("id") long id) {
		return ResponseEntity.ok(repository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found")));
	}

	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return ResponseEntity.ok(repository.save(user));
	}

	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user) {
	log.info("Add Method Get Called");
		return new ResponseEntity<User>(repository.save(user), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
		repository.deleteById(id);
		return ResponseEntity.ok("User Delete with Id " + id);
	}
}
