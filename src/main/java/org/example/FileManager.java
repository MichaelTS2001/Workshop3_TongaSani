package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static List<Product> getProducts(){
        //Read the csv file
        //Loop through it line by line
        //Take each line and split it by the | into an array
        //Take the object, add it to a list
        //return the list
        List<Product> productList = new ArrayList<>();

        try{
            FileReader fileReader = new FileReader("src/main/resources/products.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String input;

            bufferedReader.readLine(); // This will skip the header in the product.csv

            while((input = bufferedReader.readLine()) != null){
                String[] csvRow = input.split("\\|");
                String sku = (csvRow[0]);
                String productName = (csvRow[1]);
                double price = Double.parseDouble(csvRow[2]);
                String department = (csvRow[3]);

                Product product = new Product(sku, productName, price, department);

                productList.add(product);

            }
            bufferedReader.close();
        }
        catch(IOException ex){
            System.out.println("There was a problem with the file.");
        }

        return productList;
    }

    public static void writeProduct(Product product){
        try{
            FileWriter fileWriter = new FileWriter("src/main/resources/products.csv", true);

            fileWriter.write(String.format("%s | %s | $%.2f | %s %n", product.getSku(), product.getProductName(),
                    product.getPrice(), product.getDepartment()));

            fileWriter.close();
        }
        catch(IOException ex){
            System.out.println("Error writing to file.");
        }
    }
}
