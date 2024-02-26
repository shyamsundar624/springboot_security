package com.library.shyam.book;

import java.util.List;
import java.util.Optional;

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

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

	private final BookService bookService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Book>> getAllBooks(){
		return ResponseEntity.ok(bookService.getAllBooks());
	}
	@GetMapping("/book/{id}")
	public Optional<Book> getById(@PathVariable("id") Long id){
		return bookService.findById(id);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Book> add(@RequestBody Book book){
		return new ResponseEntity<>(bookService.add(book),HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Book> update(@RequestBody Book book){
		return new ResponseEntity<>(bookService.update(book),HttpStatus.OK);
	}
	@DeleteMapping("/book/delete/{id}")
	public void delete(@PathVariable long id) {
		bookService.delete(id);
	}
}
