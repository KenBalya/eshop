package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product){
        productData.add(product);
        return product;
    }
    public Iterator<Product> findAll(){
        return productData.iterator();
    }

    public Product findById(int id){
        Product product = null;
        for(Product p : productData){
            if(p.getProductId() == id){
                product = p;
                break;
            }
        }
        return product;
    }
    public Boolean deleteProduct(int id){
        Product product = this.findById(id);
        if(product == null){
            return false;
        }
        productData.remove(product);
        return true;
    }
    public Product updateProduct(int id, Product productDetails){
        Product product = this.findById(id);
        if(product == null){
            return null;
        }
        product.setProductName(productDetails.getProductName());
        product.setProductQuantity(productDetails.getProductQuantity());
        return product;
    }

}
