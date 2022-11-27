package com.infy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="BOOKS")
@GenericGenerator(name="idGen",strategy="increment")
public class BookEntity {
	@Id
	@GeneratedValue(generator="idGen")
	@Column(name="BOOK_ID")
	private Integer bookId;
	@Column(name="BOOK_NAME")
	private String bookName;

	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


}
