package de.ait.app.service;

import de.ait.app.entity.Product;

import java.util.List;


public interface ProductServiceInterface {
    List<Product> getAllProduct();
    Product getProductById(Long id);
    Product save(Product product);
}
