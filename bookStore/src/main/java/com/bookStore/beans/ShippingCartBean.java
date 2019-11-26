package com.bookStore.beans;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.bookStore.DAO.BookDAO;
import com.bookStore.models.CartItem;
import com.bookStore.models.ShoppingCart;

@Model
public class ShippingCartBean {
	
	@Inject
	private BookDAO bookDAO;
	@Inject
	private ShoppingCart shoppingCart;
	
	public String addItem(Integer bookId) {
		CartItem cartItem = new CartItem(bookDAO.loadBookById(bookId));
		shoppingCart.addItem(cartItem);
		
		return "/cart?faces-redirect=true";
	}
	
	public List<CartItem> getCartItems(){
		return shoppingCart.getItems();
	}
	
}
