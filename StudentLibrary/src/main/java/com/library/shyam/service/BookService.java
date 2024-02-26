package com.library.shyam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.library.shyam.entity.Book;
import com.library.shyam.exception.BookNotFoundException;
import com.library.shyam.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
	private BookRepository bookRepository;

	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

	public List<Book> getAllBook() {
		return bookRepository.findAll();
	}

	public Book getById(long id) {
		return bookRepository.findById(id)
				.orElseThrow(() -> new BookNotFoundException("Book Doesn't exists with " + id));
	}

	public void delete(long id) {
		bookRepository.deleteById(id);
	}
}
