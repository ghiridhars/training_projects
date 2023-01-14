package com.mindtree.bookService.dto;

import java.util.Date;

import com.mindtree.bookService.entity.Book;

public class WriterDto {

	private int writerId;

	private String writerName;
	
	private int bookId;

	private Book book;

	public WriterDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WriterDto(int writerId, String writerName, Book book) {
		super();
		this.writerId = writerId;
		this.writerName = writerName;
		this.book = book;
	}

	public int getWriterId() {
		return writerId;
	}

	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

}
