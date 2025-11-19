package src.model;

import src.exception.InvalidPriceException;
import src.exception.NonRefundableException;
import src.interfaces.Deliverable;
import src.interfaces.Refundable;

public class Book extends Product implements Deliverable, Refundable {
    private String author;

    public Book(String id, String name, double price, String author) throws InvalidPriceException {
        super(id, name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void deliver() {
        System.out.println("✓ Giao sách: " + name + " (Tác giả: " + author + ")");
    }

    @Override
    public void refund() throws NonRefundableException {
        System.out.println("✓ Hoàn tiền cho sách: " + name);
    }

    @Override
    public String toString() {
        return "Book [" + super.toString() + ", Tác giả: " + author + "]";
    }
}
