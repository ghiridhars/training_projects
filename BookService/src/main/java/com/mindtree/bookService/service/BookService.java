package com.mindtree.bookService.service;

import java.util.List;

import com.mindtree.bookService.dto.BookDto;
import com.mindtree.bookService.entity.Book;

public interface BookService {

	public List<BookDto> getAllBooks();
	
	public BookDto addBook(BookDto bDto);
	
	public BookDto getBookByName(String name);

	public List<BookDto> getSortedBooks();
	
}
