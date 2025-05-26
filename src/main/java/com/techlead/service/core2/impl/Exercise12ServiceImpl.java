package com.techlead.service.core2.impl;

import com.techlead.model.Product;
import com.techlead.service.core2.Exercise12Service;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class Exercise12ServiceImpl implements Exercise12Service {

    private static final List<Product> products = new ArrayList<>();

    public Exercise12ServiceImpl(){
        products.add(new Product("Laptop", "SP001", 1500.00, LocalDate.of(2023, 5, 10)));
        products.add(new Product("Điện thoại", "SP002", 800.00, LocalDate.of(2024, 1, 15)));
        products.add(new Product("Máy tính bảng", "SP003", 800.00, LocalDate.of(2023, 12, 20)));
        products.add(new Product("Tai nghe", "SP004", 200.00, LocalDate.of(2022, 8, 5)));

    }


    @Override
    public List<Product> sortByName() {
        if (products.isEmpty()) {
            throw new IllegalStateException("Product list is empty");
        }
        List<Product> sorted = new ArrayList<>(products);
        Collections.sort(sorted, Comparator.comparing(Product::getName));
        return sorted;
    }

    @Override
    public List<Product> sortByPrice() {
        if (products.isEmpty()) {
            throw new IllegalStateException("Product list is empty");
        }
        List<Product> sorted = new ArrayList<>(products);
        Collections.sort(sorted, Comparator.comparingDouble(Product::getPrice));
        return sorted;
    }

    @Override
    public List<Product> sortByManufactureDate() {
        if (products.isEmpty()) {
            throw new IllegalStateException("Product list is empty");
        }
        List<Product> sorted = new ArrayList<>(products);
        Collections.sort(sorted, Comparator.comparing(Product::getManufactureDate));
        return sorted;
    }

    @Override
    public List<Product> sortByPriceAndManufactureDate() {
        if (products.isEmpty()) {
            throw new IllegalStateException("Product list is empty");
        }
        List<Product> sorted = new ArrayList<>(products);
        Collections.sort(sorted, Comparator.comparingDouble(Product::getPrice)
                .thenComparing(Product::getManufactureDate));
        return sorted;
    }

    @Override
    public List<Product> getProducts() {
        if (products.isEmpty()) {
            throw new IllegalStateException("Product list is empty");
        }
        return new ArrayList<>(products);
    }
}
