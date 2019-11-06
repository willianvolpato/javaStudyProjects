package com.bookStore.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.bookStore.DAO.AuthorDAO;
import com.bookStore.models.Author;

@Named
@RequestScoped
public class AdminAuthorBean {

	private Author author = new Author();
	@Inject
	private AuthorDAO authorDAO;

	@Transactional
	public void save() {
		authorDAO.persist(author);
		this.author = new Author();
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public AuthorDAO getAuthorDAO() {
		return authorDAO;
	}

	public void setAuthorDAO(AuthorDAO authorDAO) {
		this.authorDAO = authorDAO;
	}

}
