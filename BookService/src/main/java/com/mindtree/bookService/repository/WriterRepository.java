package com.mindtree.bookService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.bookService.entity.Writer;

@Repository("writerRepo")
public interface WriterRepository extends JpaRepository<Writer, Integer>{

}
