package src.model;

import src.exception.InvalidPriceException;
import src.exception.NonRefundableException;
import src.interfaces.Deliverable;
import src.interfaces.Refundable;

public class Laptop extends Product implements Deliverable, Refundable {
    private String brand;

    public Laptop(String id, String name, double price, String brand) throws InvalidPriceException {
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
        System.out.println("✓ Giao laptop: " + name + " (Hãng: " + brand + ")");
    }

    @Override
    public void refund() throws NonRefundableException {
        // Laptop không thể hoàn tiền
        throw new NonRefundableException("✗ Laptop không thể hoàn tiền: " + name);
    }

    @Override
    public String toString() {
        return "Laptop [" + super.toString() + ", Hãng: " + brand + "]";
    }
}
