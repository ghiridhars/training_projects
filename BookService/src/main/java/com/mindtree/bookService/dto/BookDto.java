package com.mindtree.bookService.dto;

import java.util.List;

import com.mindtree.bookService.entity.Writer;

public class BookDto {

	private int bookId;

	private String bookName;

	private float price;

	private List<Writer> writers;

	public BookDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookDto(int bookId, String bookName, float price) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.price = price;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<Writer> getWriters() {
		return writers;
	}

	public void setWriters(List<Writer> writers) {
		this.writers = writers;
	}

}
