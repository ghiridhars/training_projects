package com.mindtree.bookService.service.serviceImpl;

import java.util.Comparator;

import org.springframework.stereotype.Service;

import com.mindtree.bookService.entity.Book;

public class BookComparator implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		return o2.getBookName().compareTo(o1.getBookName());
	}
	

}
