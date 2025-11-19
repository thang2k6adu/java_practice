package src.model;

import src.exception.InvalidPriceException;
import src.exception.NonRefundableException;
import src.interfaces.Deliverable;
import src.interfaces.Refundable;

public class Phone extends Product implements Deliverable, Refundable {
    private String brand;

    public Phone(String id, String name, double price, String brand) throws InvalidPriceException {
        super(id, name, price);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public void deliver() {
        System.out.println("✓ Giao điện thoại: " + name + " (Hãng: " + brand + ")");
    }

    @Override
    public void refund() throws NonRefundableException {
        System.out.println("✓ Hoàn tiền cho điện thoại: " + name);
    }

    @Override
    public String toString() {
        return "Phone [" + super.toString() + ", Hãng: " + brand + "]";
    }
}
