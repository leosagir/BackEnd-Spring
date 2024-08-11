package de.ait.app.repository;

import de.ait.app.entity.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
@Component
public class ProductRepositoryImpl implements ProductRepositoryInterface{

    List<Product> db = List.of(
            new Product(1L,"Banana",new BigDecimal("0.90"),"art1"),
            new Product(2L,"Apple",new BigDecimal("1.90"),"art2"),
            new Product(3L,"Tomato",new BigDecimal("2.90"),"art3"),
            new Product(4L,"Milk",new BigDecimal("3.90"),"art4")
    );


    @Override
    public List<Product> findAll() {
        return db;
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Product delete(Product product) {
        return null;
    }
}
