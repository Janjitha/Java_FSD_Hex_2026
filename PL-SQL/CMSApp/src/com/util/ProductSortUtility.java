package com.util;

import com.model.Product;

import java.util.Comparator;

public class ProductSortUtility implements Comparator<Product> {


    @Override
    public int compare(Product p1, Product p2) {
        return (int)(p1.getPrice() - p2.getPrice());
    }
}