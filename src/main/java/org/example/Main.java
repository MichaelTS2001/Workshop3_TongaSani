package org.example;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = FileManager.getProducts();

        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        System.out.println("**** Welcome to Michael's Online Store ****");

        while(true){

            try{
                System.out.println("\nPlease choose from one of the options below:");
                System.out.println("\t1. Display Products");
                System.out.println("\t2. Display Cart");
                System.out.println("\t3. Exit - close program");
                System.out.print("Enter your option: ");

                int userInput = scanner.nextInt();

                switch(userInput){
                    case 1:
                        displayProducts(productList);
                        break;
                    case 2:
                        displayCart(cart);
                        break;
                    case 3:
                        System.out.println("Thank you for visiting our store!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid input. Please try again.");
                        break;
                }
            }
            catch(InputMismatchException ex){
                System.out.println("Wrong input. Try again.");
            }


        }
    }

    public static void displayProducts(List<Product> productList){
        for(Product product : productList){
            System.out.println(product.toString());
        }
    }

    //Not a list inside (). Do not have a list of carts. Just one cart that contains a list
    public static void displayCart(ShoppingCart cart){
        for(Product product : cart.getCart()){
            System.out.println(product + "| $" + product.getPrice());
            System.out.println("Total: $" + cart.getCartTotal());
        }
    }

    //Search list

    //Add a product

}