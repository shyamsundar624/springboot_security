package com.library.shyam.book;

import java.util.List;
import java.util.Optional;

public interface IBookService {

	List<Book> getAllBooks();
	Book add(Book book);
	Optional<Book> findById(long id);
	void delete(Long id);
	Book update(Book book);
}
