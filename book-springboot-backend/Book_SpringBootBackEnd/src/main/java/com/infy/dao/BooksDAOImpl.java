package com.infy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.entity.BookEntity;
import com.infy.model.Book;

@Repository
public class BooksDAOImpl implements BooksDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Book> getAllBooks() throws Exception {
		
		Query query = entityManager.createQuery("select book FROM BookEntity book");
		List<Book> books = null;			
		
		List<BookEntity> bookEntities = query.getResultList();		
		books = new ArrayList<Book>();

		for (BookEntity bookEntity  : bookEntities) {
			Book book = new Book();
			book.setId(bookEntity.getBookId());
			book.setName(bookEntity.getBookName());
			//book.setMessage(bookEntity.g);
			books.add(book);
		}
		return books;
	}

}
