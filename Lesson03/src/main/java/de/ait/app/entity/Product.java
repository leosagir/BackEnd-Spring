package de.ait.app.entity;

import java.math.BigDecimal;

public class Product {
   private Long id;
   private String title;
   private BigDecimal price;
   private String article;

    public Product(Long id, String title, BigDecimal price, String article) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.article = article;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getArticle() {
        return article;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", article='" + article + '\'' +
                '}'+
                "\n";
    }
}
