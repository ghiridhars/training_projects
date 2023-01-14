package com.mindtree.bookService.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.bookService.dto.WriterDto;
import com.mindtree.bookService.entity.Book;
import com.mindtree.bookService.entity.Writer;
import com.mindtree.bookService.exception.InvalidBookException;
import com.mindtree.bookService.exception.InvalidWriterException;
import com.mindtree.bookService.exception.WriterServiceException;
import com.mindtree.bookService.repository.BookRepository;
import com.mindtree.bookService.repository.WriterRepository;
import com.mindtree.bookService.service.WriterService;

@Service
public class WriterServiceImpl implements WriterService{
	
	@Autowired
	WriterRepository writerRepo;
	
	@Autowired
	BookRepository bookRepo;
	
	private static ModelMapper mapper = new ModelMapper();
	
	public WriterDto entityToDto(Writer w) {
		WriterDto wDto = mapper.map(w, WriterDto.class);
		return wDto;
	}
	
	public List<WriterDto> entityToDto(List<Writer> w) {
		return w.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	
	public List<Writer> dtoToEntity(List<WriterDto> w) {
		return w.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

	
	public Writer dtoToEntity(WriterDto wDto) {
		Writer w= mapper.map(wDto, Writer.class);
		return w;
	}

	@Override
	public List<WriterDto> getAllWriters() {
		List<Writer> wList=new ArrayList<Writer>();
		try {
			writerRepo.findAll().forEach(wList::add);;
			wList.stream().findFirst().orElseThrow(() -> new InvalidWriterException("Empty List"));
		} catch (InvalidWriterException e) {
			throw new WriterServiceException("Cant get writer edtails",e);
		}
		return entityToDto(wList);
	}

	@Override
	public WriterDto addWriterByName(WriterDto wDto, String name) {
		
		try {
			List<Book> b= bookRepo.findAll();
			System.out.println(b);
			Book book =b.stream()
					.filter(x->x.getBookName().equalsIgnoreCase(name))
					.findFirst().orElseThrow(()-> new InvalidBookException("Book Not Found"));
			
			List<Writer> wList = new ArrayList<Writer>();
			
			Writer w = writerRepo.save(dtoToEntity(wDto));
			book.setWriters(wList);
			w.setBook(book);
			bookRepo.save(book);
		} catch (InvalidBookException e) {
			throw new WriterServiceException("Writer cant be added",e);
		}
		return wDto;
	}

	@Override
	public WriterDto getWriterById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
