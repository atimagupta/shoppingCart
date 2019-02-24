package main.com.shoppingcart.service;

import main.com.shoppingcart.model.Cart;
import main.com.shoppingcart.model.Product;

import java.util.List;

public interface ShoppingCart {
    Double addToCart(Product product, java.lang.Integer quantity);
    void readFromCart();
    Double calculateTotalAmount();
    List<Product> getCart();
}
