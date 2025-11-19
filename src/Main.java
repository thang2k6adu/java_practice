package src;

import src.exception.*;
import src.model.*;
import src.payment.*;
import src.repository.*;
import src.interfaces.*;

public class Main {
    public static void main(String[] args) {

        ProductRepository products = new ProductRepository();
        CustomerRepository customers = new CustomerRepository();
        OrderRepository orders = new OrderRepository();

        try {
            products.add(new Book("B001", "Clean Code", 350000, "Robert C. Martin"));
            products.add(new Book("B002", "Effective Java", 450000, "Joshua Bloch"));
            products.add(new Phone("P001", "iPhone 15 Pro", 29000000, "Apple"));
            products.add(new Laptop("L001", "MacBook Pro M3", 45000000, "Apple"));
            products.add(new Laptop("L002", "Dell XPS 15", 35000000, "Dell"));
        } catch (DuplicateIdException | InvalidPriceException e) {
            e.printStackTrace();
        }

        try {
            customers.add(new Customer("C001", "Nguyễn Văn A", "nguyenvana@email.com"));
            customers.add(new Customer("C002", "Trần Thị B", "tranthib@email.com"));
            customers.add(new Customer("C003", "Lê Văn C", "levanc@email.com"));
            customers.add(new Customer("C004", "Phạm Thị D", "phamthid@email.com"));
        } catch (DuplicateIdException e) {
            e.printStackTrace();
        }

        try {
            Order order1 = new Order("O001", customers.findById("C001"));
            order1.addProduct(products.findById("B001"));
            order1.addProduct(products.findById("P001"));
            orders.add(order1);
            new CreditCardPayment("1234567890123456", "Nguyễn Văn A").pay(order1);

            Order order2 = new Order("O002", customers.findById("C002"));
            order2.addProduct(products.findById("L001"));
            orders.add(order2);
            new PaypalPayment("tranthib@email.com").pay(order2);

            Order order3 = new Order("O003", customers.findById("C003"));
            order3.addProduct(products.findById("B002"));
            order3.addProduct(products.findById("L002"));
            orders.add(order3);
            new CashPayment().pay(order3);

            Order order4 = new Order("O004", customers.findById("C004"));
            order4.addProduct(products.findById("P001"));
            orders.add(order4);
            new MoMoPayment("0987654321").pay(order4);
        } catch (NotFoundException | DuplicateIdException e) {
            e.printStackTrace();
        }

        try {
            Book book = (Book) products.findById("B001");
            book.refund();

            Phone phone = (Phone) products.findById("P001");
            phone.refund();

            Laptop laptop = (Laptop) products.findById("L001");
            laptop.refund();
        } catch (NonRefundableException | NotFoundException e) {
            e.printStackTrace();
        }

        try {
            Book updatedBook = new Book("B001", "Clean Code (Updated Edition)", 400000, "Robert C. Martin");
            products.update(updatedBook);
            products.delete("B002");
        } catch (InvalidPriceException | NotFoundException e) {
            e.printStackTrace();
        }

    }
}