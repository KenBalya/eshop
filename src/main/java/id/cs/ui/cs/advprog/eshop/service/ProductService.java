package id.cs.ui.cs.advprog.eshop.service;

import id.cs.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ProductService {
    public Product create(Product product);
    public List<Product> findAll();
}
