package com.infy.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.infy.model.Book;
import com.infy.service.BooksServiceImpl;


@CrossOrigin
@RestController
@RequestMapping("booksAPI")
public class BooksAPI {
	static Logger logger = LogManager.getLogger(BooksAPI.class);
	@Autowired
	Environment environment;
	@Autowired
	BooksServiceImpl serviceImpl;
	@RequestMapping(value="books",method=RequestMethod.GET)
	public ResponseEntity<List<Book>> getAllBooks() throws Exception {
		logger.trace("<C> BooksAPI <M> getAllBooks");
		List<Book> books=new ArrayList<Book>();
		try {
			//BooksServiceImpl serviceImpl = (BooksServiceImpl) ContextFactory.getContext().getBean("BooksServiceImpl");
			books=serviceImpl.getAllBooks();
			return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
		} catch (Exception e) {
		//	Environment environment = ContextFactory.getContext().getEnvironment();
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,	e.getMessage(), e);
		}

	}
}
