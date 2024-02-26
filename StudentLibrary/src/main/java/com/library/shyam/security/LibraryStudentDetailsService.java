package com.library.shyam.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.library.shyam.exception.StudentNotFoundException;
import com.library.shyam.repository.StudentRepository;

@Component
public class LibraryStudentDetailsService implements UserDetailsService {
	@Autowired
	private StudentRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		return repository.findByEmail(username).map(LibraryUserDetails::new)
				.orElseThrow(()->new StudentNotFoundException("Student Not Found with given "+username));
	}

}
