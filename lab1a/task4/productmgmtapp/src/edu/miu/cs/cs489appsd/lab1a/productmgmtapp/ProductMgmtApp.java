package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class ProductMgmtApp {

    public static void main(String[] args) {
        var products = new Product[] {
                new Product(3128874119L, "Banana", LocalDate.of(2023,1,24), 124, 0.55),
                new Product(2927458265L, "Apple", LocalDate.of(2023,12,9), 18, 1.09),
                new Product(9189927460L, "Carrot", LocalDate.of(2023,3,31), 89, 2.99)
        };
        // TODO call printProducts(...);
        printProducts(products);
    }

    private static void printProducts(Product[] products) {
        if(products != null) {
            if(products.length > 0) {
                // Sort by product's name in ascending order
                var sortedProducts = Arrays.stream(products)
                        .sorted(Comparator.comparing(Product::getName))
                        .toList();
                // Print in JSON format
                System.out.println("Printed in JSON Format");
                System.out.println("[");
//                sortedProducts.forEach(p -> System.out.println(p.toJSONString()));
                long numProducts = sortedProducts.size();
                for (int i = 0; i < numProducts; i++) {
                    if((i + 1) < numProducts ) {
                        System.out.printf("%s,\n", sortedProducts.get(i).toJSONString());
                    } else {
                        System.out.println(sortedProducts.get(i).toJSONString());
                    }
                }
                System.out.println("]");
                System.out.println("------------------------------");

                // Print in XML format
                System.out.println("Printed in XML Format");
                System.out.println("<?xml version=\"1.0\"?>");
                System.out.println("<products>");
                sortedProducts.forEach(p -> System.out.println(p.toXMLString()));
                System.out.println("</products>");
                System.out.println("------------------------------");

                // Print in CSV format
                System.out.println("Printed in Comma-Separated Values (CSV) Format");
                sortedProducts.forEach(p -> System.out.println(p.toCSVString()));
            } else {
                System.out.println("[]");
            }
        } else {
            System.out.println("Error: Invalid input data. Cannot be Null");
        }
    }
}
