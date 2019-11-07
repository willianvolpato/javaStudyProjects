package com.bookStore.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.bookStore.DAO.AuthorDAO;
import com.bookStore.DAO.BookDAO;
import com.bookStore.models.Author;
import com.bookStore.models.Book;

@Named
@RequestScoped
public class AdminBooksBean {

	private Book book = new Book();
	@Inject
	private BookDAO bookDAO;
	@Inject
	private AuthorDAO authorDAO;
	private List<Integer> authorsId = new ArrayList<>();
	@Inject
	private FacesContext facesContext;

	@Transactional
	public String save() {
		for (Integer authorId : authorsId) {
			book.getAuthors().add(new Author(authorId));
		}
		bookDAO.persist(book);
		
		facesContext.getExternalContext().getFlash().setKeepMessages(true);
		facesContext.addMessage(null, new FacesMessage("Livro " + book.getTitle() + " cadastrado com sucesso!"));
		
		return "/books/booksList?faces-redirect=true";
	}

	public List<Author> getAuthors() {
		return authorDAO.list();
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Integer> getAuthorsId() {
		return authorsId;
	}

	public void setAuthorsId(List<Integer> authorsId) {
		this.authorsId = authorsId;
	}

}
