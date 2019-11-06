package com.bookStore.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bookStore.models.Author;

public class AuthorDAO {

	@PersistenceContext
	EntityManager entityManager;

	public List<Author> list() {
		return entityManager.createQuery("SELECT a FROM Author a ", Author.class).getResultList();
	}

	public void persist(Author author) {
		entityManager.persist(author);
	}

}
