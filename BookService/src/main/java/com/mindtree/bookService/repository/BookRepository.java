package com.mindtree.bookService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.bookService.entity.Book;

@Repository("bookRepo")
public interface BookRepository extends JpaRepository<Book, Integer>{
	
}
