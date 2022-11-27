package com.infy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dao.BooksDAO;
import com.infy.model.Book;

@Service(value="BooksServiceImpl")
@Transactional(readOnly=true)
public class BooksServiceImpl implements BooksService {

	@Autowired
	private BooksDAO bookDao; 

	@Override
	public List<Book> getAllBooks() throws Exception {
		return bookDao.getAllBooks();
	}

}
