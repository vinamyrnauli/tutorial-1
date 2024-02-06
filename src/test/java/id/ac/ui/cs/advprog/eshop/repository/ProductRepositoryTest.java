package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;
    @BeforeEach
    void setup() {}

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("6f1238f8-d13a-4e5b-936f-e55156158104");
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
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
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
    void testEditProductNotFound() {
        Product editedProduct = new Product();
        editedProduct.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        editedProduct.setProductName("Sampo Cap Bakso");
        editedProduct.setProductQuantity(300);

        assertThrows(IllegalArgumentException.class, () ->
                productRepository.edit(editedProduct));
    }

    @Test
    void testEditByIdProduct() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bakso");
        product.setProductQuantity(140);
        productRepository.create(product);

        Product findProductById = productRepository.findById(product.getProductId());
        assertEquals(findProductById.getProductId(), product.getProductId());
        assertEquals(findProductById.getProductName(), product.getProductName());
        assertEquals(findProductById.getProductQuantity(), product.getProductQuantity());

        Product editProductData = new Product();
        editProductData.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        editProductData.setProductName("Sampo Cap Bakso Lagi");
        editProductData.setProductQuantity(210);
        productRepository.edit(editProductData);

        Product editedProduct = productRepository.findById(editProductData.getProductId());
        assertEquals(editProductData.getProductId(), editedProduct.getProductId());
        assertEquals("Sampo Cap Bakso Lagi", editedProduct.getProductName());
        assertEquals(210, editedProduct.getProductQuantity());
    }

    @Test
    void testDeleteProduct() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Product deletedProduct = productRepository.delete(product.getProductId());
        assertEquals(product, deletedProduct);

        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testDeleteProductNotFound() {
        assertThrows(IllegalArgumentException.class, () ->
                productRepository.delete("6f1238f8-d13a-4e5b-936f-e55156158104"));
    }

}