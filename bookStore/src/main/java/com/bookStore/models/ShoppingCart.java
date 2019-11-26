package com.bookStore.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ShoppingCart implements Serializable {
	
	private Set<CartItem> items = new HashSet<>();
	
	public void addItem(CartItem item) {
		items.add(item);
	}

	public List<CartItem> getItems() {
		return new ArrayList<>(items);
	}
	
	public BigDecimal getItemTotal(CartItem item) {
		return item.getItem().getPrice().multiply(new BigDecimal(item.getQuantity()));
	}
	
	public BigDecimal getOrderTotal() {
		BigDecimal orderTotal = BigDecimal.ZERO;
		for (CartItem item : items) {
			orderTotal = orderTotal.add(item.getItem().getPrice().multiply(new BigDecimal(item.getQuantity())));
		}
		
		return orderTotal;
	}
	
}
