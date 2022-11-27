package com.infy.dao;

import java.util.List;

import com.infy.model.Book;

public interface BooksDAO {
	public List<Book> getAllBooks() throws Exception;
}
