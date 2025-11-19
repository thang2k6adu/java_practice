package src.repository;

import src.model.Customer;

public class CustomerRepository extends Repository<Customer> {
    
    @Override
    public String getId(Customer item) {
        return item.getId();
    }
}
