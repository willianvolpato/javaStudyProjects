package com.bookStore.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bookStore.models.Book;

public class BookDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Book book) {
		entityManager.persist(book);
	}

	public List<Book> list() {
		return entityManager.createQuery("SELECT DISTINCT(b) FROM Book b JOIN FETCH b.authors ORDER BY b.id DESC", Book.class).getResultList();
	}

	public List<Book> lastReleases() {
		return entityManager.createQuery("SELECT b FROM Book b ORDER BY b.publicationDate DESC", Book.class).setMaxResults(5).getResultList();
	}

	public List<Book> allBooks() {
		return entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
	}

}
