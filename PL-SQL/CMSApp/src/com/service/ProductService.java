package com.service;

import com.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public List<Product> getSampleData() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(3, "Laptop", 999.99, LocalDate.of(2025, 1, 10)));
        products.add(new Product(6, "Phone", 499.99, LocalDate.of(2026, 3, 15)));
        products.add(new Product(2, "Tablet", 299.99, LocalDate.of(2024, 8, 22)));
        products.add(new Product(8, "Smartwatch", 199.99, LocalDate.of(2025, 6, 1)));
        products.add(new Product(13, "Monitor", 349.99, LocalDate.of(2023, 11, 14)));
        products.add(new Product(7, "Headphones", 149.99, LocalDate.of(2026, 2, 28)));
        products.add(new Product(5, "Keyboard", 89.99, LocalDate.of(2024, 1, 5)));
        products.add(new Product(90, "Mouse", 49.99, LocalDate.of(2024, 1, 5))); // Same date as Keyboard
        products.add(new Product(88, "Gaming Console", 499.99, LocalDate.of(2025, 11, 20))); // Same price as Phone
        return products;
    }


    public List<Product> getProductsWithDefaultSort(List<Product> list) {
        return list
                .stream()
                .sorted()
                .toList();
    }
}