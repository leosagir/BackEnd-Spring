package de.ait;

import de.ait.app.controller.ProductController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("de.ait.app");
        ProductController productController= context.getBean(ProductController.class);
        System.out.println(productController.getAllProduct());

    }
}
