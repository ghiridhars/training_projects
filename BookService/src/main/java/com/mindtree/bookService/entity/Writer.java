package com.mindtree.bookService.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "writer1")
public class Writer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int writerId;

	@Temporal(TemporalType.DATE)
	private Date createdDate= new Date();

	private String writerName;

	@ManyToOne
	@JsonIgnore
	private Book book;

	public Writer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Writer(int writerId, Date createdDate, String writerName, Book book) {
		super();
		this.writerId = writerId;
		this.createdDate = createdDate;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
