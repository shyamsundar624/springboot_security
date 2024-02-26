package com.library.shyam.book;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.library.shyam.exception.BookNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService implements IBookService {

	private final BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Book add(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	@Override
	public Optional<Book> findById(long id) {
	return Optional.ofNullable(bookRepository.findById(id)
			.orElseThrow(()-> new BookNotFoundException("No Book Found With the Id : "+id)));	
	}

	@Override
	public void delete(Long id) {
Optional<Book> theBook = findById(id);
theBook.ifPresent(book->bookRepository.deleteById(book.getId()));
	
	}

	@Override
	public Book update(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

}
