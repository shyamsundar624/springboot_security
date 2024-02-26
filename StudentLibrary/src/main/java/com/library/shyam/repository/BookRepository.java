package com.library.shyam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.shyam.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
