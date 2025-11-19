package src.repository;

import src.model.Order;

public class OrderRepository extends Repository<Order> {
    
    @Override
    public String getId(Order item) {
        return item.getId();
    }
}
