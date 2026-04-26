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
                System.out.print("\nEnter your choice: ");

                int userInput = scanner.nextInt();

                scanner.nextLine();

                switch(userInput){
                    case 1:
                        System.out.println();
                        displayProducts(productList);

                        System.out.print("\nEnter item by name or SKU: ");
                        String item = scanner.nextLine();

                        Product selectItem = findProduct(productList, item);

                        //If item is not nothing, add item to cart
                        if(selectItem != null){
                            cart.addToCart(selectItem);
                            System.out.println("Item has been added to cart.");
                        }
                        else{
                            System.out.println("Product was not found.");
                        }


                        break;
                    case 2:
                        displayCart(cart);

                        System.out.println("\nWould you like to:");
                        System.out.println("\t1. Check out");
                        System.out.println("\t2. Remove Product");
                        System.out.println("\t3. Go back");
                        System.out.print("Select your choice: ");
                        int choice = scanner.nextInt();

                        if(choice == 1){
                            //display the total amount and ask user to enter amount they will be paying
                            System.out.printf("%.2f", cart.getCartTotal());
                            System.out.print("\nEnter payment amount: $");
                            double payment = scanner.nextDouble();
                            double change = payment - cart.getCartTotal();

                            if(payment < cart.getCartTotal()){
                                System.out.println("Insufficient amount.");
                            }
                            else if(payment > cart.getCartTotal()){
                                System.out.println("Your change is :$" + change);
                            }

                                System.out.println("Receipt:");
                                System.out.println("-----------------------------");
                                System.out.printf("Cart total: $%.2f%n", cart.getCartTotal());
                                System.out.println("Paid: $" + payment);
                                System.out.printf("Your change: $%.2f%n" + change);
                                System.out.println("-----------------------------");
                                System.out.println("Thank you for shopping at Michael's Online Store!");

                                System.exit(0);
                        }
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
            System.out.println();
            System.out.println(product + "| $");
        }
        System.out.println("Total: $" + cart.getCartTotal());
    }

    //Search list
    public static Product findProduct(List<Product> productList, String userInput){
        for(Product product : productList){

            //If the sku is the same as what the user typed in, return that product
            if(product.getSku().equalsIgnoreCase(userInput)){
                return product;
            }

            //If the name of product is the same as what the user typed in, return that product
            if(product.getProductName().equalsIgnoreCase(userInput)){
                return product;
            }
        }
        //if nothing matches, return nothing
        return null;
    }
}