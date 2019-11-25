package com.bookStore.beans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.bookStore.DAO.BookDAO;
import com.bookStore.models.Book;

@Model
public class BookDetailBean {

	@Inject
	private BookDAO bookDAO;
	private Book book;
	private Integer bookId;

	public void loadBook() {
		this.book = bookDAO.loadBookById(bookId);
	}

	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getBookId() {
		return bookId;
	}
	
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
}
