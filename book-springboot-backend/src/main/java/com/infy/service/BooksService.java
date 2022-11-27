package com.infy.service;

import java.util.List;

import com.infy.model.Book;

public interface BooksService {
	public List<Book> getAllBooks() throws Exception;
}
