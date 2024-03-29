package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {
    @InjectMocks
    ProductRepository productRepository;
    @BeforeEach
    void setUp(){

    }
    @Test
    void testCreateAndFind(){
        Product product = new Product();
        product.setProductId(0);
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());

    }
    @Test
    void testFindAllEmpty(){
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());

    }

    @Test
    void testFindAllIfMoreThanOneProduct(){
        Product product1 = new Product();
        product1.setProductId(0);
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId(1);
        product2.setProductName("Sampo Cap Asep");
        product2.setProductQuantity(100);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());

    }
    @Test
    void updateTest(){
        Product product1 = new Product();
        product1.setProductId(0);
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product updatedProduct = new Product();
        updatedProduct.setProductId(0);
        updatedProduct.setProductName("Sampo Cap Asep");
        updatedProduct.setProductQuantity(100);


        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        productRepository.updateProduct(0, updatedProduct);
        Product savedProduct = productIterator.next();
        assertEquals(savedProduct.getProductName(), updatedProduct.getProductName());
        assertEquals(savedProduct.getProductQuantity(), updatedProduct.getProductQuantity());

    }

    @Test
    void deleteTest(){
        productRepository.deleteProduct(0);
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }




}
