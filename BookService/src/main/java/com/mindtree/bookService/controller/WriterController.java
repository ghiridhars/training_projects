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
import com.mindtree.bookService.dto.WriterDto;
import com.mindtree.bookService.exception.BookAppException;
import com.mindtree.bookService.exception.BookServiceException;
import com.mindtree.bookService.exception.WriterServiceException;
import com.mindtree.bookService.service.BookService;
import com.mindtree.bookService.service.WriterService;

@Controller
@RequestMapping("/writer")
public class WriterController {
	
	@Autowired
	private WriterService writerservice;	
	
	@Autowired
	private BookService bookService;	

	@RequestMapping(method = RequestMethod.GET, value ="getAllWriters")
	public String getAllBooks(Model m){
		try {
			List<WriterDto> wList = writerservice.getAllWriters();
			m.addAttribute("writers", wList);
			return "getWriters";
		} catch (WriterServiceException e) {
			return "error";
		} 
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/addWriter")
	public String addBook(Model m) {
		try {
			m.addAttribute("bookList",bookService.getAllBooks());
			return "addWriter";
		} catch (WriterServiceException e) {
			return "error";
		}
	}
	
	@PostMapping("/addWriter/{name}")
	public ResponseEntity<?> addBook(@RequestBody WriterDto bDto,@PathVariable String name) {
		WriterDto b = null;
		try {
			b= writerservice.addWriterByName(bDto, name);
			return new ResponseEntity(b, HttpStatus.ACCEPTED);
		} catch (WriterServiceException e) {
			e.printStackTrace();
			throw new BookAppException("cant Add books",e);
		}
	}

}
