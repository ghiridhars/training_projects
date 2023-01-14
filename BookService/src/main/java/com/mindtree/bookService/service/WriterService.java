package com.mindtree.bookService.service;

import java.util.List;

import com.mindtree.bookService.dto.WriterDto;

public interface WriterService {
	
	public List<WriterDto> getAllWriters();
	
	public WriterDto addWriterByName(WriterDto wDto,String name);
	
	public WriterDto getWriterById(int id);


}
