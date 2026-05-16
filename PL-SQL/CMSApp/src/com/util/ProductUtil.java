package com.util;

import com.model.Product;
import com.service.ProductService;

import java.util.List;

public class ProductUtil {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        List<Product> list =  productService.getSampleData();
        System.out.println("------Unsorted List---------");
        list.forEach(System.out::println);
        System.out.println("---------Sorted List (Default Sort: id)------------");
        List<Product> listProductsSortedWithDefault = productService.getProductsWithDefaultSort(list);
        listProductsSortedWithDefault.forEach(System.out::println);

    }
}