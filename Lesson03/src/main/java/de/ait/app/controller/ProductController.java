package de.ait.app.controller;

import de.ait.app.entity.Product;
import de.ait.app.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductController {
    private final ProductServiceImpl productService;
@Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }
    public Product getProductById(int id){
        return productService.getProductById((long) id);
    }
}
