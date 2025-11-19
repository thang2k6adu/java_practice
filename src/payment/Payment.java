package src.payment;

import src.model.Order;

public interface Payment {
    void pay(Order order);
}
