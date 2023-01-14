package com.mindtree.bookService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.bookService.dto.BookDto;
import com.mindtree.bookService.exception.BookAppException;
import com.mindtree.bookService.exception.BookServiceException;
import com.mindtree.bookService.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookservice;

	@RequestMapping(method = RequestMethod.GET,value="/getAllBooks")
	public String getAllBooks(Model m) {
		try {
			List<BookDto> bList = bookservice.getAllBooks();
			m.addAttribute("books", bList);
			return "getBooks";

		} catch (BookServiceException e) {
			return "error";
		}
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/addBook")
	public String addBook(Model m) {
		try {
			return "addBooks";
		} catch (BookServiceException e) {
			return "error";
		}
	}
	
	@RequestMapping("getBookByName/{name}")
	public ResponseEntity<?> getBookByName(@PathVariable String name) {
		try {
			BookDto b= bookservice.getBookByName(name);
			return new ResponseEntity(b, HttpStatus.ACCEPTED);
		} catch (BookServiceException e) {
			e.printStackTrace();
			throw new BookAppException("Cant get Books");
		}
	}

	@RequestMapping("getSortedBooks")
	public ResponseEntity<?> getSortedBooks() {
		try {
			List<BookDto> bList = bookservice.getSortedBooks();
			return new ResponseEntity(bList, HttpStatus.ACCEPTED);
		} catch (BookServiceException e) {
			e.printStackTrace();
			throw new BookAppException("Cant get Books", e);
		}
	}

	@PostMapping("/addBook")
	public ResponseEntity<?> addBook(@RequestBody BookDto bDto) {
		BookDto b = null;

		try {
			b = bookservice.addBook(bDto);
			return new ResponseEntity(b, HttpStatus.ACCEPTED);
		} catch (BookServiceException e) {
			e.printStackTrace();
			throw new BookAppException("cant Add books", e);
		}
	}

}
