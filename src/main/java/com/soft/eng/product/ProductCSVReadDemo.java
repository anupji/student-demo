package com.soft.eng.product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ProductCSVReadDemo {
    public static void main(String[] args) {

        String fileName = "product.csv";
        List<Product> products = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            boolean isHeader = false;
            String line;

            while ((line = br.readLine()) != null){
                if(!isHeader){
                    isHeader = true;
                    continue;
                }

                String [] fields = line.split(",");

                int id = Integer.parseInt(fields[0].trim());
                String name = fields[1].trim();
                double price = Double.parseDouble(fields[2].trim());
                int quantity = Integer.parseInt(fields[3].trim());

                Product product = new Product(id,name,price,quantity);
                products.add(product);
            }

        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        for(Product product: products){
            System.out.println(product);
        }
    }
}
