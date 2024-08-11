package de.ait.app.service;

import de.ait.app.entity.Product;
import de.ait.app.repository.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductServiceImpl implements ProductServiceInterface{
private final ProductRepositoryImpl repository;

    @Autowired
public ProductServiceImpl(ProductRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAllProduct() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return repository.findAll()
                .stream()
                .filter(product -> product.getId().equals(id))
                .findAny()
                .get();
    }

    @Override
    public Product save(Product product) {
        return null;
    }
}
