package de.ait.shop43.product.exeption;

public class ProductNotFoundExeption extends RuntimeException {
  public ProductNotFoundExeption(String message) {
    super(message);
  }
}
