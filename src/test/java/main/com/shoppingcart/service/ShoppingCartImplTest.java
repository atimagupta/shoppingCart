package main.com.shoppingcart.service;

import main.com.shoppingcart.model.Cart;
import main.com.shoppingcart.model.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartImplTest {

    @InjectMocks
    ShoppingCartImpl shoppingCart;

    @Mock
    Cart cart;

    Cart mockCart;

    @Before
    public void setup() {
        Product product = new Product("Dove Soap", 39.99);
        mockCart = new Cart();
        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(new Product("Dove Soap", 39.99));
        products.add(new Product("Dove Soap", 39.99));
        products.add(new Product("Dove Soap", 39.99));
        products.add(new Product("Dove Soap", 39.99));
        mockCart.setCart(products);
    }

    @Test
    public void testCase_Step1() {
        Product product = new Product("Dove Soap", 39.99);
        when(shoppingCart.addToCart(product, 5)).thenReturn(199.95);
        Double total = shoppingCart.addToCart(product, 5);
        assertEquals(199.95, total.doubleValue(), 0);
    }

    @Test
    public void testCaseCheckCart_Step1() {
        when(shoppingCart.getCart()).thenReturn(mockCart.getCart());
        assertEquals(5, shoppingCart.getCart().size());
        assertEquals("Dove Soap", cart.getCart().get(0).getProductName());
        assertEquals(39.99, cart.getCart().get(0).getProductPrice().doubleValue(), 0);
    }
}

