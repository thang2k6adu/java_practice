package src.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private Customer customer;
    private List<Product> products;
    private double totalAmount;
    private boolean isPaid;

    public Order(String id, Customer customer) {
        this.id = id;
        this.customer = customer;
        this.products = new ArrayList<>();
        this.totalAmount = 0;
        this.isPaid = false;
    }

    public void addProduct(Product product) {
        products.add(product);
        totalAmount += product.getPrice();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Order [ID: %s, Khách hàng: %s]\n", id, customer.getName()));
        sb.append("Sản phẩm:\n");
        for (Product p : products) {
            sb.append("  - ").append(p.toString()).append("\n");
        }
        sb.append(String.format("Tổng tiền: %.2f VND\n", totalAmount));
        sb.append("Trạng thái: ").append(isPaid ? "Đã thanh toán" : "Chưa thanh toán");
        return sb.toString();
    }
}
