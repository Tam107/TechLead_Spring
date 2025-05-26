package com.techlead.service.core2;

import com.techlead.model.Product;

import java.util.List;

public interface Exercise12Service {

    List<Product> sortByName();
    List<Product> sortByPrice();
    List<Product> sortByManufactureDate();
    List<Product> sortByPriceAndManufactureDate();
    List<Product> getProducts();
}
