package com.bookStore.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.bookStore.DAO.BookDAO;
import com.bookStore.models.Book;

@Model
public class AdminListBooksBean {

	@Inject
	private BookDAO bookDAO;
	private List<Book> books = new ArrayList<>();

	public List<Book> getBooks() {
		this.books = bookDAO.list();
		return books;
	}
	

}
