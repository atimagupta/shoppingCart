package main.com.shoppingcart.service;

import main.com.shoppingcart.model.Cart;
import main.com.shoppingcart.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShoppingCartImpl implements ShoppingCart {

    @Autowired
    private Cart cart;

    @Override
    public Double addToCart(Product product, java.lang.Integer quantity) {
        for (int i = 0; i < quantity; i++)
            cart.getCart().add(product);
        cart.setTotal(calculateTotalAmount());
        return cart.getTotal();
    }

    @Override
    public void readFromCart() {
        cart.getCart().stream().forEach(product -> printProduct(product));
    }

    private void printProduct(Product product) {
        System.out.print(product.getProductName());
        System.out.println(product.getProductPrice());
    }

    public Double calculateTotalAmount() {
        cart.getCart().stream().forEach(product -> cart.setTotal(cart.getTotal() + product.getProductPrice()));
        return Math.round(cart.getTotal() * 100)/100D;
    }

    @Override
    public List<Product> getCart(){
        return cart.getCart();
    }
}
