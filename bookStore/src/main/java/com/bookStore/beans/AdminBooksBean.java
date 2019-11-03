package com.bookStore.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.bookStore.DAO.BookDAO;
import com.bookStore.models.Book;

@Named
@RequestScoped
public class AdminBooksBean {

	private Book book = new Book();
	
	@Inject
	private BookDAO bookDAO;

	@Transactional
	public void save() {
		System.out.println("Book saved: " + getBook());
		bookDAO.persist(book);
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
