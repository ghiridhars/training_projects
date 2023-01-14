package com.mindtree.bookService.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.bookService.dto.BookDto;
import com.mindtree.bookService.dto.WriterDto;
import com.mindtree.bookService.entity.Book;
import com.mindtree.bookService.entity.Writer;
import com.mindtree.bookService.exception.BookServiceException;
import com.mindtree.bookService.exception.InvalidBookException;
import com.mindtree.bookService.exception.InvalidWriterException;
import com.mindtree.bookService.exception.WriterServiceException;
import com.mindtree.bookService.repository.BookRepository;
import com.mindtree.bookService.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepo;

	private static ModelMapper mapper = new ModelMapper();

	public BookDto entityToDto(Book w) {
		BookDto wDto = mapper.map(w, BookDto.class);
		return wDto;
	}

	public List<BookDto> entityToDto(List<Book> w) {
		return w.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

	public List<Book> dtoToEntity(List<BookDto> w) {
		return w.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

	public Book dtoToEntity(BookDto wDto) {
		Book w = mapper.map(wDto, Book.class);
		return w;
	}

	@Override
	public List<BookDto> getAllBooks() {
		List<Book> wList = new ArrayList<Book>();
		try {
			bookRepo.findAll().forEach(wList::add);
			wList.stream().findFirst().orElseThrow(() -> new InvalidBookException("Empty List"));
		} catch (InvalidBookException e) {
			throw new WriterServiceException("Cant get writer details", e);
		}
		return entityToDto(wList);
	}

	@Override
	public BookDto addBook(BookDto bDto) {
		Book b= null;
		try {
			 b = dtoToEntity(bDto);
			bookRepo.save(b);
		} catch (RuntimeException e) {
			throw new BookServiceException("Cant add book",e);
		}
		return entityToDto(b);
	}

	@Override
	public BookDto getBookByName(String name) {
		List<BookDto> b= getAllBooks(); 
		System.out.println(b);
		BookDto book =b.stream().filter(x->x.getBookName().equalsIgnoreCase(name)).findFirst().orElse(null);
		System.out.println(book.getBookName());
		return book;
	}

	@Override
	public List<BookDto> getSortedBooks() {
		List<Book> bList = dtoToEntity(getAllBooks());
		List<Book> sorted = bList.stream().filter(x -> x.getPrice() > 500).collect(Collectors.toList());
		sorted.sort(new BookComparator());
		return entityToDto(sorted);
	}
}
