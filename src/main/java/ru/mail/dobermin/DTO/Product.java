package ru.mail.dobermin.DTO;

import ru.mail.dobermin.factory.Database;

import java.util.Objects;

public class Product implements Database {

    private int id;
    private String product;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product1 = (Product) o;
        return id == product1.id && Double.compare(product1.price, price) == 0 && Objects.equals(product, product1.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, price);
    }
}
