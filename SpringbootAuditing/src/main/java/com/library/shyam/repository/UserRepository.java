package com.library.shyam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.shyam.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
