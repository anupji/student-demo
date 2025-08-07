package com.soft.eng.product;

import java.io.*;
import java.util.*;

public class ProductCSVReader {
    public static void main(String[] args) {
        String filePath = "product.csv"; // path to your CSV file
        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean headerSkipped = false;

            while ((line = br.readLine()) != null) {
                // Skip header
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue;
                }

                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0].trim());
                String name = fields[1].trim();
                double price = Double.parseDouble(fields[2].trim());
                int quantity = Integer.parseInt(fields[3].trim());

                Product product = new Product(id, name, price, quantity);
                products.add(product);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print all products
        for (Product p : products) {
            System.out.println(p);
        }
    }
}
