package com.bookStore.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bookStore.models.Book;

public class BookDAO {

	@PersistenceContext
	EntityManager entityManager;

	public void persist(Book book) {
		entityManager.persist(book);
	}

}
