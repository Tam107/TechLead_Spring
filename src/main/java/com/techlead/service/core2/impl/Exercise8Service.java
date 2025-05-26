package com.techlead.service.core2.impl;

import com.techlead.model.Product8;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Exercise8Service {
    private final Map<String, Product8> products = new HashMap<>();


    public String addProduct(Product8 newProduct) {
        if (products.containsKey(newProduct.getCode())) {
            return "Product already exists";
        }
        products.put(newProduct.getCode(), newProduct);
        return "Product added successfully";
    }


    public String showProduct() {
        if (products.isEmpty()) {
            return "No products found";
        }
        StringBuilder sb = new StringBuilder();
        for (Product8 product : products.values()) {
            sb.append(product).append("\n");
        }
        return sb.toString();
    }

    public Product8 searchProduct(String code) {
        Product8 product = products.get(code);
        if (product == null) {
            throw new IllegalArgumentException("Product not found");
        }
        return product;
    }

    public String deleteProduct(String code) {
        products.remove(code);
        if (products.containsKey(code)) {
            return "Delete failed";
        }
        return "Product deleted successfully";
    }

    public String updateProduct(Product8 updatedProduct) {
        if (!products.containsKey(updatedProduct.getCode())) {
            return "Product not found";
        }
        products.put(updatedProduct.getCode(), updatedProduct);
        return "Product updated successfully";
    }
}
