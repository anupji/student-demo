package com.soft.eng.product;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.util.List;

public class ProductCSVDemo {
    public static void main(String[] args) throws Exception {
        List<Item> products = new CsvToBeanBuilder<Item>(new FileReader("product.csv"))
                .withType(Item.class)
                .build()
                .parse();

        for (Item product : products) {
            System.out.println(product);
        }
    }
}
