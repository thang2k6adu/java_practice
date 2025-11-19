package src.model;

import src.exception.InvalidPriceException;

public abstract class Product {
    protected String id;
    protected String name;
    protected double price;

    public Product(String id, String name, double price) throws InvalidPriceException {
        if (price < 0) {
            throw new InvalidPriceException("Giá sản phẩm không được nhỏ hơn 0. Giá nhập: " + price);
        }
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws InvalidPriceException {
        if (price < 0) {
            throw new InvalidPriceException("Giá sản phẩm không được nhỏ hơn 0. Giá nhập: " + price);
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Tên: %s, Giá: %.2f VND", id, name, price);
    }
}
