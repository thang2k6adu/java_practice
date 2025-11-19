package src.repository;

import src.model.Product;

public class ProductRepository extends Repository<Product> {
    
    @Override
    public String getId(Product item) {
        return item.getId();
    }
}
