package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    //Instantiate the list before using it
    public List<Product> cart = new ArrayList<>();

    public void addToCart(Product product){
        cart.add(product);
    }

    public void removeFromCart(Product product){
        cart.remove(product);
    }

    public double getCartTotal(){

        double total = 0;
        for(Product p : cart){
            total += p.getPrice();
        }

        return total;
    }


    //Check if a product is in the cart
    public List<Product> getCart(){
        return cart;
    }
}
