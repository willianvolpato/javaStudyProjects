package com.bookStore.beans;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.bookStore.DAO.BookDAO;
import com.bookStore.models.Book;

@Model
public class HomeBean {

	@Inject
	private BookDAO bookDAO;
	
	public List<Book> lastReleases(){
		return bookDAO.lastReleases();
	}

	public List<Book> allBooks(){
		return bookDAO.allBooks();
	}
	
}
