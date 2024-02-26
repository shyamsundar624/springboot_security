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

import com.library.shyam.entity.Book;
import com.library.shyam.service.BookService;

import lombok.Getter;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;

	@PostMapping("add")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		return new ResponseEntity<Book>(bookService.addBook(book), HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		return ResponseEntity.ok(bookService.updateBook(book));
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") long id) {
		bookService.delete(id);
		return ResponseEntity.ok("Deleted Book with Id " + id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getById(@PathVariable("id") long id) {
		return ResponseEntity.ok(bookService.getById(id));
	}

	@GetMapping("/all")
	public ResponseEntity<List<Book>> getAllBooks() {
		return ResponseEntity.ok(bookService.getAllBook());
	}
}
